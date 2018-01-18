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
    private static f boa = null;
    private int bob;
    private int currentIndex = 0;
    private boolean boc = false;
    private boolean bod = false;
    private List<String> bnt = null;
    private boolean boe = false;
    private final g.a bof = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.bob >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Ji().fz(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Ji().Jm();
            }
            f.this.bob = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.oI()) {
                f.b(f.this);
                if (f.this.bob >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.JE();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void pt() {
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
        int i = fVar.bob;
        fVar.bob = i + 1;
        return i;
    }

    public static synchronized f JB() {
        f fVar;
        synchronized (f.class) {
            if (boa == null) {
                synchronized (f.class) {
                    if (boa == null) {
                        boa = new f();
                    }
                }
            }
            fVar = boa;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.pu().a(this.bof);
    }

    public static String fE(String str) {
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

    private String JC() {
        if (this.bnt == null || this.currentIndex <= -1 || this.currentIndex >= this.bnt.size()) {
            return null;
        }
        return a.Ji().Jl().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fF(final String str) {
        String JC = JC();
        if (JC == null) {
            if (!a.Ji().Jn()) {
                a.Ji().a(new a.InterfaceC0079a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0079a
                    public void Jo() {
                        f.this.currentIndex = 0;
                        f.this.bnt = a.Ji().Jl();
                        if (f.this.bnt != null) {
                            f.this.fF(str);
                        } else {
                            f.this.boe = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            JD();
        } else if (fE(JC) == null) {
            JD();
        } else {
            this.boe = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(JC);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.boc = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JD() {
        NoNetworkView.DE();
        this.bod = false;
        this.currentIndex = 0;
        this.boe = false;
        this.boc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JE() {
        if (!this.boe) {
            this.boe = true;
            if (this.boc) {
                this.boc = false;
                b.Jq().fB(TiebaIMConfig.url);
            }
            b.Jq().Jr();
            if (!this.bod) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bS(boolean z) {
                        b.Jq().ht(z ? 2 : 1);
                        if (z) {
                            f.this.bnt = a.Ji().Jl();
                            if (f.this.bnt != null) {
                                f.this.fF("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Ji().a(new a.InterfaceC0079a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0079a
                                    public void Jo() {
                                        f.this.currentIndex = 0;
                                        f.this.bnt = a.Ji().Jl();
                                        if (f.this.bnt != null) {
                                            f.this.fF("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.boe = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.boe = false;
                        f.this.JD();
                    }
                });
                this.bod = true;
                return;
            }
            fF("change ip to reconnect with DNS' failed.");
        }
    }
}
