package com.baidu.tbadk.util;

import android.net.wifi.WifiManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class t {
    private static final byte[] cBJ = new byte[1];
    private static t cBK = null;
    private CustomMessageListener mNetworkChangedListener;

    public static t avg() {
        if (cBK == null) {
            synchronized (cBJ) {
                if (cBK == null) {
                    cBK = new t();
                }
            }
        }
        return cBK;
    }

    private t() {
        com.baidu.adp.lib.util.j.init();
    }

    public void Zy() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = avh();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener avh() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.t.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    t.this.avi();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avi() {
        try {
            boolean jS = com.baidu.adp.lib.util.j.jS();
            if (jS) {
                if (com.baidu.adp.lib.util.j.jT()) {
                    ar.ail().ea(true);
                    com.baidu.tieba.recapp.d.a.cfB().Db(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.jU()) {
                    ar.ail().ea(false);
                }
            }
            NoNetworkView.setIsHasNetwork(jS);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
