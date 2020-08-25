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
/* loaded from: classes2.dex */
public class g {
    private static g eIR = null;
    private int eIS;
    private int currentIndex = 0;
    private boolean eIT = false;
    private boolean eIU = false;
    private List<String> eIx = null;
    private boolean eIV = false;
    private final Object eIW = new Object();
    private List<String> eIX = new ArrayList();
    private boolean eIY = false;
    private BDHttpDnsResult eIZ = null;
    private final g.a eJa = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.eIS > 0) {
                    g.this.eIY = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.eIZ != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.eIZ.sT());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.eIZ.sR());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.eIZ.sS());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.eIS >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bqp().Bv(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bqp().bqs();
            }
            g.this.eIS = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void c(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.eIX == null || g.this.eIX.isEmpty()) {
                        g.this.bqF();
                    } else {
                        g.this.bqE();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.eIZ != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.eIZ.sT());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.eIZ.sR());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.eIZ.sS());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.eIS >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bqG();
                    }
                } else if (g.this.eIS >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.bqJ();
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
        int i = gVar.eIS;
        gVar.eIS = i + 1;
        return i;
    }

    public static synchronized g bqD() {
        g gVar;
        synchronized (g.class) {
            if (eIR == null) {
                synchronized (g.class) {
                    if (eIR == null) {
                        eIR = new g();
                    }
                }
            }
            gVar = eIR;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.oy().a(this.eJa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqE() {
        synchronized (this.eIW) {
            if (this.eIX != null && !this.eIX.isEmpty()) {
                String remove = this.eIX.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + BB(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqF() {
        if (!this.eIY) {
            try {
                String BA = BA(TiebaIMConfig.url);
                if (at.isEmpty(BA)) {
                    bqG();
                } else {
                    this.eIY = true;
                    BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).a(BA, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> sT;
                            g.this.eIY = false;
                            g.this.eIZ = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (sT = bDHttpDnsResult.sT()) != null && !sT.isEmpty()) {
                                synchronized (g.this.eIW) {
                                    g.this.eIX = sT;
                                }
                                g.this.bqE();
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
    public void bqG() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.eIY = false;
    }

    public static String BA(String str) {
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

    public static String BB(String str) {
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

    private String bqH() {
        if (this.eIx == null || this.currentIndex <= -1 || this.currentIndex >= this.eIx.size()) {
            return null;
        }
        return a.bqp().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BC(final String str) {
        String bqH = bqH();
        if (bqH == null) {
            if (!a.bqp().bqt()) {
                a.bqp().a(new a.InterfaceC0546a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0546a
                    public void bqu() {
                        g.this.currentIndex = 0;
                        g.this.eIx = a.bqp().getIpList();
                        if (g.this.eIx != null) {
                            g.this.BC(str);
                        } else {
                            g.this.eIV = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            bqI();
        } else if (BA(bqH) == null) {
            bqI();
        } else {
            this.eIV = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bqH);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.eIT = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqI() {
        NoNetworkView.updateUI();
        this.eIU = false;
        this.currentIndex = 0;
        this.eIV = false;
        this.eIT = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqJ() {
        if (!this.eIV) {
            this.eIV = true;
            if (this.eIT) {
                this.eIT = false;
                b.bqw().Bx(TiebaIMConfig.url);
            }
            b.bqw().bqx();
            if (!this.eIU) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void iY(boolean z) {
                        b.bqw().pU(z ? 2 : 1);
                        if (z) {
                            g.this.eIx = a.bqp().getIpList();
                            if (g.this.eIx != null) {
                                g.this.BC("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bqp().a(new a.InterfaceC0546a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0546a
                                    public void bqu() {
                                        g.this.currentIndex = 0;
                                        g.this.eIx = a.bqp().getIpList();
                                        if (g.this.eIx != null) {
                                            g.this.BC("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.eIV = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.eIV = false;
                        g.this.bqI();
                    }
                });
                this.eIU = true;
                return;
            }
            BC("change ip to reconnect with DNS' failed.");
        }
    }
}
