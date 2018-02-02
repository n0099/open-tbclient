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
    private static final byte[] bBi = new byte[1];
    private static p bBj = null;
    private CustomMessageListener mNetworkChangedListener;

    public static p Oz() {
        if (bBj == null) {
            synchronized (bBi) {
                if (bBj == null) {
                    bBj = new p();
                }
            }
        }
        return bBj;
    }

    private p() {
        com.baidu.adp.lib.util.j.init();
    }

    public void OA() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = OB();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener OB() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    p.this.OC();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OC() {
        try {
            boolean oJ = com.baidu.adp.lib.util.j.oJ();
            if (oJ) {
                if (com.baidu.adp.lib.util.j.oK()) {
                    an.CK().bk(true);
                    com.baidu.tieba.recapp.e.a.bnx().rN(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.oL()) {
                    an.CK().bk(false);
                }
            }
            NoNetworkView.setIsHasNetwork(oJ);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
