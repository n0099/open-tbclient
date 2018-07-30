package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p {
    private static final byte[] aWw = new byte[1];
    private static p aWx = null;
    private CustomMessageListener mNetworkChangedListener;

    public static p Lo() {
        if (aWx == null) {
            synchronized (aWw) {
                if (aWx == null) {
                    aWx = new p();
                }
            }
        }
        return aWx;
    }

    private p() {
        com.baidu.adp.lib.util.j.init();
    }

    public void rJ() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Lp();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Lp() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    p.this.Lq();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lq() {
        try {
            boolean jE = com.baidu.adp.lib.util.j.jE();
            if (jE) {
                if (com.baidu.adp.lib.util.j.jF()) {
                    ar.zw().aJ(true);
                    com.baidu.tieba.recapp.d.a.bod().sR(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.jG()) {
                    ar.zw().aJ(false);
                }
            }
            NoNetworkView.setIsHasNetwork(jE);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
