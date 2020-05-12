package com.baidu.tieba.im.push;

import com.baidu.adp.framework.c.e;
/* loaded from: classes.dex */
public class b {
    private static b itR = null;
    private e itS;

    private b() {
        this.itS = null;
        this.itS = new e(1000, 1000, 1000);
    }

    public static b cit() {
        if (itR == null) {
            synchronized (b.class) {
                if (itR == null) {
                    itR = new b();
                }
            }
        }
        return itR;
    }

    public e jK() {
        return this.itS;
    }
}
