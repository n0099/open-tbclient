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
    private static g fxd = null;
    private int fxe;
    private int currentIndex = 0;
    private boolean fxf = false;
    private boolean fxg = false;
    private List<String> fwJ = null;
    private boolean fxh = false;
    private final Object fxi = new Object();
    private List<String> fxj = new ArrayList();
    private boolean fxk = false;
    private BDHttpDnsResult fxl = null;
    private final g.a fxm = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.fxe > 0) {
                    g.this.fxk = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fxl != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fxl.sq());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fxl.so());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fxl.sp());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.fxe >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bzD().Ce(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bzD().bzH();
            }
            g.this.fxe = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void d(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.fxj == null || g.this.fxj.isEmpty()) {
                        g.this.bzU();
                    } else {
                        g.this.bzT();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fxl != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fxl.sq());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fxl.so());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fxl.sp());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.fxe >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bzV();
                    }
                } else if (g.this.fxe >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.bzY();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void oc() {
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
        int i = gVar.fxe;
        gVar.fxe = i + 1;
        return i;
    }

    public static synchronized g bzS() {
        g gVar;
        synchronized (g.class) {
            if (fxd == null) {
                synchronized (g.class) {
                    if (fxd == null) {
                        fxd = new g();
                    }
                }
            }
            gVar = fxd;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.od().a(this.fxm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzT() {
        synchronized (this.fxi) {
            if (this.fxj != null && !this.fxj.isEmpty()) {
                String remove = this.fxj.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + Ck(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzU() {
        if (!this.fxk) {
            try {
                String Cj = Cj(TiebaIMConfig.url);
                if (at.isEmpty(Cj)) {
                    bzV();
                } else {
                    this.fxk = true;
                    BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).a(Cj, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> sq;
                            g.this.fxk = false;
                            g.this.fxl = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (sq = bDHttpDnsResult.sq()) != null && !sq.isEmpty()) {
                                synchronized (g.this.fxi) {
                                    g.this.fxj = sq;
                                }
                                g.this.bzT();
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
    public void bzV() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.fxk = false;
    }

    public static String Cj(String str) {
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

    public static String Ck(String str) {
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

    private String bzW() {
        if (this.fwJ == null || this.currentIndex <= -1 || this.currentIndex >= this.fwJ.size()) {
            return null;
        }
        return a.bzD().bzG().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cl(final String str) {
        String bzW = bzW();
        if (bzW == null) {
            if (!a.bzD().bzI()) {
                a.bzD().a(new a.InterfaceC0570a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0570a
                    public void bzJ() {
                        g.this.currentIndex = 0;
                        g.this.fwJ = a.bzD().bzG();
                        if (g.this.fwJ != null) {
                            g.this.Cl(str);
                        } else {
                            g.this.fxh = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            bzX();
        } else if (Cj(bzW) == null) {
            bzX();
        } else {
            this.fxh = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bzW);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.fxf = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzX() {
        NoNetworkView.updateUI();
        this.fxg = false;
        this.currentIndex = 0;
        this.fxh = false;
        this.fxf = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bzY() {
        if (!this.fxh) {
            this.fxh = true;
            if (this.fxf) {
                this.fxf = false;
                b.bzL().Cg(TiebaIMConfig.url);
            }
            b.bzL().bzM();
            if (!this.fxg) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void kA(boolean z) {
                        b.bzL().qF(z ? 2 : 1);
                        if (z) {
                            g.this.fwJ = a.bzD().bzG();
                            if (g.this.fwJ != null) {
                                g.this.Cl("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bzD().a(new a.InterfaceC0570a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0570a
                                    public void bzJ() {
                                        g.this.currentIndex = 0;
                                        g.this.fwJ = a.bzD().bzG();
                                        if (g.this.fwJ != null) {
                                            g.this.Cl("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.fxh = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.fxh = false;
                        g.this.bzX();
                    }
                });
                this.fxg = true;
                return;
            }
            Cl("change ip to reconnect with DNS' failed.");
        }
    }
}
