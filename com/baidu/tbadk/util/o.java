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
    private static final byte[] aLs = new byte[1];
    private static o aLt = null;
    private CustomMessageListener mNetworkChangedListener;

    public static o Ha() {
        if (aLt == null) {
            synchronized (aLs) {
                if (aLt == null) {
                    aLt = new o();
                }
            }
        }
        return aLt;
    }

    private o() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Hb() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Hc();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Hc() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.o.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    o.this.Hd();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd() {
        try {
            boolean hh = com.baidu.adp.lib.util.i.hh();
            if (hh) {
                if (com.baidu.adp.lib.util.i.hi()) {
                    am.vG().aE(true);
                    com.baidu.tieba.recapp.d.a.bhY().rb(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.i.hj()) {
                    am.vG().aE(false);
                }
            }
            NoNetworkView.setIsHasNetwork(hh);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
