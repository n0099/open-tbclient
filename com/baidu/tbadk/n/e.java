package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends m {
    @Override // com.baidu.tbadk.n.m
    public void a(h hVar) {
        if (k.bEg().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("action", "time_t");
            a(pg, hVar);
            pg.append("ishttp", hVar.fJy ? "1" : "0");
            pg.append("issuccess", hVar.isSuccess ? "1" : "0");
            pg.append("nettype", k.bEg().getNetType());
            pg.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.fJn));
            pg.append("wt", String.valueOf(hVar.fJv));
            pg.append("qt", String.valueOf(hVar.cmm));
            pg.append("connt", String.valueOf(hVar.fJo));
            pg.append("rwt", String.valueOf(hVar.fJp));
            pg.append("dect", String.valueOf(hVar.fJq));
            pg.append("parset", String.valueOf(hVar.fJr));
            pg.append("rendert", String.valueOf(hVar.fJu));
            pg.append("ss", String.valueOf(hVar.fJw));
            pg.append("hs", String.valueOf(hVar.fJx));
            if (hVar.fJy && hVar.socketErrNo != 0) {
                pg.append("salno", String.valueOf(hVar.socketErrNo));
                if (hVar.socketCostTime != 0) {
                    pg.append("scosttime", String.valueOf(hVar.socketCostTime));
                }
            }
            if (hVar.errCode != 0) {
                pg.append("errcode", Integer.valueOf(hVar.errCode));
            }
            if (hVar.fJy) {
                pg.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(hVar.fJC));
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
        if (k.bEg().isSmallFlow()) {
            if (!z || hVar.fJD > 0) {
                if (z || hVar.fJE > 0) {
                    com.baidu.adp.lib.stats.a pg = pg();
                    pg.append("action", "time_t");
                    a(pg, hVar);
                    if (z) {
                        pg.append("put", String.valueOf(hVar.fJD));
                    } else {
                        pg.append("pdt", String.valueOf(hVar.fJE));
                    }
                    pg.append("ishttp", hVar.fJy ? "1" : "0");
                    pg.append("issuccess", hVar.isSuccess ? "1" : "0");
                    pg.append("nettype", k.bEg().getNetType());
                    pg.append("qt", String.valueOf(hVar.cmm));
                    pg.append("connt", String.valueOf(hVar.fJo));
                    pg.append("rwt", String.valueOf(hVar.fJp));
                    pg.append("dect", String.valueOf(hVar.fJq));
                    pg.append("parset", String.valueOf(hVar.fJr));
                    pg.append("rendert", String.valueOf(hVar.fJu));
                    pg.append("ss", String.valueOf(hVar.fJw));
                    pg.append("hs", String.valueOf(hVar.fJx));
                    if (hVar.fJy && hVar.socketErrNo != 0) {
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
        if (k.bEg().isSmallFlow() && hVar.fJF > 0) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("action", "time_t");
            a(pg, hVar);
            pg.append("pct", String.valueOf(hVar.fJF));
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
