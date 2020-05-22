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
    private static int gLq = 0;
    private static int gLr = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_ONCREATE_END) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SwitchManager.getInstance().findType(DnsProxySwitch.DNSPROXY_KEY) == 1) {
                            DnsProxyStatic.bNa();
                        } else {
                            DnsProxyStatic.bNb();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void bNa() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> kF = eVar.kF();
                    if (kF != null && kF.size() > 0) {
                        dVar = kF.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.Kh)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String bA(String str) {
                if (f.bNe().Dy(str)) {
                    try {
                        return e.bMX().az(new URL(str).getHost(), f.bNe().Dz(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.bMX().start();
    }

    public static final void bNb() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.bMX().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.kE().responseCode >= 400;
            if (eVar.kE().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.kE().retBytes;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.bNk().aA(dVar.Kh, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.kD().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.append("sucnum", Integer.valueOf(gLq));
                    statsItem.append("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append(TableDefine.UserInfoColumns.COLUMN_IP, dVar.Kh);
                    statsItem.append(TiebaInitialize.LogFields.REASON, dVar.exception);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    gLq = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            gLq++;
            if (gLq >= 100) {
                bNc();
            }
        }
    }

    public static final void bNc() {
        if (gLq > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.append("sucnum", Integer.valueOf(gLq));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                gLq = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.kE().responseCode >= 400;
            if (eVar.kE().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.kE().retBytes;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.kD().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.append("sucnum", Integer.valueOf(gLr));
                    statsItem.append("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append(TiebaInitialize.LogFields.REASON, dVar.exception);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    gLr = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            gLr++;
            if (gLr >= 100) {
                bNd();
            }
        }
    }

    public static final void bNd() {
        if (gLr > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.append("sucnum", Integer.valueOf(gLr));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                gLr = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
