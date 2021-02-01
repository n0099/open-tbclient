package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b kKO = null;
    private e kKP;

    private b() {
        this.kKP = null;
        this.kKP = new e(1000, 1000, 1000);
    }

    public static b cXr() {
        if (kKO == null) {
            synchronized (b.class) {
                if (kKO == null) {
                    kKO = new b();
                }
            }
        }
        return kKO;
    }

    public e lb() {
        return this.kKP;
    }
}
