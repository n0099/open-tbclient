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
    private static g duF = null;
    private int duG;
    private int currentIndex = 0;
    private boolean duH = false;
    private boolean duI = false;
    private List<String> dul = null;
    private boolean duJ = false;
    private final Object duK = new Object();
    private List<String> duL = new ArrayList();
    private boolean duM = false;
    private BDHttpDnsResult duN = null;
    private final g.a duO = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.duG > 0) {
                    g.this.duM = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.duN != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.duN.mg());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.duN.me());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.duN.mf());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.duG >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.aNg().uI(com.baidu.adp.framework.client.socket.h.getUrl());
                a.aNg().aNj();
            }
            g.this.duG = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.duL == null || g.this.duL.isEmpty()) {
                        g.this.aNw();
                    } else {
                        g.this.aNv();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.duN != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.duN.mg());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.duN.me());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.duN.mf());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.duG >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.aNx();
                    }
                } else if (g.this.duG >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.aNA();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void hZ() {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onTextMessage(String str) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void h(byte[] bArr) {
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
        int i = gVar.duG;
        gVar.duG = i + 1;
        return i;
    }

    public static synchronized g aNu() {
        g gVar;
        synchronized (g.class) {
            if (duF == null) {
                synchronized (g.class) {
                    if (duF == null) {
                        duF = new g();
                    }
                }
            }
            gVar = duF;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ia().a(this.duO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNv() {
        synchronized (this.duK) {
            if (this.duL != null && !this.duL.isEmpty()) {
                String remove = this.duL.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + uO(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNw() {
        if (!this.duM) {
            try {
                String uN = uN(TiebaIMConfig.url);
                if (aq.isEmpty(uN)) {
                    aNx();
                } else {
                    this.duM = true;
                    BDHttpDns.ag(BdBaseApplication.getInst().getApplicationContext()).a(uN, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> mg;
                            g.this.duM = false;
                            g.this.duN = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (mg = bDHttpDnsResult.mg()) != null && !mg.isEmpty()) {
                                synchronized (g.this.duK) {
                                    g.this.duL = mg;
                                }
                                g.this.aNv();
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
    public void aNx() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.duM = false;
    }

    public static String uN(String str) {
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

    public static String uO(String str) {
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

    private String aNy() {
        if (this.dul == null || this.currentIndex <= -1 || this.currentIndex >= this.dul.size()) {
            return null;
        }
        return a.aNg().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP(final String str) {
        String aNy = aNy();
        if (aNy == null) {
            if (!a.aNg().aNk()) {
                a.aNg().a(new a.InterfaceC0382a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0382a
                    public void aNl() {
                        g.this.currentIndex = 0;
                        g.this.dul = a.aNg().getIpList();
                        if (g.this.dul != null) {
                            g.this.uP(str);
                        } else {
                            g.this.duJ = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            aNz();
        } else if (uN(aNy) == null) {
            aNz();
        } else {
            this.duJ = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(aNy);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.duH = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNz() {
        NoNetworkView.updateUI();
        this.duI = false;
        this.currentIndex = 0;
        this.duJ = false;
        this.duH = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNA() {
        if (!this.duJ) {
            this.duJ = true;
            if (this.duH) {
                this.duH = false;
                b.aNn().uK(TiebaIMConfig.url);
            }
            b.aNn().aNo();
            if (!this.duI) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void gs(boolean z) {
                        b.aNn().mf(z ? 2 : 1);
                        if (z) {
                            g.this.dul = a.aNg().getIpList();
                            if (g.this.dul != null) {
                                g.this.uP("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.aNg().a(new a.InterfaceC0382a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0382a
                                    public void aNl() {
                                        g.this.currentIndex = 0;
                                        g.this.dul = a.aNg().getIpList();
                                        if (g.this.dul != null) {
                                            g.this.uP("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.duJ = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.duJ = false;
                        g.this.aNz();
                    }
                });
                this.duI = true;
                return;
            }
            uP("change ip to reconnect with DNS' failed.");
        }
    }
}
