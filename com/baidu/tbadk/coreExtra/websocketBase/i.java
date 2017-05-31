package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i awG = null;
    private int awH;
    private int currentIndex = 0;
    private boolean awI = false;
    private boolean awJ = false;
    private List<String> avY = null;
    private boolean awK = false;
    private final g.a awL = new j(this);

    public static synchronized i Bt() {
        i iVar;
        synchronized (i.class) {
            if (awG == null) {
                synchronized (i.class) {
                    if (awG == null) {
                        awG = new i();
                    }
                }
            }
            iVar = awG;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hX().a(this.awL);
    }

    public static String eO(String str) {
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

    private String Bu() {
        if (this.avY == null || this.currentIndex <= -1 || this.currentIndex >= this.avY.size()) {
            return null;
        }
        return a.Ba().Bd().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(String str) {
        String Bu = Bu();
        if (Bu == null) {
            if (!a.Ba().Bf()) {
                a.Ba().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Bv();
        } else if (eO(Bu) == null) {
            Bv();
        } else {
            this.awK = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(Bu);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.awI = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bv() {
        NoNetworkView.we();
        this.awJ = false;
        this.currentIndex = 0;
        this.awK = false;
        this.awI = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bw() {
        if (!this.awK) {
            this.awK = true;
            if (this.awI) {
                this.awI = false;
                c.Bi().eL(TiebaIMConfig.url);
            }
            c.Bi().Bj();
            if (!this.awJ) {
                new e("www.baidu.com", new l(this));
                this.awJ = true;
                return;
            }
            eP("change ip to reconnect with DNS' failed.");
        }
    }
}
