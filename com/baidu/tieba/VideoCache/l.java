package com.baidu.tieba.VideoCache;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.InputStream;
/* loaded from: classes.dex */
public class l {
    private static l aUJ;
    private Handler.Callback aQx = new m(this);
    private h aUK;
    private b aUL;
    private Handler mHandler;

    private l() {
        HandlerThread handlerThread = new HandlerThread("video_cache_handler");
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this.aQx);
        this.aUK = new h();
        this.aUL = new b();
    }

    public static l Lj() {
        if (aUJ == null) {
            synchronized (l.class) {
                if (aUJ == null) {
                    aUJ = new l();
                }
            }
        }
        return aUJ;
    }

    public void n(InputStream inputStream) {
        Message obtainMessage = this.mHandler.obtainMessage(1);
        obtainMessage.obj = inputStream;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void gN(String str) {
        this.mHandler.removeMessages(2);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = str;
        this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
    }

    public void KX() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    public void gC(String str) {
        Message obtainMessage = this.mHandler.obtainMessage(4);
        obtainMessage.obj = str;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void clearCache() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5));
    }
}
