package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b kHo = null;
    private e kHp;

    private b() {
        this.kHp = null;
        this.kHp = new e(1000, 1000, 1000);
    }

    public static b cZl() {
        if (kHo == null) {
            synchronized (b.class) {
                if (kHo == null) {
                    kHo = new b();
                }
            }
        }
        return kHo;
    }

    public e lc() {
        return this.kHp;
    }
}
