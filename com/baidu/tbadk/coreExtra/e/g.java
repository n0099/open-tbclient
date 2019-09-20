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
    private static g cqS = null;
    private int cqT;
    private int currentIndex = 0;
    private boolean cqU = false;
    private boolean cqV = false;
    private List<String> cql = null;
    private boolean cqW = false;
    private final g.a cqX = new g.a() { // from class: com.baidu.tbadk.coreExtra.e.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (g.this.cqT >= 5) {
                com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.arc().pY(com.baidu.adp.framework.client.socket.h.getUrl());
                a.arc().arg();
            }
            g.this.cqT = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kc()) {
                g.b(g.this);
                if (g.this.cqT >= 5) {
                    com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    g.this.arx();
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
        int i = gVar.cqT;
        gVar.cqT = i + 1;
        return i;
    }

    public static synchronized g aru() {
        g gVar;
        synchronized (g.class) {
            if (cqS == null) {
                synchronized (g.class) {
                    if (cqS == null) {
                        cqS = new g();
                    }
                }
            }
            gVar = cqS;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.kS().a(this.cqX);
    }

    public static String qd(String str) {
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

    private String arv() {
        if (this.cql == null || this.currentIndex <= -1 || this.currentIndex >= this.cql.size()) {
            return null;
        }
        return a.arc().arf().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qe(final String str) {
        String arv = arv();
        if (arv == null) {
            if (!a.arc().arh()) {
                a.arc().a(new a.InterfaceC0256a() { // from class: com.baidu.tbadk.coreExtra.e.g.2
                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0256a
                    public void ari() {
                        g.this.currentIndex = 0;
                        g.this.cql = a.arc().arf();
                        if (g.this.cql != null) {
                            g.this.qe(str);
                        } else {
                            g.this.cqW = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            arw();
        } else if (qd(arv) == null) {
            arw();
        } else {
            this.cqW = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(arv);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.cqU = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arw() {
        NoNetworkView.JW();
        this.cqV = false;
        this.currentIndex = 0;
        this.cqW = false;
        this.cqU = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arx() {
        if (!this.cqW) {
            this.cqW = true;
            if (this.cqU) {
                this.cqU = false;
                b.ark().qa(TiebaIMConfig.url);
            }
            b.ark().arl();
            if (!this.cqV) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.e.g.3
                    @Override // com.baidu.tbadk.coreExtra.e.d.b
                    public void fa(boolean z) {
                        b.ark().ke(z ? 2 : 1);
                        if (z) {
                            g.this.cql = a.arc().arf();
                            if (g.this.cql != null) {
                                g.this.qe("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.arc().a(new a.InterfaceC0256a() { // from class: com.baidu.tbadk.coreExtra.e.g.3.1
                                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0256a
                                    public void ari() {
                                        g.this.currentIndex = 0;
                                        g.this.cql = a.arc().arf();
                                        if (g.this.cql != null) {
                                            g.this.qe("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.cqW = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.cqW = false;
                        g.this.arw();
                    }
                });
                this.cqV = true;
                return;
            }
            qe("change ip to reconnect with DNS' failed.");
        }
    }
}
