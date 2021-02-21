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
public class w {
    private CustomMessageListener PM;
    private static final byte[] mlock = new byte[1];
    private static w fNb = null;

    public static w bFA() {
        if (fNb == null) {
            synchronized (mlock) {
                if (fNb == null) {
                    fNb = new w();
                }
            }
        }
        return fNb;
    }

    private w() {
        com.baidu.adp.lib.util.j.init();
    }

    public void registerNetworkChangedListener() {
        try {
            if (this.PM == null) {
                this.PM = bFB();
                MessageManager.getInstance().registerListener(this.PM);
            }
        } catch (Exception e) {
            this.PM = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener bFB() {
        return new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tbadk.util.w.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    w.this.handleNetworkState();
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
                    av.bsS().setNetworkIsWifi(true);
                    com.baidu.tieba.recapp.c.a.dEm().dEo();
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    av.bsS().setNetworkIsWifi(false);
                }
            }
            NoNetworkView.setIsHasNetwork(isNetWorkAvailable);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
