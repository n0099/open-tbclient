package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i are = null;
    private int arf;
    private int currentIndex = 0;
    private boolean arg = false;
    private boolean arh = false;
    private List<String> aqx = null;
    private boolean ari = false;
    private final g.a arj = new j(this);

    public static synchronized i By() {
        i iVar;
        synchronized (i.class) {
            if (are == null) {
                synchronized (i.class) {
                    if (are == null) {
                        are = new i();
                    }
                }
            }
            iVar = are;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.gY().a(this.arj);
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

    private String Bz() {
        if (this.aqx == null || this.currentIndex <= -1 || this.currentIndex >= this.aqx.size()) {
            return null;
        }
        return a.Bf().Bi().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eX(String str) {
        String Bz = Bz();
        if (Bz == null) {
            if (!a.Bf().Bk()) {
                a.Bf().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BA();
        } else if (eW(Bz) == null) {
            BA();
        } else {
            this.ari = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(Bz);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.arg = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BA() {
        NoNetworkView.wb();
        this.arh = false;
        this.currentIndex = 0;
        this.ari = false;
        this.arg = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BB() {
        if (!this.ari) {
            this.ari = true;
            if (this.arg) {
                this.arg = false;
                c.Bn().eT(TiebaIMConfig.url);
            }
            c.Bn().Bo();
            if (!this.arh) {
                new e("www.baidu.com", new l(this));
                this.arh = true;
                return;
            }
            eX("change ip to reconnect with DNS' failed.");
        }
    }
}
