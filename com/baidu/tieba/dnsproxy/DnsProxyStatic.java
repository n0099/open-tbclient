package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.searchbox.ng.ai.apps.network.WebSocketAction;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
/* loaded from: classes3.dex */
public class DnsProxyStatic {
    private static int deB = 0;
    private static int deC = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2007015) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.g.e.jG().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (com.baidu.adp.lib.b.d.iQ().aO("switch_dnsproxy") == 1) {
                            DnsProxyStatic.asm();
                        } else {
                            DnsProxyStatic.asn();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void asm() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.kV()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> jr = eVar.jr();
                    if (jr != null && jr.size() > 0) {
                        dVar = jr.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.CP)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String aP(String str) {
                if (f.asq().mx(str)) {
                    try {
                        return e.asj().E(new URL(str).getHost(), f.asq().my(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.asj().start();
    }

    public static final void asn() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.asj().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.jq().responseCode >= 400;
            if (eVar.jq().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.jq().Dg;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.asw().F(dVar.CP, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.jp().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.f("sucnum", Integer.valueOf(deB));
                    statsItem.f("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append("ip", dVar.CP);
                    statsItem.append(WebSocketAction.PARAM_KEY_REASON, dVar.CL);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    deB = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            deB++;
            if (deB >= 100) {
                aso();
            }
        }
    }

    public static final void aso() {
        if (deB > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.f("sucnum", Integer.valueOf(deB));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                deB = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.jq().responseCode >= 400;
            if (eVar.jq().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.jq().Dg;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.jp().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.f("sucnum", Integer.valueOf(deC));
                    statsItem.f("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append(WebSocketAction.PARAM_KEY_REASON, dVar.CL);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    deC = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            deC++;
            if (deC >= 100) {
                asp();
            }
        }
    }

    public static final void asp() {
        if (deC > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.f("sucnum", Integer.valueOf(deC));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                deC = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
