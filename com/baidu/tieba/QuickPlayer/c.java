package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aVG;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Kr() {
        if (aVG == null) {
            synchronized (c.class) {
                if (aVG == null) {
                    aVG = new c();
                }
            }
        }
        return aVG;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
