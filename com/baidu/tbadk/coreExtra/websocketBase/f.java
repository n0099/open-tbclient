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
    private static f azf = null;
    private int azg;
    private int currentIndex = 0;
    private boolean azh = false;
    private boolean azi = false;
    private List<String> ayx = null;
    private boolean azj = false;
    private final g.a azk = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(Map<String, String> map) {
            if (f.this.azg >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.BJ().fm(com.baidu.adp.framework.client.socket.h.getUrl());
                a.BJ().BN();
            }
            f.this.azg = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && com.baidu.adp.lib.util.i.hi()) {
                f.b(f.this);
                if (f.this.azg >= 5) {
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
        int i = fVar.azg;
        fVar.azg = i + 1;
        return i;
    }

    public static synchronized f Cc() {
        f fVar;
        synchronized (f.class) {
            if (azf == null) {
                synchronized (f.class) {
                    if (azf == null) {
                        azf = new f();
                    }
                }
            }
            fVar = azf;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hV().a(this.azk);
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
        if (this.ayx == null || this.currentIndex <= -1 || this.currentIndex >= this.ayx.size()) {
            return null;
        }
        return a.BJ().BM().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fs(final String str) {
        String Cd = Cd();
        if (Cd == null) {
            if (!a.BJ().BO()) {
                a.BJ().a(new a.InterfaceC0054a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0054a
                    public void BP() {
                        f.this.currentIndex = 0;
                        f.this.ayx = a.BJ().BM();
                        if (f.this.ayx != null) {
                            f.this.fs(str);
                        } else {
                            f.this.azj = false;
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
            this.azj = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Cd);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.azh = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ce() {
        NoNetworkView.wO();
        this.azi = false;
        this.currentIndex = 0;
        this.azj = false;
        this.azh = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cf() {
        if (!this.azj) {
            this.azj = true;
            if (this.azh) {
                this.azh = false;
                b.BR().fo(TiebaIMConfig.url);
            }
            b.BR().BS();
            if (!this.azi) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void bu(boolean z) {
                        b.BR().eo(z ? 2 : 1);
                        if (z) {
                            f.this.ayx = a.BJ().BM();
                            if (f.this.ayx != null) {
                                f.this.fs("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.BJ().a(new a.InterfaceC0054a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0054a
                                    public void BP() {
                                        f.this.currentIndex = 0;
                                        f.this.ayx = a.BJ().BM();
                                        if (f.this.ayx != null) {
                                            f.this.fs("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.azj = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.azj = false;
                        f.this.Ce();
                    }
                });
                this.azi = true;
                return;
            }
            fs("change ip to reconnect with DNS' failed.");
        }
    }
}
