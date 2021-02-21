package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b kLc = null;
    private e kLd;

    private b() {
        this.kLd = null;
        this.kLd = new e(1000, 1000, 1000);
    }

    public static b cXy() {
        if (kLc == null) {
            synchronized (b.class) {
                if (kLc == null) {
                    kLc = new b();
                }
            }
        }
        return kLc;
    }

    public e lb() {
        return this.kLd;
    }
}
