package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes2.dex */
public class u {
    private CustomMessageListener Oe;
    private static final byte[] mlock = new byte[1];
    private static u eVr = null;

    public static u bvz() {
        if (eVr == null) {
            synchronized (mlock) {
                if (eVr == null) {
                    eVr = new u();
                }
            }
        }
        return eVr;
    }

    private u() {
        com.baidu.adp.lib.util.j.init();
    }

    public void registerNetworkChangedListener() {
        try {
            if (this.Oe == null) {
                this.Oe = bvA();
                MessageManager.getInstance().registerListener(this.Oe);
            }
        } catch (Exception e) {
            this.Oe = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener bvA() {
        return new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tbadk.util.u.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    u.this.handleNetworkState();
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
                    au.bjr().setNetworkIsWifi(true);
                    com.baidu.tieba.recapp.d.a.dnW().dnY();
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    au.bjr().setNetworkIsWifi(false);
                }
            }
            NoNetworkView.setIsHasNetwork(isNetWorkAvailable);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
