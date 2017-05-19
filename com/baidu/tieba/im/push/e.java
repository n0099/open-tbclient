package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e cZW = null;
    private com.baidu.adp.framework.c.e cZX;

    private e() {
        this.cZX = null;
        this.cZX = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e aqU() {
        if (cZW == null) {
            synchronized (e.class) {
                if (cZW == null) {
                    cZW = new e();
                }
            }
        }
        return cZW;
    }

    public com.baidu.adp.framework.c.e dv() {
        return this.cZX;
    }
}
