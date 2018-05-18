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
    private static final byte[] aNC = new byte[1];
    private static p aND = null;
    private CustomMessageListener mNetworkChangedListener;

    public static p HF() {
        if (aND == null) {
            synchronized (aNC) {
                if (aND == null) {
                    aND = new p();
                }
            }
        }
        return aND;
    }

    private p() {
        com.baidu.adp.lib.util.j.init();
    }

    public void oD() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = HG();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener HG() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    p.this.HH();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HH() {
        try {
            boolean gP = com.baidu.adp.lib.util.j.gP();
            if (gP) {
                if (com.baidu.adp.lib.util.j.gQ()) {
                    ap.vP().aF(true);
                    com.baidu.tieba.recapp.d.a.bjY().se(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.gR()) {
                    ap.vP().aF(false);
                }
            }
            NoNetworkView.setIsHasNetwork(gP);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
