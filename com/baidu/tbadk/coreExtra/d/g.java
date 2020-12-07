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
    private static g fsg = null;
    private int fsh;
    private int currentIndex = 0;
    private boolean fsi = false;
    private boolean fsj = false;
    private List<String> frM = null;
    private boolean fsk = false;
    private final Object fsl = new Object();
    private List<String> fsm = new ArrayList();
    private boolean fsn = false;
    private BDHttpDnsResult fso = null;
    private final g.a fsp = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.fsh > 0) {
                    g.this.fsn = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fso != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fso.tb());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fso.sZ());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fso.ta());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.fsh >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bBc().Ds(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bBc().bBf();
            }
            g.this.fsh = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void c(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.fsm == null || g.this.fsm.isEmpty()) {
                        g.this.bBs();
                    } else {
                        g.this.bBr();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fso != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fso.tb());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fso.sZ());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fso.ta());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.fsh >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bBt();
                    }
                } else if (g.this.fsh >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.bBw();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void oB() {
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
        int i = gVar.fsh;
        gVar.fsh = i + 1;
        return i;
    }

    public static synchronized g bBq() {
        g gVar;
        synchronized (g.class) {
            if (fsg == null) {
                synchronized (g.class) {
                    if (fsg == null) {
                        fsg = new g();
                    }
                }
            }
            gVar = fsg;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.oC().a(this.fsp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBr() {
        synchronized (this.fsl) {
            if (this.fsm != null && !this.fsm.isEmpty()) {
                String remove = this.fsm.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + Dy(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBs() {
        if (!this.fsn) {
            try {
                String Dx = Dx(TiebaIMConfig.url);
                if (au.isEmpty(Dx)) {
                    bBt();
                } else {
                    this.fsn = true;
                    BDHttpDns.Q(BdBaseApplication.getInst().getApplicationContext()).a(Dx, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> tb;
                            g.this.fsn = false;
                            g.this.fso = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (tb = bDHttpDnsResult.tb()) != null && !tb.isEmpty()) {
                                synchronized (g.this.fsl) {
                                    g.this.fsm = tb;
                                }
                                g.this.bBr();
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
    public void bBt() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.fsn = false;
    }

    public static String Dx(String str) {
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

    public static String Dy(String str) {
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

    private String bBu() {
        if (this.frM == null || this.currentIndex <= -1 || this.currentIndex >= this.frM.size()) {
            return null;
        }
        return a.bBc().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dz(final String str) {
        String bBu = bBu();
        if (bBu == null) {
            if (!a.bBc().bBg()) {
                a.bBc().a(new a.InterfaceC0596a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0596a
                    public void bBh() {
                        g.this.currentIndex = 0;
                        g.this.frM = a.bBc().getIpList();
                        if (g.this.frM != null) {
                            g.this.Dz(str);
                        } else {
                            g.this.fsk = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            bBv();
        } else if (Dx(bBu) == null) {
            bBv();
        } else {
            this.fsk = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bBu);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.fsi = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBv() {
        NoNetworkView.updateUI();
        this.fsj = false;
        this.currentIndex = 0;
        this.fsk = false;
        this.fsi = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBw() {
        if (!this.fsk) {
            this.fsk = true;
            if (this.fsi) {
                this.fsi = false;
                b.bBj().Du(TiebaIMConfig.url);
            }
            b.bBj().bBk();
            if (!this.fsj) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void ki(boolean z) {
                        b.bBj().rZ(z ? 2 : 1);
                        if (z) {
                            g.this.frM = a.bBc().getIpList();
                            if (g.this.frM != null) {
                                g.this.Dz("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bBc().a(new a.InterfaceC0596a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0596a
                                    public void bBh() {
                                        g.this.currentIndex = 0;
                                        g.this.frM = a.bBc().getIpList();
                                        if (g.this.frM != null) {
                                            g.this.Dz("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.fsk = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.fsk = false;
                        g.this.bBv();
                    }
                });
                this.fsj = true;
                return;
            }
            Dz("change ip to reconnect with DNS' failed.");
        }
    }
}
