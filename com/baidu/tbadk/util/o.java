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
    private static final byte[] aIO = new byte[1];
    private static o aIP = null;
    private CustomMessageListener mNetworkChangedListener;

    public static o GP() {
        if (aIP == null) {
            synchronized (aIO) {
                if (aIP == null) {
                    aIP = new o();
                }
            }
        }
        return aIP;
    }

    private o() {
        com.baidu.adp.lib.util.i.init();
    }

    public void GQ() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = GR();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener GR() {
        return new p(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GS() {
        try {
            boolean he = com.baidu.adp.lib.util.i.he();
            if (he) {
                if (com.baidu.adp.lib.util.i.hf()) {
                    av.vD().aF(true);
                    com.baidu.tieba.recapp.c.a.aZL().pc(((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.hg()) {
                    av.vD().aF(false);
                }
            }
            NoNetworkView.setIsHasNetwork(he);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
