package com.baidu.tieba.im.push;

import com.baidu.adp.framework.d.e;
/* loaded from: classes.dex */
public class b {
    private static b jGq = null;
    private e jGr;

    private b() {
        this.jGr = null;
        this.jGr = new e(1000, 1000, 1000);
    }

    public static b cLp() {
        if (jGq == null) {
            synchronized (b.class) {
                if (jGq == null) {
                    jGq = new b();
                }
            }
        }
        return jGq;
    }

    public e lF() {
        return this.jGr;
    }
}
