package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b kCJ = null;
    private e kCK;

    private b() {
        this.kCK = null;
        this.kCK = new e(1000, 1000, 1000);
    }

    public static b cVt() {
        if (kCJ == null) {
            synchronized (b.class) {
                if (kCJ == null) {
                    kCJ = new b();
                }
            }
        }
        return kCJ;
    }

    public e lc() {
        return this.kCK;
    }
}
