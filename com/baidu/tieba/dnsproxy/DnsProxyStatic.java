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
    private static int cPm = 0;
    private static int cPn = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2007015) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.g.e.in().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.adp.lib.b.d.hv().ax("switch_dnsproxy") == 1) {
                            DnsProxyStatic.anC();
                        } else {
                            DnsProxyStatic.anD();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void anC() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.jE()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> hY = eVar.hY();
                    if (hY != null && hY.size() > 0) {
                        dVar = hY.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.zI)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String ay(String str) {
                if (f.anG().ls(str)) {
                    try {
                        return e.anz().w(new URL(str).getHost(), f.anG().lt(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.anz().start();
    }

    public static final void anD() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.anz().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.hX().responseCode >= 400;
            if (eVar.hX().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.hX().zX;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.anM().x(dVar.zI, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.hW().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.f("sucnum", Integer.valueOf(cPm));
                    statsItem.f("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("ip", dVar.zI);
                    statsItem.append("reason", dVar.zE);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    cPm = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            cPm++;
            if (cPm >= 100) {
                anE();
            }
        }
    }

    public static final void anE() {
        if (cPm > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.f("sucnum", Integer.valueOf(cPm));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                cPm = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.hX().responseCode >= 400;
            if (eVar.hX().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.hX().zX;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.hW().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.f("sucnum", Integer.valueOf(cPn));
                    statsItem.f("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("reason", dVar.zE);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    cPn = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            cPn++;
            if (cPn >= 100) {
                anF();
            }
        }
    }

    public static final void anF() {
        if (cPn > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.f("sucnum", Integer.valueOf(cPn));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                cPn = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
