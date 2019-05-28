package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class k {
    private static k cUg;
    private g cUh;
    private b cUi;
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
                    k.this.cUh.setVideoUrl((String) message.obj);
                    k.this.cUh.run();
                }
            } else if (message.what == 3) {
                if (k.this.cUi != null) {
                    k.this.cUi.aAH();
                }
            } else if (message.what == 4) {
                if (message.obj instanceof String) {
                    k.this.cUi.rv((String) message.obj);
                }
            } else if (message.what == 5 && k.this.cUi != null) {
                k.this.cUi.clearCache();
            }
            return true;
        }
    };

    private k() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.mHandlerCallback);
        this.cUh = new g();
        this.cUi = new b();
    }

    public static k aAW() {
        if (cUg == null) {
            synchronized (k.class) {
                if (cUg == null) {
                    cUg = new k();
                }
            }
        }
        return cUg;
    }

    public void o(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void rG(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void aAH() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void rv(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
