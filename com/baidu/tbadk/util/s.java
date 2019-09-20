package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class s {
    private static final byte[] cDZ = new byte[1];
    private static s cEa = null;
    private CustomMessageListener mNetworkChangedListener;

    public static s awD() {
        if (cEa == null) {
            synchronized (cDZ) {
                if (cEa == null) {
                    cEa = new s();
                }
            }
        }
        return cEa;
    }

    private s() {
        com.baidu.adp.lib.util.j.init();
    }

    public void aaB() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = awE();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener awE() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.s.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    s.this.awF();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awF() {
        try {
            boolean kc = com.baidu.adp.lib.util.j.kc();
            if (kc) {
                if (com.baidu.adp.lib.util.j.kd()) {
                    ar.ajw().ee(true);
                    com.baidu.tieba.recapp.d.a.cjz().Er(((WifiManager) TbadkCoreApplication.getInst().getSystemService(IXAdSystemUtils.NT_WIFI)).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.ke()) {
                    ar.ajw().ee(false);
                }
            }
            NoNetworkView.setIsHasNetwork(kc);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
