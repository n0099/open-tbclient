package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p {
    private static final byte[] aJi = new byte[1];
    private static p aJj = null;
    private CustomMessageListener mNetworkChangedListener;

    public static p Gu() {
        if (aJj == null) {
            synchronized (aJi) {
                if (aJj == null) {
                    aJj = new p();
                }
            }
        }
        return aJj;
    }

    private p() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Gv() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Gw();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Gw() {
        return new q(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gx() {
        try {
            boolean hk = com.baidu.adp.lib.util.i.hk();
            if (hk) {
                if (com.baidu.adp.lib.util.i.hl()) {
                    av.vo().aF(true);
                    com.baidu.tieba.recapp.d.a.aYU().pq(((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.hm()) {
                    av.vo().aF(false);
                }
            }
            NoNetworkView.setIsHasNetwork(hk);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
