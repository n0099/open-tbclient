package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i awR = null;
    private int awS;
    private int currentIndex = 0;
    private boolean awT = false;
    private boolean awU = false;
    private List<String> awk = null;
    private boolean awV = false;
    private final g.a awW = new j(this);

    public static synchronized i Cp() {
        i iVar;
        synchronized (i.class) {
            if (awR == null) {
                synchronized (i.class) {
                    if (awR == null) {
                        awR = new i();
                    }
                }
            }
            iVar = awR;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hY().a(this.awW);
    }

    public static String eR(String str) {
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

    private String Cq() {
        if (this.awk == null || this.currentIndex <= -1 || this.currentIndex >= this.awk.size()) {
            return null;
        }
        return a.BW().BZ().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS(String str) {
        String Cq = Cq();
        if (Cq == null) {
            if (!a.BW().Cb()) {
                a.BW().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Cr();
        } else if (eR(Cq) == null) {
            Cr();
        } else {
            this.awV = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(Cq);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.awT = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cr() {
        NoNetworkView.wU();
        this.awU = false;
        this.currentIndex = 0;
        this.awV = false;
        this.awT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cs() {
        if (!this.awV) {
            this.awV = true;
            if (this.awT) {
                this.awT = false;
                c.Ce().eO(TiebaIMConfig.url);
            }
            c.Ce().Cf();
            if (!this.awU) {
                new e("www.baidu.com", new l(this));
                this.awU = true;
                return;
            }
            eS("change ip to reconnect with DNS' failed.");
        }
    }
}
