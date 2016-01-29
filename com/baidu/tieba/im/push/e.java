package com.baidu.tieba.im.push;
/* loaded from: classes.dex */
public class e {
    private static e cei = null;
    private com.baidu.adp.framework.c.e cej;

    private e() {
        this.cej = null;
        this.cej = new com.baidu.adp.framework.c.e(1000, 1000, 1000);
    }

    public static e aeu() {
        if (cei == null) {
            synchronized (e.class) {
                if (cei == null) {
                    cei = new e();
                }
            }
        }
        return cei;
    }

    public com.baidu.adp.framework.c.e fc() {
        return this.cej;
    }
}
