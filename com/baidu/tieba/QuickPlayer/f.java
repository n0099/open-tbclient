package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class f {
    private static f aLp;
    private HandlerThread aLq = new HandlerThread("PlayerHandlerThread");

    private f() {
        this.aLq.start();
    }

    public static f II() {
        if (aLp == null) {
            synchronized (f.class) {
                if (aLp == null) {
                    aLp = new f();
                }
            }
        }
        return aLp;
    }

    public Looper getLooper() {
        return this.aLq.getLooper();
    }
}
