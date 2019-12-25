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
/* loaded from: classes4.dex */
public class DnsProxyStatic {
    private static int fLq = 0;
    private static int fLr = 0;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.MAINTAB_ONCREATE_END) { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                com.baidu.adp.lib.f.e.gy().postDelayed(new Runnable() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (SwitchManager.getInstance().findType(DnsProxySwitch.DNSPROXY_KEY) == 1) {
                            DnsProxyStatic.bui();
                        } else {
                            DnsProxyStatic.buj();
                        }
                    }
                }, 1000L);
            }
        });
    }

    public static final void bui() {
        com.baidu.adp.lib.network.http.a.a(new com.baidu.adp.lib.network.http.a() { // from class: com.baidu.tieba.dnsproxy.DnsProxyStatic.1
            @Override // com.baidu.adp.lib.network.http.a
            public void a(com.baidu.adp.lib.network.http.f fVar) {
                if (fVar != null && j.isNetWorkAvailable()) {
                    com.baidu.adp.lib.network.http.d dVar = null;
                    List<com.baidu.adp.lib.network.http.d> ga = fVar.ga();
                    if (ga != null && ga.size() > 0) {
                        dVar = ga.get(0);
                    }
                    if (dVar != null) {
                        if (!TextUtils.isEmpty(dVar.qT)) {
                            DnsProxyStatic.a(fVar, dVar);
                        } else {
                            DnsProxyStatic.b(fVar, dVar);
                        }
                    }
                }
            }

            @Override // com.baidu.adp.lib.network.http.a
            public String ak(String str) {
                if (f.bum().zD(str)) {
                    try {
                        return e.buf().ag(new URL(str).getHost(), f.bum().zE(str));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }
        });
        e.buf().start();
    }

    public static final void buj() {
        com.baidu.adp.lib.network.http.a.a((com.baidu.adp.lib.network.http.a) null);
        e.buf().close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(com.baidu.adp.lib.network.http.f fVar, com.baidu.adp.lib.network.http.d dVar) {
        if (fVar != null && dVar != null) {
            boolean z = fVar.fZ().responseCode >= 400;
            if (fVar.fZ().responseCode < 200) {
                z = true;
            }
            byte[] bArr = fVar.fZ().retBytes;
            if (bArr == null) {
                z = true;
            }
            if (bArr != null && bArr.length == 0) {
                z = true;
            }
            com.baidu.tieba.dnsproxy.a.d.bus().ah(dVar.qT, z ? false : true);
            if (z) {
                try {
                    URL url = new URL(fVar.fY().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_use");
                    statsItem.append("sucnum", Integer.valueOf(fLq));
                    statsItem.append("failnum", 1);
                    statsItem.append(Contract.SCHEME_KEY_HOST, url.getHost());
                    statsItem.append(TableDefine.UserInfoColumns.COLUMN_IP, dVar.qT);
                    statsItem.append(TiebaInitialize.LogFields.REASON, dVar.exception);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    fLq = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            fLq++;
            if (fLq >= 100) {
                buk();
            }
        }
    }

    public static final void buk() {
        if (fLq > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_use");
                statsItem.append("sucnum", Integer.valueOf(fLq));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                fLq = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(com.baidu.adp.lib.network.http.f fVar, com.baidu.adp.lib.network.http.d dVar) {
        boolean z = true;
        if (fVar != null && dVar != null) {
            boolean z2 = fVar.fZ().responseCode >= 400;
            if (fVar.fZ().responseCode < 200) {
                z2 = true;
            }
            byte[] bArr = fVar.fZ().retBytes;
            if (bArr == null) {
                z2 = true;
            }
            if (bArr == null || bArr.length != 0) {
                z = z2;
            }
            if (z) {
                try {
                    URL url = new URL(fVar.fY().getUrl());
                    com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                    statsItem.append("workflow", "dnsproxy_unuse");
                    statsItem.append("sucnum", Integer.valueOf(fLr));
                    statsItem.append("failnum", 1);
                    statsItem.append(Contract.SCHEME_KEY_HOST, url.getHost());
                    statsItem.append(TiebaInitialize.LogFields.REASON, dVar.exception);
                    BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                    fLr = 0;
                    return;
                } catch (Throwable th) {
                    BdLog.detailException(th);
                    return;
                }
            }
            fLr++;
            if (fLr >= 100) {
                bul();
            }
        }
    }

    public static final void bul() {
        if (fLr > 0) {
            try {
                com.baidu.adp.lib.stats.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.append("workflow", "dnsproxy_unuse");
                statsItem.append("sucnum", Integer.valueOf(fLr));
                BdStatisticsManager.getInstance().debug("dnsproxy", statsItem);
                fLr = 0;
            } catch (Throwable th) {
                BdLog.detailException(th);
            }
        }
    }
}
