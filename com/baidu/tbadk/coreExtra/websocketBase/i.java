package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private static i arZ = null;
    private int asa;
    private int currentIndex = 0;
    private boolean asb = false;
    private boolean asc = false;
    private List<String> arr = null;
    private boolean asd = false;
    private final g.a ase = new j(this);

    public static synchronized i BD() {
        i iVar;
        synchronized (i.class) {
            if (arZ == null) {
                synchronized (i.class) {
                    if (arZ == null) {
                        arZ = new i();
                    }
                }
            }
            iVar = arZ;
        }
        return iVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ha().a(this.ase);
    }

    public static String eZ(String str) {
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

    private String BE() {
        if (this.arr == null || this.currentIndex <= -1 || this.currentIndex >= this.arr.size()) {
            return null;
        }
        return a.Bk().Bn().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fa(String str) {
        String BE = BE();
        if (BE == null) {
            if (!a.Bk().Bp()) {
                a.Bk().a(new k(this, str));
            }
            com.baidu.adp.framework.client.socket.j.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BF();
        } else if (eZ(BE) == null) {
            BF();
        } else {
            this.asd = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.j.setUrl(BE);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.asb = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BF() {
        NoNetworkView.wg();
        this.asc = false;
        this.currentIndex = 0;
        this.asd = false;
        this.asb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BG() {
        if (!this.asd) {
            this.asd = true;
            if (this.asb) {
                this.asb = false;
                c.Bs().eW(TiebaIMConfig.url);
            }
            c.Bs().Bt();
            if (!this.asc) {
                new e("www.baidu.com", new l(this));
                this.asc = true;
                return;
            }
            fa("change ip to reconnect with DNS' failed.");
        }
    }
}
