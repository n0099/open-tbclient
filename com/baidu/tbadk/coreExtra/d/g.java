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
    private static g eLc = null;
    private int eLd;
    private int currentIndex = 0;
    private boolean eLe = false;
    private boolean eLf = false;
    private List<String> eKI = null;
    private boolean eLg = false;
    private final Object eLh = new Object();
    private List<String> eLi = new ArrayList();
    private boolean eLj = false;
    private BDHttpDnsResult eLk = null;
    private final g.a eLl = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.eLd > 0) {
                    g.this.eLj = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.eLk != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.eLk.sY());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.eLk.sW());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.eLk.sX());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.eLd >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.brk().BS(com.baidu.adp.framework.client.socket.h.getUrl());
                a.brk().brn();
            }
            g.this.eLd = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void c(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.eLi == null || g.this.eLi.isEmpty()) {
                        g.this.brA();
                    } else {
                        g.this.brz();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.eLk != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.eLk.sY());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.eLk.sW());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.eLk.sX());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.eLd >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.brB();
                    }
                } else if (g.this.eLd >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.brE();
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
        int i = gVar.eLd;
        gVar.eLd = i + 1;
        return i;
    }

    public static synchronized g bry() {
        g gVar;
        synchronized (g.class) {
            if (eLc == null) {
                synchronized (g.class) {
                    if (eLc == null) {
                        eLc = new g();
                    }
                }
            }
            gVar = eLc;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.oD().a(this.eLl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brz() {
        synchronized (this.eLh) {
            if (this.eLi != null && !this.eLi.isEmpty()) {
                String remove = this.eLi.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + BY(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brA() {
        if (!this.eLj) {
            try {
                String BX = BX(TiebaIMConfig.url);
                if (at.isEmpty(BX)) {
                    brB();
                } else {
                    this.eLj = true;
                    BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).a(BX, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> sY;
                            g.this.eLj = false;
                            g.this.eLk = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (sY = bDHttpDnsResult.sY()) != null && !sY.isEmpty()) {
                                synchronized (g.this.eLh) {
                                    g.this.eLi = sY;
                                }
                                g.this.brz();
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
    public void brB() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.eLj = false;
    }

    public static String BX(String str) {
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

    public static String BY(String str) {
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

    private String brC() {
        if (this.eKI == null || this.currentIndex <= -1 || this.currentIndex >= this.eKI.size()) {
            return null;
        }
        return a.brk().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BZ(final String str) {
        String brC = brC();
        if (brC == null) {
            if (!a.brk().bro()) {
                a.brk().a(new a.InterfaceC0541a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0541a
                    public void brp() {
                        g.this.currentIndex = 0;
                        g.this.eKI = a.brk().getIpList();
                        if (g.this.eKI != null) {
                            g.this.BZ(str);
                        } else {
                            g.this.eLg = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            brD();
        } else if (BX(brC) == null) {
            brD();
        } else {
            this.eLg = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(brC);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.eLe = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brD() {
        NoNetworkView.updateUI();
        this.eLf = false;
        this.currentIndex = 0;
        this.eLg = false;
        this.eLe = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brE() {
        if (!this.eLg) {
            this.eLg = true;
            if (this.eLe) {
                this.eLe = false;
                b.brr().BU(TiebaIMConfig.url);
            }
            b.brr().brs();
            if (!this.eLf) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void iX(boolean z) {
                        b.brr().qh(z ? 2 : 1);
                        if (z) {
                            g.this.eKI = a.brk().getIpList();
                            if (g.this.eKI != null) {
                                g.this.BZ("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.brk().a(new a.InterfaceC0541a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0541a
                                    public void brp() {
                                        g.this.currentIndex = 0;
                                        g.this.eKI = a.brk().getIpList();
                                        if (g.this.eKI != null) {
                                            g.this.BZ("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.eLg = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.eLg = false;
                        g.this.brD();
                    }
                });
                this.eLf = true;
                return;
            }
            BZ("change ip to reconnect with DNS' failed.");
        }
    }
}
