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
    private static f azd = null;
    private int aze;
    private int currentIndex = 0;
    private boolean azf = false;
    private boolean azg = false;
    private List<String> ayw = null;
    private boolean azh = false;
    private final g.a azi = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.aze >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.BG().fm(com.baidu.adp.framework.client.socket.h.getUrl());
                a.BG().BK();
            }
            f.this.aze = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.hh()) {
                f.b(f.this);
                if (f.this.aze >= 5) {
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
        int i = fVar.aze;
        fVar.aze = i + 1;
        return i;
    }

    public static synchronized f BZ() {
        f fVar;
        synchronized (f.class) {
            if (azd == null) {
                synchronized (f.class) {
                    if (azd == null) {
                        azd = new f();
                    }
                }
            }
            fVar = azd;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hU().a(this.azi);
    }

    public static String fr(String str) {
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
        if (this.ayw == null || this.currentIndex <= -1 || this.currentIndex >= this.ayw.size()) {
            return null;
        }
        return a.BG().BJ().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(final String str) {
        String Ca = Ca();
        if (Ca == null) {
            if (!a.BG().BL()) {
                a.BG().a(new a.InterfaceC0053a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0053a
                    public void BM() {
                        f.this.currentIndex = 0;
                        f.this.ayw = a.BG().BJ();
                        if (f.this.ayw != null) {
                            f.this.fs(str);
                        } else {
                            f.this.azh = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Cb();
        } else if (fr(Ca) == null) {
            Cb();
        } else {
            this.azh = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Ca);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.azf = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cb() {
        NoNetworkView.wn();
        this.azg = false;
        this.currentIndex = 0;
        this.azh = false;
        this.azf = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cc() {
        if (!this.azh) {
            this.azh = true;
            if (this.azf) {
                this.azf = false;
                b.BO().fo(TiebaIMConfig.url);
            }
            b.BO().BP();
            if (!this.azg) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bo(boolean z) {
                        b.BO().ey(z ? 2 : 1);
                        if (z) {
                            f.this.ayw = a.BG().BJ();
                            if (f.this.ayw != null) {
                                f.this.fs("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.BG().a(new a.InterfaceC0053a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0053a
                                    public void BM() {
                                        f.this.currentIndex = 0;
                                        f.this.ayw = a.BG().BJ();
                                        if (f.this.ayw != null) {
                                            f.this.fs("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.azh = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.azh = false;
                        f.this.Cb();
                    }
                });
                this.azg = true;
                return;
            }
            fs("change ip to reconnect with DNS' failed.");
        }
    }
}
