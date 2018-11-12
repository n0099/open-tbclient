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
    private static f aSQ = null;
    private int aSR;
    private int currentIndex = 0;
    private boolean aSS = false;
    private boolean aST = false;
    private List<String> aSj = null;
    private boolean aSU = false;
    private final g.a aSV = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (f.this.aSR >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.JP().gT(com.baidu.adp.framework.client.socket.h.getUrl());
                a.JP().JS();
            }
            f.this.aSR = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kV()) {
                f.b(f.this);
                if (f.this.aSR >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.Kj();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void lE() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void aj(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void w(byte[] bArr) {
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
        int i = fVar.aSR;
        fVar.aSR = i + 1;
        return i;
    }

    public static synchronized f Kg() {
        f fVar;
        synchronized (f.class) {
            if (aSQ == null) {
                synchronized (f.class) {
                    if (aSQ == null) {
                        aSQ = new f();
                    }
                }
            }
            fVar = aSQ;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.lF().a(this.aSV);
    }

    public static String gY(String str) {
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

    private String Kh() {
        if (this.aSj == null || this.currentIndex <= -1 || this.currentIndex >= this.aSj.size()) {
            return null;
        }
        return a.JP().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gZ(final String str) {
        String Kh = Kh();
        if (Kh == null) {
            if (!a.JP().JT()) {
                a.JP().a(new a.InterfaceC0156a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0156a
                    public void JU() {
                        f.this.currentIndex = 0;
                        f.this.aSj = a.JP().getIpList();
                        if (f.this.aSj != null) {
                            f.this.gZ(str);
                        } else {
                            f.this.aSU = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Ki();
        } else if (gY(Kh) == null) {
            Ki();
        } else {
            this.aSU = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Kh);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aSS = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ki() {
        NoNetworkView.updateUI();
        this.aST = false;
        this.currentIndex = 0;
        this.aSU = false;
        this.aSS = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kj() {
        if (!this.aSU) {
            this.aSU = true;
            if (this.aSS) {
                this.aSS = false;
                b.JW().gV(TiebaIMConfig.url);
            }
            b.JW().JX();
            if (!this.aST) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void ch(boolean z) {
                        b.JW().fh(z ? 2 : 1);
                        if (z) {
                            f.this.aSj = a.JP().getIpList();
                            if (f.this.aSj != null) {
                                f.this.gZ("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.JP().a(new a.InterfaceC0156a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0156a
                                    public void JU() {
                                        f.this.currentIndex = 0;
                                        f.this.aSj = a.JP().getIpList();
                                        if (f.this.aSj != null) {
                                            f.this.gZ("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aSU = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aSU = false;
                        f.this.Ki();
                    }
                });
                this.aST = true;
                return;
            }
            gZ("change ip to reconnect with DNS' failed.");
        }
    }
}
