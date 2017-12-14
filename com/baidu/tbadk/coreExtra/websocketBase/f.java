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
    private static f azJ = null;
    private int azK;
    private int currentIndex = 0;
    private boolean azL = false;
    private boolean azM = false;
    private List<String> azc = null;
    private boolean azN = false;
    private final g.a azO = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.azK >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.BR().fr(com.baidu.adp.framework.client.socket.h.getUrl());
                a.BR().BV();
            }
            f.this.azK = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.hh()) {
                f.b(f.this);
                if (f.this.azK >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.Cn();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void hT() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void C(String str) {
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
        int i = fVar.azK;
        fVar.azK = i + 1;
        return i;
    }

    public static synchronized f Ck() {
        f fVar;
        synchronized (f.class) {
            if (azJ == null) {
                synchronized (f.class) {
                    if (azJ == null) {
                        azJ = new f();
                    }
                }
            }
            fVar = azJ;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hU().a(this.azO);
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

    private String Cl() {
        if (this.azc == null || this.currentIndex <= -1 || this.currentIndex >= this.azc.size()) {
            return null;
        }
        return a.BR().BU().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(final String str) {
        String Cl = Cl();
        if (Cl == null) {
            if (!a.BR().BW()) {
                a.BR().a(new a.InterfaceC0067a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0067a
                    public void BX() {
                        f.this.currentIndex = 0;
                        f.this.azc = a.BR().BU();
                        if (f.this.azc != null) {
                            f.this.fx(str);
                        } else {
                            f.this.azN = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Cm();
        } else if (fw(Cl) == null) {
            Cm();
        } else {
            this.azN = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Cl);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.azL = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cm() {
        NoNetworkView.wp();
        this.azM = false;
        this.currentIndex = 0;
        this.azN = false;
        this.azL = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cn() {
        if (!this.azN) {
            this.azN = true;
            if (this.azL) {
                this.azL = false;
                b.BZ().ft(TiebaIMConfig.url);
            }
            b.BZ().Ca();
            if (!this.azM) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bp(boolean z) {
                        b.BZ().ez(z ? 2 : 1);
                        if (z) {
                            f.this.azc = a.BR().BU();
                            if (f.this.azc != null) {
                                f.this.fx("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.BR().a(new a.InterfaceC0067a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0067a
                                    public void BX() {
                                        f.this.currentIndex = 0;
                                        f.this.azc = a.BR().BU();
                                        if (f.this.azc != null) {
                                            f.this.fx("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.azN = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.azN = false;
                        f.this.Cm();
                    }
                });
                this.azM = true;
                return;
            }
            fx("change ip to reconnect with DNS' failed.");
        }
    }
}
