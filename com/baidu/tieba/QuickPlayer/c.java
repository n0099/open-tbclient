package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public class c {
    private static c dcD;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c aBS() {
        if (dcD == null) {
            synchronized (c.class) {
                if (dcD == null) {
                    dcD = new c();
                }
            }
        }
        return dcD;
    }

    public Looper aBT() {
        return this.mHandlerThread.getLooper();
    }
}
