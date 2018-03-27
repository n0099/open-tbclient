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
    private static f bqn = null;
    private int bqo;
    private int currentIndex = 0;
    private boolean bqp = false;
    private boolean bqq = false;
    private List<String> bpG = null;
    private boolean bqr = false;
    private final g.a bqs = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.bqo >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.JR().fQ(com.baidu.adp.framework.client.socket.h.getUrl());
                a.JR().JV();
            }
            f.this.bqo = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.oJ()) {
                f.b(f.this);
                if (f.this.bqo >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.Kn();
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
        int i = fVar.bqo;
        fVar.bqo = i + 1;
        return i;
    }

    public static synchronized f Kk() {
        f fVar;
        synchronized (f.class) {
            if (bqn == null) {
                synchronized (f.class) {
                    if (bqn == null) {
                        bqn = new f();
                    }
                }
            }
            fVar = bqn;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.pv().a(this.bqs);
    }

    public static String fV(String str) {
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

    private String Kl() {
        if (this.bpG == null || this.currentIndex <= -1 || this.currentIndex >= this.bpG.size()) {
            return null;
        }
        return a.JR().JU().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(final String str) {
        String Kl = Kl();
        if (Kl == null) {
            if (!a.JR().JW()) {
                a.JR().a(new a.InterfaceC0104a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0104a
                    public void JX() {
                        f.this.currentIndex = 0;
                        f.this.bpG = a.JR().JU();
                        if (f.this.bpG != null) {
                            f.this.fW(str);
                        } else {
                            f.this.bqr = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Km();
        } else if (fV(Kl) == null) {
            Km();
        } else {
            this.bqr = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Kl);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.bqp = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km() {
        NoNetworkView.Ea();
        this.bqq = false;
        this.currentIndex = 0;
        this.bqr = false;
        this.bqp = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kn() {
        if (!this.bqr) {
            this.bqr = true;
            if (this.bqp) {
                this.bqp = false;
                b.JZ().fS(TiebaIMConfig.url);
            }
            b.JZ().Ka();
            if (!this.bqq) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bX(boolean z) {
                        b.JZ().hs(z ? 2 : 1);
                        if (z) {
                            f.this.bpG = a.JR().JU();
                            if (f.this.bpG != null) {
                                f.this.fW("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.JR().a(new a.InterfaceC0104a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0104a
                                    public void JX() {
                                        f.this.currentIndex = 0;
                                        f.this.bpG = a.JR().JU();
                                        if (f.this.bpG != null) {
                                            f.this.fW("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.bqr = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.bqr = false;
                        f.this.Km();
                    }
                });
                this.bqq = true;
                return;
            }
            fW("change ip to reconnect with DNS' failed.");
        }
    }
}
