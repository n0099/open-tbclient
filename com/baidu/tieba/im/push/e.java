package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e cXV = null;
    private com.baidu.adp.framework.c.e cXW;

    private e() {
        this.cXW = null;
        this.cXW = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e aqW() {
        if (cXV == null) {
            synchronized (e.class) {
                if (cXV == null) {
                    cXV = new e();
                }
            }
        }
        return cXV;
    }

    public com.baidu.adp.framework.c.e bt() {
        return this.cXW;
    }
}
