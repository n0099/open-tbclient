package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e dfj = null;
    private com.baidu.adp.framework.c.e dfk;

    private e() {
        this.dfk = null;
        this.dfk = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e atg() {
        if (dfj == null) {
            synchronized (e.class) {
                if (dfj == null) {
                    dfj = new e();
                }
            }
        }
        return dfj;
    }

    public com.baidu.adp.framework.c.e dv() {
        return this.dfk;
    }
}
