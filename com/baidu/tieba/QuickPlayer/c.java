package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class c {
    private static c aYZ;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private c() {
        this.mHandlerThread.start();
    }

    public static c Lh() {
        if (aYZ == null) {
            synchronized (c.class) {
                if (aYZ == null) {
                    aYZ = new c();
                }
            }
        }
        return aYZ;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
