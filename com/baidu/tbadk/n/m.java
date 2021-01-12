package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class m extends j {
    public void a(h hVar) {
        if (k.bDO().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("action", "time");
            pi.append("ishttp", hVar.fHn ? "1" : "0");
            pi.append("issuccess", hVar.isSuccess ? "1" : "0");
            pi.append("nettype", k.bDO().getNetType());
            pi.append("wt", String.valueOf(hVar.fHk));
            pi.append("qt", String.valueOf(hVar.chW));
            pi.append("connt", String.valueOf(hVar.fHd));
            pi.append("rwt", String.valueOf(hVar.fHe));
            pi.append("fbt", String.valueOf(hVar.firstByteReachTime));
            pi.append("abt", String.valueOf(hVar.allDataReadTime));
            pi.append("dect", String.valueOf(hVar.fHf));
            pi.append("parset", String.valueOf(hVar.fHg));
            pi.append("tqt", String.valueOf(hVar.fHi));
            pi.append("rendert", String.valueOf(hVar.fHj));
            pi.append("ss", String.valueOf(hVar.fHl));
            pi.append("hs", String.valueOf(hVar.fHm));
            if (hVar.fHn && hVar.socketErrNo != 0) {
                pi.append("salno", String.valueOf(hVar.socketErrNo));
                if (hVar.socketCostTime != 0) {
                    pi.append("scosttime", String.valueOf(hVar.socketCostTime));
                }
            }
            if (hVar.fHn) {
                pi.append("hrtn", String.valueOf(hVar.fHo));
                pi.append("hrtt", String.valueOf(hVar.fHp));
            }
            if (hVar.errCode != 0) {
                pi.append("errcode", Integer.valueOf(hVar.errCode));
            }
            if (hVar.fHq) {
                pi.append("pt", "1");
            } else {
                pi.append("sysct", String.valueOf(hVar.fHa));
                pi.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.fHc));
                pi.append("lt", String.valueOf(hVar.fHb));
                pi.append("df", String.valueOf(hVar.fHh));
            }
            if (hVar.fHn) {
                pi.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(hVar.fHr));
                if (hVar.sequenceID != 0) {
                    pi.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(hVar.sequenceID & 4294967295L));
                }
            } else {
                pi.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(hVar.sequenceID & 4294967295L));
            }
            if (hVar.extra != null && !hVar.extra.isEmpty()) {
                for (Map.Entry<String, String> entry : hVar.extra.entrySet()) {
                    pi.append(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.subType, pi);
        }
    }

    public void a(b bVar) {
        if (bVar != null && k.bDO().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("action", "fluency");
            pi.append(AlaRecorderLog.KEY_CANERA_START_FPS, String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, pi);
            com.baidu.adp.lib.stats.a pi2 = pi();
            pi2.append("action", "mem");
            pi2.append("memp", String.valueOf(k.bDO().bDP()));
            BdStatisticsManager.getInstance().performance(this.subType, pi2);
        }
    }

    public void a(h hVar, boolean z) {
        if (k.bDO().isSmallFlow()) {
            if (!z || hVar.fHs > 0) {
                if (z || hVar.fHt > 0) {
                    com.baidu.adp.lib.stats.a pi = pi();
                    pi.append("action", "time");
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

    public void a(h hVar, int i) {
        if (k.bDO().isSmallFlow() && hVar.fHu > 0) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("action", "time");
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
