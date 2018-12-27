package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b fax = null;
    private e fay;

    private b() {
        this.fay = null;
        this.fay = new e(1000, 1000, 1000);
    }

    public static b aUv() {
        if (fax == null) {
            synchronized (b.class) {
                if (fax == null) {
                    fax = new b();
                }
            }
        }
        return fax;
    }

    public e hq() {
        return this.fay;
    }
}
