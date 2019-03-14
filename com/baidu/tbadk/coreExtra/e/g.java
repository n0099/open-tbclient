package com.baidu.tbadk.coreExtra.e;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.e.a;
import com.baidu.tbadk.coreExtra.e.d;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g cgt = null;
    private int cgu;
    private int currentIndex = 0;
    private boolean cgv = false;
    private boolean cgw = false;
    private List<String> cfM = null;
    private boolean cgx = false;
    private final g.a cgy = new g.a() { // from class: com.baidu.tbadk.coreExtra.e.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (g.this.cgu >= 5) {
                com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.akJ().oo(com.baidu.adp.framework.client.socket.h.getUrl());
                a.akJ().akN();
            }
            g.this.cgu = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kY()) {
                g.b(g.this);
                if (g.this.cgu >= 5) {
                    com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    g.this.ale();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void lI() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void aj(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void x(byte[] bArr) {
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
        int i = gVar.cgu;
        gVar.cgu = i + 1;
        return i;
    }

    public static synchronized g alb() {
        g gVar;
        synchronized (g.class) {
            if (cgt == null) {
                synchronized (g.class) {
                    if (cgt == null) {
                        cgt = new g();
                    }
                }
            }
            gVar = cgt;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.lJ().a(this.cgy);
    }

    public static String ot(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(Config.TRACE_TODAY_VISIT_SPLIT)) >= 5) {
            try {
                return str.substring(5, lastIndexOf);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private String alc() {
        if (this.cfM == null || this.currentIndex <= -1 || this.currentIndex >= this.cfM.size()) {
            return null;
        }
        return a.akJ().akM().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ou(final String str) {
        String alc = alc();
        if (alc == null) {
            if (!a.akJ().akO()) {
                a.akJ().a(new a.InterfaceC0230a() { // from class: com.baidu.tbadk.coreExtra.e.g.2
                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0230a
                    public void akP() {
                        g.this.currentIndex = 0;
                        g.this.cfM = a.akJ().akM();
                        if (g.this.cfM != null) {
                            g.this.ou(str);
                        } else {
                            g.this.cgx = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            ald();
        } else if (ot(alc) == null) {
            ald();
        } else {
            this.cgx = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(alc);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.cgv = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ald() {
        NoNetworkView.GR();
        this.cgw = false;
        this.currentIndex = 0;
        this.cgx = false;
        this.cgv = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ale() {
        if (!this.cgx) {
            this.cgx = true;
            if (this.cgv) {
                this.cgv = false;
                b.akR().oq(TiebaIMConfig.url);
            }
            b.akR().akS();
            if (!this.cgw) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.e.g.3
                    @Override // com.baidu.tbadk.coreExtra.e.d.b
                    public void ex(boolean z) {
                        b.akR().jh(z ? 2 : 1);
                        if (z) {
                            g.this.cfM = a.akJ().akM();
                            if (g.this.cfM != null) {
                                g.this.ou("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.akJ().a(new a.InterfaceC0230a() { // from class: com.baidu.tbadk.coreExtra.e.g.3.1
                                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0230a
                                    public void akP() {
                                        g.this.currentIndex = 0;
                                        g.this.cfM = a.akJ().akM();
                                        if (g.this.cfM != null) {
                                            g.this.ou("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.cgx = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.cgx = false;
                        g.this.ald();
                    }
                });
                this.cgw = true;
                return;
            }
            ou("change ip to reconnect with DNS' failed.");
        }
    }
}
