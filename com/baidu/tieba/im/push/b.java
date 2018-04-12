package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b egy = null;
    private e egz;

    private b() {
        this.egz = null;
        this.egz = new e(1000, 1000, 1000);
    }

    public static b aGu() {
        if (egy == null) {
            synchronized (b.class) {
                if (egy == null) {
                    egy = new b();
                }
            }
        }
        return egy;
    }

    public e dd() {
        return this.egz;
    }
}
