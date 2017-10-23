package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dCH = null;
    private e dCI;

    private b() {
        this.dCI = null;
        this.dCI = new e(1000, 1000, 1000);
    }

    public static b ayB() {
        if (dCH == null) {
            synchronized (b.class) {
                if (dCH == null) {
                    dCH = new b();
                }
            }
        }
        return dCH;
    }

    public e dv() {
        return this.dCI;
    }
}
