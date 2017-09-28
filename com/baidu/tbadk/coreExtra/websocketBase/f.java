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
    private static f ayx = null;
    private int ayy;
    private int currentIndex = 0;
    private boolean ayz = false;
    private boolean ayA = false;
    private List<String> axP = null;
    private boolean ayB = false;
    private final g.a ayC = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.ayy >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Bm().ff(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Bm().Bq();
            }
            f.this.ayy = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.hh()) {
                f.b(f.this);
                if (f.this.ayy >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.BI();
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
        int i = fVar.ayy;
        fVar.ayy = i + 1;
        return i;
    }

    public static synchronized f BF() {
        f fVar;
        synchronized (f.class) {
            if (ayx == null) {
                synchronized (f.class) {
                    if (ayx == null) {
                        ayx = new f();
                    }
                }
            }
            fVar = ayx;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hU().a(this.ayC);
    }

    public static String fk(String str) {
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

    private String BG() {
        if (this.axP == null || this.currentIndex <= -1 || this.currentIndex >= this.axP.size()) {
            return null;
        }
        return a.Bm().Bp().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fl(final String str) {
        String BG = BG();
        if (BG == null) {
            if (!a.Bm().Br()) {
                a.Bm().a(new a.InterfaceC0053a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0053a
                    public void Bs() {
                        f.this.currentIndex = 0;
                        f.this.axP = a.Bm().Bp();
                        if (f.this.axP != null) {
                            f.this.fl(str);
                        } else {
                            f.this.ayB = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            BH();
        } else if (fk(BG) == null) {
            BH();
        } else {
            this.ayB = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(BG);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.ayz = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BH() {
        NoNetworkView.wn();
        this.ayA = false;
        this.currentIndex = 0;
        this.ayB = false;
        this.ayz = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BI() {
        if (!this.ayB) {
            this.ayB = true;
            if (this.ayz) {
                this.ayz = false;
                b.Bu().fh(TiebaIMConfig.url);
            }
            b.Bu().Bv();
            if (!this.ayA) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bt(boolean z) {
                        b.Bu().ez(z ? 2 : 1);
                        if (z) {
                            f.this.axP = a.Bm().Bp();
                            if (f.this.axP != null) {
                                f.this.fl("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Bm().a(new a.InterfaceC0053a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0053a
                                    public void Bs() {
                                        f.this.currentIndex = 0;
                                        f.this.axP = a.Bm().Bp();
                                        if (f.this.axP != null) {
                                            f.this.fl("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.ayB = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.ayB = false;
                        f.this.BH();
                    }
                });
                this.ayA = true;
                return;
            }
            fl("change ip to reconnect with DNS' failed.");
        }
    }
}
