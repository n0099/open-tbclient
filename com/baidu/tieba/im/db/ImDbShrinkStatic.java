package com.baidu.tieba.im.db;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TiebaIMConfig;
/* loaded from: classes.dex */
public class ImDbShrinkStatic {
    private static ImDbShrinkStatic aYh;
    private static long aYk = -1;
    private static int aYl = 0;
    private i aYi = new i(null);
    private j aYj = null;

    static {
        MW();
    }

    public static ImDbShrinkStatic MW() {
        if (aYh == null) {
            synchronized (ImDbShrinkStatic.class) {
                if (aYh == null) {
                    aYh = new ImDbShrinkStatic();
                }
            }
        }
        return aYh;
    }

    private ImDbShrinkStatic() {
        MessageManager.getInstance().registerListener(new h(this, 2001011));
    }

    public void execute() {
        if (this.aYj != null) {
            this.aYj.cancel();
            this.aYj = null;
        }
        this.aYj = new j(this, null);
        this.aYj.setParallel(TiebaIMConfig.getParallel());
        this.aYj.setPriority(4);
        this.aYj.execute(new String[0]);
    }

    public void stop() {
        if (this.aYj != null) {
            this.aYj.cancel();
            this.aYj = null;
        }
    }
}
