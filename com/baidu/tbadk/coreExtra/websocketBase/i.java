package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i aqr = null;
    private int aqs;
    private int currentIndex = 0;
    private boolean aqt = false;
    private boolean aqu = false;
    private List<String> apK = null;
    private boolean aqv = false;
    private final g.a aqw = new j(this);

    public static synchronized i Ax() {
        i iVar;
        synchronized (i.class) {
            if (aqr == null) {
                synchronized (i.class) {
                    if (aqr == null) {
                        aqr = new i();
                    }
                }
            }
            iVar = aqr;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.jC().a(this.aqw);
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

    private String Ay() {
        if (this.apK == null || this.currentIndex <= -1 || this.currentIndex >= this.apK.size()) {
            return null;
        }
        return a.Ae().Ah().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eR(String str) {
        String Ay = Ay();
        if (Ay == null) {
            if (!a.Ae().Aj()) {
                a.Ae().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Az();
        } else if (eQ(Ay) == null) {
            Az();
        } else {
            this.aqv = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(Ay);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aqt = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Az() {
        NoNetworkView.vN();
        this.aqu = false;
        this.currentIndex = 0;
        this.aqv = false;
        this.aqt = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AA() {
        if (!this.aqv) {
            this.aqv = true;
            if (this.aqt) {
                this.aqt = false;
                c.Am().eN(TiebaIMConfig.url);
            }
            c.Am().An();
            if (!this.aqu) {
                new e("www.baidu.com", new l(this));
                this.aqu = true;
                return;
            }
            eR("change ip to reconnect with DNS' failed.");
        }
    }
}
