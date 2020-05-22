package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.n.o
    public void a(i iVar) {
        if (m.bfI().bfJ()) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("action", "time_t");
            a(kY, iVar);
            kY.append("ishttp", iVar.esk ? "1" : "0");
            kY.append("issuccess", iVar.isSuccess ? "1" : "0");
            kY.append("nettype", m.bfI().getNetType());
            kY.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.erY));
            kY.append("wt", String.valueOf(iVar.esh));
            kY.append("qt", String.valueOf(iVar.erZ));
            kY.append("connt", String.valueOf(iVar.esa));
            kY.append("rwt", String.valueOf(iVar.esb));
            kY.append("dect", String.valueOf(iVar.esc));
            kY.append("parset", String.valueOf(iVar.esd));
            kY.append("rendert", String.valueOf(iVar.esg));
            kY.append("ss", String.valueOf(iVar.esi));
            kY.append("hs", String.valueOf(iVar.esj));
            if (iVar.esk && iVar.socketErrNo != 0) {
                kY.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    kY.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                kY.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.esk) {
                kY.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.eso));
            } else {
                kY.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, kY);
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.bfI().bfJ()) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("action", "resource_t");
            kY.append("actype", str);
            kY.append("issuccess", hVar.isSuccess ? "1" : "0");
            kY.append("isfs", hVar.erV ? "1" : "0");
            kY.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            kY.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, kY);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.append("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, boolean z) {
        if (m.bfI().bfJ()) {
            if (!z || iVar.esp > 0) {
                if (z || iVar.esq > 0) {
                    com.baidu.adp.lib.stats.a kY = kY();
                    kY.append("action", "time_t");
                    a(kY, iVar);
                    if (z) {
                        kY.append("put", String.valueOf(iVar.esp));
                    } else {
                        kY.append("pdt", String.valueOf(iVar.esq));
                    }
                    kY.append("ishttp", iVar.esk ? "1" : "0");
                    kY.append("issuccess", iVar.isSuccess ? "1" : "0");
                    kY.append("nettype", m.bfI().getNetType());
                    kY.append("qt", String.valueOf(iVar.erZ));
                    kY.append("connt", String.valueOf(iVar.esa));
                    kY.append("rwt", String.valueOf(iVar.esb));
                    kY.append("dect", String.valueOf(iVar.esc));
                    kY.append("parset", String.valueOf(iVar.esd));
                    kY.append("rendert", String.valueOf(iVar.esg));
                    kY.append("ss", String.valueOf(iVar.esi));
                    kY.append("hs", String.valueOf(iVar.esj));
                    if (iVar.esk && iVar.socketErrNo != 0) {
                        kY.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            kY.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        kY.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, kY);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, int i) {
        if (m.bfI().bfJ() && iVar.esr > 0) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("action", "time_t");
            a(kY, iVar);
            kY.append("pct", String.valueOf(iVar.esr));
            switch (i) {
                case 0:
                    kY.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    kY.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, kY);
        }
    }
}
