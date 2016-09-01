package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes.dex */
public class n {
    private static n aNn;
    private i aNo;
    private c aNp;
    private Handler.Callback aNq = new o(this);
    private Handler mHandler;

    private n() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aNq);
        this.aNo = new i();
        this.aNp = new c();
    }

    public static n JG() {
        if (aNn == null) {
            synchronized (n.class) {
                if (aNn == null) {
                    aNn = new n();
                }
            }
        }
        return aNn;
    }

    public void n(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void gU(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void Ju() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void gJ(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
