package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dKA = null;
    private e dKB;

    private b() {
        this.dKB = null;
        this.dKB = new e(1000, 1000, 1000);
    }

    public static b aBa() {
        if (dKA == null) {
            synchronized (b.class) {
                if (dKA == null) {
                    dKA = new b();
                }
            }
        }
        return dKA;
    }

    public e dv() {
        return this.dKB;
    }
}
