package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class m {
    private static final byte[] aDU = new byte[1];
    private static m aDV = null;
    private CustomMessageListener xT;

    public static m Hv() {
        if (aDV == null) {
            synchronized (aDU) {
                if (aDV == null) {
                    aDV = new m();
                }
            }
        }
        return aDV;
    }

    private m() {
        com.baidu.adp.lib.util.i.init();
    }

    public void Hw() {
        try {
            if (this.xT == null) {
                this.xT = Hx();
                MessageManager.getInstance().registerListener(this.xT);
            }
        } catch (Exception e) {
            this.xT = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener Hx() {
        return new n(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hy() {
        try {
            boolean jf = com.baidu.adp.lib.util.i.jf();
            if (jf) {
                if (com.baidu.adp.lib.util.i.jg()) {
                    az.wz().av(true);
                } else if (com.baidu.adp.lib.util.i.jh()) {
                    az.wz().av(false);
                }
            }
            NoNetworkView.setIsHasNetwork(jf);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
