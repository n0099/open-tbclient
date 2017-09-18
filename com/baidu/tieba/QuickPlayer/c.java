package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aUk;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Kg() {
        if (aUk == null) {
            synchronized (c.class) {
                if (aUk == null) {
                    aUk = new c();
                }
            }
        }
        return aUk;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
