package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b egv = null;
    private e egw;

    private b() {
        this.egw = null;
        this.egw = new e(1000, 1000, 1000);
    }

    public static b aGu() {
        if (egv == null) {
            synchronized (b.class) {
                if (egv == null) {
                    egv = new b();
                }
            }
        }
        return egv;
    }

    public e dd() {
        return this.egw;
    }
}
