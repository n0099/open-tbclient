package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class b {
    private static volatile b aOZ;
    private long aOW;
    private final int aOU = 2;
    private final int aOV = 3;
    private int aPa = -1;
    private CustomMessageListener aPb = new c(this, CmdConfigCustom.CMD_HOT_SPLASH_SHOW);
    private CustomMessageListener aPc = new d(this, CmdConfigCustom.CMD_APP_ENTER_BACKGROUND);
    private CustomMessageListener aPd = new e(this, CmdConfigCustom.CMD_APP_ENTER_FOREGROUND);
    private CustomMessageListener aPe = new f(this, CmdConfigCustom.CMD_APP_SCREEN_LOCK_STATE_CHANGED);
    private boolean aOX = false;
    private boolean aOY = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b IM() {
        if (aOZ == null) {
            synchronized (b.class) {
                if (aOZ == null) {
                    aOZ = new b();
                }
            }
        }
        return aOZ;
    }

    private b() {
        MessageManager.getInstance().registerListener(this.aPc);
        MessageManager.getInstance().registerListener(this.aPd);
        MessageManager.getInstance().registerListener(this.aPb);
        MessageManager.getInstance().registerListener(this.aPe);
        if (com.baidu.tieba.recapp.r.aZD().aZC() != null) {
            com.baidu.tieba.recapp.r.aZD().aZC().aZu();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IN() {
        this.aOY = true;
        this.aOW = System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean IO() {
        return false;
    }
}
