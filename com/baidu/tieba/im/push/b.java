package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b itL = null;
    private e itM;

    private b() {
        this.itM = null;
        this.itM = new e(1000, 1000, 1000);
    }

    public static b ciu() {
        if (itL == null) {
            synchronized (b.class) {
                if (itL == null) {
                    itL = new b();
                }
            }
        }
        return itL;
    }

    public e jK() {
        return this.itM;
    }
}
