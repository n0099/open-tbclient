package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.l.o
    public void a(i iVar) {
        if (m.PD().PE()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "time_t");
            a(jB, iVar);
            jB.append("ishttp", iVar.bgN ? "1" : "0");
            jB.append("issuccess", iVar.isSuccess ? "1" : "0");
            jB.append("nettype", m.PD().getNetType());
            jB.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.bgC));
            jB.append("wt", String.valueOf(iVar.bgK));
            jB.append("qt", String.valueOf(iVar.bgD));
            jB.append("connt", String.valueOf(iVar.bgE));
            jB.append("rwt", String.valueOf(iVar.bgF));
            jB.append("dect", String.valueOf(iVar.bgG));
            jB.append("parset", String.valueOf(iVar.bgH));
            jB.append("rendert", String.valueOf(iVar.bgJ));
            jB.append("ss", String.valueOf(iVar.bgL));
            jB.append("hs", String.valueOf(iVar.bgM));
            if (iVar.bgN && iVar.socketErrNo != 0) {
                jB.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    jB.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                jB.f(AiAppsUBCStatistic.EXT_KEY_ERRCODE, Integer.valueOf(iVar.errCode));
            }
            if (iVar.bgN) {
                jB.append("c_logid", String.valueOf(iVar.bgR));
            } else {
                jB.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, jB);
        }
    }

    @Override // com.baidu.tbadk.l.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.PD().PE()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "resource_t");
            jB.append("actype", str);
            jB.append("issuccess", hVar.isSuccess ? "1" : "0");
            jB.append("isfs", hVar.bgA ? "1" : "0");
            jB.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.NW));
            jB.append("from", String.valueOf(hVar.NV));
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
        if (m.PD().PE()) {
            if (!z || iVar.bgS > 0) {
                if (z || iVar.bgT > 0) {
                    com.baidu.adp.lib.stats.a jB = jB();
                    jB.append("action", "time_t");
                    a(jB, iVar);
                    if (z) {
                        jB.append("put", String.valueOf(iVar.bgS));
                    } else {
                        jB.append("pdt", String.valueOf(iVar.bgT));
                    }
                    jB.append("ishttp", iVar.bgN ? "1" : "0");
                    jB.append("issuccess", iVar.isSuccess ? "1" : "0");
                    jB.append("nettype", m.PD().getNetType());
                    jB.append("qt", String.valueOf(iVar.bgD));
                    jB.append("connt", String.valueOf(iVar.bgE));
                    jB.append("rwt", String.valueOf(iVar.bgF));
                    jB.append("dect", String.valueOf(iVar.bgG));
                    jB.append("parset", String.valueOf(iVar.bgH));
                    jB.append("rendert", String.valueOf(iVar.bgJ));
                    jB.append("ss", String.valueOf(iVar.bgL));
                    jB.append("hs", String.valueOf(iVar.bgM));
                    if (iVar.bgN && iVar.socketErrNo != 0) {
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
        if (m.PD().PE() && iVar.bgU > 0) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "time_t");
            a(jB, iVar);
            jB.append("pct", String.valueOf(iVar.bgU));
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
