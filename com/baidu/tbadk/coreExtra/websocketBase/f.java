package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.websocketBase.a;
import com.baidu.tbadk.coreExtra.websocketBase.d;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static f aKf = null;
    private int aKg;
    private int currentIndex = 0;
    private boolean aKh = false;
    private boolean aKi = false;
    private List<String> aJy = null;
    private boolean aKj = false;
    private final g.a aKk = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void i(Map<String, String> map) {
            if (f.this.aKg >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Gq().gj(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Gq().Gu();
            }
            f.this.aKg = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.jD()) {
                f.b(f.this);
                if (f.this.aKg >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.GM();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void ko() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void S(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void r(byte[] bArr) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void b(k.a aVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void b(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(int i, com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void c(com.baidu.adp.lib.webSocket.c cVar) {
        }
    };

    static /* synthetic */ int b(f fVar) {
        int i = fVar.aKg;
        fVar.aKg = i + 1;
        return i;
    }

    public static synchronized f GJ() {
        f fVar;
        synchronized (f.class) {
            if (aKf == null) {
                synchronized (f.class) {
                    if (aKf == null) {
                        aKf = new f();
                    }
                }
            }
            fVar = aKf;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.kp().a(this.aKk);
    }

    public static String go(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(SystemInfoUtil.COLON)) >= 5) {
            try {
                return str.substring(5, lastIndexOf);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private String GK() {
        if (this.aJy == null || this.currentIndex <= -1 || this.currentIndex >= this.aJy.size()) {
            return null;
        }
        return a.Gq().Gt().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gp(final String str) {
        String GK = GK();
        if (GK == null) {
            if (!a.Gq().Gv()) {
                a.Gq().a(new a.InterfaceC0111a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0111a
                    public void Gw() {
                        f.this.currentIndex = 0;
                        f.this.aJy = a.Gq().Gt();
                        if (f.this.aJy != null) {
                            f.this.gp(str);
                        } else {
                            f.this.aKj = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            GL();
        } else if (go(GK) == null) {
            GL();
        } else {
            this.aKj = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(GK);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aKh = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GL() {
        NoNetworkView.AB();
        this.aKi = false;
        this.currentIndex = 0;
        this.aKj = false;
        this.aKh = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GM() {
        if (!this.aKj) {
            this.aKj = true;
            if (this.aKh) {
                this.aKh = false;
                b.Gy().gl(TiebaIMConfig.url);
            }
            b.Gy().Gz();
            if (!this.aKi) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bw(boolean z) {
                        b.Gy().ew(z ? 2 : 1);
                        if (z) {
                            f.this.aJy = a.Gq().Gt();
                            if (f.this.aJy != null) {
                                f.this.gp("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Gq().a(new a.InterfaceC0111a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0111a
                                    public void Gw() {
                                        f.this.currentIndex = 0;
                                        f.this.aJy = a.Gq().Gt();
                                        if (f.this.aJy != null) {
                                            f.this.gp("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aKj = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aKj = false;
                        f.this.GL();
                    }
                });
                this.aKi = true;
                return;
            }
            gp("change ip to reconnect with DNS' failed.");
        }
    }
}
