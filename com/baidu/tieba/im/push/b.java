package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b ePy = null;
    private e ePz;

    private b() {
        this.ePz = null;
        this.ePz = new e(1000, 1000, 1000);
    }

    public static b aSt() {
        if (ePy == null) {
            synchronized (b.class) {
                if (ePy == null) {
                    ePy = new b();
                }
            }
        }
        return ePy;
    }

    public e hr() {
        return this.ePz;
    }
}
