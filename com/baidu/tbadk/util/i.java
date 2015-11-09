package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class i {
    private static final byte[] ayu = new byte[1];
    private static i ayv = null;
    private CustomMessageListener xl;

    public static i Eq() {
        if (ayv == null) {
            synchronized (ayu) {
                if (ayv == null) {
                    ayv = new i();
                }
            }
        }
        return ayv;
    }

    private i() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Er() {
        try {
            if (this.xl == null) {
                this.xl = Es();
                MessageManager.getInstance().registerListener(this.xl);
            }
        } catch (Exception e) {
            this.xl = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Es() {
        return new j(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Et() {
        try {
            boolean iN = com.baidu.adp.lib.util.i.iN();
            if (iN) {
                if (com.baidu.adp.lib.util.i.iO()) {
                    at.uK().as(true);
                } else if (com.baidu.adp.lib.util.i.iP()) {
                    at.uK().as(false);
                }
            }
            NoNetworkView.setIsHasNetwork(iN);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
