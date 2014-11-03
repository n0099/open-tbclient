package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private static q PX = null;
    private int PY;
    private int currentIndex = 0;
    private boolean PZ = false;
    private boolean Qa = false;
    private List<String> Pq = null;
    private boolean Qb = false;
    private final com.baidu.adp.lib.webSocket.l Qc = new r(this);

    public static synchronized q qJ() {
        q qVar;
        synchronized (q.class) {
            if (PX == null) {
                synchronized (q.class) {
                    if (PX == null) {
                        PX = new q();
                    }
                }
            }
            qVar = PX;
        }
        return qVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.m.fT().a(this.Qc);
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

    private String qK() {
        if (this.Pq == null || this.currentIndex <= -1 || this.currentIndex >= this.Pq.size()) {
            return null;
        }
        return a.qq().qt().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(String str) {
        String qK = qK();
        if (qK == null) {
            if (!a.qq().qv()) {
                a.qq().a(new s(this, str));
            }
            com.baidu.adp.framework.client.socket.l.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            qL();
        } else if (cT(qK) == null) {
            qL();
        } else {
            this.Qb = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.l.setUrl(qK);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.PZ = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qL() {
        NoNetworkView.nx();
        this.Qa = false;
        this.currentIndex = 0;
        this.Qb = false;
        this.PZ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM() {
        if (!this.Qb) {
            this.Qb = true;
            if (this.PZ) {
                this.PZ = false;
                f.qy().cQ(TiebaIMConfig.url);
            }
            f.qy().qz();
            if (!this.Qa) {
                new j("www.baidu.com", new t(this));
                this.Qa = true;
                return;
            }
            cU("change ip to reconnect with DNS' failed.");
        }
    }
}
