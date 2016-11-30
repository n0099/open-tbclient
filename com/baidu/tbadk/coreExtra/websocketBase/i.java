package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i asw = null;
    private int asx;
    private int currentIndex = 0;
    private boolean asy = false;
    private boolean asz = false;
    private List<String> arO = null;
    private boolean asA = false;
    private final g.a asB = new j(this);

    public static synchronized i BQ() {
        i iVar;
        synchronized (i.class) {
            if (asw == null) {
                synchronized (i.class) {
                    if (asw == null) {
                        asw = new i();
                    }
                }
            }
            iVar = asw;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ha().a(this.asB);
    }

    public static String fd(String str) {
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

    private String BR() {
        if (this.arO == null || this.currentIndex <= -1 || this.currentIndex >= this.arO.size()) {
            return null;
        }
        return a.Bx().BA().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fe(String str) {
        String BR = BR();
        if (BR == null) {
            if (!a.Bx().BC()) {
                a.Bx().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BS();
        } else if (fd(BR) == null) {
            BS();
        } else {
            this.asA = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(BR);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.asy = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BS() {
        NoNetworkView.ww();
        this.asz = false;
        this.currentIndex = 0;
        this.asA = false;
        this.asy = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BT() {
        if (!this.asA) {
            this.asA = true;
            if (this.asy) {
                this.asy = false;
                c.BF().fa(TiebaIMConfig.url);
            }
            c.BF().BG();
            if (!this.asz) {
                new e("www.baidu.com", new l(this));
                this.asz = true;
                return;
            }
            fe("change ip to reconnect with DNS' failed.");
        }
    }
}
