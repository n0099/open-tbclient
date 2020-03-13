package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class k {
    private static k dXv;
    private g dXw;
    private b dXx;
    private Handler mHandler;
    private Handler.Callback mHandlerCallback = new Handler.Callback() { // from class: com.baidu.tieba.VideoCache.k.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                if (message.obj instanceof InputStream) {
                    try {
                        ((InputStream) message.obj).close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } else if (message.what == 2) {
                if (message.obj instanceof String) {
                    k.this.dXw.setVideoUrl((String) message.obj);
                    k.this.dXw.run();
                }
            } else if (message.what == 3) {
                if (k.this.dXx != null) {
                    k.this.dXx.aXb();
                }
            } else if (message.what == 4) {
                if (message.obj instanceof String) {
                    k.this.dXx.wq((String) message.obj);
                }
            } else if (message.what == 5 && k.this.dXx != null) {
                k.this.dXx.clearCache();
            }
            return true;
        }
    };

    private k() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.mHandlerCallback);
        this.dXw = new g();
        this.dXx = new b();
    }

    public static k aXo() {
        if (dXv == null) {
            synchronized (k.class) {
                if (dXv == null) {
                    dXv = new k();
                }
            }
        }
        return dXv;
    }

    public void l(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void wA(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void aXb() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void wq(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
