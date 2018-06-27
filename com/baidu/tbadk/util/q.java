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
public class q {
    private static final byte[] aWu = new byte[1];
    private static q aWv = null;
    private CustomMessageListener mNetworkChangedListener;

    public static q Lt() {
        if (aWv == null) {
            synchronized (aWu) {
                if (aWv == null) {
                    aWv = new q();
                }
            }
        }
        return aWv;
    }

    private q() {
        com.baidu.adp.lib.util.j.init();
    }

    public void rY() {
        try {
            if (this.mNetworkChangedListener == null) {
                this.mNetworkChangedListener = Lu();
                MessageManager.getInstance().registerListener(this.mNetworkChangedListener);
            }
        } catch (Exception e) {
            this.mNetworkChangedListener = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Lu() {
        return new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.util.q.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                    q.this.Lv();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lv() {
        try {
            boolean jD = com.baidu.adp.lib.util.j.jD();
            if (jD) {
                if (com.baidu.adp.lib.util.j.jE()) {
                    ar.zF().aL(true);
                    com.baidu.tieba.recapp.d.a.bpy().sV(((WifiManager) TbadkCoreApplication.getInst().getSystemService("wifi")).getConnectionInfo().getBSSID());
                } else if (com.baidu.adp.lib.util.j.jF()) {
                    ar.zF().aL(false);
                }
            }
            NoNetworkView.setIsHasNetwork(jD);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
