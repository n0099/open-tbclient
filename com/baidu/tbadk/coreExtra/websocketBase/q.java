package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private static q VI = null;
    private int VJ;
    private int currentIndex = 0;
    private boolean VK = false;
    private boolean VL = false;
    private List<String> Vc = null;
    private boolean VM = false;
    private final com.baidu.adp.lib.webSocket.l VN = new r(this);

    public static synchronized q ub() {
        q qVar;
        synchronized (q.class) {
            if (VI == null) {
                synchronized (q.class) {
                    if (VI == null) {
                        VI = new q();
                    }
                }
            }
            qVar = VI;
        }
        return qVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.m.fV().a(this.VN);
    }

    public static String dP(String str) {
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

    private String uc() {
        if (this.Vc == null || this.currentIndex <= -1 || this.currentIndex >= this.Vc.size()) {
            return null;
        }
        return a.tJ().tM().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQ(String str) {
        String uc = uc();
        if (uc == null) {
            if (!a.tJ().tO()) {
                a.tJ().a(new s(this, str));
            }
            com.baidu.adp.framework.client.socket.l.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            ud();
        } else if (dP(uc) == null) {
            ud();
        } else {
            this.VM = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.l.setUrl(uc);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.VK = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud() {
        NoNetworkView.qw();
        this.VL = false;
        this.currentIndex = 0;
        this.VM = false;
        this.VK = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ue() {
        if (!this.VM) {
            this.VM = true;
            if (this.VK) {
                this.VK = false;
                f.tR().dM(TiebaIMConfig.url);
            }
            f.tR().tS();
            if (!this.VL) {
                new j("www.baidu.com", new t(this));
                this.VL = true;
                return;
            }
            dQ("change ip to reconnect with DNS' failed.");
        }
    }
}
