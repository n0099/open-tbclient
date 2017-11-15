package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class k {
    private static k aYm;
    private Handler.Callback aWv = new Handler.Callback() { // from class: com.baidu.tieba.VideoCache.k.1
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
                    k.this.aYn.setVideoUrl((String) message.obj);
                    k.this.aYn.run();
                }
            } else if (message.what == 3) {
                if (k.this.aYo != null) {
                    k.this.aYo.Lf();
                }
            } else if (message.what == 4) {
                if (message.obj instanceof String) {
                    k.this.aYo.hl((String) message.obj);
                }
            } else if (message.what == 5 && k.this.aYo != null) {
                k.this.aYo.clearCache();
            }
            return true;
        }
    };
    private g aYn;
    private b aYo;
    private Handler mHandler;

    private k() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aWv);
        this.aYn = new g();
        this.aYo = new b();
    }

    public static k Lr() {
        if (aYm == null) {
            synchronized (k.class) {
                if (aYm == null) {
                    aYm = new k();
                }
            }
        }
        return aYm;
    }

    public void h(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hw(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void Lf() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void hl(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
