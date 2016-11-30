package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes.dex */
public class n {
    private static n aQD;
    private Handler.Callback aMt = new o(this);
    private i aQE;
    private c aQF;
    private Handler mHandler;

    private n() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aMt);
        this.aQE = new i();
        this.aQF = new c();
    }

    public static n KW() {
        if (aQD == null) {
            synchronized (n.class) {
                if (aQD == null) {
                    aQD = new n();
                }
            }
        }
        return aQD;
    }

    public void n(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void hc(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void KK() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void gR(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
