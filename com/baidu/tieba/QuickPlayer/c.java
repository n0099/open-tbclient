package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes5.dex */
public class c {
    private static c bxt;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c UE() {
        if (bxt == null) {
            synchronized (c.class) {
                if (bxt == null) {
                    bxt = new c();
                }
            }
        }
        return bxt;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
