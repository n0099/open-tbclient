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
    private static final byte[] ben = new byte[1];
    private static q beo = null;
    private CustomMessageListener mNetworkChangedListener;

    public static q OH() {
        if (beo == null) {
            synchronized (ben) {
                if (beo == null) {
                    beo = new q();
                }
            }
        }
        return beo;
    }

    private q() {
        com.baidu.adp.lib.util.j.init();
    }

    public void uY() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = OI();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener OI() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    q.this.OJ();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OJ() {
        try {
            boolean kX = com.baidu.adp.lib.util.j.kX();
            if (kX) {
                if (com.baidu.adp.lib.util.j.kY()) {
                    aq.CG().be(true);
                    com.baidu.tieba.recapp.d.a.bua().ue(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.kZ()) {
                    aq.CG().be(false);
                }
            }
            NoNetworkView.setIsHasNetwork(kX);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
