package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i awW = null;
    private int awX;
    private int currentIndex = 0;
    private boolean awY = false;
    private boolean awZ = false;
    private List<String> awo = null;
    private boolean axa = false;
    private final g.a axb = new j(this);

    public static synchronized i BA() {
        i iVar;
        synchronized (i.class) {
            if (awW == null) {
                synchronized (i.class) {
                    if (awW == null) {
                        awW = new i();
                    }
                }
            }
            iVar = awW;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hX().a(this.axb);
    }

    public static String eQ(String str) {
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

    private String BB() {
        if (this.awo == null || this.currentIndex <= -1 || this.currentIndex >= this.awo.size()) {
            return null;
        }
        return a.Bh().Bk().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eR(String str) {
        String BB = BB();
        if (BB == null) {
            if (!a.Bh().Bm()) {
                a.Bh().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BC();
        } else if (eQ(BB) == null) {
            BC();
        } else {
            this.axa = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(BB);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.awY = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BC() {
        NoNetworkView.wh();
        this.awZ = false;
        this.currentIndex = 0;
        this.axa = false;
        this.awY = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BD() {
        if (!this.axa) {
            this.axa = true;
            if (this.awY) {
                this.awY = false;
                c.Bp().eN(TiebaIMConfig.url);
            }
            c.Bp().Bq();
            if (!this.awZ) {
                new e("www.baidu.com", new l(this));
                this.awZ = true;
                return;
            }
            eR("change ip to reconnect with DNS' failed.");
        }
    }
}
