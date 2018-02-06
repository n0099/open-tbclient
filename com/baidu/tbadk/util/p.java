package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p {
    private static final byte[] bDm = new byte[1];
    private static p bDn = null;
    private CustomMessageListener mNetworkChangedListener;

    public static p Pe() {
        if (bDn == null) {
            synchronized (bDm) {
                if (bDn == null) {
                    bDn = new p();
                }
            }
        }
        return bDn;
    }

    private p() {
        com.baidu.adp.lib.util.j.init();
    }

    public void Pf() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Pg();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Pg() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    p.this.Ph();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ph() {
        try {
            boolean oJ = com.baidu.adp.lib.util.j.oJ();
            if (oJ) {
                if (com.baidu.adp.lib.util.j.oK()) {
                    ao.De().bn(true);
                    com.baidu.tieba.recapp.d.a.boS().rU(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.oL()) {
                    ao.De().bn(false);
                }
            }
            NoNetworkView.setIsHasNetwork(oJ);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
