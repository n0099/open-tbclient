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
    private static f bqk = null;
    private int bql;
    private int currentIndex = 0;
    private boolean bqm = false;
    private boolean bqn = false;
    private List<String> bpD = null;
    private boolean bqo = false;
    private final g.a bqp = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.bql >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.JQ().fQ(com.baidu.adp.framework.client.socket.h.getUrl());
                a.JQ().JU();
            }
            f.this.bql = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.oJ()) {
                f.b(f.this);
                if (f.this.bql >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.Km();
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
        int i = fVar.bql;
        fVar.bql = i + 1;
        return i;
    }

    public static synchronized f Kj() {
        f fVar;
        synchronized (f.class) {
            if (bqk == null) {
                synchronized (f.class) {
                    if (bqk == null) {
                        bqk = new f();
                    }
                }
            }
            fVar = bqk;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.pv().a(this.bqp);
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

    private String Kk() {
        if (this.bpD == null || this.currentIndex <= -1 || this.currentIndex >= this.bpD.size()) {
            return null;
        }
        return a.JQ().JT().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fW(final String str) {
        String Kk = Kk();
        if (Kk == null) {
            if (!a.JQ().JV()) {
                a.JQ().a(new a.InterfaceC0104a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0104a
                    public void JW() {
                        f.this.currentIndex = 0;
                        f.this.bpD = a.JQ().JT();
                        if (f.this.bpD != null) {
                            f.this.fW(str);
                        } else {
                            f.this.bqo = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Kl();
        } else if (fV(Kk) == null) {
            Kl();
        } else {
            this.bqo = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Kk);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.bqm = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kl() {
        NoNetworkView.DZ();
        this.bqn = false;
        this.currentIndex = 0;
        this.bqo = false;
        this.bqm = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km() {
        if (!this.bqo) {
            this.bqo = true;
            if (this.bqm) {
                this.bqm = false;
                b.JY().fS(TiebaIMConfig.url);
            }
            b.JY().JZ();
            if (!this.bqn) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bX(boolean z) {
                        b.JY().hs(z ? 2 : 1);
                        if (z) {
                            f.this.bpD = a.JQ().JT();
                            if (f.this.bpD != null) {
                                f.this.fW("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.JQ().a(new a.InterfaceC0104a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0104a
                                    public void JW() {
                                        f.this.currentIndex = 0;
                                        f.this.bpD = a.JQ().JT();
                                        if (f.this.bpD != null) {
                                            f.this.fW("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.bqo = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.bqo = false;
                        f.this.Kl();
                    }
                });
                this.bqn = true;
                return;
            }
            fW("change ip to reconnect with DNS' failed.");
        }
    }
}
