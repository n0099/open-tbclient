package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p {
    private static final byte[] aEr = new byte[1];
    private static p aEs = null;
    private CustomMessageListener qQ;

    public static p GZ() {
        if (aEs == null) {
            synchronized (aEr) {
                if (aEs == null) {
                    aEs = new p();
                }
            }
        }
        return aEs;
    }

    private p() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Ha() {
        try {
            if (this.qQ == null) {
                this.qQ = Hb();
                MessageManager.getInstance().registerListener(this.qQ);
            }
        } catch (Exception e) {
            this.qQ = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Hb() {
        return new q(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc() {
        try {
            boolean gm = com.baidu.adp.lib.util.i.gm();
            if (gm) {
                if (com.baidu.adp.lib.util.i.gn()) {
                    ba.vy().aC(true);
                } else if (com.baidu.adp.lib.util.i.go()) {
                    ba.vy().aC(false);
                }
            }
            NoNetworkView.setIsHasNetwork(gm);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
