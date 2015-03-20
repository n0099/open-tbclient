package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic bco;
    private static long bcr = -1;
    private static int bcs = 0;
    private i bcp = new i(null);
    private j bcq = null;

    static {
        PQ();
    }

    public static ImDbShrinkStatic PQ() {
        if (bco == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bco == null) {
                    bco = new ImDbShrinkStatic();
                }
            }
        }
        return bco;
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, 2001011));
    }

    public void execute() {
        if (this.bcq != null) {
            this.bcq.cancel();
            this.bcq = null;
        }
        this.bcq = new j(this, null);
        this.bcq.setParallel(TiebaIMConfig.getParallel());
        this.bcq.setPriority(4);
        this.bcq.execute(new String[0]);
    }

    public void stop() {
        if (this.bcq != null) {
            this.bcq.cancel();
            this.bcq = null;
        }
    }
}
