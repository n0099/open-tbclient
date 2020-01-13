package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.n.o
    public void a(i iVar) {
        if (m.aOT().aOU()) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "time_t");
            a(gs, iVar);
            gs.append("ishttp", iVar.dzF ? "1" : "0");
            gs.append("issuccess", iVar.isSuccess ? "1" : "0");
            gs.append("nettype", m.aOT().getNetType());
            gs.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.dzu));
            gs.append("wt", String.valueOf(iVar.dzC));
            gs.append("qt", String.valueOf(iVar.dzv));
            gs.append("connt", String.valueOf(iVar.dzw));
            gs.append("rwt", String.valueOf(iVar.dzx));
            gs.append("dect", String.valueOf(iVar.dzy));
            gs.append("parset", String.valueOf(iVar.dzz));
            gs.append("rendert", String.valueOf(iVar.dzB));
            gs.append("ss", String.valueOf(iVar.dzD));
            gs.append("hs", String.valueOf(iVar.dzE));
            if (iVar.dzF && iVar.socketErrNo != 0) {
                gs.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    gs.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                gs.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.dzF) {
                gs.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.dzJ));
            } else {
                gs.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, gs);
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.aOT().aOU()) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "resource_t");
            gs.append("actype", str);
            gs.append("issuccess", hVar.isSuccess ? "1" : "0");
            gs.append("isfs", hVar.dzs ? "1" : "0");
            gs.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            gs.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, gs);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.append("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, boolean z) {
        if (m.aOT().aOU()) {
            if (!z || iVar.dzK > 0) {
                if (z || iVar.dzL > 0) {
                    com.baidu.adp.lib.stats.a gs = gs();
                    gs.append("action", "time_t");
                    a(gs, iVar);
                    if (z) {
                        gs.append("put", String.valueOf(iVar.dzK));
                    } else {
                        gs.append("pdt", String.valueOf(iVar.dzL));
                    }
                    gs.append("ishttp", iVar.dzF ? "1" : "0");
                    gs.append("issuccess", iVar.isSuccess ? "1" : "0");
                    gs.append("nettype", m.aOT().getNetType());
                    gs.append("qt", String.valueOf(iVar.dzv));
                    gs.append("connt", String.valueOf(iVar.dzw));
                    gs.append("rwt", String.valueOf(iVar.dzx));
                    gs.append("dect", String.valueOf(iVar.dzy));
                    gs.append("parset", String.valueOf(iVar.dzz));
                    gs.append("rendert", String.valueOf(iVar.dzB));
                    gs.append("ss", String.valueOf(iVar.dzD));
                    gs.append("hs", String.valueOf(iVar.dzE));
                    if (iVar.dzF && iVar.socketErrNo != 0) {
                        gs.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            gs.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        gs.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, gs);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, int i) {
        if (m.aOT().aOU() && iVar.dzM > 0) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "time_t");
            a(gs, iVar);
            gs.append("pct", String.valueOf(iVar.dzM));
            switch (i) {
                case 0:
                    gs.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    gs.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, gs);
        }
    }
}
