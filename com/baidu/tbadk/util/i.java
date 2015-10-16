package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class i {
    private static final byte[] azG = new byte[1];
    private static i azH = null;
    private CustomMessageListener xl;

    public static i EB() {
        if (azH == null) {
            synchronized (azG) {
                if (azH == null) {
                    azH = new i();
                }
            }
        }
        return azH;
    }

    private i() {
        com.baidu.adp.lib.util.i.init();
    }

    public void EC() {
        try {
            if (this.xl == null) {
                this.xl = ED();
                MessageManager.getInstance().registerListener(this.xl);
            }
        } catch (Exception e) {
            this.xl = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener ED() {
        return new j(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EE() {
        try {
            boolean iM = com.baidu.adp.lib.util.i.iM();
            if (iM) {
                if (com.baidu.adp.lib.util.i.iN()) {
                    at.uJ().as(true);
                } else if (com.baidu.adp.lib.util.i.iO()) {
                    at.uJ().as(false);
                }
            }
            NoNetworkView.setIsHasNetwork(iM);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
