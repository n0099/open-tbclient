package com.baidu.tbadk.coreExtra.e;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.e.a;
import com.baidu.tbadk.coreExtra.e.d;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g cpY = null;
    private int cpZ;
    private int currentIndex = 0;
    private boolean cqa = false;
    private boolean cqb = false;
    private List<String> cpq = null;
    private boolean cqc = false;
    private final g.a cqd = new g.a() { // from class: com.baidu.tbadk.coreExtra.e.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (g.this.cpZ >= 5) {
                com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.aqQ().pN(com.baidu.adp.framework.client.socket.h.getUrl());
                a.aqQ().aqU();
            }
            g.this.cpZ = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kc()) {
                g.b(g.this);
                if (g.this.cpZ >= 5) {
                    com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    g.this.arl();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void kR() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void S(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void q(byte[] bArr) {
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

    static /* synthetic */ int b(g gVar) {
        int i = gVar.cpZ;
        gVar.cpZ = i + 1;
        return i;
    }

    public static synchronized g ari() {
        g gVar;
        synchronized (g.class) {
            if (cpY == null) {
                synchronized (g.class) {
                    if (cpY == null) {
                        cpY = new g();
                    }
                }
            }
            gVar = cpY;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.kS().a(this.cqd);
    }

    public static String pS(String str) {
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

    private String arj() {
        if (this.cpq == null || this.currentIndex <= -1 || this.currentIndex >= this.cpq.size()) {
            return null;
        }
        return a.aqQ().aqT().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pT(final String str) {
        String arj = arj();
        if (arj == null) {
            if (!a.aqQ().aqV()) {
                a.aqQ().a(new a.InterfaceC0247a() { // from class: com.baidu.tbadk.coreExtra.e.g.2
                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0247a
                    public void aqW() {
                        g.this.currentIndex = 0;
                        g.this.cpq = a.aqQ().aqT();
                        if (g.this.cpq != null) {
                            g.this.pT(str);
                        } else {
                            g.this.cqc = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            ark();
        } else if (pS(arj) == null) {
            ark();
        } else {
            this.cqc = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(arj);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.cqa = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ark() {
        NoNetworkView.JS();
        this.cqb = false;
        this.currentIndex = 0;
        this.cqc = false;
        this.cqa = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arl() {
        if (!this.cqc) {
            this.cqc = true;
            if (this.cqa) {
                this.cqa = false;
                b.aqY().pP(TiebaIMConfig.url);
            }
            b.aqY().aqZ();
            if (!this.cqb) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.e.g.3
                    @Override // com.baidu.tbadk.coreExtra.e.d.b
                    public void eX(boolean z) {
                        b.aqY().kb(z ? 2 : 1);
                        if (z) {
                            g.this.cpq = a.aqQ().aqT();
                            if (g.this.cpq != null) {
                                g.this.pT("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.aqQ().a(new a.InterfaceC0247a() { // from class: com.baidu.tbadk.coreExtra.e.g.3.1
                                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0247a
                                    public void aqW() {
                                        g.this.currentIndex = 0;
                                        g.this.cpq = a.aqQ().aqT();
                                        if (g.this.cpq != null) {
                                            g.this.pT("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.cqc = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.cqc = false;
                        g.this.ark();
                    }
                });
                this.cqb = true;
                return;
            }
            pT("change ip to reconnect with DNS' failed.");
        }
    }
}
