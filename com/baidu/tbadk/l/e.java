package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.l.o
    public void a(i iVar) {
        if (m.NX().NY()) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("action", "time_t");
            a(jD, iVar);
            jD.append("ishttp", iVar.bbM ? "1" : "0");
            jD.append("issuccess", iVar.isSuccess ? "1" : "0");
            jD.append("nettype", m.NX().getNetType());
            jD.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.bbB));
            jD.append("wt", String.valueOf(iVar.bbJ));
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
            if (iVar.bbM) {
                jD.append("c_logid", String.valueOf(iVar.bbQ));
            } else {
                jD.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, jD);
        }
    }

    @Override // com.baidu.tbadk.l.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.NX().NY()) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("action", "resource_t");
            jD.append("actype", str);
            jD.append("issuccess", hVar.isSuccess ? "1" : "0");
            jD.append("isfs", hVar.bbz ? "1" : "0");
            jD.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.NI));
            jD.append("from", String.valueOf(hVar.NH));
            BdStatisticsManager.getInstance().performance(this.subType, jD);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.f("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.l.o
    public void a(i iVar, boolean z) {
        if (m.NX().NY()) {
            if (!z || iVar.bbR > 0) {
                if (z || iVar.bbS > 0) {
                    com.baidu.adp.lib.stats.a jD = jD();
                    jD.append("action", "time_t");
                    a(jD, iVar);
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

    @Override // com.baidu.tbadk.l.o
    public void a(i iVar, int i) {
        if (m.NX().NY() && iVar.bbT > 0) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("action", "time_t");
            a(jD, iVar);
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
