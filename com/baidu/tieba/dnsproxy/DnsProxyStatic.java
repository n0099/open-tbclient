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
import com.baidu.searchbox.datachannel.Contract;
import com.baidu.tbadk.switchs.DnsProxySwitch;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
/* loaded from: classes6.dex */
public class DnsProxyStatic {
    private static int fQU = 0;
    private static int fQV = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_ONCREATE_END) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SwitchManager.getInstance().findType(DnsProxySwitch.DNSPROXY_KEY) == 1) {
                            DnsProxyStatic.bwO();
                        } else {
                            DnsProxyStatic.bwP();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void bwO() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.e eVar) {
                if (eVar != null && j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> fZ = eVar.fZ();
                    if (fZ != null && fZ.size() > 0) {
                        dVar = fZ.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.qS)) {
                            DnsProxyStatic.a(eVar, dVar);
                        } else {
                            DnsProxyStatic.b(eVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String ak(String str) {
                if (f.bwS().Ad(str)) {
                    try {
                        return e.bwL().ag(new URL(str).getHost(), f.bwS().Ae(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.bwL().start();
    }

    public static final void bwP() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.bwL().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        if (eVar != null && dVar != null) {
            boolean z = eVar.fY().responseCode >= 400;
            if (eVar.fY().responseCode < 200) {
                z = true;
            }
            byte[] bArr = eVar.fY().retBytes;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.bwY().ah(dVar.qS, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(eVar.fX().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.append("sucnum", Integer.valueOf(fQU));
                    statsItem.append("failnum", 1);
                    statsItem.append(Contract.SCHEME_KEY_HOST, url.getHost());
                    statsItem.append(TableDefine.UserInfoColumns.COLUMN_IP, dVar.qS);
                    statsItem.append(TiebaInitialize.LogFields.REASON, dVar.exception);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    fQU = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            fQU++;
            if (fQU >= 100) {
                bwQ();
            }
        }
    }

    public static final void bwQ() {
        if (fQU > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.append("sucnum", Integer.valueOf(fQU));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                fQU = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.e eVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (eVar != null && dVar != null) {
            boolean z2 = eVar.fY().responseCode >= 400;
            if (eVar.fY().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = eVar.fY().retBytes;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(eVar.fX().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.append("sucnum", Integer.valueOf(fQV));
                    statsItem.append("failnum", 1);
                    statsItem.append(Contract.SCHEME_KEY_HOST, url.getHost());
                    statsItem.append(TiebaInitialize.LogFields.REASON, dVar.exception);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    fQV = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            fQV++;
            if (fQV >= 100) {
                bwR();
            }
        }
    }

    public static final void bwR() {
        if (fQV > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.append("sucnum", Integer.valueOf(fQV));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                fQV = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
