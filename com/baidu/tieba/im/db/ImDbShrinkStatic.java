package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic bfj;
    private static long bfm = -1;
    private static int bfn = 0;
    private i bfk = new i(null);
    private j bfl = null;

    static {
        Rt();
    }

    public static ImDbShrinkStatic Rt() {
        if (bfj == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bfj == null) {
                    bfj = new ImDbShrinkStatic();
                }
            }
        }
        return bfj;
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, 2001011));
    }

    public void execute() {
        if (this.bfl != null) {
            this.bfl.cancel();
            this.bfl = null;
        }
        this.bfl = new j(this, null);
        this.bfl.setParallel(TiebaIMConfig.getParallel());
        this.bfl.setPriority(4);
        this.bfl.execute(new String[0]);
    }

    public void stop() {
        if (this.bfl != null) {
            this.bfl.cancel();
            this.bfl = null;
        }
    }
}
