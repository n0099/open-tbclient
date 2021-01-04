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
    private static g fBL = null;
    private int fBM;
    private int currentIndex = 0;
    private boolean fBN = false;
    private boolean fBO = false;
    private List<String> fBr = null;
    private boolean fBP = false;
    private final Object fBQ = new Object();
    private List<String> fBR = new ArrayList();
    private boolean fBS = false;
    private BDHttpDnsResult fBT = null;
    private final g.a fBU = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.fBM > 0) {
                    g.this.fBS = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fBT != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fBT.sB());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fBT.sz());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fBT.sA());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.fBM >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bDw().Dq(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bDw().bDA();
            }
            g.this.fBM = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void c(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.fBR == null || g.this.fBR.isEmpty()) {
                        g.this.bDN();
                    } else {
                        g.this.bDM();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fBT != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fBT.sB());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fBT.sz());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fBT.sA());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.fBM >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bDO();
                    }
                } else if (g.this.fBM >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.bDR();
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
        int i = gVar.fBM;
        gVar.fBM = i + 1;
        return i;
    }

    public static synchronized g bDL() {
        g gVar;
        synchronized (g.class) {
            if (fBL == null) {
                synchronized (g.class) {
                    if (fBL == null) {
                        fBL = new g();
                    }
                }
            }
            gVar = fBL;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.od().a(this.fBU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDM() {
        synchronized (this.fBQ) {
            if (this.fBR != null && !this.fBR.isEmpty()) {
                String remove = this.fBR.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + Dw(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDN() {
        if (!this.fBS) {
            try {
                String Dv = Dv(TiebaIMConfig.url);
                if (at.isEmpty(Dv)) {
                    bDO();
                } else {
                    this.fBS = true;
                    BDHttpDns.Q(BdBaseApplication.getInst().getApplicationContext()).a(Dv, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> sB;
                            g.this.fBS = false;
                            g.this.fBT = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (sB = bDHttpDnsResult.sB()) != null && !sB.isEmpty()) {
                                synchronized (g.this.fBQ) {
                                    g.this.fBR = sB;
                                }
                                g.this.bDM();
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
    public void bDO() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.fBS = false;
    }

    public static String Dv(String str) {
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

    public static String Dw(String str) {
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

    private String bDP() {
        if (this.fBr == null || this.currentIndex <= -1 || this.currentIndex >= this.fBr.size()) {
            return null;
        }
        return a.bDw().bDz().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dx(final String str) {
        String bDP = bDP();
        if (bDP == null) {
            if (!a.bDw().bDB()) {
                a.bDw().a(new a.InterfaceC0587a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0587a
                    public void bDC() {
                        g.this.currentIndex = 0;
                        g.this.fBr = a.bDw().bDz();
                        if (g.this.fBr != null) {
                            g.this.Dx(str);
                        } else {
                            g.this.fBP = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            bDQ();
        } else if (Dv(bDP) == null) {
            bDQ();
        } else {
            this.fBP = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bDP);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.fBN = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDQ() {
        NoNetworkView.updateUI();
        this.fBO = false;
        this.currentIndex = 0;
        this.fBP = false;
        this.fBN = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDR() {
        if (!this.fBP) {
            this.fBP = true;
            if (this.fBN) {
                this.fBN = false;
                b.bDE().Ds(TiebaIMConfig.url);
            }
            b.bDE().bDF();
            if (!this.fBO) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void kE(boolean z) {
                        b.bDE().sl(z ? 2 : 1);
                        if (z) {
                            g.this.fBr = a.bDw().bDz();
                            if (g.this.fBr != null) {
                                g.this.Dx("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bDw().a(new a.InterfaceC0587a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0587a
                                    public void bDC() {
                                        g.this.currentIndex = 0;
                                        g.this.fBr = a.bDw().bDz();
                                        if (g.this.fBr != null) {
                                            g.this.Dx("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.fBP = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.fBP = false;
                        g.this.bDQ();
                    }
                });
                this.fBO = true;
                return;
            }
            Dx("change ip to reconnect with DNS' failed.");
        }
    }
}
