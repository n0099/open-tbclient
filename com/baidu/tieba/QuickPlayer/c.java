package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public class c {
    private static c cTh;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aBw() {
        if (cTh == null) {
            synchronized (c.class) {
                if (cTh == null) {
                    cTh = new c();
                }
            }
        }
        return cTh;
    }

    public Looper aBx() {
        return this.mHandlerThread.getLooper();
    }
}
