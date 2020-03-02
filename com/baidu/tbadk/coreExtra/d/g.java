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
    private static g duG = null;
    private int duH;
    private int currentIndex = 0;
    private boolean duI = false;
    private boolean duJ = false;
    private List<String> dum = null;
    private boolean duK = false;
    private final Object duL = new Object();
    private List<String> duM = new ArrayList();
    private boolean duN = false;
    private BDHttpDnsResult duO = null;
    private final g.a duP = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.duH > 0) {
                    g.this.duN = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.duO != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.duO.mg());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.duO.me());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.duO.mf());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.duH >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.aNi().uI(com.baidu.adp.framework.client.socket.h.getUrl());
                a.aNi().aNl();
            }
            g.this.duH = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void e(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.duM == null || g.this.duM.isEmpty()) {
                        g.this.aNy();
                    } else {
                        g.this.aNx();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.duO != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.duO.mg());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.duO.me());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.duO.mf());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.duH >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.aNz();
                    }
                } else if (g.this.duH >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.aNC();
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
        int i = gVar.duH;
        gVar.duH = i + 1;
        return i;
    }

    public static synchronized g aNw() {
        g gVar;
        synchronized (g.class) {
            if (duG == null) {
                synchronized (g.class) {
                    if (duG == null) {
                        duG = new g();
                    }
                }
            }
            gVar = duG;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.ia().a(this.duP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNx() {
        synchronized (this.duL) {
            if (this.duM != null && !this.duM.isEmpty()) {
                String remove = this.duM.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + uO(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNy() {
        if (!this.duN) {
            try {
                String uN = uN(TiebaIMConfig.url);
                if (aq.isEmpty(uN)) {
                    aNz();
                } else {
                    this.duN = true;
                    BDHttpDns.ag(BdBaseApplication.getInst().getApplicationContext()).a(uN, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> mg;
                            g.this.duN = false;
                            g.this.duO = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (mg = bDHttpDnsResult.mg()) != null && !mg.isEmpty()) {
                                synchronized (g.this.duL) {
                                    g.this.duM = mg;
                                }
                                g.this.aNx();
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
    public void aNz() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.duN = false;
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

    private String aNA() {
        if (this.dum == null || this.currentIndex <= -1 || this.currentIndex >= this.dum.size()) {
            return null;
        }
        return a.aNi().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uP(final String str) {
        String aNA = aNA();
        if (aNA == null) {
            if (!a.aNi().aNm()) {
                a.aNi().a(new a.InterfaceC0382a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0382a
                    public void aNn() {
                        g.this.currentIndex = 0;
                        g.this.dum = a.aNi().getIpList();
                        if (g.this.dum != null) {
                            g.this.uP(str);
                        } else {
                            g.this.duK = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            aNB();
        } else if (uN(aNA) == null) {
            aNB();
        } else {
            this.duK = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(aNA);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.duI = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNB() {
        NoNetworkView.updateUI();
        this.duJ = false;
        this.currentIndex = 0;
        this.duK = false;
        this.duI = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNC() {
        if (!this.duK) {
            this.duK = true;
            if (this.duI) {
                this.duI = false;
                b.aNp().uK(TiebaIMConfig.url);
            }
            b.aNp().aNq();
            if (!this.duJ) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void gs(boolean z) {
                        b.aNp().mf(z ? 2 : 1);
                        if (z) {
                            g.this.dum = a.aNi().getIpList();
                            if (g.this.dum != null) {
                                g.this.uP("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.aNi().a(new a.InterfaceC0382a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0382a
                                    public void aNn() {
                                        g.this.currentIndex = 0;
                                        g.this.dum = a.aNi().getIpList();
                                        if (g.this.dum != null) {
                                            g.this.uP("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.duK = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.duK = false;
                        g.this.aNB();
                    }
                });
                this.duJ = true;
                return;
            }
            uP("change ip to reconnect with DNS' failed.");
        }
    }
}
