package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class m extends j {
    public void a(h hVar) {
        if (k.bHG().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("action", "time");
            pi.append("ishttp", hVar.fLU ? "1" : "0");
            pi.append("issuccess", hVar.isSuccess ? "1" : "0");
            pi.append("nettype", k.bHG().getNetType());
            pi.append("wt", String.valueOf(hVar.fLR));
            pi.append("qt", String.valueOf(hVar.cmK));
            pi.append("connt", String.valueOf(hVar.fLK));
            pi.append("rwt", String.valueOf(hVar.fLL));
            pi.append("fbt", String.valueOf(hVar.firstByteReachTime));
            pi.append("abt", String.valueOf(hVar.allDataReadTime));
            pi.append("dect", String.valueOf(hVar.fLM));
            pi.append("parset", String.valueOf(hVar.fLN));
            pi.append("tqt", String.valueOf(hVar.fLP));
            pi.append("rendert", String.valueOf(hVar.fLQ));
            pi.append("ss", String.valueOf(hVar.fLS));
            pi.append("hs", String.valueOf(hVar.fLT));
            if (hVar.fLU && hVar.socketErrNo != 0) {
                pi.append("salno", String.valueOf(hVar.socketErrNo));
                if (hVar.socketCostTime != 0) {
                    pi.append("scosttime", String.valueOf(hVar.socketCostTime));
                }
            }
            if (hVar.fLU) {
                pi.append("hrtn", String.valueOf(hVar.fLV));
                pi.append("hrtt", String.valueOf(hVar.fLW));
            }
            if (hVar.errCode != 0) {
                pi.append("errcode", Integer.valueOf(hVar.errCode));
            }
            if (hVar.fLX) {
                pi.append("pt", "1");
            } else {
                pi.append("sysct", String.valueOf(hVar.fLH));
                pi.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.fLJ));
                pi.append("lt", String.valueOf(hVar.fLI));
                pi.append("df", String.valueOf(hVar.fLO));
            }
            if (hVar.fLU) {
                pi.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(hVar.fLY));
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
        if (bVar != null && k.bHG().isSmallFlow()) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("action", "fluency");
            pi.append(AlaRecorderLog.KEY_CANERA_START_FPS, String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, pi);
            com.baidu.adp.lib.stats.a pi2 = pi();
            pi2.append("action", "mem");
            pi2.append("memp", String.valueOf(k.bHG().bHH()));
            BdStatisticsManager.getInstance().performance(this.subType, pi2);
        }
    }

    public void a(h hVar, boolean z) {
        if (k.bHG().isSmallFlow()) {
            if (!z || hVar.fLZ > 0) {
                if (z || hVar.fMa > 0) {
                    com.baidu.adp.lib.stats.a pi = pi();
                    pi.append("action", "time");
                    if (z) {
                        pi.append("put", String.valueOf(hVar.fLZ));
                    } else {
                        pi.append("pdt", String.valueOf(hVar.fMa));
                    }
                    pi.append("ishttp", hVar.fLU ? "1" : "0");
                    pi.append("issuccess", hVar.isSuccess ? "1" : "0");
                    pi.append("nettype", k.bHG().getNetType());
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

    public void a(h hVar, int i) {
        if (k.bHG().isSmallFlow() && hVar.fMb > 0) {
            com.baidu.adp.lib.stats.a pi = pi();
            pi.append("action", "time");
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
