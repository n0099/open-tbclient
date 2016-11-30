package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e dqL = null;
    private com.baidu.adp.framework.c.e dqM;

    private e() {
        this.dqM = null;
        this.dqM = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e ayg() {
        if (dqL == null) {
            synchronized (e.class) {
                if (dqL == null) {
                    dqL = new e();
                }
            }
        }
        return dqL;
    }

    public com.baidu.adp.framework.c.e co() {
        return this.dqM;
    }
}
