package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes.dex */
public class l {
    private static l aPU;
    private Handler.Callback aLK = new m(this);
    private h aPV;
    private b aPW;
    private Handler mHandler;

    private l() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aLK);
        this.aPV = new h();
        this.aPW = new b();
    }

    public static l Kp() {
        if (aPU == null) {
            synchronized (l.class) {
                if (aPU == null) {
                    aPU = new l();
                }
            }
        }
        return aPU;
    }

    public void n(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void gX(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void Kd() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void gM(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
