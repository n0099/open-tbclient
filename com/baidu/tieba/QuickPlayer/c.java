package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes13.dex */
public class c {
    private static c eJW;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c bkT() {
        if (eJW == null) {
            synchronized (c.class) {
                if (eJW == null) {
                    eJW = new c();
                }
            }
        }
        return eJW;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
