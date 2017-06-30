package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e dnq = null;
    private com.baidu.adp.framework.c.e dnr;

    private e() {
        this.dnr = null;
        this.dnr = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e avE() {
        if (dnq == null) {
            synchronized (e.class) {
                if (dnq == null) {
                    dnq = new e();
                }
            }
        }
        return dnq;
    }

    public com.baidu.adp.framework.c.e dv() {
        return this.dnr;
    }
}
