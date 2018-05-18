package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public class c {
    private static c aZa;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Ly() {
        if (aZa == null) {
            synchronized (c.class) {
                if (aZa == null) {
                    aZa = new c();
                }
            }
        }
        return aZa;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
