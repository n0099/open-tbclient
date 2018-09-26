package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b eHP = null;
    private e eHQ;

    private b() {
        this.eHQ = null;
        this.eHQ = new e(1000, 1000, 1000);
    }

    public static b aPf() {
        if (eHP == null) {
            synchronized (b.class) {
                if (eHP == null) {
                    eHP = new b();
                }
            }
        }
        return eHP;
    }

    public e gZ() {
        return this.eHQ;
    }
}
