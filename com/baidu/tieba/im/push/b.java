package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dFL = null;
    private e dFM;

    private b() {
        this.dFM = null;
        this.dFM = new e(1000, 1000, 1000);
    }

    public static b azJ() {
        if (dFL == null) {
            synchronized (b.class) {
                if (dFL == null) {
                    dFL = new b();
                }
            }
        }
        return dFL;
    }

    public e dv() {
        return this.dFM;
    }
}
