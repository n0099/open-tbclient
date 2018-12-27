package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.l.o
    public void a(i iVar) {
        if (m.Pl().Pm()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "time_t");
            a(jB, iVar);
            jB.append("ishttp", iVar.bgc ? "1" : "0");
            jB.append("issuccess", iVar.isSuccess ? "1" : "0");
            jB.append("nettype", m.Pl().getNetType());
            jB.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.bfR));
            jB.append("wt", String.valueOf(iVar.bfZ));
            jB.append("qt", String.valueOf(iVar.bfS));
            jB.append("connt", String.valueOf(iVar.bfT));
            jB.append("rwt", String.valueOf(iVar.bfU));
            jB.append("dect", String.valueOf(iVar.bfV));
            jB.append("parset", String.valueOf(iVar.bfW));
            jB.append("rendert", String.valueOf(iVar.bfY));
            jB.append("ss", String.valueOf(iVar.bga));
            jB.append("hs", String.valueOf(iVar.bgb));
            if (iVar.bgc && iVar.socketErrNo != 0) {
                jB.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    jB.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                jB.f(AiAppsUBCStatistic.EXT_KEY_ERRCODE, Integer.valueOf(iVar.errCode));
            }
            if (iVar.bgc) {
                jB.append("c_logid", String.valueOf(iVar.bgg));
            } else {
                jB.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, jB);
        }
    }

    @Override // com.baidu.tbadk.l.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.Pl().Pm()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "resource_t");
            jB.append("actype", str);
            jB.append("issuccess", hVar.isSuccess ? "1" : "0");
            jB.append("isfs", hVar.bfP ? "1" : "0");
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
        if (m.Pl().Pm()) {
            if (!z || iVar.bgh > 0) {
                if (z || iVar.bgi > 0) {
                    com.baidu.adp.lib.stats.a jB = jB();
                    jB.append("action", "time_t");
                    a(jB, iVar);
                    if (z) {
                        jB.append("put", String.valueOf(iVar.bgh));
                    } else {
                        jB.append("pdt", String.valueOf(iVar.bgi));
                    }
                    jB.append("ishttp", iVar.bgc ? "1" : "0");
                    jB.append("issuccess", iVar.isSuccess ? "1" : "0");
                    jB.append("nettype", m.Pl().getNetType());
                    jB.append("qt", String.valueOf(iVar.bfS));
                    jB.append("connt", String.valueOf(iVar.bfT));
                    jB.append("rwt", String.valueOf(iVar.bfU));
                    jB.append("dect", String.valueOf(iVar.bfV));
                    jB.append("parset", String.valueOf(iVar.bfW));
                    jB.append("rendert", String.valueOf(iVar.bfY));
                    jB.append("ss", String.valueOf(iVar.bga));
                    jB.append("hs", String.valueOf(iVar.bgb));
                    if (iVar.bgc && iVar.socketErrNo != 0) {
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
        if (m.Pl().Pm() && iVar.bgj > 0) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "time_t");
            a(jB, iVar);
            jB.append("pct", String.valueOf(iVar.bgj));
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
