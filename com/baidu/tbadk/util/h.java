package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h {
    private static final byte[] aAU = new byte[1];
    private static h aAV = null;
    private CustomMessageListener xk;

    public static h EN() {
        if (aAV == null) {
            synchronized (aAU) {
                if (aAV == null) {
                    aAV = new h();
                }
            }
        }
        return aAV;
    }

    private h() {
        com.baidu.adp.lib.util.i.init();
    }

    public void EO() {
        try {
            if (this.xk == null) {
                this.xk = EP();
                MessageManager.getInstance().registerListener(this.xk);
            }
        } catch (Exception e) {
            this.xk = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener EP() {
        return new i(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EQ() {
        try {
            boolean iL = com.baidu.adp.lib.util.i.iL();
            if (iL) {
                if (com.baidu.adp.lib.util.i.iM()) {
                    ar.uK().as(true);
                } else if (com.baidu.adp.lib.util.i.iN()) {
                    ar.uK().as(false);
                }
            }
            NoNetworkView.setIsHasNetwork(iL);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
