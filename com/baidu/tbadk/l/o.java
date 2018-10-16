package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.NX().NY()) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("action", "time");
            jD.append("ishttp", iVar.bbM ? "1" : "0");
            jD.append("issuccess", iVar.isSuccess ? "1" : "0");
            jD.append("nettype", m.NX().getNetType());
            jD.append("wt", String.valueOf(iVar.bbJ));
            jD.append("qt", String.valueOf(iVar.bbC));
            jD.append("connt", String.valueOf(iVar.bbD));
            jD.append("rwt", String.valueOf(iVar.bbE));
            jD.append("fbt", String.valueOf(iVar.wu));
            jD.append("abt", String.valueOf(iVar.wv));
            jD.append("dect", String.valueOf(iVar.bbF));
            jD.append("parset", String.valueOf(iVar.bbG));
            jD.append("tqt", String.valueOf(iVar.bbH));
            jD.append("rendert", String.valueOf(iVar.bbI));
            jD.append("ss", String.valueOf(iVar.bbK));
            jD.append("hs", String.valueOf(iVar.bbL));
            if (iVar.bbM && iVar.socketErrNo != 0) {
                jD.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    jD.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.bbM) {
                jD.append("hrtn", String.valueOf(iVar.bbN));
                jD.append("hrtt", String.valueOf(iVar.bbO));
            }
            if (iVar.errCode != 0) {
                jD.f(AiAppsUBCStatistic.EXT_KEY_ERRCODE, Integer.valueOf(iVar.errCode));
            }
            if (iVar.bbP) {
                jD.append(Config.PLATFORM_TYPE, "1");
            } else {
                jD.append("sysct", String.valueOf(iVar.bbA));
                jD.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.bbB));
            }
            if (iVar.bbM) {
                jD.append("c_logid", String.valueOf(iVar.bbQ));
                if (iVar.sequenceID != 0) {
                    jD.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                jD.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, jD);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.NX().NY()) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("action", "resource");
            jD.append("actype", str);
            jD.append("issuccess", hVar.isSuccess ? "1" : "0");
            jD.append("isfs", hVar.bbz ? "1" : "0");
            jD.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.NI));
            jD.append("from", String.valueOf(hVar.NH));
            BdStatisticsManager.getInstance().performance(this.subType, jD);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.NX().NY()) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("action", "fluency");
            jD.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, jD);
            com.baidu.adp.lib.stats.a jD2 = jD();
            jD2.append("action", "mem");
            jD2.append("memp", String.valueOf(m.NX().NZ()));
            BdStatisticsManager.getInstance().performance(this.subType, jD2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.NX().NY()) {
            if (!z || iVar.bbR > 0) {
                if (z || iVar.bbS > 0) {
                    com.baidu.adp.lib.stats.a jD = jD();
                    jD.append("action", "time");
                    if (z) {
                        jD.append("put", String.valueOf(iVar.bbR));
                    } else {
                        jD.append("pdt", String.valueOf(iVar.bbS));
                    }
                    jD.append("ishttp", iVar.bbM ? "1" : "0");
                    jD.append("issuccess", iVar.isSuccess ? "1" : "0");
                    jD.append("nettype", m.NX().getNetType());
                    jD.append("qt", String.valueOf(iVar.bbC));
                    jD.append("connt", String.valueOf(iVar.bbD));
                    jD.append("rwt", String.valueOf(iVar.bbE));
                    jD.append("dect", String.valueOf(iVar.bbF));
                    jD.append("parset", String.valueOf(iVar.bbG));
                    jD.append("rendert", String.valueOf(iVar.bbI));
                    jD.append("ss", String.valueOf(iVar.bbK));
                    jD.append("hs", String.valueOf(iVar.bbL));
                    if (iVar.bbM && iVar.socketErrNo != 0) {
                        jD.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            jD.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        jD.f(AiAppsUBCStatistic.EXT_KEY_ERRCODE, Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, jD);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.NX().NY() && iVar.bbT > 0) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("action", "time");
            jD.append("pct", String.valueOf(iVar.bbT));
            switch (i) {
                case 0:
                    jD.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    jD.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, jD);
        }
    }
}
