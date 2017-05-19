package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.recapp.x;
/* loaded from: classes.dex */
public class b {
    private static volatile b aPK;
    private long aPH;
    private final int aPF = 2;
    private final int aPG = 3;
    private int aPL = -1;
    private CustomMessageListener aPM = new c(this, CmdConfigCustom.CMD_HOT_SPLASH_SHOW);
    private CustomMessageListener aPN = new d(this, CmdConfigCustom.CMD_APP_ENTER_BACKGROUND);
    private CustomMessageListener aPO = new e(this, CmdConfigCustom.CMD_APP_ENTER_FOREGROUND);
    private CustomMessageListener aPP = new f(this, CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED);
    private boolean aPI = false;
    private boolean aPJ = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b Iz() {
        if (aPK == null) {
            synchronized (b.class) {
                if (aPK == null) {
                    aPK = new b();
                }
            }
        }
        return aPK;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aPN);
        MessageManager.getInstance().registerListener(this.aPO);
        MessageManager.getInstance().registerListener(this.aPM);
        MessageManager.getInstance().registerListener(this.aPP);
        if (x.aYp().aYn() != null) {
            x.aYp().aYn().aYe();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IA() {
        this.aPJ = true;
        this.aPH = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IB() {
        IC();
        this.aPJ = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aPI) {
            this.aPI = false;
            return false;
        } else if (currentTimeMillis - this.aPH <= 2 || currentTimeMillis - this.aPH <= this.aPL) {
            return false;
        } else {
            com.baidu.tieba.recapp.s aYn = x.aYp().aYn();
            return (aYn != null ? aYn.aYg() : 3) < 3;
        }
    }

    private void IC() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aPL = adAdSense.xy();
            if (this.aPL <= 0) {
                this.aPL = 86400;
                return;
            }
            return;
        }
        this.aPL = 300;
    }
}
