package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p {
    private static final byte[] aET = new byte[1];
    private static p aEU = null;
    private CustomMessageListener qQ;

    public static p Ha() {
        if (aEU == null) {
            synchronized (aET) {
                if (aEU == null) {
                    aEU = new p();
                }
            }
        }
        return aEU;
    }

    private p() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Hb() {
        try {
            if (this.qQ == null) {
                this.qQ = Hc();
                MessageManager.getInstance().registerListener(this.qQ);
            }
        } catch (Exception e) {
            this.qQ = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Hc() {
        return new q(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd() {
        try {
            boolean gm = com.baidu.adp.lib.util.i.gm();
            if (gm) {
                if (com.baidu.adp.lib.util.i.gn()) {
                    bb.vk().aC(true);
                } else if (com.baidu.adp.lib.util.i.go()) {
                    bb.vk().aC(false);
                }
            }
            NoNetworkView.setIsHasNetwork(gm);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
