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
    private static g cpR = null;
    private int cpS;
    private int currentIndex = 0;
    private boolean cpT = false;
    private boolean cpU = false;
    private List<String> cpj = null;
    private boolean cpV = false;
    private final g.a cpW = new g.a() { // from class: com.baidu.tbadk.coreExtra.e.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (g.this.cpS >= 5) {
                com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.aqO().pN(com.baidu.adp.framework.client.socket.h.getUrl());
                a.aqO().aqS();
            }
            g.this.cpS = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kc()) {
                g.b(g.this);
                if (g.this.cpS >= 5) {
                    com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    g.this.arj();
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
        int i = gVar.cpS;
        gVar.cpS = i + 1;
        return i;
    }

    public static synchronized g arg() {
        g gVar;
        synchronized (g.class) {
            if (cpR == null) {
                synchronized (g.class) {
                    if (cpR == null) {
                        cpR = new g();
                    }
                }
            }
            gVar = cpR;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.kS().a(this.cpW);
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

    private String arh() {
        if (this.cpj == null || this.currentIndex <= -1 || this.currentIndex >= this.cpj.size()) {
            return null;
        }
        return a.aqO().aqR().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pT(final String str) {
        String arh = arh();
        if (arh == null) {
            if (!a.aqO().aqT()) {
                a.aqO().a(new a.InterfaceC0247a() { // from class: com.baidu.tbadk.coreExtra.e.g.2
                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0247a
                    public void aqU() {
                        g.this.currentIndex = 0;
                        g.this.cpj = a.aqO().aqR();
                        if (g.this.cpj != null) {
                            g.this.pT(str);
                        } else {
                            g.this.cpV = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            ari();
        } else if (pS(arh) == null) {
            ari();
        } else {
            this.cpV = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(arh);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.cpT = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ari() {
        NoNetworkView.JS();
        this.cpU = false;
        this.currentIndex = 0;
        this.cpV = false;
        this.cpT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arj() {
        if (!this.cpV) {
            this.cpV = true;
            if (this.cpT) {
                this.cpT = false;
                b.aqW().pP(TiebaIMConfig.url);
            }
            b.aqW().aqX();
            if (!this.cpU) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.e.g.3
                    @Override // com.baidu.tbadk.coreExtra.e.d.b
                    public void eX(boolean z) {
                        b.aqW().ka(z ? 2 : 1);
                        if (z) {
                            g.this.cpj = a.aqO().aqR();
                            if (g.this.cpj != null) {
                                g.this.pT("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.aqO().a(new a.InterfaceC0247a() { // from class: com.baidu.tbadk.coreExtra.e.g.3.1
                                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0247a
                                    public void aqU() {
                                        g.this.currentIndex = 0;
                                        g.this.cpj = a.aqO().aqR();
                                        if (g.this.cpj != null) {
                                            g.this.pT("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.cpV = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.cpV = false;
                        g.this.ari();
                    }
                });
                this.cpU = true;
                return;
            }
            pT("change ip to reconnect with DNS' failed.");
        }
    }
}
