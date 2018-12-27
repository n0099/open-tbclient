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
    private static f aWq = null;
    private int aWr;
    private int currentIndex = 0;
    private boolean aWs = false;
    private boolean aWt = false;
    private List<String> aVJ = null;
    private boolean aWu = false;
    private final g.a aWv = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (f.this.aWr >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.KU().hm(com.baidu.adp.framework.client.socket.h.getUrl());
                a.KU().KX();
            }
            f.this.aWr = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kV()) {
                f.b(f.this);
                if (f.this.aWr >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.Lo();
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
        int i = fVar.aWr;
        fVar.aWr = i + 1;
        return i;
    }

    public static synchronized f Ll() {
        f fVar;
        synchronized (f.class) {
            if (aWq == null) {
                synchronized (f.class) {
                    if (aWq == null) {
                        aWq = new f();
                    }
                }
            }
            fVar = aWq;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.lE().a(this.aWv);
    }

    public static String hr(String str) {
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

    private String Lm() {
        if (this.aVJ == null || this.currentIndex <= -1 || this.currentIndex >= this.aVJ.size()) {
            return null;
        }
        return a.KU().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hs(final String str) {
        String Lm = Lm();
        if (Lm == null) {
            if (!a.KU().KY()) {
                a.KU().a(new a.InterfaceC0166a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0166a
                    public void KZ() {
                        f.this.currentIndex = 0;
                        f.this.aVJ = a.KU().getIpList();
                        if (f.this.aVJ != null) {
                            f.this.hs(str);
                        } else {
                            f.this.aWu = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            Ln();
        } else if (hr(Lm) == null) {
            Ln();
        } else {
            this.aWu = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(Lm);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aWs = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ln() {
        NoNetworkView.updateUI();
        this.aWt = false;
        this.currentIndex = 0;
        this.aWu = false;
        this.aWs = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lo() {
        if (!this.aWu) {
            this.aWu = true;
            if (this.aWs) {
                this.aWs = false;
                b.Lb().ho(TiebaIMConfig.url);
            }
            b.Lb().Lc();
            if (!this.aWt) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void ci(boolean z) {
                        b.Lb().fw(z ? 2 : 1);
                        if (z) {
                            f.this.aVJ = a.KU().getIpList();
                            if (f.this.aVJ != null) {
                                f.this.hs("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.KU().a(new a.InterfaceC0166a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0166a
                                    public void KZ() {
                                        f.this.currentIndex = 0;
                                        f.this.aVJ = a.KU().getIpList();
                                        if (f.this.aVJ != null) {
                                            f.this.hs("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aWu = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aWu = false;
                        f.this.Ln();
                    }
                });
                this.aWt = true;
                return;
            }
            hs("change ip to reconnect with DNS' failed.");
        }
    }
}
