package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class o {
    private static final byte[] aDr = new byte[1];
    private static o aDs = null;
    private CustomMessageListener mNetworkChangedListener;

    public static o Gq() {
        if (aDs == null) {
            synchronized (aDr) {
                if (aDs == null) {
                    aDs = new o();
                }
            }
        }
        return aDs;
    }

    private o() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Gr() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Gs();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Gs() {
        return new p(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt() {
        try {
            boolean gk = com.baidu.adp.lib.util.i.gk();
            if (gk) {
                if (com.baidu.adp.lib.util.i.gl()) {
                    au.vg().aG(true);
                    com.baidu.tieba.recapp.c.a.bad().pT(((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.gm()) {
                    au.vg().aG(false);
                }
            }
            NoNetworkView.setIsHasNetwork(gk);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
