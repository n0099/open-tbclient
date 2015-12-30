package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e bZN = null;
    private com.baidu.adp.framework.c.e bZO;

    private e() {
        this.bZO = null;
        this.bZO = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e abu() {
        if (bZN == null) {
            synchronized (e.class) {
                if (bZN == null) {
                    bZN = new e();
                }
            }
        }
        return bZN;
    }

    public com.baidu.adp.framework.c.e eW() {
        return this.bZO;
    }
}
