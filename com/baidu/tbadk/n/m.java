package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class m extends j {
    public void a(h hVar) {
        if (k.bEg().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("action", "time");
            pg.append("ishttp", hVar.fJy ? "1" : "0");
            pg.append("issuccess", hVar.isSuccess ? "1" : "0");
            pg.append("nettype", k.bEg().getNetType());
            pg.append("wt", String.valueOf(hVar.fJv));
            pg.append("qt", String.valueOf(hVar.cmm));
            pg.append("connt", String.valueOf(hVar.fJo));
            pg.append("rwt", String.valueOf(hVar.fJp));
            pg.append("fbt", String.valueOf(hVar.firstByteReachTime));
            pg.append("abt", String.valueOf(hVar.allDataReadTime));
            pg.append("dect", String.valueOf(hVar.fJq));
            pg.append("parset", String.valueOf(hVar.fJr));
            pg.append("tqt", String.valueOf(hVar.fJt));
            pg.append("rendert", String.valueOf(hVar.fJu));
            pg.append("ss", String.valueOf(hVar.fJw));
            pg.append("hs", String.valueOf(hVar.fJx));
            if (hVar.fJy && hVar.socketErrNo != 0) {
                pg.append("salno", String.valueOf(hVar.socketErrNo));
                if (hVar.socketCostTime != 0) {
                    pg.append("scosttime", String.valueOf(hVar.socketCostTime));
                }
            }
            if (hVar.fJy) {
                pg.append("hrtn", String.valueOf(hVar.fJz));
                pg.append("hrtt", String.valueOf(hVar.fJA));
            }
            if (hVar.errCode != 0) {
                pg.append("errcode", Integer.valueOf(hVar.errCode));
            }
            if (hVar.fJB) {
                pg.append("pt", "1");
            } else {
                pg.append("sysct", String.valueOf(hVar.fJl));
                pg.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.fJn));
                pg.append("lt", String.valueOf(hVar.fJm));
                pg.append("df", String.valueOf(hVar.fJs));
            }
            if (hVar.fJy) {
                pg.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(hVar.fJC));
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
        if (bVar != null && k.bEg().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("action", "fluency");
            pg.append(AlaRecorderLog.KEY_CANERA_START_FPS, String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, pg);
            com.baidu.adp.lib.stats.a pg2 = pg();
            pg2.append("action", "mem");
            pg2.append("memp", String.valueOf(k.bEg().bEh()));
            BdStatisticsManager.getInstance().performance(this.subType, pg2);
        }
    }

    public void a(h hVar, boolean z) {
        if (k.bEg().isSmallFlow()) {
            if (!z || hVar.fJD > 0) {
                if (z || hVar.fJE > 0) {
                    com.baidu.adp.lib.stats.a pg = pg();
                    pg.append("action", "time");
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

    public void a(h hVar, int i) {
        if (k.bEg().isSmallFlow() && hVar.fJF > 0) {
            com.baidu.adp.lib.stats.a pg = pg();
            pg.append("action", "time");
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
