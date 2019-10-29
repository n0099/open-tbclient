package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public class c {
    private static c ddv;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aBU() {
        if (ddv == null) {
            synchronized (c.class) {
                if (ddv == null) {
                    ddv = new c();
                }
            }
        }
        return ddv;
    }

    public Looper aBV() {
        return this.mHandlerThread.getLooper();
    }
}
