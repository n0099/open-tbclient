package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import java.util.List;
/* loaded from: classes.dex */
public class q {
    private static q ahz = null;
    private int ahA;
    private int currentIndex = 0;
    private boolean ahB = false;
    private boolean ahC = false;
    private List<String> agT = null;
    private boolean ahD = false;
    private final com.baidu.adp.lib.webSocket.k ahE = new r(this);

    public static synchronized q yx() {
        q qVar;
        synchronized (q.class) {
            if (ahz == null) {
                synchronized (q.class) {
                    if (ahz == null) {
                        ahz = new q();
                    }
                }
            }
            qVar = ahz;
        }
        return qVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.l.jI().a(this.ahE);
    }

    public static String eo(String str) {
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

    private String yy() {
        if (this.agT == null || this.currentIndex <= -1 || this.currentIndex >= this.agT.size()) {
            return null;
        }
        return a.yf().yi().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ep(String str) {
        String yy = yy();
        if (yy == null) {
            if (!a.yf().yk()) {
                a.yf().a(new s(this, str));
            }
            com.baidu.adp.framework.client.socket.l.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            yz();
        } else if (eo(yy) == null) {
            yz();
        } else {
            this.ahD = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.l.setUrl(yy);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.ahB = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yz() {
        NoNetworkView.uv();
        this.ahC = false;
        this.currentIndex = 0;
        this.ahD = false;
        this.ahB = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yA() {
        if (!this.ahD) {
            this.ahD = true;
            if (this.ahB) {
                this.ahB = false;
                f.yn().el(TiebaIMConfig.url);
            }
            f.yn().yo();
            if (!this.ahC) {
                new j("www.baidu.com", new t(this));
                this.ahC = true;
                return;
            }
            ep("change ip to reconnect with DNS' failed.");
        }
    }
}
