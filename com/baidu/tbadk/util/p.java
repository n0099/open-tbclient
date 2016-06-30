package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p {
    private static final byte[] aAW = new byte[1];
    private static p aAX = null;
    private CustomMessageListener nT;

    public static p FF() {
        if (aAX == null) {
            synchronized (aAW) {
                if (aAX == null) {
                    aAX = new p();
                }
            }
        }
        return aAX;
    }

    private p() {
        com.baidu.adp.lib.util.i.init();
    }

    public void FG() {
        try {
            if (this.nT == null) {
                this.nT = FH();
                MessageManager.getInstance().registerListener(this.nT);
            }
        } catch (Exception e) {
            this.nT = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener FH() {
        return new q(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FI() {
        try {
            boolean fr = com.baidu.adp.lib.util.i.fr();
            if (fr) {
                if (com.baidu.adp.lib.util.i.fs()) {
                    bb.uf().ay(true);
                } else if (com.baidu.adp.lib.util.i.ft()) {
                    bb.uf().ay(false);
                }
            }
            NoNetworkView.setIsHasNetwork(fr);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
