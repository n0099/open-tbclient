package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.p.o
    public void a(i iVar) {
        if (m.awL().awM()) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "time_t");
            a(fU, iVar);
            fU.append("ishttp", iVar.cLu ? "1" : "0");
            fU.append("issuccess", iVar.isSuccess ? "1" : "0");
            fU.append("nettype", m.awL().getNetType());
            fU.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cLj));
            fU.append("wt", String.valueOf(iVar.cLr));
            fU.append("qt", String.valueOf(iVar.cLk));
            fU.append("connt", String.valueOf(iVar.cLl));
            fU.append("rwt", String.valueOf(iVar.cLm));
            fU.append("dect", String.valueOf(iVar.cLn));
            fU.append("parset", String.valueOf(iVar.cLo));
            fU.append("rendert", String.valueOf(iVar.cLq));
            fU.append("ss", String.valueOf(iVar.cLs));
            fU.append("hs", String.valueOf(iVar.cLt));
            if (iVar.cLu && iVar.socketErrNo != 0) {
                fU.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    fU.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                fU.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cLu) {
                fU.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.cLy));
            } else {
                fU.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fU);
        }
    }

    @Override // com.baidu.tbadk.p.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.awL().awM()) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "resource_t");
            fU.append("actype", str);
            fU.append("issuccess", hVar.isSuccess ? "1" : "0");
            fU.append("isfs", hVar.cLh ? "1" : "0");
            fU.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            fU.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, fU);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.append("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.p.o
    public void a(i iVar, boolean z) {
        if (m.awL().awM()) {
            if (!z || iVar.cLz > 0) {
                if (z || iVar.cLA > 0) {
                    com.baidu.adp.lib.stats.a fU = fU();
                    fU.append("action", "time_t");
                    a(fU, iVar);
                    if (z) {
                        fU.append("put", String.valueOf(iVar.cLz));
                    } else {
                        fU.append("pdt", String.valueOf(iVar.cLA));
                    }
                    fU.append("ishttp", iVar.cLu ? "1" : "0");
                    fU.append("issuccess", iVar.isSuccess ? "1" : "0");
                    fU.append("nettype", m.awL().getNetType());
                    fU.append("qt", String.valueOf(iVar.cLk));
                    fU.append("connt", String.valueOf(iVar.cLl));
                    fU.append("rwt", String.valueOf(iVar.cLm));
                    fU.append("dect", String.valueOf(iVar.cLn));
                    fU.append("parset", String.valueOf(iVar.cLo));
                    fU.append("rendert", String.valueOf(iVar.cLq));
                    fU.append("ss", String.valueOf(iVar.cLs));
                    fU.append("hs", String.valueOf(iVar.cLt));
                    if (iVar.cLu && iVar.socketErrNo != 0) {
                        fU.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            fU.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        fU.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, fU);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.p.o
    public void a(i iVar, int i) {
        if (m.awL().awM() && iVar.cLB > 0) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "time_t");
            a(fU, iVar);
            fU.append("pct", String.valueOf(iVar.cLB));
            switch (i) {
                case 0:
                    fU.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    fU.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, fU);
        }
    }
}
