package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic aVt;
    private static long aVw = -1;
    private static int aVx = 0;
    private i aVu = new i(null);
    private j aVv = null;

    static {
        MG();
    }

    public static ImDbShrinkStatic MG() {
        if (aVt == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (aVt == null) {
                    aVt = new ImDbShrinkStatic();
                }
            }
        }
        return aVt;
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, 2001011));
    }

    public void execute() {
        if (this.aVv != null) {
            this.aVv.cancel();
            this.aVv = null;
        }
        this.aVv = new j(this, null);
        this.aVv.setParallel(TiebaIMConfig.getParallel());
        this.aVv.setPriority(4);
        this.aVv.execute(new String[0]);
    }

    public void stop() {
        if (this.aVv != null) {
            this.aVv.cancel();
            this.aVv = null;
        }
    }
}
