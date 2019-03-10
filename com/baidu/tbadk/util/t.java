package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class t {
    private static final byte[] ctA = new byte[1];
    private static t ctB = null;
    private CustomMessageListener mNetworkChangedListener;

    public static t aqf() {
        if (ctB == null) {
            synchronized (ctA) {
                if (ctB == null) {
                    ctB = new t();
                }
            }
        }
        return ctB;
    }

    private t() {
        com.baidu.adp.lib.util.j.init();
    }

    public void UX() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = aqg();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener aqg() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    t.this.aqh();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqh() {
        try {
            boolean kY = com.baidu.adp.lib.util.j.kY();
            if (kY) {
                if (com.baidu.adp.lib.util.j.kZ()) {
                    ar.adp().dE(true);
                    com.baidu.tieba.recapp.d.a.bXx().BI(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.la()) {
                    ar.adp().dE(false);
                }
            }
            NoNetworkView.setIsHasNetwork(kY);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
