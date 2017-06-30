package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class q {
    private static final byte[] aKk = new byte[1];
    private static q aKl = null;
    private CustomMessageListener mNetworkChangedListener;

    public static q GL() {
        if (aKl == null) {
            synchronized (aKk) {
                if (aKl == null) {
                    aKl = new q();
                }
            }
        }
        return aKl;
    }

    private q() {
        com.baidu.adp.lib.util.i.init();
    }

    public void GM() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = GN();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener GN() {
        return new r(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GO() {
        try {
            boolean hj = com.baidu.adp.lib.util.i.hj();
            if (hj) {
                if (com.baidu.adp.lib.util.i.hk()) {
                    ax.vA().aF(true);
                    com.baidu.tieba.recapp.d.a.bex().qC(((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.hl()) {
                    ax.vA().aF(false);
                }
            }
            NoNetworkView.setIsHasNetwork(hj);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
