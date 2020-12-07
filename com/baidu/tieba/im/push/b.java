package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b kBQ = null;
    private e kBR;

    private b() {
        this.kBR = null;
        this.kBR = new e(1000, 1000, 1000);
    }

    public static b cZx() {
        if (kBQ == null) {
            synchronized (b.class) {
                if (kBQ == null) {
                    kBQ = new b();
                }
            }
        }
        return kBQ;
    }

    public e lG() {
        return this.kBR;
    }
}
