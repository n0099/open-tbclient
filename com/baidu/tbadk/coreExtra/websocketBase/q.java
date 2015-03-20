package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private static q agq = null;
    private int agr;
    private int currentIndex = 0;
    private boolean ags = false;
    private boolean agt = false;
    private List<String> afK = null;
    private boolean agu = false;
    private final com.baidu.adp.lib.webSocket.k agv = new r(this);

    public static synchronized q xD() {
        q qVar;
        synchronized (q.class) {
            if (agq == null) {
                synchronized (q.class) {
                    if (agq == null) {
                        agq = new q();
                    }
                }
            }
            qVar = agq;
        }
        return qVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.l.jr().a(this.agv);
    }

    public static String dU(String str) {
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

    private String xE() {
        if (this.afK == null || this.currentIndex <= -1 || this.currentIndex >= this.afK.size()) {
            return null;
        }
        return a.xl().xo().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dV(String str) {
        String xE = xE();
        if (xE == null) {
            if (!a.xl().xq()) {
                a.xl().a(new s(this, str));
            }
            com.baidu.adp.framework.client.socket.l.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            xF();
        } else if (dU(xE) == null) {
            xF();
        } else {
            this.agu = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.l.setUrl(xE);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.ags = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xF() {
        NoNetworkView.tM();
        this.agt = false;
        this.currentIndex = 0;
        this.agu = false;
        this.ags = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xG() {
        if (!this.agu) {
            this.agu = true;
            if (this.ags) {
                this.ags = false;
                f.xt().dR(TiebaIMConfig.url);
            }
            f.xt().xu();
            if (!this.agt) {
                new j("www.baidu.com", new t(this));
                this.agt = true;
                return;
            }
            dV("change ip to reconnect with DNS' failed.");
        }
    }
}
