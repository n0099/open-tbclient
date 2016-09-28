package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e dlb = null;
    private com.baidu.adp.framework.c.e dlc;

    private e() {
        this.dlc = null;
        this.dlc = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e awj() {
        if (dlb == null) {
            synchronized (e.class) {
                if (dlb == null) {
                    dlb = new e();
                }
            }
        }
        return dlb;
    }

    public com.baidu.adp.framework.c.e co() {
        return this.dlc;
    }
}
