package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.client.socket.i;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.ar.util.SystemInfoUtil;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.websocketBase.a;
import com.baidu.tbadk.coreExtra.websocketBase.d;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class f {
    private static f aJi = null;
    private int aJj;
    private int currentIndex = 0;
    private boolean aJk = false;
    private boolean aJl = false;
    private List<String> aIB = null;
    private boolean aJm = false;
    private final g.a aJn = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void i(Map<String, String> map) {
            if (f.this.aJj >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.FY().gf(com.baidu.adp.framework.client.socket.h.getUrl());
                a.FY().Gc();
            }
            f.this.aJj = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.jD()) {
                f.b(f.this);
                if (f.this.aJj >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.Gu();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void ko() {
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

    static /* synthetic */ int b(f fVar) {
        int i = fVar.aJj;
        fVar.aJj = i + 1;
        return i;
    }

    public static synchronized f Gr() {
        f fVar;
        synchronized (f.class) {
            if (aJi == null) {
                synchronized (f.class) {
                    if (aJi == null) {
                        aJi = new f();
                    }
                }
            }
            fVar = aJi;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.kp().a(this.aJn);
    }

    public static String gk(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(SystemInfoUtil.COLON)) >= 5) {
            try {
                return str.substring(5, lastIndexOf);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private String Gs() {
        if (this.aIB == null || this.currentIndex <= -1 || this.currentIndex >= this.aIB.size()) {
            return null;
        }
        return a.FY().Gb().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gl(final String str) {
        String Gs = Gs();
        if (Gs == null) {
            if (!a.FY().Gd()) {
                a.FY().a(new a.InterfaceC0110a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0110a
                    public void Ge() {
                        f.this.currentIndex = 0;
                        f.this.aIB = a.FY().Gb();
                        if (f.this.aIB != null) {
                            f.this.gl(str);
                        } else {
                            f.this.aJm = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Gt();
        } else if (gk(Gs) == null) {
            Gt();
        } else {
            this.aJm = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Gs);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aJk = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt() {
        NoNetworkView.Al();
        this.aJl = false;
        this.currentIndex = 0;
        this.aJm = false;
        this.aJk = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gu() {
        if (!this.aJm) {
            this.aJm = true;
            if (this.aJk) {
                this.aJk = false;
                b.Gg().gh(TiebaIMConfig.url);
            }
            b.Gg().Gh();
            if (!this.aJl) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bt(boolean z) {
                        b.Gg().ev(z ? 2 : 1);
                        if (z) {
                            f.this.aIB = a.FY().Gb();
                            if (f.this.aIB != null) {
                                f.this.gl("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.FY().a(new a.InterfaceC0110a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0110a
                                    public void Ge() {
                                        f.this.currentIndex = 0;
                                        f.this.aIB = a.FY().Gb();
                                        if (f.this.aIB != null) {
                                            f.this.gl("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aJm = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aJm = false;
                        f.this.Gt();
                    }
                });
                this.aJl = true;
                return;
            }
            gl("change ip to reconnect with DNS' failed.");
        }
    }
}
