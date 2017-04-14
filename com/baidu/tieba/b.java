package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class b {
    private static volatile b aPp;
    private long aPm;
    private final int aPk = 2;
    private final int aPl = 3;
    private int aPq = -1;
    private CustomMessageListener aPr = new c(this, CmdConfigCustom.CMD_HOT_SPLASH_SHOW);
    private CustomMessageListener aPs = new d(this, CmdConfigCustom.CMD_APP_ENTER_BACKGROUND);
    private CustomMessageListener aPt = new e(this, CmdConfigCustom.CMD_APP_ENTER_FOREGROUND);
    private CustomMessageListener aPu = new f(this, CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED);
    private boolean aPn = false;
    private boolean aPo = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Jl() {
        if (aPp == null) {
            synchronized (b.class) {
                if (aPp == null) {
                    aPp = new b();
                }
            }
        }
        return aPp;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aPs);
        MessageManager.getInstance().registerListener(this.aPt);
        MessageManager.getInstance().registerListener(this.aPr);
        MessageManager.getInstance().registerListener(this.aPu);
        if (com.baidu.tieba.recapp.v.aZP().aZN() != null) {
            com.baidu.tieba.recapp.v.aZP().aZN().aZE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jm() {
        this.aPo = true;
        this.aPm = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Jn() {
        Jo();
        this.aPo = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aPn) {
            this.aPn = false;
            return false;
        } else if (currentTimeMillis - this.aPm <= 2 || currentTimeMillis - this.aPm <= this.aPq) {
            return false;
        } else {
            com.baidu.tieba.recapp.q aZN = com.baidu.tieba.recapp.v.aZP().aZN();
            return (aZN != null ? aZN.aZG() : 3) < 3;
        }
    }

    private void Jo() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aPq = adAdSense.yk();
            if (this.aPq <= 0) {
                this.aPq = 86400;
                return;
            }
            return;
        }
        this.aPq = 300;
    }
}
