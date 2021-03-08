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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.d.a;
import com.baidu.tbadk.coreExtra.d.d;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g fAS = null;
    private int fAT;
    private int currentIndex = 0;
    private boolean fAU = false;
    private boolean fAV = false;
    private List<String> fAy = null;
    private boolean fAW = false;
    private final Object fAX = new Object();
    private List<String> fAY = new ArrayList();
    private boolean fAZ = false;
    private BDHttpDnsResult fBa = null;
    private final g.a fBb = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.fAT > 0) {
                    g.this.fAZ = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fBa != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fBa.sn());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fBa.sl());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fBa.sm());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.fAT >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bzY().CC(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bzY().bAc();
            }
            g.this.fAT = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void d(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.fAY == null || g.this.fAY.isEmpty()) {
                        g.this.bAp();
                    } else {
                        g.this.bAo();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fBa != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fBa.sn());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fBa.sl());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fBa.sm());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.fAT >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bAq();
                    }
                } else if (g.this.fAT >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.bAt();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void oa() {
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
        int i = gVar.fAT;
        gVar.fAT = i + 1;
        return i;
    }

    public static synchronized g bAn() {
        g gVar;
        synchronized (g.class) {
            if (fAS == null) {
                synchronized (g.class) {
                    if (fAS == null) {
                        fAS = new g();
                    }
                }
            }
            gVar = fAS;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ob().a(this.fBb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAo() {
        synchronized (this.fAX) {
            if (this.fAY != null && !this.fAY.isEmpty()) {
                String remove = this.fAY.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + CI(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAp() {
        if (!this.fAZ) {
            try {
                String CH = CH(TiebaIMConfig.url);
                if (au.isEmpty(CH)) {
                    bAq();
                } else {
                    this.fAZ = true;
                    BDHttpDns.O(BdBaseApplication.getInst().getApplicationContext()).a(CH, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> sn;
                            g.this.fAZ = false;
                            g.this.fBa = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (sn = bDHttpDnsResult.sn()) != null && !sn.isEmpty()) {
                                synchronized (g.this.fAX) {
                                    g.this.fAY = sn;
                                }
                                g.this.bAo();
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
    public void bAq() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.fAZ = false;
    }

    public static String CH(String str) {
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

    public static String CI(String str) {
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

    private String bAr() {
        if (this.fAy == null || this.currentIndex <= -1 || this.currentIndex >= this.fAy.size()) {
            return null;
        }
        return a.bzY().bAb().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CJ(final String str) {
        String bAr = bAr();
        if (bAr == null) {
            if (!a.bzY().bAd()) {
                a.bzY().a(new a.InterfaceC0573a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0573a
                    public void bAe() {
                        g.this.currentIndex = 0;
                        g.this.fAy = a.bzY().bAb();
                        if (g.this.fAy != null) {
                            g.this.CJ(str);
                        } else {
                            g.this.fAW = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            bAs();
        } else if (CH(bAr) == null) {
            bAs();
        } else {
            this.fAW = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bAr);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.fAU = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAs() {
        NoNetworkView.updateUI();
        this.fAV = false;
        this.currentIndex = 0;
        this.fAW = false;
        this.fAU = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAt() {
        if (!this.fAW) {
            this.fAW = true;
            if (this.fAU) {
                this.fAU = false;
                b.bAg().CE(TiebaIMConfig.url);
            }
            b.bAg().bAh();
            if (!this.fAV) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void kD(boolean z) {
                        b.bAg().qL(z ? 2 : 1);
                        if (z) {
                            g.this.fAy = a.bzY().bAb();
                            if (g.this.fAy != null) {
                                g.this.CJ("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bzY().a(new a.InterfaceC0573a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0573a
                                    public void bAe() {
                                        g.this.currentIndex = 0;
                                        g.this.fAy = a.bzY().bAb();
                                        if (g.this.fAy != null) {
                                            g.this.CJ("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.fAW = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.fAW = false;
                        g.this.bAs();
                    }
                });
                this.fAV = true;
                return;
            }
            CJ("change ip to reconnect with DNS' failed.");
        }
    }
}
