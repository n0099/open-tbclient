package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b ePz = null;
    private e ePA;

    private b() {
        this.ePA = null;
        this.ePA = new e(1000, 1000, 1000);
    }

    public static b aSt() {
        if (ePz == null) {
            synchronized (b.class) {
                if (ePz == null) {
                    ePz = new b();
                }
            }
        }
        return ePz;
    }

    public e hr() {
        return this.ePA;
    }
}
