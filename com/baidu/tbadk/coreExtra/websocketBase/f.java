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
    private static f ayV = null;
    private int ayW;
    private int currentIndex = 0;
    private boolean ayX = false;
    private boolean ayY = false;
    private List<String> ayo = null;
    private boolean ayZ = false;
    private final g.a aza = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.ayW >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Bu().fl(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Bu().By();
            }
            f.this.ayW = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.hh()) {
                f.b(f.this);
                if (f.this.ayW >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.BQ();
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
        int i = fVar.ayW;
        fVar.ayW = i + 1;
        return i;
    }

    public static synchronized f BN() {
        f fVar;
        synchronized (f.class) {
            if (ayV == null) {
                synchronized (f.class) {
                    if (ayV == null) {
                        ayV = new f();
                    }
                }
            }
            fVar = ayV;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hU().a(this.aza);
    }

    public static String fq(String str) {
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

    private String BO() {
        if (this.ayo == null || this.currentIndex <= -1 || this.currentIndex >= this.ayo.size()) {
            return null;
        }
        return a.Bu().Bx().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fr(final String str) {
        String BO = BO();
        if (BO == null) {
            if (!a.Bu().Bz()) {
                a.Bu().a(new a.InterfaceC0053a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0053a
                    public void BA() {
                        f.this.currentIndex = 0;
                        f.this.ayo = a.Bu().Bx();
                        if (f.this.ayo != null) {
                            f.this.fr(str);
                        } else {
                            f.this.ayZ = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BP();
        } else if (fq(BO) == null) {
            BP();
        } else {
            this.ayZ = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(BO);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.ayX = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BP() {
        NoNetworkView.wn();
        this.ayY = false;
        this.currentIndex = 0;
        this.ayZ = false;
        this.ayX = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BQ() {
        if (!this.ayZ) {
            this.ayZ = true;
            if (this.ayX) {
                this.ayX = false;
                b.BC().fn(TiebaIMConfig.url);
            }
            b.BC().BD();
            if (!this.ayY) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bn(boolean z) {
                        b.BC().ez(z ? 2 : 1);
                        if (z) {
                            f.this.ayo = a.Bu().Bx();
                            if (f.this.ayo != null) {
                                f.this.fr("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Bu().a(new a.InterfaceC0053a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0053a
                                    public void BA() {
                                        f.this.currentIndex = 0;
                                        f.this.ayo = a.Bu().Bx();
                                        if (f.this.ayo != null) {
                                            f.this.fr("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.ayZ = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.ayZ = false;
                        f.this.BP();
                    }
                });
                this.ayY = true;
                return;
            }
            fr("change ip to reconnect with DNS' failed.");
        }
    }
}
