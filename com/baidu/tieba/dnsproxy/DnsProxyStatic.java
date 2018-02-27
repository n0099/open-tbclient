package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
/* loaded from: classes3.dex */
public class DnsProxyStatic {
    private static int dmH = 0;
    private static int dmI = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2007015) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.g.e.ns().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.adp.lib.b.d.mA().an("switch_dnsproxy") == 1) {
                            DnsProxyStatic.apB();
                        } else {
                            DnsProxyStatic.apC();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void apB() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.oJ()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> nd = eVar.nd();
                    if (nd != null && nd.size() > 0) {
                        dVar = nd.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.ajj)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String ao(String str) {
                if (f.apF().kL(str)) {
                    try {
                        return e.apy().A(new URL(str).getHost(), f.apF().kM(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.apy().start();
    }

    public static final void apC() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.apy().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.nc().responseCode >= 400;
            if (eVar.nc().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.nc().ajy;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.apL().B(dVar.ajj, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.nb().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.h("sucnum", Integer.valueOf(dmH));
                    statsItem.h("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("ip", dVar.ajj);
                    statsItem.append("reason", dVar.ajf);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    dmH = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            dmH++;
            if (dmH >= 100) {
                apD();
            }
        }
    }

    public static final void apD() {
        if (dmH > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.h("sucnum", Integer.valueOf(dmH));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                dmH = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.nc().responseCode >= 400;
            if (eVar.nc().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.nc().ajy;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.nb().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.h("sucnum", Integer.valueOf(dmI));
                    statsItem.h("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("reason", dVar.ajf);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    dmI = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            dmI++;
            if (dmI >= 100) {
                apE();
            }
        }
    }

    public static final void apE() {
        if (dmI > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.h("sucnum", Integer.valueOf(dmI));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                dmI = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
