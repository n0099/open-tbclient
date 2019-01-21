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
public class r {
    private static final byte[] bjt = new byte[1];
    private static r bju = null;
    private CustomMessageListener mNetworkChangedListener;

    public static r Qt() {
        if (bju == null) {
            synchronized (bjt) {
                if (bju == null) {
                    bju = new r();
                }
            }
        }
        return bju;
    }

    private r() {
        com.baidu.adp.lib.util.j.init();
    }

    public void wt() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Qu();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Qu() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.r.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    r.this.Qv();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qv() {
        try {
            boolean kV = com.baidu.adp.lib.util.j.kV();
            if (kV) {
                if (com.baidu.adp.lib.util.j.kW()) {
                    aq.Ee().bw(true);
                    com.baidu.tieba.recapp.d.a.bwJ().vc(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.kX()) {
                    aq.Ee().bw(false);
                }
            }
            NoNetworkView.setIsHasNetwork(kV);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
