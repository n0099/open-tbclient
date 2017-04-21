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
    private static final byte[] aJg = new byte[1];
    private static o aJh = null;
    private CustomMessageListener mNetworkChangedListener;

    public static o Ho() {
        if (aJh == null) {
            synchronized (aJg) {
                if (aJh == null) {
                    aJh = new o();
                }
            }
        }
        return aJh;
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
            boolean hk = com.baidu.adp.lib.util.i.hk();
            if (hk) {
                if (com.baidu.adp.lib.util.i.hl()) {
                    av.wa().aH(true);
                    com.baidu.tieba.recapp.d.a.bbv().ps(((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.hm()) {
                    av.wa().aH(false);
                }
            }
            NoNetworkView.setIsHasNetwork(hk);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
