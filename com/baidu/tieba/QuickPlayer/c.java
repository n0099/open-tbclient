package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public class c {
    private static c cUa;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aBK() {
        if (cUa == null) {
            synchronized (c.class) {
                if (cUa == null) {
                    cUa = new c();
                }
            }
        }
        return cUa;
    }

    public Looper aBL() {
        return this.mHandlerThread.getLooper();
    }
}
