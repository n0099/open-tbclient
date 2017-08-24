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
    private static f azU = null;
    private int azV;
    private int currentIndex = 0;
    private boolean azW = false;
    private boolean azX = false;
    private List<String> azm = null;
    private boolean azY = false;
    private final g.a azZ = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(Map<String, String> map) {
            if (f.this.azV >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.BO().fr(com.baidu.adp.framework.client.socket.h.getUrl());
                a.BO().BS();
            }
            f.this.azV = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && com.baidu.adp.lib.util.i.hr()) {
                f.b(f.this);
                if (f.this.azV >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.Ck();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void id() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void J(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void u(byte[] bArr) {
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
        int i = fVar.azV;
        fVar.azV = i + 1;
        return i;
    }

    public static synchronized f Ch() {
        f fVar;
        synchronized (f.class) {
            if (azU == null) {
                synchronized (f.class) {
                    if (azU == null) {
                        azU = new f();
                    }
                }
            }
            fVar = azU;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ie().a(this.azZ);
    }

    public static String fw(String str) {
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

    private String Ci() {
        if (this.azm == null || this.currentIndex <= -1 || this.currentIndex >= this.azm.size()) {
            return null;
        }
        return a.BO().BR().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(final String str) {
        String Ci = Ci();
        if (Ci == null) {
            if (!a.BO().BT()) {
                a.BO().a(new a.InterfaceC0051a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0051a
                    public void BU() {
                        f.this.currentIndex = 0;
                        f.this.azm = a.BO().BR();
                        if (f.this.azm != null) {
                            f.this.fx(str);
                        } else {
                            f.this.azY = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Cj();
        } else if (fw(Ci) == null) {
            Cj();
        } else {
            this.azY = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Ci);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.azW = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cj() {
        NoNetworkView.wQ();
        this.azX = false;
        this.currentIndex = 0;
        this.azY = false;
        this.azW = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ck() {
        if (!this.azY) {
            this.azY = true;
            if (this.azW) {
                this.azW = false;
                b.BW().ft(TiebaIMConfig.url);
            }
            b.BW().BX();
            if (!this.azX) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bv(boolean z) {
                        b.BW().ep(z ? 2 : 1);
                        if (z) {
                            f.this.azm = a.BO().BR();
                            if (f.this.azm != null) {
                                f.this.fx("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.BO().a(new a.InterfaceC0051a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0051a
                                    public void BU() {
                                        f.this.currentIndex = 0;
                                        f.this.azm = a.BO().BR();
                                        if (f.this.azm != null) {
                                            f.this.fx("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.azY = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.azY = false;
                        f.this.Cj();
                    }
                });
                this.azX = true;
                return;
            }
            fx("change ip to reconnect with DNS' failed.");
        }
    }
}
