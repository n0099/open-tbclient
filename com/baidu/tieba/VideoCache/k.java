package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class k {
    private static k aWm;
    private Handler.Callback aUz = new Handler.Callback() { // from class: com.baidu.tieba.VideoCache.k.1
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
                    k.this.aWn.setVideoUrl((String) message.obj);
                    k.this.aWn.run();
                }
            } else if (message.what == 3) {
                if (k.this.aWo != null) {
                    k.this.aWo.Kz();
                }
            } else if (message.what == 4) {
                if (message.obj instanceof String) {
                    k.this.aWo.hg((String) message.obj);
                }
            } else if (message.what == 5 && k.this.aWo != null) {
                k.this.aWo.clearCache();
            }
            return true;
        }
    };
    private g aWn;
    private b aWo;
    private Handler mHandler;

    private k() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aUz);
        this.aWn = new g();
        this.aWo = new b();
    }

    public static k KL() {
        if (aWm == null) {
            synchronized (k.class) {
                if (aWm == null) {
                    aWm = new k();
                }
            }
        }
        return aWm;
    }

    public void k(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hr(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void Kz() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void hg(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
