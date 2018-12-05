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
    private static f aWn = null;
    private int aWo;
    private int currentIndex = 0;
    private boolean aWp = false;
    private boolean aWq = false;
    private List<String> aVG = null;
    private boolean aWr = false;
    private final g.a aWs = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (f.this.aWo >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.KT().hl(com.baidu.adp.framework.client.socket.h.getUrl());
                a.KT().KW();
            }
            f.this.aWo = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kV()) {
                f.b(f.this);
                if (f.this.aWo >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.Ln();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void lD() {
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
        int i = fVar.aWo;
        fVar.aWo = i + 1;
        return i;
    }

    public static synchronized f Lk() {
        f fVar;
        synchronized (f.class) {
            if (aWn == null) {
                synchronized (f.class) {
                    if (aWn == null) {
                        aWn = new f();
                    }
                }
            }
            fVar = aWn;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.lE().a(this.aWs);
    }

    public static String hq(String str) {
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

    private String Ll() {
        if (this.aVG == null || this.currentIndex <= -1 || this.currentIndex >= this.aVG.size()) {
            return null;
        }
        return a.KT().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hr(final String str) {
        String Ll = Ll();
        if (Ll == null) {
            if (!a.KT().KX()) {
                a.KT().a(new a.InterfaceC0166a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0166a
                    public void KY() {
                        f.this.currentIndex = 0;
                        f.this.aVG = a.KT().getIpList();
                        if (f.this.aVG != null) {
                            f.this.hr(str);
                        } else {
                            f.this.aWr = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Lm();
        } else if (hq(Ll) == null) {
            Lm();
        } else {
            this.aWr = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Ll);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aWp = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lm() {
        NoNetworkView.updateUI();
        this.aWq = false;
        this.currentIndex = 0;
        this.aWr = false;
        this.aWp = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ln() {
        if (!this.aWr) {
            this.aWr = true;
            if (this.aWp) {
                this.aWp = false;
                b.La().hn(TiebaIMConfig.url);
            }
            b.La().Lb();
            if (!this.aWq) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void ci(boolean z) {
                        b.La().fv(z ? 2 : 1);
                        if (z) {
                            f.this.aVG = a.KT().getIpList();
                            if (f.this.aVG != null) {
                                f.this.hr("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.KT().a(new a.InterfaceC0166a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0166a
                                    public void KY() {
                                        f.this.currentIndex = 0;
                                        f.this.aVG = a.KT().getIpList();
                                        if (f.this.aVG != null) {
                                            f.this.hr("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aWr = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aWr = false;
                        f.this.Lm();
                    }
                });
                this.aWq = true;
                return;
            }
            hr("change ip to reconnect with DNS' failed.");
        }
    }
}
