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
    private static int eyK = 0;
    private static int eyL = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2007015) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.g.e.jH().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.adp.lib.b.d.iQ().aO("switch_dnsproxy") == 1) {
                            DnsProxyStatic.aVd();
                        } else {
                            DnsProxyStatic.aVe();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void aVd() {
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
                if (f.aVh().tS(str)) {
                    try {
                        return e.aVa().aa(new URL(str).getHost(), f.aVh().tT(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.aVa().start();
    }

    public static final void aVe() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.aVa().close();
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
            com.baidu.tieba.dnsproxy.a.d.aVn().ab(dVar.CO, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.jr().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.f("sucnum", Integer.valueOf(eyK));
                    statsItem.f("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("ip", dVar.CO);
                    statsItem.append("reason", dVar.CK);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    eyK = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            eyK++;
            if (eyK >= 100) {
                aVf();
            }
        }
    }

    public static final void aVf() {
        if (eyK > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.f("sucnum", Integer.valueOf(eyK));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                eyK = 0;
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
                    statsItem.f("sucnum", Integer.valueOf(eyL));
                    statsItem.f("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("reason", dVar.CK);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    eyL = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            eyL++;
            if (eyL >= 100) {
                aVg();
            }
        }
    }

    public static final void aVg() {
        if (eyL > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.f("sucnum", Integer.valueOf(eyL));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                eyL = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
