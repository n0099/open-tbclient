package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public class c {
    private static c bPe;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Td() {
        if (bPe == null) {
            synchronized (c.class) {
                if (bPe == null) {
                    bPe = new c();
                }
            }
        }
        return bPe;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
