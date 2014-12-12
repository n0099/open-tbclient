package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic aWL;
    private static long aWO = -1;
    private static int aWP = 0;
    private i aWM = new i(null);
    private j aWN = null;

    static {
        MA();
    }

    public static ImDbShrinkStatic MA() {
        if (aWL == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (aWL == null) {
                    aWL = new ImDbShrinkStatic();
                }
            }
        }
        return aWL;
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, 2001011));
    }

    public void execute() {
        if (this.aWN != null) {
            this.aWN.cancel();
            this.aWN = null;
        }
        this.aWN = new j(this, null);
        this.aWN.setParallel(TiebaIMConfig.getParallel());
        this.aWN.setPriority(4);
        this.aWN.execute(new String[0]);
    }

    public void stop() {
        if (this.aWN != null) {
            this.aWN.cancel();
            this.aWN = null;
        }
    }
}
