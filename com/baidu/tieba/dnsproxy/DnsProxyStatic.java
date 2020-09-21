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
/* loaded from: classes13.dex */
public class DnsProxyStatic {
    private static int hyh = 0;
    private static int hyi = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_ONCREATE_END) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.f.e.mX().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SwitchManager.getInstance().findType(DnsProxySwitch.DNSPROXY_KEY) == 1) {
                            DnsProxyStatic.cgV();
                        } else {
                            DnsProxyStatic.cgW();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void cgV() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> my = eVar.my();
                    if (my != null && my.size() > 0) {
                        dVar = my.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.Lv)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String bI(String str) {
                if (f.cgZ().HH(str)) {
                    try {
                        return e.cgS().aD(new URL(str).getHost(), f.cgZ().HI(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.cgS().start();
    }

    public static final void cgW() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.cgS().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.mx().responseCode >= 400;
            if (eVar.mx().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.mx().retBytes;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.chf().aE(dVar.Lv, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.mw().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.append("sucnum", Integer.valueOf(hyh));
                    statsItem.append("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append(TableDefine.UserInfoColumns.COLUMN_IP, dVar.Lv);
                    statsItem.append(TiebaInitialize.LogFields.REASON, dVar.exception);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    hyh = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            hyh++;
            if (hyh >= 100) {
                cgX();
            }
        }
    }

    public static final void cgX() {
        if (hyh > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.append("sucnum", Integer.valueOf(hyh));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                hyh = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.mx().responseCode >= 400;
            if (eVar.mx().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.mx().retBytes;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.mw().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.append("sucnum", Integer.valueOf(hyi));
                    statsItem.append("failnum", 1);
                    statsItem.append("host", url.getHost());
                    statsItem.append(TiebaInitialize.LogFields.REASON, dVar.exception);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    hyi = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            hyi++;
            if (hyi >= 100) {
                cgY();
            }
        }
    }

    public static final void cgY() {
        if (hyi > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.append("sucnum", Integer.valueOf(hyi));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                hyi = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
