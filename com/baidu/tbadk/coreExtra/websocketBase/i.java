package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i awP = null;
    private int awQ;
    private int currentIndex = 0;
    private boolean awR = false;
    private boolean awS = false;
    private List<String> awi = null;
    private boolean awT = false;
    private final g.a awU = new j(this);

    public static synchronized i Cp() {
        i iVar;
        synchronized (i.class) {
            if (awP == null) {
                synchronized (i.class) {
                    if (awP == null) {
                        awP = new i();
                    }
                }
            }
            iVar = awP;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hX().a(this.awU);
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
        if (this.awi == null || this.currentIndex <= -1 || this.currentIndex >= this.awi.size()) {
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
            this.awT = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(Cq);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.awR = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cr() {
        NoNetworkView.wU();
        this.awS = false;
        this.currentIndex = 0;
        this.awT = false;
        this.awR = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cs() {
        if (!this.awT) {
            this.awT = true;
            if (this.awR) {
                this.awR = false;
                c.Ce().eO(TiebaIMConfig.url);
            }
            c.Ce().Cf();
            if (!this.awS) {
                new e("www.baidu.com", new l(this));
                this.awS = true;
                return;
            }
            eS("change ip to reconnect with DNS' failed.");
        }
    }
}
