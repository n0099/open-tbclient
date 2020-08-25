package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes2.dex */
public class b {
    private static b jxI = null;
    private e jxJ;

    private b() {
        this.jxJ = null;
        this.jxJ = new e(1000, 1000, 1000);
    }

    public static b cHI() {
        if (jxI == null) {
            synchronized (b.class) {
                if (jxI == null) {
                    jxI = new b();
                }
            }
        }
        return jxI;
    }

    public e lB() {
        return this.jxJ;
    }
}
