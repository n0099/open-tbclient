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
    private static f aKl = null;
    private int aKm;
    private int currentIndex = 0;
    private boolean aKn = false;
    private boolean aKo = false;
    private List<String> aJE = null;
    private boolean aKp = false;
    private final g.a aKq = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void i(Map<String, String> map) {
            if (f.this.aKm >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Gm().gh(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Gm().Gq();
            }
            f.this.aKm = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.jE()) {
                f.b(f.this);
                if (f.this.aKm >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.GI();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void kp() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void S(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void p(byte[] bArr) {
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
        int i = fVar.aKm;
        fVar.aKm = i + 1;
        return i;
    }

    public static synchronized f GF() {
        f fVar;
        synchronized (f.class) {
            if (aKl == null) {
                synchronized (f.class) {
                    if (aKl == null) {
                        aKl = new f();
                    }
                }
            }
            fVar = aKl;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.kq().a(this.aKq);
    }

    public static String gm(String str) {
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

    private String GG() {
        if (this.aJE == null || this.currentIndex <= -1 || this.currentIndex >= this.aJE.size()) {
            return null;
        }
        return a.Gm().Gp().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gn(final String str) {
        String GG = GG();
        if (GG == null) {
            if (!a.Gm().Gr()) {
                a.Gm().a(new a.InterfaceC0108a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0108a
                    public void Gs() {
                        f.this.currentIndex = 0;
                        f.this.aJE = a.Gm().Gp();
                        if (f.this.aJE != null) {
                            f.this.gn(str);
                        } else {
                            f.this.aKp = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            GH();
        } else if (gm(GG) == null) {
            GH();
        } else {
            this.aKp = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(GG);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aKn = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GH() {
        NoNetworkView.Ar();
        this.aKo = false;
        this.currentIndex = 0;
        this.aKp = false;
        this.aKn = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GI() {
        if (!this.aKp) {
            this.aKp = true;
            if (this.aKn) {
                this.aKn = false;
                b.Gu().gj(TiebaIMConfig.url);
            }
            b.Gu().Gv();
            if (!this.aKo) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bu(boolean z) {
                        b.Gu().ez(z ? 2 : 1);
                        if (z) {
                            f.this.aJE = a.Gm().Gp();
                            if (f.this.aJE != null) {
                                f.this.gn("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Gm().a(new a.InterfaceC0108a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0108a
                                    public void Gs() {
                                        f.this.currentIndex = 0;
                                        f.this.aJE = a.Gm().Gp();
                                        if (f.this.aJE != null) {
                                            f.this.gn("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aKp = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aKp = false;
                        f.this.GH();
                    }
                });
                this.aKo = true;
                return;
            }
            gn("change ip to reconnect with DNS' failed.");
        }
    }
}
