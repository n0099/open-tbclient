package com.baidu.tieba.QuickPlayer;

import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public class d {
    private static d aLh;
    private HandlerThread aLi = new HandlerThread("PlayerHandlerThread");

    private d() {
        this.aLi.start();
    }

    public static d Jh() {
        if (aLh == null) {
            synchronized (d.class) {
                if (aLh == null) {
                    aLh = new d();
                }
            }
        }
        return aLh;
    }

    public Looper getLooper() {
        return this.aLi.getLooper();
    }
}
