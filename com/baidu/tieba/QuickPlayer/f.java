package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class f {
    private static f aSi;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private f() {
        this.mHandlerThread.start();
    }

    public static f JJ() {
        if (aSi == null) {
            synchronized (f.class) {
                if (aSi == null) {
                    aSi = new f();
                }
            }
        }
        return aSi;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
