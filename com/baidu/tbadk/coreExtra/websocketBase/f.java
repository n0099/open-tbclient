package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.websocketBase.a;
import com.baidu.tbadk.coreExtra.websocketBase.d;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static f boj = null;
    private int bok;
    private int currentIndex = 0;
    private boolean bol = false;
    private boolean bom = false;
    private List<String> bnC = null;
    private boolean bon = false;
    private final g.a boo = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.bok >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Jk().fG(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Jk().Jo();
            }
            f.this.bok = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.oJ()) {
                f.b(f.this);
                if (f.this.bok >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.JG();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void pu() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void J(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void o(byte[] bArr) {
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
        int i = fVar.bok;
        fVar.bok = i + 1;
        return i;
    }

    public static synchronized f JD() {
        f fVar;
        synchronized (f.class) {
            if (boj == null) {
                synchronized (f.class) {
                    if (boj == null) {
                        boj = new f();
                    }
                }
            }
            fVar = boj;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.pv().a(this.boo);
    }

    public static String fL(String str) {
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

    private String JE() {
        if (this.bnC == null || this.currentIndex <= -1 || this.currentIndex >= this.bnC.size()) {
            return null;
        }
        return a.Jk().Jn().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM(final String str) {
        String JE = JE();
        if (JE == null) {
            if (!a.Jk().Jp()) {
                a.Jk().a(new a.InterfaceC0080a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0080a
                    public void Jq() {
                        f.this.currentIndex = 0;
                        f.this.bnC = a.Jk().Jn();
                        if (f.this.bnC != null) {
                            f.this.fM(str);
                        } else {
                            f.this.bon = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            JF();
        } else if (fL(JE) == null) {
            JF();
        } else {
            this.bon = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(JE);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.bol = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JF() {
        NoNetworkView.DG();
        this.bom = false;
        this.currentIndex = 0;
        this.bon = false;
        this.bol = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
        if (!this.bon) {
            this.bon = true;
            if (this.bol) {
                this.bol = false;
                b.Js().fI(TiebaIMConfig.url);
            }
            b.Js().Jt();
            if (!this.bom) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bT(boolean z) {
                        b.Js().ht(z ? 2 : 1);
                        if (z) {
                            f.this.bnC = a.Jk().Jn();
                            if (f.this.bnC != null) {
                                f.this.fM("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Jk().a(new a.InterfaceC0080a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0080a
                                    public void Jq() {
                                        f.this.currentIndex = 0;
                                        f.this.bnC = a.Jk().Jn();
                                        if (f.this.bnC != null) {
                                            f.this.fM("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.bon = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.bon = false;
                        f.this.JF();
                    }
                });
                this.bom = true;
                return;
            }
            fM("change ip to reconnect with DNS' failed.");
        }
    }
}
