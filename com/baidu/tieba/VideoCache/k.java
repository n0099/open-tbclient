package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class k {
    private static k aYd;
    private Handler.Callback aWm = new Handler.Callback() { // from class: com.baidu.tieba.VideoCache.k.1
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
                    k.this.aYe.setVideoUrl((String) message.obj);
                    k.this.aYe.run();
                }
            } else if (message.what == 3) {
                if (k.this.aYf != null) {
                    k.this.aYf.KU();
                }
            } else if (message.what == 4) {
                if (message.obj instanceof String) {
                    k.this.aYf.hk((String) message.obj);
                }
            } else if (message.what == 5 && k.this.aYf != null) {
                k.this.aYf.clearCache();
            }
            return true;
        }
    };
    private g aYe;
    private b aYf;
    private Handler mHandler;

    private k() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aWm);
        this.aYe = new g();
        this.aYf = new b();
    }

    public static k Lg() {
        if (aYd == null) {
            synchronized (k.class) {
                if (aYd == null) {
                    aYd = new k();
                }
            }
        }
        return aYd;
    }

    public void h(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hv(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void KU() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void hk(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
