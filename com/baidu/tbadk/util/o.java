package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class o {
    private static final byte[] aFh = new byte[1];
    private static o aFi = null;
    private CustomMessageListener qR;

    public static o Hc() {
        if (aFi == null) {
            synchronized (aFh) {
                if (aFi == null) {
                    aFi = new o();
                }
            }
        }
        return aFi;
    }

    private o() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Hd() {
        try {
            if (this.qR == null) {
                this.qR = He();
                MessageManager.getInstance().registerListener(this.qR);
            }
        } catch (Exception e) {
            this.qR = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener He() {
        return new p(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf() {
        try {
            boolean gm = com.baidu.adp.lib.util.i.gm();
            if (gm) {
                if (com.baidu.adp.lib.util.i.gn()) {
                    ay.vC().aF(true);
                    com.baidu.tieba.recapp.c.a.beA().qV(((WifiManager) TbadkCoreApplication.m9getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.go()) {
                    ay.vC().aF(false);
                }
            }
            NoNetworkView.setIsHasNetwork(gm);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
