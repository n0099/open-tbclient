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
    private static f aNy = null;
    private int aNz;
    private int currentIndex = 0;
    private boolean aNA = false;
    private boolean aNB = false;
    private List<String> aMR = null;
    private boolean aNC = false;
    private final g.a aND = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void j(Map<String, String> map) {
            if (f.this.aNz >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.HC().gE(com.baidu.adp.framework.client.socket.h.getUrl());
                a.HC().HG();
            }
            f.this.aNz = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kK()) {
                f.b(f.this);
                if (f.this.aNz >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.HY();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void lv() {
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
        int i = fVar.aNz;
        fVar.aNz = i + 1;
        return i;
    }

    public static synchronized f HV() {
        f fVar;
        synchronized (f.class) {
            if (aNy == null) {
                synchronized (f.class) {
                    if (aNy == null) {
                        aNy = new f();
                    }
                }
            }
            fVar = aNy;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.lw().a(this.aND);
    }

    public static String gJ(String str) {
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

    private String HW() {
        if (this.aMR == null || this.currentIndex <= -1 || this.currentIndex >= this.aMR.size()) {
            return null;
        }
        return a.HC().HF().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gK(final String str) {
        String HW = HW();
        if (HW == null) {
            if (!a.HC().HH()) {
                a.HC().a(new a.InterfaceC0108a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0108a
                    public void HI() {
                        f.this.currentIndex = 0;
                        f.this.aMR = a.HC().HF();
                        if (f.this.aMR != null) {
                            f.this.gK(str);
                        } else {
                            f.this.aNC = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            HX();
        } else if (gJ(HW) == null) {
            HX();
        } else {
            this.aNC = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(HW);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aNA = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HX() {
        NoNetworkView.Bp();
        this.aNB = false;
        this.currentIndex = 0;
        this.aNC = false;
        this.aNA = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HY() {
        if (!this.aNC) {
            this.aNC = true;
            if (this.aNA) {
                this.aNA = false;
                b.HK().gG(TiebaIMConfig.url);
            }
            b.HK().HL();
            if (!this.aNB) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bH(boolean z) {
                        b.HK().eK(z ? 2 : 1);
                        if (z) {
                            f.this.aMR = a.HC().HF();
                            if (f.this.aMR != null) {
                                f.this.gK("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.HC().a(new a.InterfaceC0108a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0108a
                                    public void HI() {
                                        f.this.currentIndex = 0;
                                        f.this.aMR = a.HC().HF();
                                        if (f.this.aMR != null) {
                                            f.this.gK("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aNC = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aNC = false;
                        f.this.HX();
                    }
                });
                this.aNB = true;
                return;
            }
            gK("change ip to reconnect with DNS' failed.");
        }
    }
}
