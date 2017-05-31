package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e dfv = null;
    private com.baidu.adp.framework.c.e dfw;

    private e() {
        this.dfw = null;
        this.dfw = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e arT() {
        if (dfv == null) {
            synchronized (e.class) {
                if (dfv == null) {
                    dfv = new e();
                }
            }
        }
        return dfv;
    }

    public com.baidu.adp.framework.c.e dv() {
        return this.dfw;
    }
}
