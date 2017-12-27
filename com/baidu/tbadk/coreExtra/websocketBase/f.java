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
    private static f bnR = null;
    private int bnS;
    private int currentIndex = 0;
    private boolean bnT = false;
    private boolean bnU = false;
    private List<String> bnk = null;
    private boolean bnV = false;
    private final g.a bnW = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.bnS >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Jt().fy(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Jt().Jx();
            }
            f.this.bnS = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.oI()) {
                f.b(f.this);
                if (f.this.bnS >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.JP();
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
        int i = fVar.bnS;
        fVar.bnS = i + 1;
        return i;
    }

    public static synchronized f JM() {
        f fVar;
        synchronized (f.class) {
            if (bnR == null) {
                synchronized (f.class) {
                    if (bnR == null) {
                        bnR = new f();
                    }
                }
            }
            fVar = bnR;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.pu().a(this.bnW);
    }

    public static String fD(String str) {
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

    private String JN() {
        if (this.bnk == null || this.currentIndex <= -1 || this.currentIndex >= this.bnk.size()) {
            return null;
        }
        return a.Jt().Jw().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(final String str) {
        String JN = JN();
        if (JN == null) {
            if (!a.Jt().Jy()) {
                a.Jt().a(new a.InterfaceC0080a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0080a
                    public void Jz() {
                        f.this.currentIndex = 0;
                        f.this.bnk = a.Jt().Jw();
                        if (f.this.bnk != null) {
                            f.this.fE(str);
                        } else {
                            f.this.bnV = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            JO();
        } else if (fD(JN) == null) {
            JO();
        } else {
            this.bnV = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(JN);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.bnT = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JO() {
        NoNetworkView.DN();
        this.bnU = false;
        this.currentIndex = 0;
        this.bnV = false;
        this.bnT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JP() {
        if (!this.bnV) {
            this.bnV = true;
            if (this.bnT) {
                this.bnT = false;
                b.JB().fA(TiebaIMConfig.url);
            }
            b.JB().JC();
            if (!this.bnU) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bU(boolean z) {
                        b.JB().hx(z ? 2 : 1);
                        if (z) {
                            f.this.bnk = a.Jt().Jw();
                            if (f.this.bnk != null) {
                                f.this.fE("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Jt().a(new a.InterfaceC0080a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0080a
                                    public void Jz() {
                                        f.this.currentIndex = 0;
                                        f.this.bnk = a.Jt().Jw();
                                        if (f.this.bnk != null) {
                                            f.this.fE("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.bnV = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.bnV = false;
                        f.this.JO();
                    }
                });
                this.bnU = true;
                return;
            }
            fE("change ip to reconnect with DNS' failed.");
        }
    }
}
