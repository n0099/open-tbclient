package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public class c {
    private static c biN;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Pu() {
        if (biN == null) {
            synchronized (c.class) {
                if (biN == null) {
                    biN = new c();
                }
            }
        }
        return biN;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
