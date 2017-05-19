package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class l {
    private static l aVt;
    private Handler.Callback aRi = new m(this);
    private h aVu;
    private b aVv;
    private Handler mHandler;

    private l() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aRi);
        this.aVu = new h();
        this.aVv = new b();
    }

    public static l KX() {
        if (aVt == null) {
            synchronized (l.class) {
                if (aVt == null) {
                    aVt = new l();
                }
            }
        }
        return aVt;
    }

    public void q(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void gP(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void KL() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void gE(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
