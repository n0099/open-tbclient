package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
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
    private static f ayB = null;
    private int ayC;
    private int currentIndex = 0;
    private boolean ayD = false;
    private boolean ayE = false;
    private List<String> axT = null;
    private boolean ayF = false;
    private final g.a ayG = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.ayC >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.BG().fh(com.baidu.adp.framework.client.socket.h.getUrl());
                a.BG().BK();
            }
            f.this.ayC = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && com.baidu.adp.lib.util.i.hh()) {
                f.b(f.this);
                if (f.this.ayC >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.Cc();
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
        public void r(byte[] bArr) {
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
        int i = fVar.ayC;
        fVar.ayC = i + 1;
        return i;
    }

    public static synchronized f BZ() {
        f fVar;
        synchronized (f.class) {
            if (ayB == null) {
                synchronized (f.class) {
                    if (ayB == null) {
                        ayB = new f();
                    }
                }
            }
            fVar = ayB;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hU().a(this.ayG);
    }

    public static String fm(String str) {
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

    private String Ca() {
        if (this.axT == null || this.currentIndex <= -1 || this.currentIndex >= this.axT.size()) {
            return null;
        }
        return a.BG().BJ().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fn(final String str) {
        String Ca = Ca();
        if (Ca == null) {
            if (!a.BG().BL()) {
                a.BG().a(new a.InterfaceC0051a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0051a
                    public void BM() {
                        f.this.currentIndex = 0;
                        f.this.axT = a.BG().BJ();
                        if (f.this.axT != null) {
                            f.this.fn(str);
                        } else {
                            f.this.ayF = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Cb();
        } else if (fm(Ca) == null) {
            Cb();
        } else {
            this.ayF = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Ca);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.ayD = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cb() {
        NoNetworkView.wG();
        this.ayE = false;
        this.currentIndex = 0;
        this.ayF = false;
        this.ayD = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cc() {
        if (!this.ayF) {
            this.ayF = true;
            if (this.ayD) {
                this.ayD = false;
                b.BO().fj(TiebaIMConfig.url);
            }
            b.BO().BP();
            if (!this.ayE) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bv(boolean z) {
                        b.BO().en(z ? 2 : 1);
                        if (z) {
                            f.this.axT = a.BG().BJ();
                            if (f.this.axT != null) {
                                f.this.fn("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.BG().a(new a.InterfaceC0051a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0051a
                                    public void BM() {
                                        f.this.currentIndex = 0;
                                        f.this.axT = a.BG().BJ();
                                        if (f.this.axT != null) {
                                            f.this.fn("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.ayF = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.ayF = false;
                        f.this.Cb();
                    }
                });
                this.ayE = true;
                return;
            }
            fn("change ip to reconnect with DNS' failed.");
        }
    }
}
