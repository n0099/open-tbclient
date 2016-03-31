package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i arB = null;
    private int arC;
    private int currentIndex = 0;
    private boolean arD = false;
    private boolean arE = false;
    private List<String> aqT = null;
    private boolean arF = false;
    private final g.a arG = new j(this);

    public static synchronized i Cq() {
        i iVar;
        synchronized (i.class) {
            if (arB == null) {
                synchronized (i.class) {
                    if (arB == null) {
                        arB = new i();
                    }
                }
            }
            iVar = arB;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.jR().a(this.arG);
    }

    public static String eW(String str) {
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

    private String Cr() {
        if (this.aqT == null || this.currentIndex <= -1 || this.currentIndex >= this.aqT.size()) {
            return null;
        }
        return a.BX().Ca().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        String Cr = Cr();
        if (Cr == null) {
            if (!a.BX().Cc()) {
                a.BX().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Cs();
        } else if (eW(Cr) == null) {
            Cs();
        } else {
            this.arF = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(Cr);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.arD = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cs() {
        NoNetworkView.xo();
        this.arE = false;
        this.currentIndex = 0;
        this.arF = false;
        this.arD = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ct() {
        if (!this.arF) {
            this.arF = true;
            if (this.arD) {
                this.arD = false;
                c.Cf().eT(TiebaIMConfig.url);
            }
            c.Cf().Cg();
            if (!this.arE) {
                new e("www.baidu.com", new l(this));
                this.arE = true;
                return;
            }
            eX("change ip to reconnect with DNS' failed.");
        }
    }
}
