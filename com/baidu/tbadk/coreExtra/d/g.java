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
    private static g dqx = null;
    private int dqy;
    private int currentIndex = 0;
    private boolean dqz = false;
    private boolean dqA = false;
    private List<String> dqd = null;
    private boolean dqB = false;
    private final Object dqC = new Object();
    private List<String> dqD = new ArrayList();
    private boolean dqE = false;
    private BDHttpDnsResult dqF = null;
    private final g.a dqG = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.dqy > 0) {
                    g.this.dqE = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.dqF != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.dqF.lR());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.dqF.lP());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.dqF.lQ());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.dqy >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.aKK().ur(com.baidu.adp.framework.client.socket.h.getUrl());
                a.aKK().aKN();
            }
            g.this.dqy = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.dqD == null || g.this.dqD.isEmpty()) {
                        g.this.aLa();
                    } else {
                        g.this.aKZ();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.dqF != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.dqF.lR());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.dqF.lP());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.dqF.lQ());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.dqy >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.aLb();
                    }
                } else if (g.this.dqy >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.aLe();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void hL() {
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
        int i = gVar.dqy;
        gVar.dqy = i + 1;
        return i;
    }

    public static synchronized g aKY() {
        g gVar;
        synchronized (g.class) {
            if (dqx == null) {
                synchronized (g.class) {
                    if (dqx == null) {
                        dqx = new g();
                    }
                }
            }
            gVar = dqx;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.hM().a(this.dqG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKZ() {
        synchronized (this.dqC) {
            if (this.dqD != null && !this.dqD.isEmpty()) {
                String remove = this.dqD.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + ux(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLa() {
        if (!this.dqE) {
            try {
                String uw = uw(TiebaIMConfig.url);
                if (aq.isEmpty(uw)) {
                    aLb();
                } else {
                    this.dqE = true;
                    BDHttpDns.ag(BdBaseApplication.getInst().getApplicationContext()).a(uw, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> lR;
                            g.this.dqE = false;
                            g.this.dqF = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (lR = bDHttpDnsResult.lR()) != null && !lR.isEmpty()) {
                                synchronized (g.this.dqC) {
                                    g.this.dqD = lR;
                                }
                                g.this.aKZ();
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
    public void aLb() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.dqE = false;
    }

    public static String uw(String str) {
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

    public static String ux(String str) {
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

    private String aLc() {
        if (this.dqd == null || this.currentIndex <= -1 || this.currentIndex >= this.dqd.size()) {
            return null;
        }
        return a.aKK().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uy(final String str) {
        String aLc = aLc();
        if (aLc == null) {
            if (!a.aKK().aKO()) {
                a.aKK().a(new a.InterfaceC0372a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0372a
                    public void aKP() {
                        g.this.currentIndex = 0;
                        g.this.dqd = a.aKK().getIpList();
                        if (g.this.dqd != null) {
                            g.this.uy(str);
                        } else {
                            g.this.dqB = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            aLd();
        } else if (uw(aLc) == null) {
            aLd();
        } else {
            this.dqB = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(aLc);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.dqz = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLd() {
        NoNetworkView.updateUI();
        this.dqA = false;
        this.currentIndex = 0;
        this.dqB = false;
        this.dqz = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aLe() {
        if (!this.dqB) {
            this.dqB = true;
            if (this.dqz) {
                this.dqz = false;
                b.aKR().ut(TiebaIMConfig.url);
            }
            b.aKR().aKS();
            if (!this.dqA) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void gl(boolean z) {
                        b.aKR().lN(z ? 2 : 1);
                        if (z) {
                            g.this.dqd = a.aKK().getIpList();
                            if (g.this.dqd != null) {
                                g.this.uy("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.aKK().a(new a.InterfaceC0372a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0372a
                                    public void aKP() {
                                        g.this.currentIndex = 0;
                                        g.this.dqd = a.aKK().getIpList();
                                        if (g.this.dqd != null) {
                                            g.this.uy("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.dqB = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.dqB = false;
                        g.this.aLd();
                    }
                });
                this.dqA = true;
                return;
            }
            uy("change ip to reconnect with DNS' failed.");
        }
    }
}
