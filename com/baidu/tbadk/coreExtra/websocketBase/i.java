package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i anp = null;
    private int anq;
    private int currentIndex = 0;
    private boolean anr = false;
    private boolean ans = false;
    private List<String> amH = null;
    private boolean ant = false;
    private final g.a anu = new j(this);

    public static synchronized i Al() {
        i iVar;
        synchronized (i.class) {
            if (anp == null) {
                synchronized (i.class) {
                    if (anp == null) {
                        anp = new i();
                    }
                }
            }
            iVar = anp;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.gf().a(this.anu);
    }

    public static String eT(String str) {
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

    private String Am() {
        if (this.amH == null || this.currentIndex <= -1 || this.currentIndex >= this.amH.size()) {
            return null;
        }
        return a.zS().zV().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eU(String str) {
        String Am = Am();
        if (Am == null) {
            if (!a.zS().zX()) {
                a.zS().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            An();
        } else if (eT(Am) == null) {
            An();
        } else {
            this.ant = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(Am);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.anr = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void An() {
        NoNetworkView.uY();
        this.ans = false;
        this.currentIndex = 0;
        this.ant = false;
        this.anr = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ao() {
        if (!this.ant) {
            this.ant = true;
            if (this.anr) {
                this.anr = false;
                c.Aa().eQ(TiebaIMConfig.url);
            }
            c.Aa().Ab();
            if (!this.ans) {
                new e("www.baidu.com", new l(this));
                this.ans = true;
                return;
            }
            eU("change ip to reconnect with DNS' failed.");
        }
    }
}
