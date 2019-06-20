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
    private static int eNV = 0;
    private static int eNW = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2007015) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.g.e.iB().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.adp.lib.b.d.hI().ay("switch_dnsproxy") == 1) {
                            DnsProxyStatic.bcl();
                        } else {
                            DnsProxyStatic.bcm();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void bcl() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.jS()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> im = eVar.im();
                    if (im != null && im.size() > 0) {
                        dVar = im.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.Ax)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String az(String str) {
                if (f.bcp().vi(str)) {
                    try {
                        return e.bci().ac(new URL(str).getHost(), f.bcp().vj(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.bci().start();
    }

    public static final void bcm() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.bci().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.il().responseCode >= 400;
            if (eVar.il().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.il().AN;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.bcv().ad(dVar.Ax, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.ik().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.c("sucnum", Integer.valueOf(eNV));
                    statsItem.c("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("ip", dVar.Ax);
                    statsItem.append("reason", dVar.At);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    eNV = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            eNV++;
            if (eNV >= 100) {
                bcn();
            }
        }
    }

    public static final void bcn() {
        if (eNV > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.c("sucnum", Integer.valueOf(eNV));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                eNV = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.il().responseCode >= 400;
            if (eVar.il().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.il().AN;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.ik().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.c("sucnum", Integer.valueOf(eNW));
                    statsItem.c("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("reason", dVar.At);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    eNW = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            eNW++;
            if (eNW >= 100) {
                bco();
            }
        }
    }

    public static final void bco() {
        if (eNW > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.c("sucnum", Integer.valueOf(eNW));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                eNW = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
