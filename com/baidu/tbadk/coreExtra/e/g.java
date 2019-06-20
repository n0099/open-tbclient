package com.baidu.tbadk.coreExtra.e;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.e.a;
import com.baidu.tbadk.coreExtra.e.d;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g coE = null;
    private int coF;
    private int currentIndex = 0;
    private boolean coG = false;
    private boolean coH = false;
    private List<String> cnX = null;
    private boolean coI = false;
    private final g.a coJ = new g.a() { // from class: com.baidu.tbadk.coreExtra.e.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (g.this.coF >= 5) {
                com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.apJ().pw(com.baidu.adp.framework.client.socket.h.getUrl());
                a.apJ().apN();
            }
            g.this.coF = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.jS()) {
                g.b(g.this);
                if (g.this.coF >= 5) {
                    com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    g.this.aqe();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void kC() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void S(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void p(byte[] bArr) {
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

    static /* synthetic */ int b(g gVar) {
        int i = gVar.coF;
        gVar.coF = i + 1;
        return i;
    }

    public static synchronized g aqb() {
        g gVar;
        synchronized (g.class) {
            if (coE == null) {
                synchronized (g.class) {
                    if (coE == null) {
                        coE = new g();
                    }
                }
            }
            gVar = coE;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.kD().a(this.coJ);
    }

    public static String pB(String str) {
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

    private String aqc() {
        if (this.cnX == null || this.currentIndex <= -1 || this.currentIndex >= this.cnX.size()) {
            return null;
        }
        return a.apJ().apM().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pC(final String str) {
        String aqc = aqc();
        if (aqc == null) {
            if (!a.apJ().apO()) {
                a.apJ().a(new a.InterfaceC0245a() { // from class: com.baidu.tbadk.coreExtra.e.g.2
                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0245a
                    public void apP() {
                        g.this.currentIndex = 0;
                        g.this.cnX = a.apJ().apM();
                        if (g.this.cnX != null) {
                            g.this.pC(str);
                        } else {
                            g.this.coI = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            aqd();
        } else if (pB(aqc) == null) {
            aqd();
        } else {
            this.coI = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(aqc);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.coG = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqd() {
        NoNetworkView.Jf();
        this.coH = false;
        this.currentIndex = 0;
        this.coI = false;
        this.coG = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aqe() {
        if (!this.coI) {
            this.coI = true;
            if (this.coG) {
                this.coG = false;
                b.apR().py(TiebaIMConfig.url);
            }
            b.apR().apS();
            if (!this.coH) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.e.g.3
                    @Override // com.baidu.tbadk.coreExtra.e.d.b
                    public void eT(boolean z) {
                        b.apR().jU(z ? 2 : 1);
                        if (z) {
                            g.this.cnX = a.apJ().apM();
                            if (g.this.cnX != null) {
                                g.this.pC("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.apJ().a(new a.InterfaceC0245a() { // from class: com.baidu.tbadk.coreExtra.e.g.3.1
                                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0245a
                                    public void apP() {
                                        g.this.currentIndex = 0;
                                        g.this.cnX = a.apJ().apM();
                                        if (g.this.cnX != null) {
                                            g.this.pC("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.coI = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.coI = false;
                        g.this.aqd();
                    }
                });
                this.coH = true;
                return;
            }
            pC("change ip to reconnect with DNS' failed.");
        }
    }
}
