package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b dvT = null;
    private e dvU;

    private b() {
        this.dvU = null;
        this.dvU = new e(1000, 1000, 1000);
    }

    public static b axh() {
        if (dvT == null) {
            synchronized (b.class) {
                if (dvT == null) {
                    dvT = new b();
                }
            }
        }
        return dvT;
    }

    public e du() {
        return this.dvU;
    }
}
