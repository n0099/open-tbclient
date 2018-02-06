package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public class c {
    private static c bPo;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Td() {
        if (bPo == null) {
            synchronized (c.class) {
                if (bPo == null) {
                    bPo = new c();
                }
            }
        }
        return bPo;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
