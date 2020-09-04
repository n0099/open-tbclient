package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b jxO = null;
    private e jxP;

    private b() {
        this.jxP = null;
        this.jxP = new e(1000, 1000, 1000);
    }

    public static b cHJ() {
        if (jxO == null) {
            synchronized (b.class) {
                if (jxO == null) {
                    jxO = new b();
                }
            }
        }
        return jxO;
    }

    public e lB() {
        return this.jxP;
    }
}
