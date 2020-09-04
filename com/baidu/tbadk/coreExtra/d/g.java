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
    private static g eIV = null;
    private int eIW;
    private int currentIndex = 0;
    private boolean eIX = false;
    private boolean eIY = false;
    private List<String> eIB = null;
    private boolean eIZ = false;
    private final Object eJa = new Object();
    private List<String> eJb = new ArrayList();
    private boolean eJc = false;
    private BDHttpDnsResult eJd = null;
    private final g.a eJe = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.eIW > 0) {
                    g.this.eJc = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.eJd != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.eJd.sT());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.eJd.sR());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.eJd.sS());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.eIW >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bqq().Bw(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bqq().bqt();
            }
            g.this.eIW = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void c(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.eJb == null || g.this.eJb.isEmpty()) {
                        g.this.bqG();
                    } else {
                        g.this.bqF();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.eJd != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.eJd.sT());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.eJd.sR());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.eJd.sS());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.eIW >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bqH();
                    }
                } else if (g.this.eIW >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.bqK();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void ox() {
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
        int i = gVar.eIW;
        gVar.eIW = i + 1;
        return i;
    }

    public static synchronized g bqE() {
        g gVar;
        synchronized (g.class) {
            if (eIV == null) {
                synchronized (g.class) {
                    if (eIV == null) {
                        eIV = new g();
                    }
                }
            }
            gVar = eIV;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.oy().a(this.eJe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqF() {
        synchronized (this.eJa) {
            if (this.eJb != null && !this.eJb.isEmpty()) {
                String remove = this.eJb.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + BC(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqG() {
        if (!this.eJc) {
            try {
                String BB = BB(TiebaIMConfig.url);
                if (at.isEmpty(BB)) {
                    bqH();
                } else {
                    this.eJc = true;
                    BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).a(BB, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> sT;
                            g.this.eJc = false;
                            g.this.eJd = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (sT = bDHttpDnsResult.sT()) != null && !sT.isEmpty()) {
                                synchronized (g.this.eJa) {
                                    g.this.eJb = sT;
                                }
                                g.this.bqF();
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
    public void bqH() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.eJc = false;
    }

    public static String BB(String str) {
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

    public static String BC(String str) {
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

    private String bqI() {
        if (this.eIB == null || this.currentIndex <= -1 || this.currentIndex >= this.eIB.size()) {
            return null;
        }
        return a.bqq().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BD(final String str) {
        String bqI = bqI();
        if (bqI == null) {
            if (!a.bqq().bqu()) {
                a.bqq().a(new a.InterfaceC0546a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0546a
                    public void bqv() {
                        g.this.currentIndex = 0;
                        g.this.eIB = a.bqq().getIpList();
                        if (g.this.eIB != null) {
                            g.this.BD(str);
                        } else {
                            g.this.eIZ = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            bqJ();
        } else if (BB(bqI) == null) {
            bqJ();
        } else {
            this.eIZ = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bqI);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.eIX = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqJ() {
        NoNetworkView.updateUI();
        this.eIY = false;
        this.currentIndex = 0;
        this.eIZ = false;
        this.eIX = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqK() {
        if (!this.eIZ) {
            this.eIZ = true;
            if (this.eIX) {
                this.eIX = false;
                b.bqx().By(TiebaIMConfig.url);
            }
            b.bqx().bqy();
            if (!this.eIY) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void ja(boolean z) {
                        b.bqx().pU(z ? 2 : 1);
                        if (z) {
                            g.this.eIB = a.bqq().getIpList();
                            if (g.this.eIB != null) {
                                g.this.BD("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bqq().a(new a.InterfaceC0546a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0546a
                                    public void bqv() {
                                        g.this.currentIndex = 0;
                                        g.this.eIB = a.bqq().getIpList();
                                        if (g.this.eIB != null) {
                                            g.this.BD("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.eIZ = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.eIZ = false;
                        g.this.bqJ();
                    }
                });
                this.eIY = true;
                return;
            }
            BD("change ip to reconnect with DNS' failed.");
        }
    }
}
