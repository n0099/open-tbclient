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
public class n {
    private static final byte[] aLO = new byte[1];
    private static n aLP = null;
    private CustomMessageListener mNetworkChangedListener;

    public static n GL() {
        if (aLP == null) {
            synchronized (aLO) {
                if (aLP == null) {
                    aLP = new n();
                }
            }
        }
        return aLP;
    }

    private n() {
        com.baidu.adp.lib.util.j.init();
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
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.n.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    n.this.GO();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GO() {
        try {
            boolean hh = com.baidu.adp.lib.util.j.hh();
            if (hh) {
                if (com.baidu.adp.lib.util.j.hi()) {
                    an.vs().aE(true);
                    com.baidu.tieba.recapp.d.a.bgz().qN(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.hj()) {
                    an.vs().aE(false);
                }
            }
            NoNetworkView.setIsHasNetwork(hh);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
