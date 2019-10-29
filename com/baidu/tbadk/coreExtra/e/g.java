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
    private static g cDr = null;
    private int cDs;
    private int currentIndex = 0;
    private boolean cDt = false;
    private boolean cDu = false;
    private List<String> cCX = null;
    private boolean cDv = false;
    private final g.a cDw = new g.a() { // from class: com.baidu.tbadk.coreExtra.e.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (g.this.cDs >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.asU().pi(com.baidu.adp.framework.client.socket.h.getUrl());
                a.asU().asY();
            }
            g.this.cDs = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.b(g.this);
                if (g.this.cDs >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    g.this.atm();
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
        int i = gVar.cDs;
        gVar.cDs = i + 1;
        return i;
    }

    public static synchronized g atj() {
        g gVar;
        synchronized (g.class) {
            if (cDr == null) {
                synchronized (g.class) {
                    if (cDr == null) {
                        cDr = new g();
                    }
                }
            }
            gVar = cDr;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hr().a(this.cDw);
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

    private String atk() {
        if (this.cCX == null || this.currentIndex <= -1 || this.currentIndex >= this.cCX.size()) {
            return null;
        }
        return a.asU().asX().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void po(final String str) {
        String atk = atk();
        if (atk == null) {
            if (!a.asU().asZ()) {
                a.asU().a(new a.InterfaceC0288a() { // from class: com.baidu.tbadk.coreExtra.e.g.2
                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0288a
                    public void ata() {
                        g.this.currentIndex = 0;
                        g.this.cCX = a.asU().asX();
                        if (g.this.cCX != null) {
                            g.this.po(str);
                        } else {
                            g.this.cDv = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            atl();
        } else if (pn(atk) == null) {
            atl();
        } else {
            this.cDv = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(atk);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.cDt = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atl() {
        NoNetworkView.updateUI();
        this.cDu = false;
        this.currentIndex = 0;
        this.cDv = false;
        this.cDt = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atm() {
        if (!this.cDv) {
            this.cDv = true;
            if (this.cDt) {
                this.cDt = false;
                b.atc().pk(TiebaIMConfig.url);
            }
            b.atc().atd();
            if (!this.cDu) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.e.g.3
                    @Override // com.baidu.tbadk.coreExtra.e.d.b
                    public void eU(boolean z) {
                        b.atc().jB(z ? 2 : 1);
                        if (z) {
                            g.this.cCX = a.asU().asX();
                            if (g.this.cCX != null) {
                                g.this.po("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.asU().a(new a.InterfaceC0288a() { // from class: com.baidu.tbadk.coreExtra.e.g.3.1
                                    @Override // com.baidu.tbadk.coreExtra.e.a.InterfaceC0288a
                                    public void ata() {
                                        g.this.currentIndex = 0;
                                        g.this.cCX = a.asU().asX();
                                        if (g.this.cCX != null) {
                                            g.this.po("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.cDv = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.cDv = false;
                        g.this.atl();
                    }
                });
                this.cDu = true;
                return;
            }
            po("change ip to reconnect with DNS' failed.");
        }
    }
}
