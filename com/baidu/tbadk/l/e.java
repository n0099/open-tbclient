package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.l.o
    public void a(i iVar) {
        if (m.Pk().Pl()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "time_t");
            a(jB, iVar);
            jB.append("ishttp", iVar.bfZ ? "1" : "0");
            jB.append("issuccess", iVar.isSuccess ? "1" : "0");
            jB.append("nettype", m.Pk().getNetType());
            jB.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.bfO));
            jB.append("wt", String.valueOf(iVar.bfW));
            jB.append("qt", String.valueOf(iVar.bfP));
            jB.append("connt", String.valueOf(iVar.bfQ));
            jB.append("rwt", String.valueOf(iVar.bfR));
            jB.append("dect", String.valueOf(iVar.bfS));
            jB.append("parset", String.valueOf(iVar.bfT));
            jB.append("rendert", String.valueOf(iVar.bfV));
            jB.append("ss", String.valueOf(iVar.bfX));
            jB.append("hs", String.valueOf(iVar.bfY));
            if (iVar.bfZ && iVar.socketErrNo != 0) {
                jB.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    jB.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                jB.f(AiAppsUBCStatistic.EXT_KEY_ERRCODE, Integer.valueOf(iVar.errCode));
            }
            if (iVar.bfZ) {
                jB.append("c_logid", String.valueOf(iVar.bgd));
            } else {
                jB.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, jB);
        }
    }

    @Override // com.baidu.tbadk.l.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.Pk().Pl()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "resource_t");
            jB.append("actype", str);
            jB.append("issuccess", hVar.isSuccess ? "1" : "0");
            jB.append("isfs", hVar.bfM ? "1" : "0");
            jB.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.NL));
            jB.append("from", String.valueOf(hVar.NK));
            BdStatisticsManager.getInstance().performance(this.subType, jB);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.f("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.l.o
    public void a(i iVar, boolean z) {
        if (m.Pk().Pl()) {
            if (!z || iVar.bge > 0) {
                if (z || iVar.bgf > 0) {
                    com.baidu.adp.lib.stats.a jB = jB();
                    jB.append("action", "time_t");
                    a(jB, iVar);
                    if (z) {
                        jB.append("put", String.valueOf(iVar.bge));
                    } else {
                        jB.append("pdt", String.valueOf(iVar.bgf));
                    }
                    jB.append("ishttp", iVar.bfZ ? "1" : "0");
                    jB.append("issuccess", iVar.isSuccess ? "1" : "0");
                    jB.append("nettype", m.Pk().getNetType());
                    jB.append("qt", String.valueOf(iVar.bfP));
                    jB.append("connt", String.valueOf(iVar.bfQ));
                    jB.append("rwt", String.valueOf(iVar.bfR));
                    jB.append("dect", String.valueOf(iVar.bfS));
                    jB.append("parset", String.valueOf(iVar.bfT));
                    jB.append("rendert", String.valueOf(iVar.bfV));
                    jB.append("ss", String.valueOf(iVar.bfX));
                    jB.append("hs", String.valueOf(iVar.bfY));
                    if (iVar.bfZ && iVar.socketErrNo != 0) {
                        jB.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            jB.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        jB.f(AiAppsUBCStatistic.EXT_KEY_ERRCODE, Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, jB);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.l.o
    public void a(i iVar, int i) {
        if (m.Pk().Pl() && iVar.bgg > 0) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "time_t");
            a(jB, iVar);
            jB.append("pct", String.valueOf(iVar.bgg));
            switch (i) {
                case 0:
                    jB.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    jB.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, jB);
        }
    }
}
