package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e cVF = null;
    private com.baidu.adp.framework.c.e cVG;

    private e() {
        this.cVG = null;
        this.cVG = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e asF() {
        if (cVF == null) {
            synchronized (e.class) {
                if (cVF == null) {
                    cVF = new e();
                }
            }
        }
        return cVF;
    }

    public com.baidu.adp.framework.c.e co() {
        return this.cVG;
    }
}
