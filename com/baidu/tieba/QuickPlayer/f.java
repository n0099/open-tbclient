package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class f {
    private static f aQP;
    private HandlerThread mHandlerThread = new HandlerThread("PlayerHandlerThread");

    private f() {
        this.mHandlerThread.start();
    }

    public static f Jl() {
        if (aQP == null) {
            synchronized (f.class) {
                if (aQP == null) {
                    aQP = new f();
                }
            }
        }
        return aQP;
    }

    public Looper getLooper() {
        return this.mHandlerThread.getLooper();
    }
}
