package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dCV = null;
    private e dCW;

    private b() {
        this.dCW = null;
        this.dCW = new e(1000, 1000, 1000);
    }

    public static b ayG() {
        if (dCV == null) {
            synchronized (b.class) {
                if (dCV == null) {
                    dCV = new b();
                }
            }
        }
        return dCV;
    }

    public e dv() {
        return this.dCW;
    }
}
