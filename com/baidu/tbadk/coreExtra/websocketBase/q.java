package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private static q Wk = null;
    private int Wl;
    private int currentIndex = 0;
    private boolean Wm = false;
    private boolean Wn = false;
    private List<String> VE = null;
    private boolean Wo = false;
    private final com.baidu.adp.lib.webSocket.l Wp = new r(this);

    public static synchronized q um() {
        q qVar;
        synchronized (q.class) {
            if (Wk == null) {
                synchronized (q.class) {
                    if (Wk == null) {
                        Wk = new q();
                    }
                }
            }
            qVar = Wk;
        }
        return qVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.m.fU().a(this.Wp);
    }

    public static String dL(String str) {
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

    private String un() {
        if (this.VE == null || this.currentIndex <= -1 || this.currentIndex >= this.VE.size()) {
            return null;
        }
        return a.tU().tX().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dM(String str) {
        String un = un();
        if (un == null) {
            if (!a.tU().tZ()) {
                a.tU().a(new s(this, str));
            }
            com.baidu.adp.framework.client.socket.l.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            uo();
        } else if (dL(un) == null) {
            uo();
        } else {
            this.Wo = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.l.setUrl(un);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.Wm = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uo() {
        NoNetworkView.qB();
        this.Wn = false;
        this.currentIndex = 0;
        this.Wo = false;
        this.Wm = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void up() {
        if (!this.Wo) {
            this.Wo = true;
            if (this.Wm) {
                this.Wm = false;
                f.uc().dI(TiebaIMConfig.url);
            }
            f.uc().ud();
            if (!this.Wn) {
                new j("www.baidu.com", new t(this));
                this.Wn = true;
                return;
            }
            dM("change ip to reconnect with DNS' failed.");
        }
    }
}
