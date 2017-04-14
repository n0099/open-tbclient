package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e ddF = null;
    private com.baidu.adp.framework.c.e ddG;

    private e() {
        this.ddG = null;
        this.ddG = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e asZ() {
        if (ddF == null) {
            synchronized (e.class) {
                if (ddF == null) {
                    ddF = new e();
                }
            }
        }
        return ddF;
    }

    public com.baidu.adp.framework.c.e du() {
        return this.ddG;
    }
}
