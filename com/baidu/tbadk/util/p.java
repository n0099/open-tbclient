package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p {
    private static final byte[] aBM = new byte[1];
    private static p aBN = null;
    private CustomMessageListener oz;

    public static p FG() {
        if (aBN == null) {
            synchronized (aBM) {
                if (aBN == null) {
                    aBN = new p();
                }
            }
        }
        return aBN;
    }

    private p() {
        com.baidu.adp.lib.util.i.init();
    }

    public void FH() {
        try {
            if (this.oz == null) {
                this.oz = FI();
                MessageManager.getInstance().registerListener(this.oz);
            }
        } catch (Exception e) {
            this.oz = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener FI() {
        return new q(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FJ() {
        try {
            boolean fq = com.baidu.adp.lib.util.i.fq();
            if (fq) {
                if (com.baidu.adp.lib.util.i.fr()) {
                    bb.ue().aB(true);
                } else if (com.baidu.adp.lib.util.i.fs()) {
                    bb.ue().aB(false);
                }
            }
            NoNetworkView.setIsHasNetwork(fq);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
