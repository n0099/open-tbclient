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
    private static final byte[] biC = new byte[1];
    private static q biD = null;
    private CustomMessageListener mNetworkChangedListener;

    public static q PW() {
        if (biD == null) {
            synchronized (biC) {
                if (biD == null) {
                    biD = new q();
                }
            }
        }
        return biD;
    }

    private q() {
        com.baidu.adp.lib.util.j.init();
    }

    public void wm() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = PX();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener PX() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    q.this.PY();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PY() {
        try {
            boolean kV = com.baidu.adp.lib.util.j.kV();
            if (kV) {
                if (com.baidu.adp.lib.util.j.kW()) {
                    aq.DR().bv(true);
                    com.baidu.tieba.recapp.d.a.bvo().uJ(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.kX()) {
                    aq.DR().bv(false);
                }
            }
            NoNetworkView.setIsHasNetwork(kV);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
