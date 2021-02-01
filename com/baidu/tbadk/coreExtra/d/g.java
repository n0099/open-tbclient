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
    private static g fzt = null;
    private int fzu;
    private int currentIndex = 0;
    private boolean fzv = false;
    private boolean fzw = false;
    private List<String> fyZ = null;
    private boolean fzx = false;
    private final Object fzy = new Object();
    private List<String> fzz = new ArrayList();
    private boolean fzA = false;
    private BDHttpDnsResult fzB = null;
    private final g.a fzC = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.fzu > 0) {
                    g.this.fzA = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fzB != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fzB.sn());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fzB.sl());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fzB.sm());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.fzu >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bzV().Cv(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bzV().bzZ();
            }
            g.this.fzu = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void d(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.fzz == null || g.this.fzz.isEmpty()) {
                        g.this.bAm();
                    } else {
                        g.this.bAl();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fzB != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fzB.sn());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fzB.sl());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fzB.sm());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.fzu >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bAn();
                    }
                } else if (g.this.fzu >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.bAq();
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
        int i = gVar.fzu;
        gVar.fzu = i + 1;
        return i;
    }

    public static synchronized g bAk() {
        g gVar;
        synchronized (g.class) {
            if (fzt == null) {
                synchronized (g.class) {
                    if (fzt == null) {
                        fzt = new g();
                    }
                }
            }
            gVar = fzt;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ob().a(this.fzC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAl() {
        synchronized (this.fzy) {
            if (this.fzz != null && !this.fzz.isEmpty()) {
                String remove = this.fzz.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + CB(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAm() {
        if (!this.fzA) {
            try {
                String CA = CA(TiebaIMConfig.url);
                if (au.isEmpty(CA)) {
                    bAn();
                } else {
                    this.fzA = true;
                    BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).a(CA, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> sn;
                            g.this.fzA = false;
                            g.this.fzB = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (sn = bDHttpDnsResult.sn()) != null && !sn.isEmpty()) {
                                synchronized (g.this.fzy) {
                                    g.this.fzz = sn;
                                }
                                g.this.bAl();
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
    public void bAn() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.fzA = false;
    }

    public static String CA(String str) {
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

    public static String CB(String str) {
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

    private String bAo() {
        if (this.fyZ == null || this.currentIndex <= -1 || this.currentIndex >= this.fyZ.size()) {
            return null;
        }
        return a.bzV().bzY().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CC(final String str) {
        String bAo = bAo();
        if (bAo == null) {
            if (!a.bzV().bAa()) {
                a.bzV().a(new a.InterfaceC0567a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0567a
                    public void bAb() {
                        g.this.currentIndex = 0;
                        g.this.fyZ = a.bzV().bzY();
                        if (g.this.fyZ != null) {
                            g.this.CC(str);
                        } else {
                            g.this.fzx = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            bAp();
        } else if (CA(bAo) == null) {
            bAp();
        } else {
            this.fzx = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bAo);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.fzv = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAp() {
        NoNetworkView.updateUI();
        this.fzw = false;
        this.currentIndex = 0;
        this.fzx = false;
        this.fzv = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAq() {
        if (!this.fzx) {
            this.fzx = true;
            if (this.fzv) {
                this.fzv = false;
                b.bAd().Cx(TiebaIMConfig.url);
            }
            b.bAd().bAe();
            if (!this.fzw) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void kD(boolean z) {
                        b.bAd().qK(z ? 2 : 1);
                        if (z) {
                            g.this.fyZ = a.bzV().bzY();
                            if (g.this.fyZ != null) {
                                g.this.CC("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bzV().a(new a.InterfaceC0567a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0567a
                                    public void bAb() {
                                        g.this.currentIndex = 0;
                                        g.this.fyZ = a.bzV().bzY();
                                        if (g.this.fyZ != null) {
                                            g.this.CC("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.fzx = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.fzx = false;
                        g.this.bAp();
                    }
                });
                this.fzw = true;
                return;
            }
            CC("change ip to reconnect with DNS' failed.");
        }
    }
}
