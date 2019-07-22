package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class t {
    private static final byte[] cDb = new byte[1];
    private static t cDc = null;
    private CustomMessageListener mNetworkChangedListener;

    public static t awp() {
        if (cDc == null) {
            synchronized (cDb) {
                if (cDc == null) {
                    cDc = new t();
                }
            }
        }
        return cDc;
    }

    private t() {
        com.baidu.adp.lib.util.j.init();
    }

    public void aax() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = awq();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener awq() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    t.this.awr();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awr() {
        try {
            boolean kc = com.baidu.adp.lib.util.j.kc();
            if (kc) {
                if (com.baidu.adp.lib.util.j.kd()) {
                    as.ajo().ee(true);
                    com.baidu.tieba.recapp.d.a.cit().DQ(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.ke()) {
                    as.ajo().ee(false);
                }
            }
            NoNetworkView.setIsHasNetwork(kc);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
