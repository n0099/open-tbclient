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
public class o {
    private static final byte[] aJe = new byte[1];
    private static o aJf = null;
    private CustomMessageListener mNetworkChangedListener;

    public static o Ho() {
        if (aJf == null) {
            synchronized (aJe) {
                if (aJf == null) {
                    aJf = new o();
                }
            }
        }
        return aJf;
    }

    private o() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Hp() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Hq();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Hq() {
        return new p(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hr() {
        try {
            boolean hj = com.baidu.adp.lib.util.i.hj();
            if (hj) {
                if (com.baidu.adp.lib.util.i.hk()) {
                    av.wa().aH(true);
                    com.baidu.tieba.recapp.d.a.bau().pr(((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.hl()) {
                    av.wa().aH(false);
                }
            }
            NoNetworkView.setIsHasNetwork(hj);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
