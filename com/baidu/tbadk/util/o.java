package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class o {
    private static final byte[] aEB = new byte[1];
    private static o aEC = null;
    private CustomMessageListener qR;

    public static o Gy() {
        if (aEC == null) {
            synchronized (aEB) {
                if (aEC == null) {
                    aEC = new o();
                }
            }
        }
        return aEC;
    }

    private o() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Gz() {
        try {
            if (this.qR == null) {
                this.qR = GA();
                MessageManager.getInstance().registerListener(this.qR);
            }
        } catch (Exception e) {
            this.qR = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener GA() {
        return new p(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GB() {
        try {
            boolean gm = com.baidu.adp.lib.util.i.gm();
            if (gm) {
                if (com.baidu.adp.lib.util.i.gn()) {
                    aw.vm().aG(true);
                    com.baidu.tieba.recapp.c.a.aYn().pz(((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.go()) {
                    aw.vm().aG(false);
                }
            }
            NoNetworkView.setIsHasNetwork(gm);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
