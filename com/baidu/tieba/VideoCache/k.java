package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class k {
    private static k bAO;
    private g bAP;
    private b bAQ;
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
                    k.this.bAP.setVideoUrl((String) message.obj);
                    k.this.bAP.run();
                }
            } else if (message.what == 3) {
                if (k.this.bAQ != null) {
                    k.this.bAQ.VB();
                }
            } else if (message.what == 4) {
                if (message.obj instanceof String) {
                    k.this.bAQ.jB((String) message.obj);
                }
            } else if (message.what == 5 && k.this.bAQ != null) {
                k.this.bAQ.clearCache();
            }
            return true;
        }
    };

    private k() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.mHandlerCallback);
        this.bAP = new g();
        this.bAQ = new b();
    }

    public static k VQ() {
        if (bAO == null) {
            synchronized (k.class) {
                if (bAO == null) {
                    bAO = new k();
                }
            }
        }
        return bAO;
    }

    public void m(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void jM(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void VB() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void jB(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
