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
    private static f aAM = null;
    private int aAN;
    private int currentIndex = 0;
    private boolean aAO = false;
    private boolean aAP = false;
    private List<String> aAf = null;
    private boolean aAQ = false;
    private final g.a aAR = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.aAN >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Cx().fH(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Cx().CB();
            }
            f.this.aAN = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.gP()) {
                f.b(f.this);
                if (f.this.aAN >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.CT();
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
        int i = fVar.aAN;
        fVar.aAN = i + 1;
        return i;
    }

    public static synchronized f CQ() {
        f fVar;
        synchronized (f.class) {
            if (aAM == null) {
                synchronized (f.class) {
                    if (aAM == null) {
                        aAM = new f();
                    }
                }
            }
            fVar = aAM;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hB().a(this.aAR);
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

    private String CR() {
        if (this.aAf == null || this.currentIndex <= -1 || this.currentIndex >= this.aAf.size()) {
            return null;
        }
        return a.Cx().CA().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(final String str) {
        String CR = CR();
        if (CR == null) {
            if (!a.Cx().CC()) {
                a.Cx().a(new a.InterfaceC0093a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0093a
                    public void CD() {
                        f.this.currentIndex = 0;
                        f.this.aAf = a.Cx().CA();
                        if (f.this.aAf != null) {
                            f.this.fN(str);
                        } else {
                            f.this.aAQ = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            CS();
        } else if (fM(CR) == null) {
            CS();
        } else {
            this.aAQ = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(CR);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aAO = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CS() {
        NoNetworkView.wL();
        this.aAP = false;
        this.currentIndex = 0;
        this.aAQ = false;
        this.aAO = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CT() {
        if (!this.aAQ) {
            this.aAQ = true;
            if (this.aAO) {
                this.aAO = false;
                b.CF().fJ(TiebaIMConfig.url);
            }
            b.CF().CG();
            if (!this.aAP) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bp(boolean z) {
                        b.CF().eq(z ? 2 : 1);
                        if (z) {
                            f.this.aAf = a.Cx().CA();
                            if (f.this.aAf != null) {
                                f.this.fN("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Cx().a(new a.InterfaceC0093a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0093a
                                    public void CD() {
                                        f.this.currentIndex = 0;
                                        f.this.aAf = a.Cx().CA();
                                        if (f.this.aAf != null) {
                                            f.this.fN("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aAQ = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aAQ = false;
                        f.this.CS();
                    }
                });
                this.aAP = true;
                return;
            }
            fN("change ip to reconnect with DNS' failed.");
        }
    }
}
