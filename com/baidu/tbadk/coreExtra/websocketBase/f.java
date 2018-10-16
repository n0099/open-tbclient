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
    private static f aSa = null;
    private int aSb;
    private int currentIndex = 0;
    private boolean aSc = false;
    private boolean aSd = false;
    private List<String> aRt = null;
    private boolean aSe = false;
    private final g.a aSf = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (f.this.aSb >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.JD().gS(com.baidu.adp.framework.client.socket.h.getUrl());
                a.JD().JG();
            }
            f.this.aSb = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kX()) {
                f.b(f.this);
                if (f.this.aSb >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.JX();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void lG() {
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

    static /* synthetic */ int b(f fVar) {
        int i = fVar.aSb;
        fVar.aSb = i + 1;
        return i;
    }

    public static synchronized f JU() {
        f fVar;
        synchronized (f.class) {
            if (aSa == null) {
                synchronized (f.class) {
                    if (aSa == null) {
                        aSa = new f();
                    }
                }
            }
            fVar = aSa;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.lH().a(this.aSf);
    }

    public static String gX(String str) {
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

    private String JV() {
        if (this.aRt == null || this.currentIndex <= -1 || this.currentIndex >= this.aRt.size()) {
            return null;
        }
        return a.JD().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gY(final String str) {
        String JV = JV();
        if (JV == null) {
            if (!a.JD().JH()) {
                a.JD().a(new a.InterfaceC0132a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0132a
                    public void JI() {
                        f.this.currentIndex = 0;
                        f.this.aRt = a.JD().getIpList();
                        if (f.this.aRt != null) {
                            f.this.gY(str);
                        } else {
                            f.this.aSe = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            JW();
        } else if (gX(JV) == null) {
            JW();
        } else {
            this.aSe = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(JV);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aSc = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JW() {
        NoNetworkView.updateUI();
        this.aSd = false;
        this.currentIndex = 0;
        this.aSe = false;
        this.aSc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JX() {
        if (!this.aSe) {
            this.aSe = true;
            if (this.aSc) {
                this.aSc = false;
                b.JK().gU(TiebaIMConfig.url);
            }
            b.JK().JL();
            if (!this.aSd) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bQ(boolean z) {
                        b.JK().eT(z ? 2 : 1);
                        if (z) {
                            f.this.aRt = a.JD().getIpList();
                            if (f.this.aRt != null) {
                                f.this.gY("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.JD().a(new a.InterfaceC0132a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0132a
                                    public void JI() {
                                        f.this.currentIndex = 0;
                                        f.this.aRt = a.JD().getIpList();
                                        if (f.this.aRt != null) {
                                            f.this.gY("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aSe = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aSe = false;
                        f.this.JW();
                    }
                });
                this.aSd = true;
                return;
            }
            gY("change ip to reconnect with DNS' failed.");
        }
    }
}
