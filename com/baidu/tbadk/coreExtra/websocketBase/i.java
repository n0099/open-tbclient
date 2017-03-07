package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i awz = null;
    private int awA;
    private int currentIndex = 0;
    private boolean awB = false;
    private boolean awC = false;
    private List<String> avS = null;
    private boolean awD = false;
    private final g.a awE = new j(this);

    public static synchronized i BR() {
        i iVar;
        synchronized (i.class) {
            if (awz == null) {
                synchronized (i.class) {
                    if (awz == null) {
                        awz = new i();
                    }
                }
            }
            iVar = awz;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hS().a(this.awE);
    }

    public static String eL(String str) {
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

    private String BS() {
        if (this.avS == null || this.currentIndex <= -1 || this.currentIndex >= this.avS.size()) {
            return null;
        }
        return a.By().BB().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(String str) {
        String BS = BS();
        if (BS == null) {
            if (!a.By().BD()) {
                a.By().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BT();
        } else if (eL(BS) == null) {
            BT();
        } else {
            this.awD = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(BS);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.awB = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BT() {
        NoNetworkView.wy();
        this.awC = false;
        this.currentIndex = 0;
        this.awD = false;
        this.awB = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU() {
        if (!this.awD) {
            this.awD = true;
            if (this.awB) {
                this.awB = false;
                c.BG().eI(TiebaIMConfig.url);
            }
            c.BG().BH();
            if (!this.awC) {
                new e("www.baidu.com", new l(this));
                this.awC = true;
                return;
            }
            eM("change ip to reconnect with DNS' failed.");
        }
    }
}
