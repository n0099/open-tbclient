package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends m {
    @Override // com.baidu.tbadk.n.m
    public void a(h hVar) {
        if (k.bHF().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("action", "time_t");
            a(pi, hVar);
            pi.append("ishttp", hVar.fLU ? "1" : "0");
            pi.append("issuccess", hVar.isSuccess ? "1" : "0");
            pi.append("nettype", k.bHF().getNetType());
            pi.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.fLJ));
            pi.append("wt", String.valueOf(hVar.fLR));
            pi.append("qt", String.valueOf(hVar.cmK));
            pi.append("connt", String.valueOf(hVar.fLK));
            pi.append("rwt", String.valueOf(hVar.fLL));
            pi.append("dect", String.valueOf(hVar.fLM));
            pi.append("parset", String.valueOf(hVar.fLN));
            pi.append("rendert", String.valueOf(hVar.fLQ));
            pi.append("ss", String.valueOf(hVar.fLS));
            pi.append("hs", String.valueOf(hVar.fLT));
            if (hVar.fLU && hVar.socketErrNo != 0) {
                pi.append("salno", String.valueOf(hVar.socketErrNo));
                if (hVar.socketCostTime != 0) {
                    pi.append("scosttime", String.valueOf(hVar.socketCostTime));
                }
            }
            if (hVar.errCode != 0) {
                pi.append("errcode", Integer.valueOf(hVar.errCode));
            }
            if (hVar.fLU) {
                pi.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(hVar.fLY));
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
        if (k.bHF().isSmallFlow()) {
            if (!z || hVar.fLZ > 0) {
                if (z || hVar.fMa > 0) {
                    com.baidu.adp.lib.stats.a pi = pi();
                    pi.append("action", "time_t");
                    a(pi, hVar);
                    if (z) {
                        pi.append("put", String.valueOf(hVar.fLZ));
                    } else {
                        pi.append("pdt", String.valueOf(hVar.fMa));
                    }
                    pi.append("ishttp", hVar.fLU ? "1" : "0");
                    pi.append("issuccess", hVar.isSuccess ? "1" : "0");
                    pi.append("nettype", k.bHF().getNetType());
                    pi.append("qt", String.valueOf(hVar.cmK));
                    pi.append("connt", String.valueOf(hVar.fLK));
                    pi.append("rwt", String.valueOf(hVar.fLL));
                    pi.append("dect", String.valueOf(hVar.fLM));
                    pi.append("parset", String.valueOf(hVar.fLN));
                    pi.append("rendert", String.valueOf(hVar.fLQ));
                    pi.append("ss", String.valueOf(hVar.fLS));
                    pi.append("hs", String.valueOf(hVar.fLT));
                    if (hVar.fLU && hVar.socketErrNo != 0) {
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
        if (k.bHF().isSmallFlow() && hVar.fMb > 0) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("action", "time_t");
            a(pi, hVar);
            pi.append("pct", String.valueOf(hVar.fMb));
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
