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
    private static g dVf = null;
    private int dVg;
    private int currentIndex = 0;
    private boolean dVh = false;
    private boolean dVi = false;
    private List<String> dUL = null;
    private boolean dVj = false;
    private final Object dVk = new Object();
    private List<String> dVl = new ArrayList();
    private boolean dVm = false;
    private BDHttpDnsResult dVn = null;
    private final g.a dVo = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.dVg > 0) {
                    g.this.dVm = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.dVn != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.dVn.qI());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.dVn.qG());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.dVn.qH());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.dVg >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.aVI().wa(com.baidu.adp.framework.client.socket.h.getUrl());
                a.aVI().aVL();
            }
            g.this.dVg = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void d(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.dVl == null || g.this.dVl.isEmpty()) {
                        g.this.aVY();
                    } else {
                        g.this.aVX();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.dVn != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.dVn.qI());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.dVn.qG());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.dVn.qH());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.dVg >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.aVZ();
                    }
                } else if (g.this.dVg >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.aWc();
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
        int i = gVar.dVg;
        gVar.dVg = i + 1;
        return i;
    }

    public static synchronized g aVW() {
        g gVar;
        synchronized (g.class) {
            if (dVf == null) {
                synchronized (g.class) {
                    if (dVf == null) {
                        dVf = new g();
                    }
                }
            }
            gVar = dVf;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.mF().a(this.dVo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVX() {
        synchronized (this.dVk) {
            if (this.dVl != null && !this.dVl.isEmpty()) {
                String remove = this.dVl.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + wg(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVY() {
        if (!this.dVm) {
            try {
                String wf = wf(TiebaIMConfig.url);
                if (aq.isEmpty(wf)) {
                    aVZ();
                } else {
                    this.dVm = true;
                    BDHttpDns.K(BdBaseApplication.getInst().getApplicationContext()).a(wf, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> qI;
                            g.this.dVm = false;
                            g.this.dVn = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (qI = bDHttpDnsResult.qI()) != null && !qI.isEmpty()) {
                                synchronized (g.this.dVk) {
                                    g.this.dVl = qI;
                                }
                                g.this.aVX();
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
    public void aVZ() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.dVm = false;
    }

    public static String wf(String str) {
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

    public static String wg(String str) {
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

    private String aWa() {
        if (this.dUL == null || this.currentIndex <= -1 || this.currentIndex >= this.dUL.size()) {
            return null;
        }
        return a.aVI().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wh(final String str) {
        String aWa = aWa();
        if (aWa == null) {
            if (!a.aVI().aVM()) {
                a.aVI().a(new a.InterfaceC0434a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0434a
                    public void aVN() {
                        g.this.currentIndex = 0;
                        g.this.dUL = a.aVI().getIpList();
                        if (g.this.dUL != null) {
                            g.this.wh(str);
                        } else {
                            g.this.dVj = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            aWb();
        } else if (wf(aWa) == null) {
            aWb();
        } else {
            this.dVj = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(aWa);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.dVh = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWb() {
        NoNetworkView.updateUI();
        this.dVi = false;
        this.currentIndex = 0;
        this.dVj = false;
        this.dVh = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWc() {
        if (!this.dVj) {
            this.dVj = true;
            if (this.dVh) {
                this.dVh = false;
                b.aVP().wc(TiebaIMConfig.url);
            }
            b.aVP().aVQ();
            if (!this.dVi) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void hr(boolean z) {
                        b.aVP().mt(z ? 2 : 1);
                        if (z) {
                            g.this.dUL = a.aVI().getIpList();
                            if (g.this.dUL != null) {
                                g.this.wh("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.aVI().a(new a.InterfaceC0434a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0434a
                                    public void aVN() {
                                        g.this.currentIndex = 0;
                                        g.this.dUL = a.aVI().getIpList();
                                        if (g.this.dUL != null) {
                                            g.this.wh("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.dVj = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.dVj = false;
                        g.this.aWb();
                    }
                });
                this.dVi = true;
                return;
            }
            wh("change ip to reconnect with DNS' failed.");
        }
    }
}
