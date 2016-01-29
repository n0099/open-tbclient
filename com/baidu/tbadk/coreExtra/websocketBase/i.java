package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i ark = null;
    private int arl;
    private int currentIndex = 0;
    private boolean arm = false;
    private boolean arn = false;
    private List<String> aqC = null;
    private boolean aro = false;
    private final g.a arp = new j(this);

    public static synchronized i BN() {
        i iVar;
        synchronized (i.class) {
            if (ark == null) {
                synchronized (i.class) {
                    if (ark == null) {
                        ark = new i();
                    }
                }
            }
            iVar = ark;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.jL().a(this.arp);
    }

    public static String eP(String str) {
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

    private String BO() {
        if (this.aqC == null || this.currentIndex <= -1 || this.currentIndex >= this.aqC.size()) {
            return null;
        }
        return a.Bu().Bx().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eQ(String str) {
        String BO = BO();
        if (BO == null) {
            if (!a.Bu().Bz()) {
                a.Bu().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BP();
        } else if (eP(BO) == null) {
            BP();
        } else {
            this.aro = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(BO);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.arm = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP() {
        NoNetworkView.wV();
        this.arn = false;
        this.currentIndex = 0;
        this.aro = false;
        this.arm = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BQ() {
        if (!this.aro) {
            this.aro = true;
            if (this.arm) {
                this.arm = false;
                c.BC().eM(TiebaIMConfig.url);
            }
            c.BC().BD();
            if (!this.arn) {
                new e("www.baidu.com", new l(this));
                this.arn = true;
                return;
            }
            eQ("change ip to reconnect with DNS' failed.");
        }
    }
}
