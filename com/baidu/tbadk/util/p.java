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
    private static final byte[] bBa = new byte[1];
    private static p bBb = null;
    private CustomMessageListener mNetworkChangedListener;

    public static p Ox() {
        if (bBb == null) {
            synchronized (bBa) {
                if (bBb == null) {
                    bBb = new p();
                }
            }
        }
        return bBb;
    }

    private p() {
        com.baidu.adp.lib.util.j.init();
    }

    public void Oy() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Oz();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Oz() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    p.this.OA();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OA() {
        try {
            boolean oI = com.baidu.adp.lib.util.j.oI();
            if (oI) {
                if (com.baidu.adp.lib.util.j.oJ()) {
                    an.CJ().bj(true);
                    com.baidu.tieba.recapp.e.a.bnw().rF(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.oK()) {
                    an.CJ().bj(false);
                }
            }
            NoNetworkView.setIsHasNetwork(oI);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
