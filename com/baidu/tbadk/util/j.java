package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class j {
    private CustomMessageListener xr;
    private static final byte[] aAz = new byte[1];
    private static j aAA = null;

    public static j Ft() {
        if (aAA == null) {
            synchronized (aAz) {
                if (aAA == null) {
                    aAA = new j();
                }
            }
        }
        return aAA;
    }

    private j() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Fu() {
        try {
            if (this.xr == null) {
                this.xr = Fv();
                MessageManager.getInstance().registerListener(this.xr);
            }
        } catch (Exception e) {
            this.xr = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Fv() {
        return new k(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fw() {
        try {
            boolean iP = com.baidu.adp.lib.util.i.iP();
            if (iP) {
                if (com.baidu.adp.lib.util.i.iQ()) {
                    ay.vq().av(true);
                } else if (com.baidu.adp.lib.util.i.iR()) {
                    ay.vq().av(false);
                }
            }
            NoNetworkView.setIsHasNetwork(iP);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
