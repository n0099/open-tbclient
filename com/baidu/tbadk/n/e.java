package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends m {
    @Override // com.baidu.tbadk.n.m
    public void a(h hVar) {
        if (k.bDO().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("action", "time_t");
            a(pi, hVar);
            pi.append("ishttp", hVar.fHn ? "1" : "0");
            pi.append("issuccess", hVar.isSuccess ? "1" : "0");
            pi.append("nettype", k.bDO().getNetType());
            pi.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.fHc));
            pi.append("wt", String.valueOf(hVar.fHk));
            pi.append("qt", String.valueOf(hVar.chW));
            pi.append("connt", String.valueOf(hVar.fHd));
            pi.append("rwt", String.valueOf(hVar.fHe));
            pi.append("dect", String.valueOf(hVar.fHf));
            pi.append("parset", String.valueOf(hVar.fHg));
            pi.append("rendert", String.valueOf(hVar.fHj));
            pi.append("ss", String.valueOf(hVar.fHl));
            pi.append("hs", String.valueOf(hVar.fHm));
            if (hVar.fHn && hVar.socketErrNo != 0) {
                pi.append("salno", String.valueOf(hVar.socketErrNo));
                if (hVar.socketCostTime != 0) {
                    pi.append("scosttime", String.valueOf(hVar.socketCostTime));
                }
            }
            if (hVar.errCode != 0) {
                pi.append("errcode", Integer.valueOf(hVar.errCode));
            }
            if (hVar.fHn) {
                pi.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(hVar.fHr));
            } else {
                pi.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(hVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, pi);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, h hVar) {
        if (hVar instanceof d) {
            aVar.append("ptype", Integer.valueOf(((d) hVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.n.m
    public void a(h hVar, boolean z) {
        if (k.bDO().isSmallFlow()) {
            if (!z || hVar.fHs > 0) {
                if (z || hVar.fHt > 0) {
                    com.baidu.adp.lib.stats.a pi = pi();
                    pi.append("action", "time_t");
                    a(pi, hVar);
                    if (z) {
                        pi.append("put", String.valueOf(hVar.fHs));
                    } else {
                        pi.append("pdt", String.valueOf(hVar.fHt));
                    }
                    pi.append("ishttp", hVar.fHn ? "1" : "0");
                    pi.append("issuccess", hVar.isSuccess ? "1" : "0");
                    pi.append("nettype", k.bDO().getNetType());
                    pi.append("qt", String.valueOf(hVar.chW));
                    pi.append("connt", String.valueOf(hVar.fHd));
                    pi.append("rwt", String.valueOf(hVar.fHe));
                    pi.append("dect", String.valueOf(hVar.fHf));
                    pi.append("parset", String.valueOf(hVar.fHg));
                    pi.append("rendert", String.valueOf(hVar.fHj));
                    pi.append("ss", String.valueOf(hVar.fHl));
                    pi.append("hs", String.valueOf(hVar.fHm));
                    if (hVar.fHn && hVar.socketErrNo != 0) {
                        pi.append("salno", String.valueOf(hVar.socketErrNo));
                        if (hVar.socketCostTime != 0) {
                            pi.append("scosttime", String.valueOf(hVar.socketCostTime));
                        }
                    }
                    if (hVar.errCode != 0) {
                        pi.append("errcode", Integer.valueOf(hVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, pi);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.n.m
    public void a(h hVar, int i) {
        if (k.bDO().isSmallFlow() && hVar.fHu > 0) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("action", "time_t");
            a(pi, hVar);
            pi.append("pct", String.valueOf(hVar.fHu));
            switch (i) {
                case 0:
                    pi.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    pi.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, pi);
        }
    }
}
