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
    private static g cgw = null;
    private int cgx;
    private int currentIndex = 0;
    private boolean cgy = false;
    private boolean cgz = false;
    private List<String> cfP = null;
    private boolean cgA = false;
    private final g.a cgB = new g.a() { // from class: com.baidu.tbadk.coreExtra.e.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (g.this.cgx >= 5) {
                com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.akG().op(com.baidu.adp.framework.client.socket.h.getUrl());
                a.akG().akK();
            }
            g.this.cgx = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kY()) {
                g.b(g.this);
                if (g.this.cgx >= 5) {
                    com.baidu.adp.framework.client.socket.i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    g.this.alb();
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
        int i = gVar.cgx;
        gVar.cgx = i + 1;
        return i;
    }

    public static synchronized g akY() {
        g gVar;
        synchronized (g.class) {
            if (cgw == null) {
                synchronized (g.class) {
                    if (cgw == null) {
                        cgw = new g();
                    }
                }
            }
            gVar = cgw;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.lJ().a(this.cgB);
    }

    public static String ou(String str) {
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

    private String akZ() {
        if (this.cfP == null || this.currentIndex <= -1 || this.currentIndex >= this.cfP.size()) {
            return null;
        }
        return a.akG().akJ().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ov(final String str) {
        String akZ = akZ();
        if (akZ == null) {
            if (!a.akG().akL()) {
                a.akG().a(new a.InterfaceC0230a() { // from class: com.baidu.tbadk.coreExtra.e.g.2
                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0230a
                    public void akM() {
                        g.this.currentIndex = 0;
                        g.this.cfP = a.akG().akJ();
                        if (g.this.cfP != null) {
                            g.this.ov(str);
                        } else {
                            g.this.cgA = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            ala();
        } else if (ou(akZ) == null) {
            ala();
        } else {
            this.cgA = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(akZ);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.cgy = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ala() {
        NoNetworkView.GP();
        this.cgz = false;
        this.currentIndex = 0;
        this.cgA = false;
        this.cgy = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alb() {
        if (!this.cgA) {
            this.cgA = true;
            if (this.cgy) {
                this.cgy = false;
                b.akO().or(TiebaIMConfig.url);
            }
            b.akO().akP();
            if (!this.cgz) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.e.g.3
                    @Override // com.baidu.tbadk.coreExtra.e.d.b
                    public void ex(boolean z) {
                        b.akO().jg(z ? 2 : 1);
                        if (z) {
                            g.this.cfP = a.akG().akJ();
                            if (g.this.cfP != null) {
                                g.this.ov("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.akG().a(new a.InterfaceC0230a() { // from class: com.baidu.tbadk.coreExtra.e.g.3.1
                                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0230a
                                    public void akM() {
                                        g.this.currentIndex = 0;
                                        g.this.cfP = a.akG().akJ();
                                        if (g.this.cfP != null) {
                                            g.this.ov("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.cgA = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.cgA = false;
                        g.this.ala();
                    }
                });
                this.cgz = true;
                return;
            }
            ov("change ip to reconnect with DNS' failed.");
        }
    }
}
