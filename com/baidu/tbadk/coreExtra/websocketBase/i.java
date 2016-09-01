package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i arR = null;
    private int arS;
    private int currentIndex = 0;
    private boolean arT = false;
    private boolean arU = false;
    private List<String> arj = null;
    private boolean arV = false;
    private final g.a arW = new j(this);

    public static synchronized i BF() {
        i iVar;
        synchronized (i.class) {
            if (arR == null) {
                synchronized (i.class) {
                    if (arR == null) {
                        arR = new i();
                    }
                }
            }
            iVar = arR;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ha().a(this.arW);
    }

    public static String eY(String str) {
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

    private String BG() {
        if (this.arj == null || this.currentIndex <= -1 || this.currentIndex >= this.arj.size()) {
            return null;
        }
        return a.Bm().Bp().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eZ(String str) {
        String BG = BG();
        if (BG == null) {
            if (!a.Bm().Br()) {
                a.Bm().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BH();
        } else if (eY(BG) == null) {
            BH();
        } else {
            this.arV = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(BG);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.arT = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BH() {
        NoNetworkView.wc();
        this.arU = false;
        this.currentIndex = 0;
        this.arV = false;
        this.arT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BI() {
        if (!this.arV) {
            this.arV = true;
            if (this.arT) {
                this.arT = false;
                c.Bu().eV(TiebaIMConfig.url);
            }
            c.Bu().Bv();
            if (!this.arU) {
                new e("www.baidu.com", new l(this));
                this.arU = true;
                return;
            }
            eZ("change ip to reconnect with DNS' failed.");
        }
    }
}
