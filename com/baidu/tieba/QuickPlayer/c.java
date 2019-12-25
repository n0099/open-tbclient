package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes10.dex */
public class c {
    private static c dQy;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aTL() {
        if (dQy == null) {
            synchronized (c.class) {
                if (dQy == null) {
                    dQy = new c();
                }
            }
        }
        return dQy;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
