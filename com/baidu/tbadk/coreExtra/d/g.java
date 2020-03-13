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
    private static g duT = null;
    private int duU;
    private int currentIndex = 0;
    private boolean duV = false;
    private boolean duW = false;
    private List<String> duz = null;
    private boolean duX = false;
    private final Object duY = new Object();
    private List<String> duZ = new ArrayList();
    private boolean dva = false;
    private BDHttpDnsResult dvb = null;
    private final g.a dvc = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.duU > 0) {
                    g.this.dva = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.dvb != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.dvb.mg());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.dvb.me());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.dvb.mf());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.duU >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.aNj().uJ(com.baidu.adp.framework.client.socket.h.getUrl());
                a.aNj().aNm();
            }
            g.this.duU = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.duZ == null || g.this.duZ.isEmpty()) {
                        g.this.aNz();
                    } else {
                        g.this.aNy();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.dvb != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.dvb.mg());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.dvb.me());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.dvb.mf());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.duU >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.aNA();
                    }
                } else if (g.this.duU >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.aND();
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
        int i = gVar.duU;
        gVar.duU = i + 1;
        return i;
    }

    public static synchronized g aNx() {
        g gVar;
        synchronized (g.class) {
            if (duT == null) {
                synchronized (g.class) {
                    if (duT == null) {
                        duT = new g();
                    }
                }
            }
            gVar = duT;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ia().a(this.dvc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNy() {
        synchronized (this.duY) {
            if (this.duZ != null && !this.duZ.isEmpty()) {
                String remove = this.duZ.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + uP(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNz() {
        if (!this.dva) {
            try {
                String uO = uO(TiebaIMConfig.url);
                if (aq.isEmpty(uO)) {
                    aNA();
                } else {
                    this.dva = true;
                    BDHttpDns.ag(BdBaseApplication.getInst().getApplicationContext()).a(uO, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> mg;
                            g.this.dva = false;
                            g.this.dvb = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (mg = bDHttpDnsResult.mg()) != null && !mg.isEmpty()) {
                                synchronized (g.this.duY) {
                                    g.this.duZ = mg;
                                }
                                g.this.aNy();
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
    public void aNA() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.dva = false;
    }

    public static String uO(String str) {
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

    public static String uP(String str) {
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

    private String aNB() {
        if (this.duz == null || this.currentIndex <= -1 || this.currentIndex >= this.duz.size()) {
            return null;
        }
        return a.aNj().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uQ(final String str) {
        String aNB = aNB();
        if (aNB == null) {
            if (!a.aNj().aNn()) {
                a.aNj().a(new a.InterfaceC0382a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0382a
                    public void aNo() {
                        g.this.currentIndex = 0;
                        g.this.duz = a.aNj().getIpList();
                        if (g.this.duz != null) {
                            g.this.uQ(str);
                        } else {
                            g.this.duX = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            aNC();
        } else if (uO(aNB) == null) {
            aNC();
        } else {
            this.duX = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(aNB);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.duV = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNC() {
        NoNetworkView.updateUI();
        this.duW = false;
        this.currentIndex = 0;
        this.duX = false;
        this.duV = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aND() {
        if (!this.duX) {
            this.duX = true;
            if (this.duV) {
                this.duV = false;
                b.aNq().uL(TiebaIMConfig.url);
            }
            b.aNq().aNr();
            if (!this.duW) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void gs(boolean z) {
                        b.aNq().mf(z ? 2 : 1);
                        if (z) {
                            g.this.duz = a.aNj().getIpList();
                            if (g.this.duz != null) {
                                g.this.uQ("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.aNj().a(new a.InterfaceC0382a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0382a
                                    public void aNo() {
                                        g.this.currentIndex = 0;
                                        g.this.duz = a.aNj().getIpList();
                                        if (g.this.duz != null) {
                                            g.this.uQ("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.duX = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.duX = false;
                        g.this.aNC();
                    }
                });
                this.duW = true;
                return;
            }
            uQ("change ip to reconnect with DNS' failed.");
        }
    }
}
