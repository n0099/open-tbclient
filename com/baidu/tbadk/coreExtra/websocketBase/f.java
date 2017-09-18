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
    private static f azc = null;
    private int azd;
    private int currentIndex = 0;
    private boolean aze = false;
    private boolean azf = false;
    private List<String> ayu = null;
    private boolean azg = false;
    private final g.a azh = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.azd >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.BJ().fm(com.baidu.adp.framework.client.socket.h.getUrl());
                a.BJ().BN();
            }
            f.this.azd = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && com.baidu.adp.lib.util.i.hi()) {
                f.b(f.this);
                if (f.this.azd >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.Cf();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void hU() {
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
        int i = fVar.azd;
        fVar.azd = i + 1;
        return i;
    }

    public static synchronized f Cc() {
        f fVar;
        synchronized (f.class) {
            if (azc == null) {
                synchronized (f.class) {
                    if (azc == null) {
                        azc = new f();
                    }
                }
            }
            fVar = azc;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hV().a(this.azh);
    }

    public static String fr(String str) {
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

    private String Cd() {
        if (this.ayu == null || this.currentIndex <= -1 || this.currentIndex >= this.ayu.size()) {
            return null;
        }
        return a.BJ().BM().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(final String str) {
        String Cd = Cd();
        if (Cd == null) {
            if (!a.BJ().BO()) {
                a.BJ().a(new a.InterfaceC0053a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0053a
                    public void BP() {
                        f.this.currentIndex = 0;
                        f.this.ayu = a.BJ().BM();
                        if (f.this.ayu != null) {
                            f.this.fs(str);
                        } else {
                            f.this.azg = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Ce();
        } else if (fr(Cd) == null) {
            Ce();
        } else {
            this.azg = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Cd);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aze = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ce() {
        NoNetworkView.wO();
        this.azf = false;
        this.currentIndex = 0;
        this.azg = false;
        this.aze = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cf() {
        if (!this.azg) {
            this.azg = true;
            if (this.aze) {
                this.aze = false;
                b.BR().fo(TiebaIMConfig.url);
            }
            b.BR().BS();
            if (!this.azf) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bu(boolean z) {
                        b.BR().eo(z ? 2 : 1);
                        if (z) {
                            f.this.ayu = a.BJ().BM();
                            if (f.this.ayu != null) {
                                f.this.fs("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.BJ().a(new a.InterfaceC0053a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0053a
                                    public void BP() {
                                        f.this.currentIndex = 0;
                                        f.this.ayu = a.BJ().BM();
                                        if (f.this.ayu != null) {
                                            f.this.fs("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.azg = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.azg = false;
                        f.this.Ce();
                    }
                });
                this.azf = true;
                return;
            }
            fs("change ip to reconnect with DNS' failed.");
        }
    }
}
