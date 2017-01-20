package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes.dex */
public class l {
    private static l aOX;
    private Handler.Callback aKM = new m(this);
    private h aOY;
    private b aOZ;
    private Handler mHandler;

    private l() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aKM);
        this.aOY = new h();
        this.aOZ = new b();
    }

    public static l KE() {
        if (aOX == null) {
            synchronized (l.class) {
                if (aOX == null) {
                    aOX = new l();
                }
            }
        }
        return aOX;
    }

    public void n(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void gY(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void Ks() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void gN(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
