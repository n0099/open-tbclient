package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class h {
    private static final byte[] azm = new byte[1];
    private static h azn = null;
    private CustomMessageListener xm;

    public static h ED() {
        if (azn == null) {
            synchronized (azm) {
                if (azn == null) {
                    azn = new h();
                }
            }
        }
        return azn;
    }

    private h() {
        com.baidu.adp.lib.util.i.init();
    }

    public void EE() {
        try {
            if (this.xm == null) {
                this.xm = EF();
                MessageManager.getInstance().registerListener(this.xm);
            }
        } catch (Exception e) {
            this.xm = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener EF() {
        return new i(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG() {
        try {
            boolean iO = com.baidu.adp.lib.util.i.iO();
            if (iO) {
                if (com.baidu.adp.lib.util.i.iP()) {
                    ar.uE().as(true);
                } else if (com.baidu.adp.lib.util.i.iQ()) {
                    ar.uE().as(false);
                }
            }
            NoNetworkView.setIsHasNetwork(iO);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
