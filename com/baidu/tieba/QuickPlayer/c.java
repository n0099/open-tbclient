package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public class c {
    private static c cTa;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aBu() {
        if (cTa == null) {
            synchronized (c.class) {
                if (cTa == null) {
                    cTa = new c();
                }
            }
        }
        return cTa;
    }

    public Looper aBv() {
        return this.mHandlerThread.getLooper();
    }
}
