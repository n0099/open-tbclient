package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic aVf;
    private static long aVi = -1;
    private static int aVj = 0;
    private i aVg = new i(null);
    private j aVh = null;

    static {
        MC();
    }

    public static ImDbShrinkStatic MC() {
        if (aVf == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (aVf == null) {
                    aVf = new ImDbShrinkStatic();
                }
            }
        }
        return aVf;
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, 2001011));
    }

    public void execute() {
        if (this.aVh != null) {
            this.aVh.cancel();
            this.aVh = null;
        }
        this.aVh = new j(this, null);
        this.aVh.setParallel(TiebaIMConfig.getParallel());
        this.aVh.setPriority(4);
        this.aVh.execute(new String[0]);
    }

    public void stop() {
        if (this.aVh != null) {
            this.aVh.cancel();
            this.aVh = null;
        }
    }
}
