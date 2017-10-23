package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class k {
    private static k aXN;
    private Handler.Callback aWa = new Handler.Callback() { // from class: com.baidu.tieba.VideoCache.k.1
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
                    k.this.aXO.setVideoUrl((String) message.obj);
                    k.this.aXO.run();
                }
            } else if (message.what == 3) {
                if (k.this.aXP != null) {
                    k.this.aXP.KL();
                }
            } else if (message.what == 4) {
                if (message.obj instanceof String) {
                    k.this.aXP.hc((String) message.obj);
                }
            } else if (message.what == 5 && k.this.aXP != null) {
                k.this.aXP.clearCache();
            }
            return true;
        }
    };
    private g aXO;
    private b aXP;
    private Handler mHandler;

    private k() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aWa);
        this.aXO = new g();
        this.aXP = new b();
    }

    public static k KX() {
        if (aXN == null) {
            synchronized (k.class) {
                if (aXN == null) {
                    aXN = new k();
                }
            }
        }
        return aXN;
    }

    public void h(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hn(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void KL() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void hc(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
