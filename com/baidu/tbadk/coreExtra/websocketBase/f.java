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
    private static f ayl = null;
    private int aym;
    private int currentIndex = 0;
    private boolean ayn = false;
    private boolean ayo = false;
    private List<String> axD = null;
    private boolean ayp = false;
    private final g.a ayq = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.aym >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Bg().fe(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Bg().Bk();
            }
            f.this.aym = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.hh()) {
                f.b(f.this);
                if (f.this.aym >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.BC();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void hT() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void C(String str) {
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
        int i = fVar.aym;
        fVar.aym = i + 1;
        return i;
    }

    public static synchronized f Bz() {
        f fVar;
        synchronized (f.class) {
            if (ayl == null) {
                synchronized (f.class) {
                    if (ayl == null) {
                        ayl = new f();
                    }
                }
            }
            fVar = ayl;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hU().a(this.ayq);
    }

    public static String fj(String str) {
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

    private String BA() {
        if (this.axD == null || this.currentIndex <= -1 || this.currentIndex >= this.axD.size()) {
            return null;
        }
        return a.Bg().Bj().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fk(final String str) {
        String BA = BA();
        if (BA == null) {
            if (!a.Bg().Bl()) {
                a.Bg().a(new a.InterfaceC0053a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0053a
                    public void Bm() {
                        f.this.currentIndex = 0;
                        f.this.axD = a.Bg().Bj();
                        if (f.this.axD != null) {
                            f.this.fk(str);
                        } else {
                            f.this.ayp = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BB();
        } else if (fj(BA) == null) {
            BB();
        } else {
            this.ayp = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(BA);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.ayn = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BB() {
        NoNetworkView.wg();
        this.ayo = false;
        this.currentIndex = 0;
        this.ayp = false;
        this.ayn = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BC() {
        if (!this.ayp) {
            this.ayp = true;
            if (this.ayn) {
                this.ayn = false;
                b.Bo().fg(TiebaIMConfig.url);
            }
            b.Bo().Bp();
            if (!this.ayo) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bs(boolean z) {
                        b.Bo().ey(z ? 2 : 1);
                        if (z) {
                            f.this.axD = a.Bg().Bj();
                            if (f.this.axD != null) {
                                f.this.fk("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Bg().a(new a.InterfaceC0053a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0053a
                                    public void Bm() {
                                        f.this.currentIndex = 0;
                                        f.this.axD = a.Bg().Bj();
                                        if (f.this.axD != null) {
                                            f.this.fk("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.ayp = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.ayp = false;
                        f.this.BB();
                    }
                });
                this.ayo = true;
                return;
            }
            fk("change ip to reconnect with DNS' failed.");
        }
    }
}
