package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e dfX = null;
    private com.baidu.adp.framework.c.e dfY;

    private e() {
        this.dfY = null;
        this.dfY = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e aua() {
        if (dfX == null) {
            synchronized (e.class) {
                if (dfX == null) {
                    dfX = new e();
                }
            }
        }
        return dfX;
    }

    public com.baidu.adp.framework.c.e dv() {
        return this.dfY;
    }
}
