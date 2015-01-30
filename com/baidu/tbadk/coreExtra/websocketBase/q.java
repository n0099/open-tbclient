package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private static q Wn = null;
    private int Wo;
    private int currentIndex = 0;
    private boolean Wp = false;
    private boolean Wq = false;
    private List<String> VH = null;
    private boolean Wr = false;
    private final com.baidu.adp.lib.webSocket.l Ws = new r(this);

    public static synchronized q us() {
        q qVar;
        synchronized (q.class) {
            if (Wn == null) {
                synchronized (q.class) {
                    if (Wn == null) {
                        Wn = new q();
                    }
                }
            }
            qVar = Wn;
        }
        return qVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.m.fU().a(this.Ws);
    }

    public static String dO(String str) {
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

    private String ut() {
        if (this.VH == null || this.currentIndex <= -1 || this.currentIndex >= this.VH.size()) {
            return null;
        }
        return a.ua().ud().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dP(String str) {
        String ut = ut();
        if (ut == null) {
            if (!a.ua().uf()) {
                a.ua().a(new s(this, str));
            }
            com.baidu.adp.framework.client.socket.l.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            uu();
        } else if (dO(ut) == null) {
            uu();
        } else {
            this.Wr = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.l.setUrl(ut);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.Wp = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uu() {
        NoNetworkView.qH();
        this.Wq = false;
        this.currentIndex = 0;
        this.Wr = false;
        this.Wp = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uv() {
        if (!this.Wr) {
            this.Wr = true;
            if (this.Wp) {
                this.Wp = false;
                f.ui().dL(TiebaIMConfig.url);
            }
            f.ui().uj();
            if (!this.Wq) {
                new j("www.baidu.com", new t(this));
                this.Wq = true;
                return;
            }
            dP("change ip to reconnect with DNS' failed.");
        }
    }
}
