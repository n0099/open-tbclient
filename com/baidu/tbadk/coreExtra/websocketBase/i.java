package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i axJ = null;
    private int axK;
    private int currentIndex = 0;
    private boolean axL = false;
    private boolean axM = false;
    private List<String> axb = null;
    private boolean axN = false;
    private final g.a axO = new j(this);

    public static synchronized i BO() {
        i iVar;
        synchronized (i.class) {
            if (axJ == null) {
                synchronized (i.class) {
                    if (axJ == null) {
                        axJ = new i();
                    }
                }
            }
            iVar = axJ;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hW().a(this.axO);
    }

    public static String fi(String str) {
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

    private String BP() {
        if (this.axb == null || this.currentIndex <= -1 || this.currentIndex >= this.axb.size()) {
            return null;
        }
        return a.Bv().By().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fj(String str) {
        String BP = BP();
        if (BP == null) {
            if (!a.Bv().BA()) {
                a.Bv().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BQ();
        } else if (fi(BP) == null) {
            BQ();
        } else {
            this.axN = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(BP);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.axL = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BQ() {
        NoNetworkView.ww();
        this.axM = false;
        this.currentIndex = 0;
        this.axN = false;
        this.axL = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BR() {
        if (!this.axN) {
            this.axN = true;
            if (this.axL) {
                this.axL = false;
                c.BD().ff(TiebaIMConfig.url);
            }
            c.BD().BE();
            if (!this.axM) {
                new e("www.baidu.com", new l(this));
                this.axM = true;
                return;
            }
            fj("change ip to reconnect with DNS' failed.");
        }
    }
}
