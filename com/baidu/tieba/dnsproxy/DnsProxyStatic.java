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
    private static int eSV = 0;
    private static int eSW = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2007015) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.g.e.iK().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.adp.lib.b.d.hS().az("switch_dnsproxy") == 1) {
                            DnsProxyStatic.bem();
                        } else {
                            DnsProxyStatic.ben();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void bem() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.kc()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> iw = eVar.iw();
                    if (iw != null && iw.size() > 0) {
                        dVar = iw.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.AD)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String aA(String str) {
                if (f.beq().vN(str)) {
                    try {
                        return e.bej().ag(new URL(str).getHost(), f.beq().vO(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.bej().start();
    }

    public static final void ben() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.bej().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.iv().responseCode >= 400;
            if (eVar.iv().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.iv().AU;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.bew().ah(dVar.AD, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.iu().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.c("sucnum", Integer.valueOf(eSV));
                    statsItem.c("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("ip", dVar.AD);
                    statsItem.append("reason", dVar.Az);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    eSV = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            eSV++;
            if (eSV >= 100) {
                beo();
            }
        }
    }

    public static final void beo() {
        if (eSV > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.c("sucnum", Integer.valueOf(eSV));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                eSV = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.iv().responseCode >= 400;
            if (eVar.iv().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.iv().AU;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.iu().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.c("sucnum", Integer.valueOf(eSW));
                    statsItem.c("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("reason", dVar.Az);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    eSW = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            eSW++;
            if (eSW >= 100) {
                bep();
            }
        }
    }

    public static final void bep() {
        if (eSW > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.c("sucnum", Integer.valueOf(eSW));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                eSW = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
