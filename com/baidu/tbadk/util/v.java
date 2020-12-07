package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class v {
    private CustomMessageListener PN;
    private static final byte[] mlock = new byte[1];
    private static v fFT = null;

    public static v bGF() {
        if (fFT == null) {
            synchronized (mlock) {
                if (fFT == null) {
                    fFT = new v();
                }
            }
        }
        return fFT;
    }

    private v() {
        com.baidu.adp.lib.util.j.init();
    }

    public void registerNetworkChangedListener() {
        try {
            if (this.PN == null) {
                this.PN = bGG();
                MessageManager.getInstance().registerListener(this.PN);
            }
        } catch (Exception e) {
            this.PN = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener bGG() {
        return new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tbadk.util.v.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    v.this.handleNetworkState();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleNetworkState() {
        try {
            boolean isNetWorkAvailable = com.baidu.adp.lib.util.j.isNetWorkAvailable();
            if (isNetWorkAvailable) {
                if (com.baidu.adp.lib.util.j.isWifiNet()) {
                    av.btX().setNetworkIsWifi(true);
                    com.baidu.tieba.recapp.d.a.dFX().dFZ();
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    av.btX().setNetworkIsWifi(false);
                }
            }
            NoNetworkView.setIsHasNetwork(isNetWorkAvailable);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
