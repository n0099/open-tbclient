package com.baidu.tbadk.coreExtra.d;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.k;
import com.baidu.bdhttpdns.BDHttpDns;
import com.baidu.bdhttpdns.BDHttpDnsResult;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.d.a;
import com.baidu.tbadk.coreExtra.d.d;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g eXj = null;
    private int eXk;
    private int currentIndex = 0;
    private boolean eXl = false;
    private boolean eXm = false;
    private List<String> eWP = null;
    private boolean eXn = false;
    private final Object eXo = new Object();
    private List<String> eXp = new ArrayList();
    private boolean eXq = false;
    private BDHttpDnsResult eXr = null;
    private final g.a eXs = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.eXk > 0) {
                    g.this.eXq = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.eXr != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.eXr.sY());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.eXr.sW());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.eXr.sX());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.eXk >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.btU().CE(com.baidu.adp.framework.client.socket.h.getUrl());
                a.btU().btX();
            }
            g.this.eXk = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void c(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.eXp == null || g.this.eXp.isEmpty()) {
                        g.this.buk();
                    } else {
                        g.this.buj();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.eXr != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.eXr.sY());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.eXr.sW());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.eXr.sX());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.eXk >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bul();
                    }
                } else if (g.this.eXk >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.buo();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void oC() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onTextMessage(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void m(byte[] bArr) {
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

    static /* synthetic */ int c(g gVar) {
        int i = gVar.eXk;
        gVar.eXk = i + 1;
        return i;
    }

    public static synchronized g bui() {
        g gVar;
        synchronized (g.class) {
            if (eXj == null) {
                synchronized (g.class) {
                    if (eXj == null) {
                        eXj = new g();
                    }
                }
            }
            gVar = eXj;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.oD().a(this.eXs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buj() {
        synchronized (this.eXo) {
            if (this.eXp != null && !this.eXp.isEmpty()) {
                String remove = this.eXp.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + CK(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buk() {
        if (!this.eXq) {
            try {
                String CJ = CJ(TiebaIMConfig.url);
                if (at.isEmpty(CJ)) {
                    bul();
                } else {
                    this.eXq = true;
                    BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).a(CJ, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> sY;
                            g.this.eXq = false;
                            g.this.eXr = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (sY = bDHttpDnsResult.sY()) != null && !sY.isEmpty()) {
                                synchronized (g.this.eXo) {
                                    g.this.eXp = sY;
                                }
                                g.this.buj();
                            }
                        }
                    });
                }
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bul() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.eXq = false;
    }

    public static String CJ(String str) {
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

    public static String CK(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(":")) >= 5) {
            try {
                return str.substring(lastIndexOf + 1);
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private String bum() {
        if (this.eWP == null || this.currentIndex <= -1 || this.currentIndex >= this.eWP.size()) {
            return null;
        }
        return a.btU().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CL(final String str) {
        String bum = bum();
        if (bum == null) {
            if (!a.btU().btY()) {
                a.btU().a(new a.InterfaceC0558a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0558a
                    public void btZ() {
                        g.this.currentIndex = 0;
                        g.this.eWP = a.btU().getIpList();
                        if (g.this.eWP != null) {
                            g.this.CL(str);
                        } else {
                            g.this.eXn = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            bun();
        } else if (CJ(bum) == null) {
            bun();
        } else {
            this.eXn = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bum);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.eXl = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bun() {
        NoNetworkView.updateUI();
        this.eXm = false;
        this.currentIndex = 0;
        this.eXn = false;
        this.eXl = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buo() {
        if (!this.eXn) {
            this.eXn = true;
            if (this.eXl) {
                this.eXl = false;
                b.bub().CG(TiebaIMConfig.url);
            }
            b.bub().buc();
            if (!this.eXm) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void jv(boolean z) {
                        b.bub().qF(z ? 2 : 1);
                        if (z) {
                            g.this.eWP = a.btU().getIpList();
                            if (g.this.eWP != null) {
                                g.this.CL("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.btU().a(new a.InterfaceC0558a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0558a
                                    public void btZ() {
                                        g.this.currentIndex = 0;
                                        g.this.eWP = a.btU().getIpList();
                                        if (g.this.eWP != null) {
                                            g.this.CL("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.eXn = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.eXn = false;
                        g.this.bun();
                    }
                });
                this.eXm = true;
                return;
            }
            CL("change ip to reconnect with DNS' failed.");
        }
    }
}
