package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class o {
    private static final byte[] aMI = new byte[1];
    private static o aMJ = null;
    private CustomMessageListener mNetworkChangedListener;

    public static o Hi() {
        if (aMJ == null) {
            synchronized (aMI) {
                if (aMJ == null) {
                    aMJ = new o();
                }
            }
        }
        return aMJ;
    }

    private o() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Hj() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Hk();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Hk() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    o.this.Hl();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        try {
            boolean hr = com.baidu.adp.lib.util.i.hr();
            if (hr) {
                if (com.baidu.adp.lib.util.i.hs()) {
                    am.vQ().aE(true);
                    com.baidu.tieba.recapp.d.a.biO().ri(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.ht()) {
                    am.vQ().aE(false);
                }
            }
            NoNetworkView.setIsHasNetwork(hr);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
