package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class b {
    private static volatile b aPr;
    private long aPo;
    private final int aPm = 2;
    private final int aPn = 3;
    private int aPs = -1;
    private CustomMessageListener aPt = new c(this, CmdConfigCustom.CMD_HOT_SPLASH_SHOW);
    private CustomMessageListener aPu = new d(this, CmdConfigCustom.CMD_APP_ENTER_BACKGROUND);
    private CustomMessageListener aPv = new e(this, CmdConfigCustom.CMD_APP_ENTER_FOREGROUND);
    private CustomMessageListener aPw = new f(this, CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED);
    private boolean aPp = false;
    private boolean aPq = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Jl() {
        if (aPr == null) {
            synchronized (b.class) {
                if (aPr == null) {
                    aPr = new b();
                }
            }
        }
        return aPr;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aPu);
        MessageManager.getInstance().registerListener(this.aPv);
        MessageManager.getInstance().registerListener(this.aPt);
        MessageManager.getInstance().registerListener(this.aPw);
        if (com.baidu.tieba.recapp.v.baQ().baO() != null) {
            com.baidu.tieba.recapp.v.baQ().baO().baF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jm() {
        this.aPq = true;
        this.aPo = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jn() {
        Jo();
        this.aPq = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aPp) {
            this.aPp = false;
            return false;
        } else if (currentTimeMillis - this.aPo <= 2 || currentTimeMillis - this.aPo <= this.aPs) {
            return false;
        } else {
            com.baidu.tieba.recapp.q baO = com.baidu.tieba.recapp.v.baQ().baO();
            return (baO != null ? baO.baH() : 3) < 3;
        }
    }

    private void Jo() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aPs = adAdSense.yk();
            if (this.aPs <= 0) {
                this.aPs = 86400;
                return;
            }
            return;
        }
        this.aPs = 300;
    }
}
