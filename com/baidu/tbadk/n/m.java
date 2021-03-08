package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class m extends j {
    public void a(h hVar) {
        if (k.bEk().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("action", "time");
            pg.append("ishttp", hVar.fKY ? "1" : "0");
            pg.append("issuccess", hVar.isSuccess ? "1" : "0");
            pg.append("nettype", k.bEk().getNetType());
            pg.append("wt", String.valueOf(hVar.fKV));
            pg.append("qt", String.valueOf(hVar.cnN));
            pg.append("connt", String.valueOf(hVar.fKO));
            pg.append("rwt", String.valueOf(hVar.fKP));
            pg.append("fbt", String.valueOf(hVar.firstByteReachTime));
            pg.append("abt", String.valueOf(hVar.allDataReadTime));
            pg.append("dect", String.valueOf(hVar.fKQ));
            pg.append("parset", String.valueOf(hVar.fKR));
            pg.append("tqt", String.valueOf(hVar.fKT));
            pg.append("rendert", String.valueOf(hVar.fKU));
            pg.append("ss", String.valueOf(hVar.fKW));
            pg.append("hs", String.valueOf(hVar.fKX));
            if (hVar.fKY && hVar.socketErrNo != 0) {
                pg.append("salno", String.valueOf(hVar.socketErrNo));
                if (hVar.socketCostTime != 0) {
                    pg.append("scosttime", String.valueOf(hVar.socketCostTime));
                }
            }
            if (hVar.fKY) {
                pg.append("hrtn", String.valueOf(hVar.fKZ));
                pg.append("hrtt", String.valueOf(hVar.fLa));
            }
            if (hVar.errCode != 0) {
                pg.append("errcode", Integer.valueOf(hVar.errCode));
            }
            if (hVar.fLb) {
                pg.append("pt", "1");
            } else {
                pg.append("sysct", String.valueOf(hVar.fKL));
                pg.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.fKN));
                pg.append("lt", String.valueOf(hVar.fKM));
                pg.append("df", String.valueOf(hVar.fKS));
            }
            if (hVar.fKY) {
                pg.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(hVar.fLc));
                if (hVar.sequenceID != 0) {
                    pg.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(hVar.sequenceID & 4294967295L));
                }
            } else {
                pg.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(hVar.sequenceID & 4294967295L));
            }
            if (hVar.extra != null && !hVar.extra.isEmpty()) {
                for (Map.Entry<String, String> entry : hVar.extra.entrySet()) {
                    pg.append(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.subType, pg);
        }
    }

    public void a(b bVar) {
        if (bVar != null && k.bEk().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("action", "fluency");
            pg.append(AlaRecorderLog.KEY_CANERA_START_FPS, String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, pg);
            com.baidu.adp.lib.stats.a pg2 = pg();
            pg2.append("action", "mem");
            pg2.append("memp", String.valueOf(k.bEk().bEl()));
            BdStatisticsManager.getInstance().performance(this.subType, pg2);
        }
    }

    public void a(h hVar, boolean z) {
        if (k.bEk().isSmallFlow()) {
            if (!z || hVar.fLd > 0) {
                if (z || hVar.fLe > 0) {
                    com.baidu.adp.lib.stats.a pg = pg();
                    pg.append("action", "time");
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

    public void a(h hVar, int i) {
        if (k.bEk().isSmallFlow() && hVar.fLf > 0) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("action", "time");
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
