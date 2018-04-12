package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class p {
    private static final byte[] aNB = new byte[1];
    private static p aNC = null;
    private CustomMessageListener mNetworkChangedListener;

    public static p HH() {
        if (aNC == null) {
            synchronized (aNB) {
                if (aNC == null) {
                    aNC = new p();
                }
            }
        }
        return aNC;
    }

    private p() {
        com.baidu.adp.lib.util.j.init();
    }

    public void oE() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = HI();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener HI() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    p.this.HJ();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HJ() {
        try {
            boolean gP = com.baidu.adp.lib.util.j.gP();
            if (gP) {
                if (com.baidu.adp.lib.util.j.gQ()) {
                    ap.vQ().aF(true);
                    com.baidu.tieba.recapp.d.a.bjZ().sb(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.gR()) {
                    ap.vQ().aF(false);
                }
            }
            NoNetworkView.setIsHasNetwork(gP);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
