package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class k {
    private static k aWD;
    private Handler.Callback aUR = new Handler.Callback() { // from class: com.baidu.tieba.VideoCache.k.1
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
                    k.this.aWE.setVideoUrl((String) message.obj);
                    k.this.aWE.run();
                }
            } else if (message.what == 3) {
                if (k.this.aWF != null) {
                    k.this.aWF.Kq();
                }
            } else if (message.what == 4) {
                if (message.obj instanceof String) {
                    k.this.aWF.hh((String) message.obj);
                }
            } else if (message.what == 5 && k.this.aWF != null) {
                k.this.aWF.clearCache();
            }
            return true;
        }
    };
    private g aWE;
    private b aWF;
    private Handler mHandler;

    private k() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aUR);
        this.aWE = new g();
        this.aWF = new b();
    }

    public static k KB() {
        if (aWD == null) {
            synchronized (k.class) {
                if (aWD == null) {
                    aWD = new k();
                }
            }
        }
        return aWD;
    }

    public void w(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hs(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void Kq() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void hh(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
