package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class k {
    private static k aWE;
    private Handler.Callback aUS = new Handler.Callback() { // from class: com.baidu.tieba.VideoCache.k.1
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
                    k.this.aWF.setVideoUrl((String) message.obj);
                    k.this.aWF.run();
                }
            } else if (message.what == 3) {
                if (k.this.aWG != null) {
                    k.this.aWG.Kq();
                }
            } else if (message.what == 4) {
                if (message.obj instanceof String) {
                    k.this.aWG.hh((String) message.obj);
                }
            } else if (message.what == 5 && k.this.aWG != null) {
                k.this.aWG.clearCache();
            }
            return true;
        }
    };
    private g aWF;
    private b aWG;
    private Handler mHandler;

    private k() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aUS);
        this.aWF = new g();
        this.aWG = new b();
    }

    public static k KB() {
        if (aWE == null) {
            synchronized (k.class) {
                if (aWE == null) {
                    aWE = new k();
                }
            }
        }
        return aWE;
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
