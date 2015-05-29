package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic bfi;
    private static long bfl = -1;
    private static int bfm = 0;
    private i bfj = new i(null);
    private j bfk = null;

    static {
        Rs();
    }

    public static ImDbShrinkStatic Rs() {
        if (bfi == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (bfi == null) {
                    bfi = new ImDbShrinkStatic();
                }
            }
        }
        return bfi;
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, 2001011));
    }

    public void execute() {
        if (this.bfk != null) {
            this.bfk.cancel();
            this.bfk = null;
        }
        this.bfk = new j(this, null);
        this.bfk.setParallel(TiebaIMConfig.getParallel());
        this.bfk.setPriority(4);
        this.bfk.execute(new String[0]);
    }

    public void stop() {
        if (this.bfk != null) {
            this.bfk.cancel();
            this.bfk = null;
        }
    }
}
