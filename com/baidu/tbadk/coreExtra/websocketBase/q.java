package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private static q PT = null;
    private int PU;
    private int currentIndex = 0;
    private boolean PV = false;
    private boolean PW = false;
    private List<String> Pm = null;
    private boolean PX = false;
    private final com.baidu.adp.lib.webSocket.l PY = new r(this);

    public static synchronized q qH() {
        q qVar;
        synchronized (q.class) {
            if (PT == null) {
                synchronized (q.class) {
                    if (PT == null) {
                        PT = new q();
                    }
                }
            }
            qVar = PT;
        }
        return qVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.m.fT().a(this.PY);
    }

    public static String cT(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
            try {
                return str.substring(5, lastIndexOf);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private String qI() {
        if (this.Pm == null || this.currentIndex <= -1 || this.currentIndex >= this.Pm.size()) {
            return null;
        }
        return a.qo().qr().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(String str) {
        String qI = qI();
        if (qI == null) {
            if (!a.qo().qt()) {
                a.qo().a(new s(this, str));
            }
            com.baidu.adp.framework.client.socket.l.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            qJ();
        } else if (cT(qI) == null) {
            qJ();
        } else {
            this.PX = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.l.setUrl(qI);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.PV = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qJ() {
        NoNetworkView.nx();
        this.PW = false;
        this.currentIndex = 0;
        this.PX = false;
        this.PV = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qK() {
        if (!this.PX) {
            this.PX = true;
            if (this.PV) {
                this.PV = false;
                f.qw().cQ(TiebaIMConfig.url);
            }
            f.qw().qx();
            if (!this.PW) {
                new j("www.baidu.com", new t(this));
                this.PW = true;
                return;
            }
            cU("change ip to reconnect with DNS' failed.");
        }
    }
}
