package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class j {
    private static final byte[] aCg = new byte[1];
    private static j aCh = null;
    private CustomMessageListener xt;

    public static j Fh() {
        if (aCh == null) {
            synchronized (aCg) {
                if (aCh == null) {
                    aCh = new j();
                }
            }
        }
        return aCh;
    }

    private j() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Fi() {
        try {
            if (this.xt == null) {
                this.xt = Fj();
                MessageManager.getInstance().registerListener(this.xt);
            }
        } catch (Exception e) {
            this.xt = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Fj() {
        return new k(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fk() {
        try {
            boolean iQ = com.baidu.adp.lib.util.i.iQ();
            if (iQ) {
                if (com.baidu.adp.lib.util.i.iR()) {
                    ay.va().as(true);
                } else if (com.baidu.adp.lib.util.i.iS()) {
                    ay.va().as(false);
                }
            }
            NoNetworkView.setIsHasNetwork(iQ);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
