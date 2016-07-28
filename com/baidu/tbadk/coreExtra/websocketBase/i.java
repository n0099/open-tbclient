package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i aoK = null;
    private int aoL;
    private int currentIndex = 0;
    private boolean aoM = false;
    private boolean aoN = false;
    private List<String> aoc = null;
    private boolean aoO = false;
    private final g.a aoP = new j(this);

    public static synchronized i Aq() {
        i iVar;
        synchronized (i.class) {
            if (aoK == null) {
                synchronized (i.class) {
                    if (aoK == null) {
                        aoK = new i();
                    }
                }
            }
            iVar = aoK;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.gf().a(this.aoP);
    }

    public static String eV(String str) {
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

    private String Ar() {
        if (this.aoc == null || this.currentIndex <= -1 || this.currentIndex >= this.aoc.size()) {
            return null;
        }
        return a.zX().Aa().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eW(String str) {
        String Ar = Ar();
        if (Ar == null) {
            if (!a.zX().Ac()) {
                a.zX().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            As();
        } else if (eV(Ar) == null) {
            As();
        } else {
            this.aoO = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(Ar);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aoM = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void As() {
        NoNetworkView.uY();
        this.aoN = false;
        this.currentIndex = 0;
        this.aoO = false;
        this.aoM = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void At() {
        if (!this.aoO) {
            this.aoO = true;
            if (this.aoM) {
                this.aoM = false;
                c.Af().eS(TiebaIMConfig.url);
            }
            c.Af().Ag();
            if (!this.aoN) {
                new e("www.baidu.com", new l(this));
                this.aoN = true;
                return;
            }
            eW("change ip to reconnect with DNS' failed.");
        }
    }
}
