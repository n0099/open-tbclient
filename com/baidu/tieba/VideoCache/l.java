package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes.dex */
public class l {
    private static l aUY;
    private Handler.Callback aQP = new m(this);
    private h aUZ;
    private b aVa;
    private Handler mHandler;

    private l() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aQP);
        this.aUZ = new h();
        this.aVa = new b();
    }

    public static l LJ() {
        if (aUY == null) {
            synchronized (l.class) {
                if (aUY == null) {
                    aUY = new l();
                }
            }
        }
        return aUY;
    }

    public void q(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void gR(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void Lx() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void gG(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
