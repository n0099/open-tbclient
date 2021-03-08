package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b kNe = null;
    private e kNf;

    private b() {
        this.kNf = null;
        this.kNf = new e(1000, 1000, 1000);
    }

    public static b cXF() {
        if (kNe == null) {
            synchronized (b.class) {
                if (kNe == null) {
                    kNe = new b();
                }
            }
        }
        return kNe;
    }

    public e lb() {
        return this.kNf;
    }
}
