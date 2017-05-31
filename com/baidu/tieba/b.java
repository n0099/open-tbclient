package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class b {
    private static volatile b aPJ;
    private long aPG;
    private final int aPE = 2;
    private final int aPF = 3;
    private int aPK = -1;
    private CustomMessageListener aPL = new c(this, CmdConfigCustom.CMD_HOT_SPLASH_SHOW);
    private CustomMessageListener aPM = new d(this, CmdConfigCustom.CMD_APP_ENTER_BACKGROUND);
    private CustomMessageListener aPN = new e(this, CmdConfigCustom.CMD_APP_ENTER_FOREGROUND);
    private CustomMessageListener aPO = new f(this, CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED);
    private boolean aPH = false;
    private boolean aPI = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Iu() {
        if (aPJ == null) {
            synchronized (b.class) {
                if (aPJ == null) {
                    aPJ = new b();
                }
            }
        }
        return aPJ;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aPM);
        MessageManager.getInstance().registerListener(this.aPN);
        MessageManager.getInstance().registerListener(this.aPL);
        MessageManager.getInstance().registerListener(this.aPO);
        if (com.baidu.tieba.recapp.z.aZK().aZH() != null) {
            com.baidu.tieba.recapp.z.aZK().aZH().aZy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iv() {
        this.aPI = true;
        this.aPG = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Iw() {
        Ix();
        this.aPI = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aPH) {
            this.aPH = false;
            return false;
        } else if (currentTimeMillis - this.aPG <= 2 || currentTimeMillis - this.aPG <= this.aPK) {
            return false;
        } else {
            com.baidu.tieba.recapp.u aZH = com.baidu.tieba.recapp.z.aZK().aZH();
            return (aZH != null ? aZH.aZA() : 3) < 3;
        }
    }

    private void Ix() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aPK = adAdSense.xr();
            if (this.aPK <= 0) {
                this.aPK = 86400;
                return;
            }
            return;
        }
        this.aPK = 300;
    }
}
