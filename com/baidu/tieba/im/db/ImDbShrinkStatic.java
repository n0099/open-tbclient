package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic aYg;
    private static long aYj = -1;
    private static int aYk = 0;
    private i aYh = new i(null);
    private j aYi = null;

    static {
        MR();
    }

    public static ImDbShrinkStatic MR() {
        if (aYg == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (aYg == null) {
                    aYg = new ImDbShrinkStatic();
                }
            }
        }
        return aYg;
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, 2001011));
    }

    public void execute() {
        if (this.aYi != null) {
            this.aYi.cancel();
            this.aYi = null;
        }
        this.aYi = new j(this, null);
        this.aYi.setParallel(TiebaIMConfig.getParallel());
        this.aYi.setPriority(4);
        this.aYi.execute(new String[0]);
    }

    public void stop() {
        if (this.aYi != null) {
            this.aYi.cancel();
            this.aYi = null;
        }
    }
}
