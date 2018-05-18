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
    private static f aAN = null;
    private int aAO;
    private int currentIndex = 0;
    private boolean aAP = false;
    private boolean aAQ = false;
    private List<String> aAg = null;
    private boolean aAR = false;
    private final g.a aAS = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.aAO >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Cv().fH(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Cv().Cz();
            }
            f.this.aAO = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.gP()) {
                f.b(f.this);
                if (f.this.aAO >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.CR();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void hA() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void G(String str) {
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
        int i = fVar.aAO;
        fVar.aAO = i + 1;
        return i;
    }

    public static synchronized f CO() {
        f fVar;
        synchronized (f.class) {
            if (aAN == null) {
                synchronized (f.class) {
                    if (aAN == null) {
                        aAN = new f();
                    }
                }
            }
            fVar = aAN;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hB().a(this.aAS);
    }

    public static String fM(String str) {
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

    private String CP() {
        if (this.aAg == null || this.currentIndex <= -1 || this.currentIndex >= this.aAg.size()) {
            return null;
        }
        return a.Cv().Cy().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(final String str) {
        String CP = CP();
        if (CP == null) {
            if (!a.Cv().CA()) {
                a.Cv().a(new a.InterfaceC0093a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0093a
                    public void CB() {
                        f.this.currentIndex = 0;
                        f.this.aAg = a.Cv().Cy();
                        if (f.this.aAg != null) {
                            f.this.fN(str);
                        } else {
                            f.this.aAR = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            CQ();
        } else if (fM(CP) == null) {
            CQ();
        } else {
            this.aAR = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(CP);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aAP = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CQ() {
        NoNetworkView.wK();
        this.aAQ = false;
        this.currentIndex = 0;
        this.aAR = false;
        this.aAP = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CR() {
        if (!this.aAR) {
            this.aAR = true;
            if (this.aAP) {
                this.aAP = false;
                b.CD().fJ(TiebaIMConfig.url);
            }
            b.CD().CE();
            if (!this.aAQ) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bp(boolean z) {
                        b.CD().er(z ? 2 : 1);
                        if (z) {
                            f.this.aAg = a.Cv().Cy();
                            if (f.this.aAg != null) {
                                f.this.fN("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Cv().a(new a.InterfaceC0093a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0093a
                                    public void CB() {
                                        f.this.currentIndex = 0;
                                        f.this.aAg = a.Cv().Cy();
                                        if (f.this.aAg != null) {
                                            f.this.fN("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aAR = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aAR = false;
                        f.this.CQ();
                    }
                });
                this.aAQ = true;
                return;
            }
            fN("change ip to reconnect with DNS' failed.");
        }
    }
}
