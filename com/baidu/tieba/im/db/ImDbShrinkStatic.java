package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic a;
    private static long d = -1;
    private static int e = 0;
    private i b = new i(null);
    private j c = null;

    static {
        a();
    }

    public static ImDbShrinkStatic a() {
        if (a == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (a == null) {
                    a = new ImDbShrinkStatic();
                }
            }
        }
        return a;
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, 2001011));
    }

    public void d() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
        this.c = new j(this, null);
        this.c.setParallel(com.baidu.tbadk.k.b());
        this.c.setPriority(4);
        this.c.execute(new String[0]);
    }

    public void e() {
        if (this.c != null) {
            this.c.cancel();
            this.c = null;
        }
    }
}
