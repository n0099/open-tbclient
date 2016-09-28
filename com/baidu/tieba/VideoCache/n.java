package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes.dex */
public class n {
    private static n aOx;
    private Handler.Callback aLz = new o(this);
    private i aOy;
    private c aOz;
    private Handler mHandler;

    private n() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aLz);
        this.aOy = new i();
        this.aOz = new c();
    }

    public static n Ks() {
        if (aOx == null) {
            synchronized (n.class) {
                if (aOx == null) {
                    aOx = new n();
                }
            }
        }
        return aOx;
    }

    public void n(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hb(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void Kg() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void gQ(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
