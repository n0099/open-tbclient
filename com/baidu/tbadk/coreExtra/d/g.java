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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.coreExtra.d.a;
import com.baidu.tbadk.coreExtra.d.d;
import com.baidu.tbadk.switchs.UseHttpdnsSdkSwitch;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class g {
    private static g erZ = null;
    private int esa;
    private int currentIndex = 0;
    private boolean esb = false;
    private boolean esc = false;
    private List<String> erF = null;
    private boolean esd = false;
    private final Object ese = new Object();
    private List<String> esf = new ArrayList();
    private boolean esg = false;
    private BDHttpDnsResult esh = null;
    private final g.a esi = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.esa > 0) {
                    g.this.esg = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.esh != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.esh.rf());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.esh.rd());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.esh.re());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.esa >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bdU().xZ(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bdU().bdX();
            }
            g.this.esa = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void d(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.esf == null || g.this.esf.isEmpty()) {
                        g.this.bek();
                    } else {
                        g.this.bej();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.esh != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.esh.rf());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.esh.rd());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.esh.re());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.esa >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bel();
                    }
                } else if (g.this.esa >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.beo();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void mW() {
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
        int i = gVar.esa;
        gVar.esa = i + 1;
        return i;
    }

    public static synchronized g bei() {
        g gVar;
        synchronized (g.class) {
            if (erZ == null) {
                synchronized (g.class) {
                    if (erZ == null) {
                        erZ = new g();
                    }
                }
            }
            gVar = erZ;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.mX().a(this.esi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bej() {
        synchronized (this.ese) {
            if (this.esf != null && !this.esf.isEmpty()) {
                String remove = this.esf.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + yf(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bek() {
        if (!this.esg) {
            try {
                String ye = ye(TiebaIMConfig.url);
                if (ar.isEmpty(ye)) {
                    bel();
                } else {
                    this.esg = true;
                    BDHttpDns.L(BdBaseApplication.getInst().getApplicationContext()).a(ye, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> rf;
                            g.this.esg = false;
                            g.this.esh = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (rf = bDHttpDnsResult.rf()) != null && !rf.isEmpty()) {
                                synchronized (g.this.ese) {
                                    g.this.esf = rf;
                                }
                                g.this.bej();
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
    public void bel() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.esg = false;
    }

    public static String ye(String str) {
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

    public static String yf(String str) {
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

    private String bem() {
        if (this.erF == null || this.currentIndex <= -1 || this.currentIndex >= this.erF.size()) {
            return null;
        }
        return a.bdU().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yg(final String str) {
        String bem = bem();
        if (bem == null) {
            if (!a.bdU().bdY()) {
                a.bdU().a(new a.InterfaceC0487a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0487a
                    public void bdZ() {
                        g.this.currentIndex = 0;
                        g.this.erF = a.bdU().getIpList();
                        if (g.this.erF != null) {
                            g.this.yg(str);
                        } else {
                            g.this.esd = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            ben();
        } else if (ye(bem) == null) {
            ben();
        } else {
            this.esd = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bem);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.esb = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ben() {
        NoNetworkView.updateUI();
        this.esc = false;
        this.currentIndex = 0;
        this.esd = false;
        this.esb = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beo() {
        if (!this.esd) {
            this.esd = true;
            if (this.esb) {
                this.esb = false;
                b.beb().yb(TiebaIMConfig.url);
            }
            b.beb().bec();
            if (!this.esc) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void hW(boolean z) {
                        b.beb().nr(z ? 2 : 1);
                        if (z) {
                            g.this.erF = a.bdU().getIpList();
                            if (g.this.erF != null) {
                                g.this.yg("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bdU().a(new a.InterfaceC0487a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0487a
                                    public void bdZ() {
                                        g.this.currentIndex = 0;
                                        g.this.erF = a.bdU().getIpList();
                                        if (g.this.erF != null) {
                                            g.this.yg("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.esd = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.esd = false;
                        g.this.ben();
                    }
                });
                this.esc = true;
                return;
            }
            yg("change ip to reconnect with DNS' failed.");
        }
    }
}
