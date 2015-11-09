package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i amZ = null;
    private int ana;
    private int currentIndex = 0;
    private boolean anb = false;
    private boolean anc = false;
    private List<String> amt = null;
    private boolean and = false;
    private final g.a ane = new j(this);

    public static synchronized i zL() {
        i iVar;
        synchronized (i.class) {
            if (amZ == null) {
                synchronized (i.class) {
                    if (amZ == null) {
                        amZ = new i();
                    }
                }
            }
            iVar = amZ;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.jA().a(this.ane);
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

    private String zM() {
        if (this.amt == null || this.currentIndex <= -1 || this.currentIndex >= this.amt.size()) {
            return null;
        }
        return a.zs().zv().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eE(String str) {
        String zM = zM();
        if (zM == null) {
            if (!a.zs().zx()) {
                a.zs().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            zN();
        } else if (eD(zM) == null) {
            zN();
        } else {
            this.and = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(zM);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.anb = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zN() {
        NoNetworkView.vx();
        this.anc = false;
        this.currentIndex = 0;
        this.and = false;
        this.anb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zO() {
        if (!this.and) {
            this.and = true;
            if (this.anb) {
                this.anb = false;
                c.zA().eA(TiebaIMConfig.url);
            }
            c.zA().zB();
            if (!this.anc) {
                new e("www.baidu.com", new l(this));
                this.anc = true;
                return;
            }
            eE("change ip to reconnect with DNS' failed.");
        }
    }
}
