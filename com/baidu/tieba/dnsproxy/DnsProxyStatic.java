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
    private static int cOM = 0;
    private static int cON = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2007015) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.g.e.im().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.adp.lib.b.d.hv().aw("switch_dnsproxy") == 1) {
                            DnsProxyStatic.anH();
                        } else {
                            DnsProxyStatic.anI();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void anH() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.jD()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> hX = eVar.hX();
                    if (hX != null && hX.size() > 0) {
                        dVar = hX.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.zO)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String ax(String str) {
                if (f.anL().lu(str)) {
                    try {
                        return e.anE().x(new URL(str).getHost(), f.anL().lv(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.anE().start();
    }

    public static final void anI() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.anE().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.hW().responseCode >= 400;
            if (eVar.hW().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.hW().Ae;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.anR().y(dVar.zO, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.hV().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.f("sucnum", Integer.valueOf(cOM));
                    statsItem.f("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("ip", dVar.zO);
                    statsItem.append("reason", dVar.zK);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    cOM = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            cOM++;
            if (cOM >= 100) {
                anJ();
            }
        }
    }

    public static final void anJ() {
        if (cOM > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.f("sucnum", Integer.valueOf(cOM));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                cOM = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.hW().responseCode >= 400;
            if (eVar.hW().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.hW().Ae;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.hV().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.f("sucnum", Integer.valueOf(cON));
                    statsItem.f("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("reason", dVar.zK);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    cON = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            cON++;
            if (cON >= 100) {
                anK();
            }
        }
    }

    public static final void anK() {
        if (cON > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.f("sucnum", Integer.valueOf(cON));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                cON = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
