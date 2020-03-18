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
    private static g dvg = null;
    private int dvh;
    private int currentIndex = 0;
    private boolean dvi = false;
    private boolean dvj = false;
    private List<String> duM = null;
    private boolean dvk = false;
    private final Object dvl = new Object();
    private List<String> dvm = new ArrayList();
    private boolean dvn = false;
    private BDHttpDnsResult dvo = null;
    private final g.a dvp = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.dvh > 0) {
                    g.this.dvn = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.dvo != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.dvo.mg());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.dvo.me());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.dvo.mf());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.dvh >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.aNn().uI(com.baidu.adp.framework.client.socket.h.getUrl());
                a.aNn().aNq();
            }
            g.this.dvh = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.dvm == null || g.this.dvm.isEmpty()) {
                        g.this.aND();
                    } else {
                        g.this.aNC();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.dvo != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.dvo.mg());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.dvo.me());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.dvo.mf());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.dvh >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.aNE();
                    }
                } else if (g.this.dvh >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.aNH();
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
        int i = gVar.dvh;
        gVar.dvh = i + 1;
        return i;
    }

    public static synchronized g aNB() {
        g gVar;
        synchronized (g.class) {
            if (dvg == null) {
                synchronized (g.class) {
                    if (dvg == null) {
                        dvg = new g();
                    }
                }
            }
            gVar = dvg;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ia().a(this.dvp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNC() {
        synchronized (this.dvl) {
            if (this.dvm != null && !this.dvm.isEmpty()) {
                String remove = this.dvm.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + uO(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aND() {
        if (!this.dvn) {
            try {
                String uN = uN(TiebaIMConfig.url);
                if (aq.isEmpty(uN)) {
                    aNE();
                } else {
                    this.dvn = true;
                    BDHttpDns.ag(BdBaseApplication.getInst().getApplicationContext()).a(uN, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> mg;
                            g.this.dvn = false;
                            g.this.dvo = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (mg = bDHttpDnsResult.mg()) != null && !mg.isEmpty()) {
                                synchronized (g.this.dvl) {
                                    g.this.dvm = mg;
                                }
                                g.this.aNC();
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
    public void aNE() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.dvn = false;
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

    private String aNF() {
        if (this.duM == null || this.currentIndex <= -1 || this.currentIndex >= this.duM.size()) {
            return null;
        }
        return a.aNn().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP(final String str) {
        String aNF = aNF();
        if (aNF == null) {
            if (!a.aNn().aNr()) {
                a.aNn().a(new a.InterfaceC0382a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0382a
                    public void aNs() {
                        g.this.currentIndex = 0;
                        g.this.duM = a.aNn().getIpList();
                        if (g.this.duM != null) {
                            g.this.uP(str);
                        } else {
                            g.this.dvk = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            aNG();
        } else if (uN(aNF) == null) {
            aNG();
        } else {
            this.dvk = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(aNF);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.dvi = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNG() {
        NoNetworkView.updateUI();
        this.dvj = false;
        this.currentIndex = 0;
        this.dvk = false;
        this.dvi = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNH() {
        if (!this.dvk) {
            this.dvk = true;
            if (this.dvi) {
                this.dvi = false;
                b.aNu().uK(TiebaIMConfig.url);
            }
            b.aNu().aNv();
            if (!this.dvj) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void gt(boolean z) {
                        b.aNu().mh(z ? 2 : 1);
                        if (z) {
                            g.this.duM = a.aNn().getIpList();
                            if (g.this.duM != null) {
                                g.this.uP("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.aNn().a(new a.InterfaceC0382a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0382a
                                    public void aNs() {
                                        g.this.currentIndex = 0;
                                        g.this.duM = a.aNn().getIpList();
                                        if (g.this.duM != null) {
                                            g.this.uP("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.dvk = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.dvk = false;
                        g.this.aNG();
                    }
                });
                this.dvj = true;
                return;
            }
            uP("change ip to reconnect with DNS' failed.");
        }
    }
}
