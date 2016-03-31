package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e coN = null;
    private com.baidu.adp.framework.c.e coO;

    private e() {
        this.coO = null;
        this.coO = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e ahN() {
        if (coN == null) {
            synchronized (e.class) {
                if (coN == null) {
                    coN = new e();
                }
            }
        }
        return coN;
    }

    public com.baidu.adp.framework.c.e fe() {
        return this.coO;
    }
}
