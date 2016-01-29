package com.baidu.tbadk.util;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class j {
    private static final byte[] aCW = new byte[1];
    private static j aCX = null;
    private CustomMessageListener xC;

    public static j Gz() {
        if (aCX == null) {
            synchronized (aCW) {
                if (aCX == null) {
                    aCX = new j();
                }
            }
        }
        return aCX;
    }

    private j() {
        com.baidu.adp.lib.util.i.init();
    }

    public void GA() {
        try {
            if (this.xC == null) {
                this.xC = GB();
                MessageManager.getInstance().registerListener(this.xC);
            }
        } catch (Exception e) {
            this.xC = null;
            BdLog.e(e.getMessage());
        }
    }

    private CustomMessageListener GB() {
        return new k(this, 2000994);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GC() {
        try {
            boolean iZ = com.baidu.adp.lib.util.i.iZ();
            if (iZ) {
                if (com.baidu.adp.lib.util.i.ja()) {
                    ax.wg().at(true);
                } else if (com.baidu.adp.lib.util.i.jb()) {
                    ax.wg().at(false);
                }
            }
            NoNetworkView.setIsHasNetwork(iZ);
            CompatibleUtile.dealWebView(null);
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
        }
    }
}
