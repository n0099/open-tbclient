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
    private static g fly = null;
    private int flz;
    private int currentIndex = 0;
    private boolean flA = false;
    private boolean flB = false;
    private List<String> fle = null;
    private boolean flC = false;
    private final Object flD = new Object();
    private List<String> flE = new ArrayList();
    private boolean flF = false;
    private BDHttpDnsResult flG = null;
    private final g.a flH = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.flz > 0) {
                    g.this.flF = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.flG != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.flG.sY());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.flG.sW());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.flG.sX());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.flz >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bym().Dl(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bym().byp();
            }
            g.this.flz = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void c(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.flE == null || g.this.flE.isEmpty()) {
                        g.this.byC();
                    } else {
                        g.this.byB();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.flG != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.flG.sY());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.flG.sW());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.flG.sX());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.flz >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.byD();
                    }
                } else if (g.this.flz >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.byG();
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
        int i = gVar.flz;
        gVar.flz = i + 1;
        return i;
    }

    public static synchronized g byA() {
        g gVar;
        synchronized (g.class) {
            if (fly == null) {
                synchronized (g.class) {
                    if (fly == null) {
                        fly = new g();
                    }
                }
            }
            gVar = fly;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.oD().a(this.flH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byB() {
        synchronized (this.flD) {
            if (this.flE != null && !this.flE.isEmpty()) {
                String remove = this.flE.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + Dr(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byC() {
        if (!this.flF) {
            try {
                String Dq = Dq(TiebaIMConfig.url);
                if (at.isEmpty(Dq)) {
                    byD();
                } else {
                    this.flF = true;
                    BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).a(Dq, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> sY;
                            g.this.flF = false;
                            g.this.flG = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (sY = bDHttpDnsResult.sY()) != null && !sY.isEmpty()) {
                                synchronized (g.this.flD) {
                                    g.this.flE = sY;
                                }
                                g.this.byB();
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
    public void byD() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.flF = false;
    }

    public static String Dq(String str) {
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

    public static String Dr(String str) {
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

    private String byE() {
        if (this.fle == null || this.currentIndex <= -1 || this.currentIndex >= this.fle.size()) {
            return null;
        }
        return a.bym().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ds(final String str) {
        String byE = byE();
        if (byE == null) {
            if (!a.bym().byq()) {
                a.bym().a(new a.InterfaceC0584a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0584a
                    public void byr() {
                        g.this.currentIndex = 0;
                        g.this.fle = a.bym().getIpList();
                        if (g.this.fle != null) {
                            g.this.Ds(str);
                        } else {
                            g.this.flC = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            byF();
        } else if (Dq(byE) == null) {
            byF();
        } else {
            this.flC = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(byE);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.flA = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byF() {
        NoNetworkView.updateUI();
        this.flB = false;
        this.currentIndex = 0;
        this.flC = false;
        this.flA = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void byG() {
        if (!this.flC) {
            this.flC = true;
            if (this.flA) {
                this.flA = false;
                b.byt().Dn(TiebaIMConfig.url);
            }
            b.byt().byu();
            if (!this.flB) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void jR(boolean z) {
                        b.byt().ra(z ? 2 : 1);
                        if (z) {
                            g.this.fle = a.bym().getIpList();
                            if (g.this.fle != null) {
                                g.this.Ds("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bym().a(new a.InterfaceC0584a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0584a
                                    public void byr() {
                                        g.this.currentIndex = 0;
                                        g.this.fle = a.bym().getIpList();
                                        if (g.this.fle != null) {
                                            g.this.Ds("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.flC = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.flC = false;
                        g.this.byF();
                    }
                });
                this.flB = true;
                return;
            }
            Ds("change ip to reconnect with DNS' failed.");
        }
    }
}
