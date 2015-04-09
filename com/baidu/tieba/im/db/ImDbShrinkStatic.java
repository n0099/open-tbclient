package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic bcE;
    private static long bcH = -1;
    private static int bcI = 0;
    private i bcF = new i(null);
    private j bcG = null;

    static {
        Qd();
    }

    public static ImDbShrinkStatic Qd() {
        if (bcE == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bcE == null) {
                    bcE = new ImDbShrinkStatic();
                }
            }
        }
        return bcE;
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, 2001011));
    }

    public void execute() {
        if (this.bcG != null) {
            this.bcG.cancel();
            this.bcG = null;
        }
        this.bcG = new j(this, null);
        this.bcG.setParallel(TiebaIMConfig.getParallel());
        this.bcG.setPriority(4);
        this.bcG.execute(new String[0]);
    }

    public void stop() {
        if (this.bcG != null) {
            this.bcG.cancel();
            this.bcG = null;
        }
    }
}
