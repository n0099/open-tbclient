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
    private static final byte[] aNb = new byte[1];
    private static p aNc = null;
    private CustomMessageListener mNetworkChangedListener;

    public static p Hk() {
        if (aNc == null) {
            synchronized (aNb) {
                if (aNc == null) {
                    aNc = new p();
                }
            }
        }
        return aNc;
    }

    private p() {
        com.baidu.adp.lib.util.j.init();
    }

    public void Hl() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Hm();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Hm() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.p.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    p.this.Hn();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn() {
        try {
            boolean hh = com.baidu.adp.lib.util.j.hh();
            if (hh) {
                if (com.baidu.adp.lib.util.j.hi()) {
                    an.vs().aB(true);
                    com.baidu.tieba.recapp.e.a.bmv().rZ(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.hj()) {
                    an.vs().aB(false);
                }
            }
            NoNetworkView.setIsHasNetwork(hh);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
