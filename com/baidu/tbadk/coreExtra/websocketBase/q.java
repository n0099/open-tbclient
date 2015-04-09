package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private static q agy = null;
    private int agz;
    private int currentIndex = 0;
    private boolean agA = false;
    private boolean agB = false;
    private List<String> afS = null;
    private boolean agC = false;
    private final com.baidu.adp.lib.webSocket.k agD = new r(this);

    public static synchronized q xJ() {
        q qVar;
        synchronized (q.class) {
            if (agy == null) {
                synchronized (q.class) {
                    if (agy == null) {
                        agy = new q();
                    }
                }
            }
            qVar = agy;
        }
        return qVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.l.jr().a(this.agD);
    }

    public static String dX(String str) {
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

    private String xK() {
        if (this.afS == null || this.currentIndex <= -1 || this.currentIndex >= this.afS.size()) {
            return null;
        }
        return a.xr().xu().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dY(String str) {
        String xK = xK();
        if (xK == null) {
            if (!a.xr().xw()) {
                a.xr().a(new s(this, str));
            }
            com.baidu.adp.framework.client.socket.l.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            xL();
        } else if (dX(xK) == null) {
            xL();
        } else {
            this.agC = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.l.setUrl(xK);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.agA = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xL() {
        NoNetworkView.tM();
        this.agB = false;
        this.currentIndex = 0;
        this.agC = false;
        this.agA = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xM() {
        if (!this.agC) {
            this.agC = true;
            if (this.agA) {
                this.agA = false;
                f.xz().dU(TiebaIMConfig.url);
            }
            f.xz().xA();
            if (!this.agB) {
                new j("www.baidu.com", new t(this));
                this.agB = true;
                return;
            }
            dY("change ip to reconnect with DNS' failed.");
        }
    }
}
