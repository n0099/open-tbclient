package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class u {
    private CustomMessageListener MX;
    private static final byte[] mlock = new byte[1];
    private static u evk = null;

    public static u bgE() {
        if (evk == null) {
            synchronized (mlock) {
                if (evk == null) {
                    evk = new u();
                }
            }
        }
        return evk;
    }

    private u() {
        com.baidu.adp.lib.util.j.init();
    }

    public void registerNetworkChangedListener() {
        try {
            if (this.MX == null) {
                this.MX = bgF();
                MessageManager.getInstance().registerListener(this.MX);
            }
        } catch (Exception e) {
            this.MX = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener bgF() {
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
                    ar.aUW().setNetworkIsWifi(true);
                    com.baidu.tieba.recapp.d.a.cUZ().Lr(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.isMobileNet()) {
                    ar.aUW().setNetworkIsWifi(false);
                }
            }
            NoNetworkView.setIsHasNetwork(isNetWorkAvailable);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
