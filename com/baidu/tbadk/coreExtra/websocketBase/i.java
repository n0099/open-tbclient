package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i anV = null;
    private int anW;
    private int currentIndex = 0;
    private boolean anX = false;
    private boolean anY = false;
    private List<String> ann = null;
    private boolean anZ = false;
    private final g.a aoa = new j(this);

    public static synchronized i Aq() {
        i iVar;
        synchronized (i.class) {
            if (anV == null) {
                synchronized (i.class) {
                    if (anV == null) {
                        anV = new i();
                    }
                }
            }
            iVar = anV;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.gg().a(this.aoa);
    }

    public static String eX(String str) {
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
        if (this.ann == null || this.currentIndex <= -1 || this.currentIndex >= this.ann.size()) {
            return null;
        }
        return a.zX().Aa().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(String str) {
        String Ar = Ar();
        if (Ar == null) {
            if (!a.zX().Ac()) {
                a.zX().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            As();
        } else if (eX(Ar) == null) {
            As();
        } else {
            this.anZ = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(Ar);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.anX = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void As() {
        NoNetworkView.uY();
        this.anY = false;
        this.currentIndex = 0;
        this.anZ = false;
        this.anX = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void At() {
        if (!this.anZ) {
            this.anZ = true;
            if (this.anX) {
                this.anX = false;
                c.Af().eU(TiebaIMConfig.url);
            }
            c.Af().Ag();
            if (!this.anY) {
                new e("www.baidu.com", new l(this));
                this.anY = true;
                return;
            }
            eY("change ip to reconnect with DNS' failed.");
        }
    }
}
