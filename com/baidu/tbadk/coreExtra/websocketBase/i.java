package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i aoN = null;
    private int aoO;
    private int currentIndex = 0;
    private boolean aoP = false;
    private boolean aoQ = false;
    private List<String> aog = null;
    private boolean aoR = false;
    private final g.a aoS = new j(this);

    public static synchronized i AH() {
        i iVar;
        synchronized (i.class) {
            if (aoN == null) {
                synchronized (i.class) {
                    if (aoN == null) {
                        aoN = new i();
                    }
                }
            }
            iVar = aoN;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.jB().a(this.aoS);
    }

    public static String eN(String str) {
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

    private String AI() {
        if (this.aog == null || this.currentIndex <= -1 || this.currentIndex >= this.aog.size()) {
            return null;
        }
        return a.Ao().Ar().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eO(String str) {
        String AI = AI();
        if (AI == null) {
            if (!a.Ao().At()) {
                a.Ao().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            AJ();
        } else if (eN(AI) == null) {
            AJ();
        } else {
            this.aoR = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(AI);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aoP = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AJ() {
        NoNetworkView.wd();
        this.aoQ = false;
        this.currentIndex = 0;
        this.aoR = false;
        this.aoP = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AK() {
        if (!this.aoR) {
            this.aoR = true;
            if (this.aoP) {
                this.aoP = false;
                c.Aw().eK(TiebaIMConfig.url);
            }
            c.Aw().Ax();
            if (!this.aoQ) {
                new e("www.baidu.com", new l(this));
                this.aoQ = true;
                return;
            }
            eO("change ip to reconnect with DNS' failed.");
        }
    }
}
