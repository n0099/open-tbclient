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
/* loaded from: classes2.dex */
public class DnsProxyStatic {
    private static int eys = 0;
    private static int eyt = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2007015) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.adp.lib.b.d.iQ().aO("switch_dnsproxy") == 1) {
                            DnsProxyStatic.aVa();
                        } else {
                            DnsProxyStatic.aVb();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void aVa() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.kY()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> jt = eVar.jt();
                    if (jt != null && jt.size() > 0) {
                        dVar = jt.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.CO)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String aP(String str) {
                if (f.aVe().tP(str)) {
                    try {
                        return e.aUX().aa(new URL(str).getHost(), f.aVe().tQ(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.aUX().start();
    }

    public static final void aVb() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.aUX().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.js().responseCode >= 400;
            if (eVar.js().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.js().Df;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.aVk().ab(dVar.CO, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.jr().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.f("sucnum", Integer.valueOf(eys));
                    statsItem.f("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("ip", dVar.CO);
                    statsItem.append("reason", dVar.CK);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    eys = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            eys++;
            if (eys >= 100) {
                aVc();
            }
        }
    }

    public static final void aVc() {
        if (eys > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.f("sucnum", Integer.valueOf(eys));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                eys = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.js().responseCode >= 400;
            if (eVar.js().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.js().Df;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.jr().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.f("sucnum", Integer.valueOf(eyt));
                    statsItem.f("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("reason", dVar.CK);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    eyt = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            eyt++;
            if (eyt >= 100) {
                aVd();
            }
        }
    }

    public static final void aVd() {
        if (eyt > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.f("sucnum", Integer.valueOf(eyt));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                eyt = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
