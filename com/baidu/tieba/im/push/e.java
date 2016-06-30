package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e cVa = null;
    private com.baidu.adp.framework.c.e cVb;

    private e() {
        this.cVb = null;
        this.cVb = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e aqk() {
        if (cVa == null) {
            synchronized (e.class) {
                if (cVa == null) {
                    cVa = new e();
                }
            }
        }
        return cVa;
    }

    public com.baidu.adp.framework.c.e bu() {
        return this.cVb;
    }
}
