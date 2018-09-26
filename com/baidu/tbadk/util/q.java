package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class q {
    private static final byte[] aZM = new byte[1];
    private static q aZN = null;
    private CustomMessageListener mNetworkChangedListener;

    public static q MJ() {
        if (aZN == null) {
            synchronized (aZM) {
                if (aZN == null) {
                    aZN = new q();
                }
            }
        }
        return aZN;
    }

    private q() {
        com.baidu.adp.lib.util.j.init();
    }

    public void sN() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = MK();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener MK() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    q.this.ML();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ML() {
        try {
            boolean kK = com.baidu.adp.lib.util.j.kK();
            if (kK) {
                if (com.baidu.adp.lib.util.j.kL()) {
                    aq.Az().aU(true);
                    com.baidu.tieba.recapp.d.a.bqL().tC(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.kM()) {
                    aq.Az().aU(false);
                }
            }
            NoNetworkView.setIsHasNetwork(kK);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
