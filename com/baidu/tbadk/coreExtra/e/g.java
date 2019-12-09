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
    private static g cCA = null;
    private int cCB;
    private int currentIndex = 0;
    private boolean cCC = false;
    private boolean cCD = false;
    private List<String> cCg = null;
    private boolean cCE = false;
    private final g.a cCF = new g.a() { // from class: com.baidu.tbadk.coreExtra.e.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (g.this.cCB >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.asS().pi(com.baidu.adp.framework.client.socket.h.getUrl());
                a.asS().asW();
            }
            g.this.cCB = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.b(g.this);
                if (g.this.cCB >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    g.this.atk();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void hq() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onTextMessage(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void i(byte[] bArr) {
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
        int i = gVar.cCB;
        gVar.cCB = i + 1;
        return i;
    }

    public static synchronized g ath() {
        g gVar;
        synchronized (g.class) {
            if (cCA == null) {
                synchronized (g.class) {
                    if (cCA == null) {
                        cCA = new g();
                    }
                }
            }
            gVar = cCA;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hr().a(this.cCF);
    }

    public static String pn(String str) {
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

    private String ati() {
        if (this.cCg == null || this.currentIndex <= -1 || this.currentIndex >= this.cCg.size()) {
            return null;
        }
        return a.asS().asV().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void po(final String str) {
        String ati = ati();
        if (ati == null) {
            if (!a.asS().asX()) {
                a.asS().a(new a.InterfaceC0283a() { // from class: com.baidu.tbadk.coreExtra.e.g.2
                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0283a
                    public void asY() {
                        g.this.currentIndex = 0;
                        g.this.cCg = a.asS().asV();
                        if (g.this.cCg != null) {
                            g.this.po(str);
                        } else {
                            g.this.cCE = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            atj();
        } else if (pn(ati) == null) {
            atj();
        } else {
            this.cCE = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(ati);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.cCC = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atj() {
        NoNetworkView.updateUI();
        this.cCD = false;
        this.currentIndex = 0;
        this.cCE = false;
        this.cCC = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atk() {
        if (!this.cCE) {
            this.cCE = true;
            if (this.cCC) {
                this.cCC = false;
                b.ata().pk(TiebaIMConfig.url);
            }
            b.ata().atb();
            if (!this.cCD) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.e.g.3
                    @Override // com.baidu.tbadk.coreExtra.e.d.b
                    public void eU(boolean z) {
                        b.ata().jA(z ? 2 : 1);
                        if (z) {
                            g.this.cCg = a.asS().asV();
                            if (g.this.cCg != null) {
                                g.this.po("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.asS().a(new a.InterfaceC0283a() { // from class: com.baidu.tbadk.coreExtra.e.g.3.1
                                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0283a
                                    public void asY() {
                                        g.this.currentIndex = 0;
                                        g.this.cCg = a.asS().asV();
                                        if (g.this.cCg != null) {
                                            g.this.po("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.cCE = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.cCE = false;
                        g.this.atj();
                    }
                });
                this.cCD = true;
                return;
            }
            po("change ip to reconnect with DNS' failed.");
        }
    }
}
