package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class b {
    private static volatile b aRb;
    private long aQY;
    private final int aQW = 2;
    private final int aQX = 3;
    private int aRc = -1;
    private CustomMessageListener aRd = new c(this, CmdConfigCustom.CMD_HOT_SPLASH_SHOW);
    private CustomMessageListener aRe = new d(this, CmdConfigCustom.CMD_APP_ENTER_BACKGROUND);
    private CustomMessageListener aRf = new e(this, CmdConfigCustom.CMD_APP_ENTER_FOREGROUND);
    private CustomMessageListener aRg = new f(this, CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED);
    private boolean aQZ = false;
    private boolean aRa = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b IS() {
        if (aRb == null) {
            synchronized (b.class) {
                if (aRb == null) {
                    aRb = new b();
                }
            }
        }
        return aRb;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aRe);
        MessageManager.getInstance().registerListener(this.aRf);
        MessageManager.getInstance().registerListener(this.aRd);
        MessageManager.getInstance().registerListener(this.aRg);
        if (com.baidu.tieba.recapp.aa.bdU().bdR() != null) {
            com.baidu.tieba.recapp.aa.bdU().bdR().bdI();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IT() {
        this.aRa = true;
        this.aQY = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IU() {
        IV();
        this.aRa = false;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.aQZ) {
            this.aQZ = false;
            return false;
        } else if (currentTimeMillis - this.aQY <= 2 || currentTimeMillis - this.aQY <= this.aRc) {
            return false;
        } else {
            com.baidu.tieba.recapp.v bdR = com.baidu.tieba.recapp.aa.bdU().bdR();
            return (bdR != null ? bdR.bdK() : 3) < 3;
        }
    }

    private void IV() {
        com.baidu.tbadk.coreExtra.data.a adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense();
        if (adAdSense != null) {
            this.aRc = adAdSense.xI();
            if (this.aRc <= 0) {
                this.aRc = 86400;
                return;
            }
            return;
        }
        this.aRc = 300;
    }
}
