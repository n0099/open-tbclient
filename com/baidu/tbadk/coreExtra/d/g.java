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
    private static g ejo = null;
    private int ejp;
    private int currentIndex = 0;
    private boolean ejq = false;
    private boolean ejr = false;
    private List<String> eiU = null;
    private boolean ejs = false;
    private final Object ejt = new Object();
    private List<String> eju = new ArrayList();
    private boolean ejv = false;
    private BDHttpDnsResult ejw = null;
    private final g.a ejx = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.ejp > 0) {
                    g.this.ejv = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.ejw != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.ejw.qO());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.ejw.qM());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.ejw.qN());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.ejp >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bbR().xG(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bbR().bbU();
            }
            g.this.ejp = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void d(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.eju == null || g.this.eju.isEmpty()) {
                        g.this.bch();
                    } else {
                        g.this.bcg();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.ejw != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.ejw.qO());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.ejw.qM());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.ejw.qN());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.ejp >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bci();
                    }
                } else if (g.this.ejp >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.bcl();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void mG() {
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
        int i = gVar.ejp;
        gVar.ejp = i + 1;
        return i;
    }

    public static synchronized g bcf() {
        g gVar;
        synchronized (g.class) {
            if (ejo == null) {
                synchronized (g.class) {
                    if (ejo == null) {
                        ejo = new g();
                    }
                }
            }
            gVar = ejo;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.mH().a(this.ejx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcg() {
        synchronized (this.ejt) {
            if (this.eju != null && !this.eju.isEmpty()) {
                String remove = this.eju.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + xM(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bch() {
        if (!this.ejv) {
            try {
                String xL = xL(TiebaIMConfig.url);
                if (aq.isEmpty(xL)) {
                    bci();
                } else {
                    this.ejv = true;
                    BDHttpDns.L(BdBaseApplication.getInst().getApplicationContext()).a(xL, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> qO;
                            g.this.ejv = false;
                            g.this.ejw = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (qO = bDHttpDnsResult.qO()) != null && !qO.isEmpty()) {
                                synchronized (g.this.ejt) {
                                    g.this.eju = qO;
                                }
                                g.this.bcg();
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
    public void bci() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.ejv = false;
    }

    public static String xL(String str) {
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

    public static String xM(String str) {
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

    private String bcj() {
        if (this.eiU == null || this.currentIndex <= -1 || this.currentIndex >= this.eiU.size()) {
            return null;
        }
        return a.bbR().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xN(final String str) {
        String bcj = bcj();
        if (bcj == null) {
            if (!a.bbR().bbV()) {
                a.bbR().a(new a.InterfaceC0481a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0481a
                    public void bbW() {
                        g.this.currentIndex = 0;
                        g.this.eiU = a.bbR().getIpList();
                        if (g.this.eiU != null) {
                            g.this.xN(str);
                        } else {
                            g.this.ejs = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            bck();
        } else if (xL(bcj) == null) {
            bck();
        } else {
            this.ejs = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bcj);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.ejq = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bck() {
        NoNetworkView.updateUI();
        this.ejr = false;
        this.currentIndex = 0;
        this.ejs = false;
        this.ejq = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcl() {
        if (!this.ejs) {
            this.ejs = true;
            if (this.ejq) {
                this.ejq = false;
                b.bbY().xI(TiebaIMConfig.url);
            }
            b.bbY().bbZ();
            if (!this.ejr) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void hN(boolean z) {
                        b.bbY().mV(z ? 2 : 1);
                        if (z) {
                            g.this.eiU = a.bbR().getIpList();
                            if (g.this.eiU != null) {
                                g.this.xN("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bbR().a(new a.InterfaceC0481a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0481a
                                    public void bbW() {
                                        g.this.currentIndex = 0;
                                        g.this.eiU = a.bbR().getIpList();
                                        if (g.this.eiU != null) {
                                            g.this.xN("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.ejs = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.ejs = false;
                        g.this.bck();
                    }
                });
                this.ejr = true;
                return;
            }
            xN("change ip to reconnect with DNS' failed.");
        }
    }
}
