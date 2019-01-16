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
    private static f aWY = null;
    private int aWZ;
    private int currentIndex = 0;
    private boolean aXa = false;
    private boolean aXb = false;
    private List<String> aWr = null;
    private boolean aXc = false;
    private final g.a aXd = new g.a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (f.this.aWZ >= 5) {
                i.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.Lj().hA(com.baidu.adp.framework.client.socket.h.getUrl());
                a.Lj().Lm();
            }
            f.this.aWZ = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void f(int i, String str) {
            if ((i == 2 || i == 9) && j.kV()) {
                f.b(f.this);
                if (f.this.aWZ >= 5) {
                    i.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                    f.this.LD();
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
        int i = fVar.aWZ;
        fVar.aWZ = i + 1;
        return i;
    }

    public static synchronized f LA() {
        f fVar;
        synchronized (f.class) {
            if (aWY == null) {
                synchronized (f.class) {
                    if (aWY == null) {
                        aWY = new f();
                    }
                }
            }
            fVar = aWY;
        }
        return fVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.lE().a(this.aXd);
    }

    public static String hF(String str) {
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

    private String LB() {
        if (this.aWr == null || this.currentIndex <= -1 || this.currentIndex >= this.aWr.size()) {
            return null;
        }
        return a.Lj().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hG(final String str) {
        String LB = LB();
        if (LB == null) {
            if (!a.Lj().Ln()) {
                a.Lj().a(new a.InterfaceC0166a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.2
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0166a
                    public void Lo() {
                        f.this.currentIndex = 0;
                        f.this.aWr = a.Lj().getIpList();
                        if (f.this.aWr != null) {
                            f.this.hG(str);
                        } else {
                            f.this.aXc = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            LC();
        } else if (hF(LB) == null) {
            LC();
        } else {
            this.aXc = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(LB);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.aXa = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LC() {
        NoNetworkView.updateUI();
        this.aXb = false;
        this.currentIndex = 0;
        this.aXc = false;
        this.aXa = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LD() {
        if (!this.aXc) {
            this.aXc = true;
            if (this.aXa) {
                this.aXa = false;
                b.Lq().hC(TiebaIMConfig.url);
            }
            b.Lq().Lr();
            if (!this.aXb) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3
                    @Override // com.baidu.tbadk.coreExtra.websocketBase.d.b
                    public void cj(boolean z) {
                        b.Lq().fw(z ? 2 : 1);
                        if (z) {
                            f.this.aWr = a.Lj().getIpList();
                            if (f.this.aWr != null) {
                                f.this.hG("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.Lj().a(new a.InterfaceC0166a() { // from class: com.baidu.tbadk.coreExtra.websocketBase.f.3.1
                                    @Override // com.baidu.tbadk.coreExtra.websocketBase.a.InterfaceC0166a
                                    public void Lo() {
                                        f.this.currentIndex = 0;
                                        f.this.aWr = a.Lj().getIpList();
                                        if (f.this.aWr != null) {
                                            f.this.hG("change ip to reconnect with DNS' failed.");
                                        } else {
                                            f.this.aXc = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        f.this.aXc = false;
                        f.this.LC();
                    }
                });
                this.aXb = true;
                return;
            }
            hG("change ip to reconnect with DNS' failed.");
        }
    }
}
