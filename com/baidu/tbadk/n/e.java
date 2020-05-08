package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.n.o
    public void a(i iVar) {
        if (m.aZy().aZz()) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("action", "time_t");
            a(kW, iVar);
            kW.append("ishttp", iVar.edX ? "1" : "0");
            kW.append("issuccess", iVar.isSuccess ? "1" : "0");
            kW.append("nettype", m.aZy().getNetType());
            kW.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.edL));
            kW.append("wt", String.valueOf(iVar.edU));
            kW.append("qt", String.valueOf(iVar.edM));
            kW.append("connt", String.valueOf(iVar.edN));
            kW.append("rwt", String.valueOf(iVar.edO));
            kW.append("dect", String.valueOf(iVar.edP));
            kW.append("parset", String.valueOf(iVar.edQ));
            kW.append("rendert", String.valueOf(iVar.edT));
            kW.append("ss", String.valueOf(iVar.edV));
            kW.append("hs", String.valueOf(iVar.edW));
            if (iVar.edX && iVar.socketErrNo != 0) {
                kW.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    kW.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                kW.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.edX) {
                kW.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.eeb));
            } else {
                kW.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, kW);
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.aZy().aZz()) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("action", "resource_t");
            kW.append("actype", str);
            kW.append("issuccess", hVar.isSuccess ? "1" : "0");
            kW.append("isfs", hVar.edI ? "1" : "0");
            kW.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            kW.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, kW);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.append("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, boolean z) {
        if (m.aZy().aZz()) {
            if (!z || iVar.eec > 0) {
                if (z || iVar.eed > 0) {
                    com.baidu.adp.lib.stats.a kW = kW();
                    kW.append("action", "time_t");
                    a(kW, iVar);
                    if (z) {
                        kW.append("put", String.valueOf(iVar.eec));
                    } else {
                        kW.append("pdt", String.valueOf(iVar.eed));
                    }
                    kW.append("ishttp", iVar.edX ? "1" : "0");
                    kW.append("issuccess", iVar.isSuccess ? "1" : "0");
                    kW.append("nettype", m.aZy().getNetType());
                    kW.append("qt", String.valueOf(iVar.edM));
                    kW.append("connt", String.valueOf(iVar.edN));
                    kW.append("rwt", String.valueOf(iVar.edO));
                    kW.append("dect", String.valueOf(iVar.edP));
                    kW.append("parset", String.valueOf(iVar.edQ));
                    kW.append("rendert", String.valueOf(iVar.edT));
                    kW.append("ss", String.valueOf(iVar.edV));
                    kW.append("hs", String.valueOf(iVar.edW));
                    if (iVar.edX && iVar.socketErrNo != 0) {
                        kW.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            kW.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        kW.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, kW);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, int i) {
        if (m.aZy().aZz() && iVar.eee > 0) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("action", "time_t");
            a(kW, iVar);
            kW.append("pct", String.valueOf(iVar.eee));
            switch (i) {
                case 0:
                    kW.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    kW.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, kW);
        }
    }
}
