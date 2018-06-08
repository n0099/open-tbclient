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
    private CustomMessageListener mNetworkChangedListener;
    private static final byte[] aVz = new byte[1];
    private static q aVA = null;

    public static q Lb() {
        if (aVA == null) {
            synchronized (aVz) {
                if (aVA == null) {
                    aVA = new q();
                }
            }
        }
        return aVA;
    }

    private q() {
        com.baidu.adp.lib.util.j.init();
    }

    public void rY() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Lc();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Lc() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    q.this.Ld();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ld() {
        try {
            boolean jD = com.baidu.adp.lib.util.j.jD();
            if (jD) {
                if (com.baidu.adp.lib.util.j.jE()) {
                    aq.zq().aJ(true);
                    com.baidu.tieba.recapp.d.a.boX().sW(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.jF()) {
                    aq.zq().aJ(false);
                }
            }
            NoNetworkView.setIsHasNetwork(jD);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
