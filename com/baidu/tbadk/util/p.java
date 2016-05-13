package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p {
    private static final byte[] aAe = new byte[1];
    private static p aAf = null;
    private CustomMessageListener nT;

    public static p Fy() {
        if (aAf == null) {
            synchronized (aAe) {
                if (aAf == null) {
                    aAf = new p();
                }
            }
        }
        return aAf;
    }

    private p() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Fz() {
        try {
            if (this.nT == null) {
                this.nT = FA();
                MessageManager.getInstance().registerListener(this.nT);
            }
        } catch (Exception e) {
            this.nT = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener FA() {
        return new q(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FB() {
        try {
            boolean fq = com.baidu.adp.lib.util.i.fq();
            if (fq) {
                if (com.baidu.adp.lib.util.i.fr()) {
                    az.ug().aA(true);
                } else if (com.baidu.adp.lib.util.i.fs()) {
                    az.ug().aA(false);
                }
            }
            NoNetworkView.setIsHasNetwork(fq);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
