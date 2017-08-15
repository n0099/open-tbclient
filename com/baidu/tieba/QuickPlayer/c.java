package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aUE;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c JX() {
        if (aUE == null) {
            synchronized (c.class) {
                if (aUE == null) {
                    aUE = new c();
                }
            }
        }
        return aUE;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
