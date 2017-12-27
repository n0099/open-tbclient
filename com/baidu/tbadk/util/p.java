package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p {
    private static final byte[] bAR = new byte[1];
    private static p bAS = null;
    private CustomMessageListener mNetworkChangedListener;

    public static p OJ() {
        if (bAS == null) {
            synchronized (bAR) {
                if (bAS == null) {
                    bAS = new p();
                }
            }
        }
        return bAS;
    }

    private p() {
        com.baidu.adp.lib.util.j.init();
    }

    public void OK() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = OL();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener OL() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    p.this.OM();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OM() {
        try {
            boolean oI = com.baidu.adp.lib.util.j.oI();
            if (oI) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    an.CS().bj(true);
                    com.baidu.tieba.recapp.e.a.bud().sl(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.oK()) {
                    an.CS().bj(false);
                }
            }
            NoNetworkView.setIsHasNetwork(oI);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
