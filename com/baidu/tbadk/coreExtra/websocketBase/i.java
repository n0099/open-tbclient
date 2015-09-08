package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i aor = null;
    private int aos;
    private int currentIndex = 0;
    private boolean aot = false;
    private boolean aou = false;
    private List<String> anL = null;
    private boolean aov = false;
    private final g.a aow = new j(this);

    public static synchronized i zU() {
        i iVar;
        synchronized (i.class) {
            if (aor == null) {
                synchronized (i.class) {
                    if (aor == null) {
                        aor = new i();
                    }
                }
            }
            iVar = aor;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.jy().a(this.aow);
    }

    public static String ez(String str) {
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

    private String zV() {
        if (this.anL == null || this.currentIndex <= -1 || this.currentIndex >= this.anL.size()) {
            return null;
        }
        return a.zB().zE().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eA(String str) {
        String zV = zV();
        if (zV == null) {
            if (!a.zB().zG()) {
                a.zB().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            zW();
        } else if (ez(zV) == null) {
            zW();
        } else {
            this.aov = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(zV);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aot = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zW() {
        NoNetworkView.vE();
        this.aou = false;
        this.currentIndex = 0;
        this.aov = false;
        this.aot = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zX() {
        if (!this.aov) {
            this.aov = true;
            if (this.aot) {
                this.aot = false;
                c.zJ().ew(TiebaIMConfig.url);
            }
            c.zJ().zK();
            if (!this.aou) {
                new e("www.baidu.com", new l(this));
                this.aou = true;
                return;
            }
            eA("change ip to reconnect with DNS' failed.");
        }
    }
}
