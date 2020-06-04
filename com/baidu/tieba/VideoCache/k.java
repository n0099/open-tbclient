package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes9.dex */
public class k {
    private static k eMy;
    private b eMA;
    private g eMz;
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
                    k.this.eMz.setVideoUrl((String) message.obj);
                    k.this.eMz.run();
                }
            } else if (message.what == 3) {
                if (k.this.eMA != null) {
                    k.this.eMA.blv();
                }
            } else if (message.what == 4) {
                if (message.obj instanceof String) {
                    k.this.eMA.zm((String) message.obj);
                }
            } else if (message.what == 5 && k.this.eMA != null) {
                k.this.eMA.clearCache();
            }
            return true;
        }
    };

    private k() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.mHandlerCallback);
        this.eMz = new g();
        this.eMA = new b();
    }

    public static k blJ() {
        if (eMy == null) {
            synchronized (k.class) {
                if (eMy == null) {
                    eMy = new k();
                }
            }
        }
        return eMy;
    }

    public void n(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void zw(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void blv() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void zm(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
