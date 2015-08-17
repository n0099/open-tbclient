package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i amF = null;
    private int amG;
    private int currentIndex = 0;
    private boolean amH = false;
    private boolean amI = false;
    private List<String> alZ = null;
    private boolean amJ = false;
    private final g.a amK = new j(this);

    public static synchronized i zH() {
        i iVar;
        synchronized (i.class) {
            if (amF == null) {
                synchronized (i.class) {
                    if (amF == null) {
                        amF = new i();
                    }
                }
            }
            iVar = amF;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.jB().a(this.amK);
    }

    public static String er(String str) {
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

    private String zI() {
        if (this.alZ == null || this.currentIndex <= -1 || this.currentIndex >= this.alZ.size()) {
            return null;
        }
        return a.zo().zr().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(String str) {
        String zI = zI();
        if (zI == null) {
            if (!a.zo().zt()) {
                a.zo().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            zJ();
        } else if (er(zI) == null) {
            zJ();
        } else {
            this.amJ = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(zI);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.amH = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zJ() {
        NoNetworkView.vz();
        this.amI = false;
        this.currentIndex = 0;
        this.amJ = false;
        this.amH = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zK() {
        if (!this.amJ) {
            this.amJ = true;
            if (this.amH) {
                this.amH = false;
                c.zw().eo(TiebaIMConfig.url);
            }
            c.zw().zx();
            if (!this.amI) {
                new e("www.baidu.com", new l(this));
                this.amI = true;
                return;
            }
            es("change ip to reconnect with DNS' failed.");
        }
    }
}
