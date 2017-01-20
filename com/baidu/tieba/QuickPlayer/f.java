package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class f {
    private static f aKr;
    private HandlerThread aKs = new HandlerThread("PlayerHandlerThread");

    private f() {
        this.aKs.start();
    }

    public static f IV() {
        if (aKr == null) {
            synchronized (f.class) {
                if (aKr == null) {
                    aKr = new f();
                }
            }
        }
        return aKr;
    }

    public Looper getLooper() {
        return this.aKs.getLooper();
    }
}
