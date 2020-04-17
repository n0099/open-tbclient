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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.d.a;
import com.baidu.tbadk.coreExtra.d.d;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g dVa = null;
    private int dVb;
    private int currentIndex = 0;
    private boolean dVc = false;
    private boolean dVd = false;
    private List<String> dUG = null;
    private boolean dVe = false;
    private final Object dVf = new Object();
    private List<String> dVg = new ArrayList();
    private boolean dVh = false;
    private BDHttpDnsResult dVi = null;
    private final g.a dVj = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.dVb > 0) {
                    g.this.dVh = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.dVi != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.dVi.qI());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.dVi.qG());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.dVi.qH());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.dVb >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.aVK().vX(com.baidu.adp.framework.client.socket.h.getUrl());
                a.aVK().aVN();
            }
            g.this.dVb = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void d(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.dVg == null || g.this.dVg.isEmpty()) {
                        g.this.aWa();
                    } else {
                        g.this.aVZ();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.dVi != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.dVi.qI());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.dVi.qG());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.dVi.qH());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.dVb >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.aWb();
                    }
                } else if (g.this.dVb >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.aWe();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void mE() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onTextMessage(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void k(byte[] bArr) {
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
        int i = gVar.dVb;
        gVar.dVb = i + 1;
        return i;
    }

    public static synchronized g aVY() {
        g gVar;
        synchronized (g.class) {
            if (dVa == null) {
                synchronized (g.class) {
                    if (dVa == null) {
                        dVa = new g();
                    }
                }
            }
            gVar = dVa;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.mF().a(this.dVj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVZ() {
        synchronized (this.dVf) {
            if (this.dVg != null && !this.dVg.isEmpty()) {
                String remove = this.dVg.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + wd(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWa() {
        if (!this.dVh) {
            try {
                String wc = wc(TiebaIMConfig.url);
                if (aq.isEmpty(wc)) {
                    aWb();
                } else {
                    this.dVh = true;
                    BDHttpDns.X(BdBaseApplication.getInst().getApplicationContext()).a(wc, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> qI;
                            g.this.dVh = false;
                            g.this.dVi = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (qI = bDHttpDnsResult.qI()) != null && !qI.isEmpty()) {
                                synchronized (g.this.dVf) {
                                    g.this.dVg = qI;
                                }
                                g.this.aVZ();
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
    public void aWb() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.dVh = false;
    }

    public static String wc(String str) {
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

    public static String wd(String str) {
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

    private String aWc() {
        if (this.dUG == null || this.currentIndex <= -1 || this.currentIndex >= this.dUG.size()) {
            return null;
        }
        return a.aVK().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we(final String str) {
        String aWc = aWc();
        if (aWc == null) {
            if (!a.aVK().aVO()) {
                a.aVK().a(new a.InterfaceC0413a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0413a
                    public void aVP() {
                        g.this.currentIndex = 0;
                        g.this.dUG = a.aVK().getIpList();
                        if (g.this.dUG != null) {
                            g.this.we(str);
                        } else {
                            g.this.dVe = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            aWd();
        } else if (wc(aWc) == null) {
            aWd();
        } else {
            this.dVe = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(aWc);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.dVc = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWd() {
        NoNetworkView.updateUI();
        this.dVd = false;
        this.currentIndex = 0;
        this.dVe = false;
        this.dVc = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWe() {
        if (!this.dVe) {
            this.dVe = true;
            if (this.dVc) {
                this.dVc = false;
                b.aVR().vZ(TiebaIMConfig.url);
            }
            b.aVR().aVS();
            if (!this.dVd) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void hr(boolean z) {
                        b.aVR().mt(z ? 2 : 1);
                        if (z) {
                            g.this.dUG = a.aVK().getIpList();
                            if (g.this.dUG != null) {
                                g.this.we("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.aVK().a(new a.InterfaceC0413a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0413a
                                    public void aVP() {
                                        g.this.currentIndex = 0;
                                        g.this.dUG = a.aVK().getIpList();
                                        if (g.this.dUG != null) {
                                            g.this.we("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.dVe = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.dVe = false;
                        g.this.aWd();
                    }
                });
                this.dVd = true;
                return;
            }
            we("change ip to reconnect with DNS' failed.");
        }
    }
}
