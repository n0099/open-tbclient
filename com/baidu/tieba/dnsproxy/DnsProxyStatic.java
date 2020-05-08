package com.baidu.tieba.dnsproxy;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.featureSwitch.SwitchManager;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.j;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.switchs.DnsProxySwitch;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
/* loaded from: classes6.dex */
public class DnsProxyStatic {
    private static int gwG = 0;
    private static int gwH = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_ONCREATE_END) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.f.e.lb().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SwitchManager.getInstance().findType(DnsProxySwitch.DNSPROXY_KEY) == 1) {
                            DnsProxyStatic.bGG();
                        } else {
                            DnsProxyStatic.bGH();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void bGG() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> kD = eVar.kD();
                    if (kD != null && kD.size() > 0) {
                        dVar = kD.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.JV)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String bz(String str) {
                if (f.bGK().BP(str)) {
                    try {
                        return e.bGD().am(new URL(str).getHost(), f.bGK().BQ(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.bGD().start();
    }

    public static final void bGH() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.bGD().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.kC().responseCode >= 400;
            if (eVar.kC().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.kC().retBytes;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.bGQ().an(dVar.JV, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.kB().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.append("sucnum", Integer.valueOf(gwG));
                    statsItem.append("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append(TableDefine.UserInfoColumns.COLUMN_IP, dVar.JV);
                    statsItem.append(TiebaInitialize.LogFields.REASON, dVar.exception);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    gwG = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            gwG++;
            if (gwG >= 100) {
                bGI();
            }
        }
    }

    public static final void bGI() {
        if (gwG > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.append("sucnum", Integer.valueOf(gwG));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                gwG = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.kC().responseCode >= 400;
            if (eVar.kC().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.kC().retBytes;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.kB().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.append("sucnum", Integer.valueOf(gwH));
                    statsItem.append("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append(TiebaInitialize.LogFields.REASON, dVar.exception);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    gwH = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            gwH++;
            if (gwH >= 100) {
                bGJ();
            }
        }
    }

    public static final void bGJ() {
        if (gwH > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.append("sucnum", Integer.valueOf(gwH));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                gwH = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
