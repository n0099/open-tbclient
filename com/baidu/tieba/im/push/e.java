package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e cpK = null;
    private com.baidu.adp.framework.c.e cpL;

    private e() {
        this.cpL = null;
        this.cpL = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e ahW() {
        if (cpK == null) {
            synchronized (e.class) {
                if (cpK == null) {
                    cpK = new e();
                }
            }
        }
        return cpK;
    }

    public com.baidu.adp.framework.c.e bt() {
        return this.cpL;
    }
}
