package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends m {
    @Override // com.baidu.tbadk.n.m
    public void a(h hVar) {
        if (k.bEk().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("action", "time_t");
            a(pg, hVar);
            pg.append("ishttp", hVar.fKY ? "1" : "0");
            pg.append("issuccess", hVar.isSuccess ? "1" : "0");
            pg.append("nettype", k.bEk().getNetType());
            pg.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.fKN));
            pg.append("wt", String.valueOf(hVar.fKV));
            pg.append("qt", String.valueOf(hVar.cnN));
            pg.append("connt", String.valueOf(hVar.fKO));
            pg.append("rwt", String.valueOf(hVar.fKP));
            pg.append("dect", String.valueOf(hVar.fKQ));
            pg.append("parset", String.valueOf(hVar.fKR));
            pg.append("rendert", String.valueOf(hVar.fKU));
            pg.append("ss", String.valueOf(hVar.fKW));
            pg.append("hs", String.valueOf(hVar.fKX));
            if (hVar.fKY && hVar.socketErrNo != 0) {
                pg.append("salno", String.valueOf(hVar.socketErrNo));
                if (hVar.socketCostTime != 0) {
                    pg.append("scosttime", String.valueOf(hVar.socketCostTime));
                }
            }
            if (hVar.errCode != 0) {
                pg.append("errcode", Integer.valueOf(hVar.errCode));
            }
            if (hVar.fKY) {
                pg.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(hVar.fLc));
            } else {
                pg.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(hVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, pg);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, h hVar) {
        if (hVar instanceof d) {
            aVar.append("ptype", Integer.valueOf(((d) hVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.n.m
    public void a(h hVar, boolean z) {
        if (k.bEk().isSmallFlow()) {
            if (!z || hVar.fLd > 0) {
                if (z || hVar.fLe > 0) {
                    com.baidu.adp.lib.stats.a pg = pg();
                    pg.append("action", "time_t");
                    a(pg, hVar);
                    if (z) {
                        pg.append("put", String.valueOf(hVar.fLd));
                    } else {
                        pg.append("pdt", String.valueOf(hVar.fLe));
                    }
                    pg.append("ishttp", hVar.fKY ? "1" : "0");
                    pg.append("issuccess", hVar.isSuccess ? "1" : "0");
                    pg.append("nettype", k.bEk().getNetType());
                    pg.append("qt", String.valueOf(hVar.cnN));
                    pg.append("connt", String.valueOf(hVar.fKO));
                    pg.append("rwt", String.valueOf(hVar.fKP));
                    pg.append("dect", String.valueOf(hVar.fKQ));
                    pg.append("parset", String.valueOf(hVar.fKR));
                    pg.append("rendert", String.valueOf(hVar.fKU));
                    pg.append("ss", String.valueOf(hVar.fKW));
                    pg.append("hs", String.valueOf(hVar.fKX));
                    if (hVar.fKY && hVar.socketErrNo != 0) {
                        pg.append("salno", String.valueOf(hVar.socketErrNo));
                        if (hVar.socketCostTime != 0) {
                            pg.append("scosttime", String.valueOf(hVar.socketCostTime));
                        }
                    }
                    if (hVar.errCode != 0) {
                        pg.append("errcode", Integer.valueOf(hVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, pg);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.n.m
    public void a(h hVar, int i) {
        if (k.bEk().isSmallFlow() && hVar.fLf > 0) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("action", "time_t");
            a(pg, hVar);
            pg.append("pct", String.valueOf(hVar.fLf));
            switch (i) {
                case 0:
                    pg.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    pg.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, pg);
        }
    }
}
