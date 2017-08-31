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
public class o {
    private static final byte[] aMp = new byte[1];
    private static o aMq = null;
    private CustomMessageListener mNetworkChangedListener;

    public static o Hh() {
        if (aMq == null) {
            synchronized (aMp) {
                if (aMq == null) {
                    aMq = new o();
                }
            }
        }
        return aMq;
    }

    private o() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Hi() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Hj();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Hj() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    o.this.Hk();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hk() {
        try {
            boolean hi = com.baidu.adp.lib.util.i.hi();
            if (hi) {
                if (com.baidu.adp.lib.util.i.hj()) {
                    an.vO().aE(true);
                    com.baidu.tieba.recapp.d.a.bhI().rb(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.hk()) {
                    an.vO().aE(false);
                }
            }
            NoNetworkView.setIsHasNetwork(hi);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
