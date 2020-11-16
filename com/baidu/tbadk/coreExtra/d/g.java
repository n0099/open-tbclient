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
    private static g fkG = null;
    private int fkH;
    private int currentIndex = 0;
    private boolean fkI = false;
    private boolean fkJ = false;
    private List<String> fkm = null;
    private boolean fkK = false;
    private final Object fkL = new Object();
    private List<String> fkM = new ArrayList();
    private boolean fkN = false;
    private BDHttpDnsResult fkO = null;
    private final g.a fkP = new g.a() { // from class: com.baidu.tbadk.coreExtra.d.g.1
        @Override // com.baidu.adp.lib.webSocket.g.a
        public void onOpen(Map<String, String> map) {
            if (UseHttpdnsSdkSwitch.isOn()) {
                if (g.this.fkH > 0) {
                    g.this.fkN = false;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("URL_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fkO != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fkO.sY());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fkO.sW());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fkO.sX());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, stringBuffer.toString());
                }
            } else if (g.this.fkH >= 5) {
                com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.h.getUrl());
                a.bxC().CK(com.baidu.adp.framework.client.socket.h.getUrl());
                a.bxC().bxF();
            }
            g.this.fkH = 0;
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void c(int i, String str) {
            if ((i == 2 || i == 9) && j.isNetWorkAvailable()) {
                g.c(g.this);
                if (UseHttpdnsSdkSwitch.isOn()) {
                    if (g.this.fkM == null || g.this.fkM.isEmpty()) {
                        g.this.bxS();
                    } else {
                        g.this.bxR();
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("retryiplist_");
                    stringBuffer.append(com.baidu.adp.framework.client.socket.h.getUrl());
                    if (g.this.fkO != null) {
                        stringBuffer.append("-dnsResolveIp_");
                        stringBuffer.append(g.this.fkO.sY());
                        stringBuffer.append("-dnsResolveType_");
                        stringBuffer.append(g.this.fkO.sW());
                        stringBuffer.append("-dnsResolveStatus_");
                        stringBuffer.append(g.this.fkO.sX());
                    }
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, stringBuffer.toString());
                    if (g.this.fkH >= 5) {
                        BdSocketLinkService.setAvailable(false);
                        g.this.bxT();
                    }
                } else if (g.this.fkH >= 5) {
                    com.baidu.adp.framework.client.socket.i.debug("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist_" + com.baidu.adp.framework.client.socket.h.getUrl());
                    g.this.bxW();
                }
            }
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void a(com.baidu.adp.lib.webSocket.c cVar) {
        }

        @Override // com.baidu.adp.lib.webSocket.g.a
        public void oC() {
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
        int i = gVar.fkH;
        gVar.fkH = i + 1;
        return i;
    }

    public static synchronized g bxQ() {
        g gVar;
        synchronized (g.class) {
            if (fkG == null) {
                synchronized (g.class) {
                    if (fkG == null) {
                        fkG = new g();
                    }
                }
            }
            gVar = fkG;
        }
        return gVar;
    }

    public void init() {
        com.baidu.adp.lib.webSocket.h.oD().a(this.fkP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxR() {
        synchronized (this.fkL) {
            if (this.fkM != null && !this.fkM.isEmpty()) {
                String remove = this.fkM.remove(0);
                if (!TextUtils.isEmpty(remove)) {
                    com.baidu.adp.framework.client.socket.h.setUrl("ws://" + remove + ":" + CQ(TiebaIMConfig.url));
                    BdSocketLinkService.init();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxS() {
        if (!this.fkN) {
            try {
                String CP = CP(TiebaIMConfig.url);
                if (au.isEmpty(CP)) {
                    bxT();
                } else {
                    this.fkN = true;
                    BDHttpDns.P(BdBaseApplication.getInst().getApplicationContext()).a(CP, new BDHttpDns.a() { // from class: com.baidu.tbadk.coreExtra.d.g.2
                        @Override // com.baidu.bdhttpdns.BDHttpDns.a
                        public void a(BDHttpDnsResult bDHttpDnsResult) {
                            ArrayList<String> sY;
                            g.this.fkN = false;
                            g.this.fkO = bDHttpDnsResult;
                            if (bDHttpDnsResult != null && (sY = bDHttpDnsResult.sY()) != null && !sY.isEmpty()) {
                                synchronized (g.this.fkL) {
                                    g.this.fkM = sY;
                                }
                                g.this.bxR();
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
    public void bxT() {
        NoNetworkView.updateUI();
        this.currentIndex = 0;
        this.fkN = false;
    }

    public static String CP(String str) {
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

    public static String CQ(String str) {
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

    private String bxU() {
        if (this.fkm == null || this.currentIndex <= -1 || this.currentIndex >= this.fkm.size()) {
            return null;
        }
        return a.bxC().getIpList().get(this.currentIndex);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void CR(final String str) {
        String bxU = bxU();
        if (bxU == null) {
            if (!a.bxC().bxG()) {
                a.bxC().a(new a.InterfaceC0583a() { // from class: com.baidu.tbadk.coreExtra.d.g.3
                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0583a
                    public void bxH() {
                        g.this.currentIndex = 0;
                        g.this.fkm = a.bxC().getIpList();
                        if (g.this.fkm != null) {
                            g.this.CR(str);
                        } else {
                            g.this.fkK = false;
                        }
                    }
                });
            }
            com.baidu.adp.framework.client.socket.h.setUrl(TiebaIMConfig.url);
            BdSocketLinkService.setAvailable(false);
            bxV();
        } else if (CP(bxU) == null) {
            bxV();
        } else {
            this.fkK = false;
            BdSocketLinkService.stopReConnStrategy("change ip and stop to restart to reconnet.");
            com.baidu.adp.framework.client.socket.h.setUrl(bxU);
            BdSocketLinkService.init();
            BdSocketLinkService.startService(true, str);
            this.fkI = true;
            this.currentIndex++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxV() {
        NoNetworkView.updateUI();
        this.fkJ = false;
        this.currentIndex = 0;
        this.fkK = false;
        this.fkI = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxW() {
        if (!this.fkK) {
            this.fkK = true;
            if (this.fkI) {
                this.fkI = false;
                b.bxJ().CM(TiebaIMConfig.url);
            }
            b.bxJ().bxK();
            if (!this.fkJ) {
                new d("www.baidu.com", new d.b() { // from class: com.baidu.tbadk.coreExtra.d.g.4
                    @Override // com.baidu.tbadk.coreExtra.d.d.b
                    public void jS(boolean z) {
                        b.bxJ().ry(z ? 2 : 1);
                        if (z) {
                            g.this.fkm = a.bxC().getIpList();
                            if (g.this.fkm != null) {
                                g.this.CR("change ip to reconnect with DNS' failed.");
                                return;
                            } else {
                                a.bxC().a(new a.InterfaceC0583a() { // from class: com.baidu.tbadk.coreExtra.d.g.4.1
                                    @Override // com.baidu.tbadk.coreExtra.d.a.InterfaceC0583a
                                    public void bxH() {
                                        g.this.currentIndex = 0;
                                        g.this.fkm = a.bxC().getIpList();
                                        if (g.this.fkm != null) {
                                            g.this.CR("change ip to reconnect with DNS' failed.");
                                        } else {
                                            g.this.fkK = false;
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        g.this.fkK = false;
                        g.this.bxV();
                    }
                });
                this.fkJ = true;
                return;
            }
            CR("change ip to reconnect with DNS' failed.");
        }
    }
}
