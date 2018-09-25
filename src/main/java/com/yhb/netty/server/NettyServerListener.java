package com.yhb.netty.server;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * netty服务监听器 . 
 * 
 * @author hbyi
 */
@WebListener
public class NettyServerListener implements ServletContextListener {

    /**
     * 注入NettyServer
     */
    @Autowired
    private NettyServer nettyServer;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Thread thread = new Thread(new NettyServerThread());
        // 启动netty服务
        thread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    /**
     * netty服务启动线程 . <br>
     * 
     * @author hkb
     */
    private class NettyServerThread implements Runnable {

        @Override
        public void run() {
            nettyServer.run();
        }
    }

}
