package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i amT = null;
    private int amU;
    private int currentIndex = 0;
    private boolean amV = false;
    private boolean amW = false;
    private List<String> amn = null;
    private boolean amX = false;
    private final g.a amY = new j(this);

    public static synchronized i zJ() {
        i iVar;
        synchronized (i.class) {
            if (amT == null) {
                synchronized (i.class) {
                    if (amT == null) {
                        amT = new i();
                    }
                }
            }
            iVar = amT;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.jz().a(this.amY);
    }

    public static String eD(String str) {
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

    private String zK() {
        if (this.amn == null || this.currentIndex <= -1 || this.currentIndex >= this.amn.size()) {
            return null;
        }
        return a.zq().zt().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(String str) {
        String zK = zK();
        if (zK == null) {
            if (!a.zq().zv()) {
                a.zq().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            zL();
        } else if (eD(zK) == null) {
            zL();
        } else {
            this.amX = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(zK);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.amV = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL() {
        NoNetworkView.vw();
        this.amW = false;
        this.currentIndex = 0;
        this.amX = false;
        this.amV = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM() {
        if (!this.amX) {
            this.amX = true;
            if (this.amV) {
                this.amV = false;
                c.zy().eA(TiebaIMConfig.url);
            }
            c.zy().zz();
            if (!this.amW) {
                new e("www.baidu.com", new l(this));
                this.amW = true;
                return;
            }
            eE("change ip to reconnect with DNS' failed.");
        }
    }
}
