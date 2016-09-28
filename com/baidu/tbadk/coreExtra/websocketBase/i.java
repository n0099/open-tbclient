package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i arC = null;
    private int arD;
    private int currentIndex = 0;
    private boolean arE = false;
    private boolean arF = false;
    private List<String> aqU = null;
    private boolean arG = false;
    private final g.a arH = new j(this);

    public static synchronized i BJ() {
        i iVar;
        synchronized (i.class) {
            if (arC == null) {
                synchronized (i.class) {
                    if (arC == null) {
                        arC = new i();
                    }
                }
            }
            iVar = arC;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ha().a(this.arH);
    }

    public static String fb(String str) {
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

    private String BK() {
        if (this.aqU == null || this.currentIndex <= -1 || this.currentIndex >= this.aqU.size()) {
            return null;
        }
        return a.Bq().Bt().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fc(String str) {
        String BK = BK();
        if (BK == null) {
            if (!a.Bq().Bv()) {
                a.Bq().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BL();
        } else if (fb(BK) == null) {
            BL();
        } else {
            this.arG = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(BK);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.arE = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BL() {
        NoNetworkView.ws();
        this.arF = false;
        this.currentIndex = 0;
        this.arG = false;
        this.arE = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BM() {
        if (!this.arG) {
            this.arG = true;
            if (this.arE) {
                this.arE = false;
                c.By().eY(TiebaIMConfig.url);
            }
            c.By().Bz();
            if (!this.arF) {
                new e("www.baidu.com", new l(this));
                this.arF = true;
                return;
            }
            fc("change ip to reconnect with DNS' failed.");
        }
    }
}
