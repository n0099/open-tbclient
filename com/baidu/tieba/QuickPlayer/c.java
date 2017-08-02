package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aTr;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c JR() {
        if (aTr == null) {
            synchronized (c.class) {
                if (aTr == null) {
                    aTr = new c();
                }
            }
        }
        return aTr;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
