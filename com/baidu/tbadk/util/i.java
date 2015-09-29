package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class i {
    private static final byte[] azv = new byte[1];
    private static i azw = null;
    private CustomMessageListener xl;

    public static i EB() {
        if (azw == null) {
            synchronized (azv) {
                if (azw == null) {
                    azw = new i();
                }
            }
        }
        return azw;
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
                    as.uI().as(true);
                } else if (com.baidu.adp.lib.util.i.iO()) {
                    as.uI().as(false);
                }
            }
            NoNetworkView.setIsHasNetwork(iM);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
