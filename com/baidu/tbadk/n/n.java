package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.ala.recorder.video.AlaRecorderLog;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends k {
    public void a(h hVar) {
        if (l.bFl().isSmallFlow()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time");
            mT.append("ishttp", hVar.fCp ? "1" : "0");
            mT.append("issuccess", hVar.isSuccess ? "1" : "0");
            mT.append("nettype", l.bFl().getNetType());
            mT.append("wt", String.valueOf(hVar.fCm));
            mT.append("qt", String.valueOf(hVar.fCe));
            mT.append("connt", String.valueOf(hVar.fCf));
            mT.append("rwt", String.valueOf(hVar.fCg));
            mT.append("fbt", String.valueOf(hVar.firstByteReachTime));
            mT.append("abt", String.valueOf(hVar.allDataReadTime));
            mT.append("dect", String.valueOf(hVar.fCh));
            mT.append("parset", String.valueOf(hVar.fCi));
            mT.append("tqt", String.valueOf(hVar.fCk));
            mT.append("rendert", String.valueOf(hVar.fCl));
            mT.append("ss", String.valueOf(hVar.fCn));
            mT.append("hs", String.valueOf(hVar.fCo));
            if (hVar.fCp && hVar.socketErrNo != 0) {
                mT.append("salno", String.valueOf(hVar.socketErrNo));
                if (hVar.socketCostTime != 0) {
                    mT.append("scosttime", String.valueOf(hVar.socketCostTime));
                }
            }
            if (hVar.fCp) {
                mT.append("hrtn", String.valueOf(hVar.fCq));
                mT.append("hrtt", String.valueOf(hVar.fCr));
            }
            if (hVar.errCode != 0) {
                mT.append("errcode", Integer.valueOf(hVar.errCode));
            }
            if (hVar.fCs) {
                mT.append("pt", "1");
            } else {
                mT.append("sysct", String.valueOf(hVar.fCb));
                mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.fCd));
                mT.append("lt", String.valueOf(hVar.fCc));
                mT.append("df", String.valueOf(hVar.fCj));
            }
            if (hVar.fCp) {
                mT.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(hVar.fCt));
                if (hVar.sequenceID != 0) {
                    mT.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(hVar.sequenceID & 4294967295L));
                }
            } else {
                mT.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(hVar.sequenceID & 4294967295L));
            }
            if (hVar.extra != null && !hVar.extra.isEmpty()) {
                for (Map.Entry<String, String> entry : hVar.extra.entrySet()) {
                    mT.append(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    public void a(b bVar) {
        if (bVar != null && l.bFl().isSmallFlow()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "fluency");
            mT.append(AlaRecorderLog.KEY_CANERA_START_FPS, String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, mT);
            com.baidu.adp.lib.stats.a mT2 = mT();
            mT2.append("action", "mem");
            mT2.append("memp", String.valueOf(l.bFl().bFm()));
            BdStatisticsManager.getInstance().performance(this.subType, mT2);
        }
    }

    public void a(h hVar, boolean z) {
        if (l.bFl().isSmallFlow()) {
            if (!z || hVar.fCu > 0) {
                if (z || hVar.fCv > 0) {
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("action", "time");
                    if (z) {
                        mT.append("put", String.valueOf(hVar.fCu));
                    } else {
                        mT.append("pdt", String.valueOf(hVar.fCv));
                    }
                    mT.append("ishttp", hVar.fCp ? "1" : "0");
                    mT.append("issuccess", hVar.isSuccess ? "1" : "0");
                    mT.append("nettype", l.bFl().getNetType());
                    mT.append("qt", String.valueOf(hVar.fCe));
                    mT.append("connt", String.valueOf(hVar.fCf));
                    mT.append("rwt", String.valueOf(hVar.fCg));
                    mT.append("dect", String.valueOf(hVar.fCh));
                    mT.append("parset", String.valueOf(hVar.fCi));
                    mT.append("rendert", String.valueOf(hVar.fCl));
                    mT.append("ss", String.valueOf(hVar.fCn));
                    mT.append("hs", String.valueOf(hVar.fCo));
                    if (hVar.fCp && hVar.socketErrNo != 0) {
                        mT.append("salno", String.valueOf(hVar.socketErrNo));
                        if (hVar.socketCostTime != 0) {
                            mT.append("scosttime", String.valueOf(hVar.socketCostTime));
                        }
                    }
                    if (hVar.errCode != 0) {
                        mT.append("errcode", Integer.valueOf(hVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, mT);
                }
            }
        }
    }

    public void a(h hVar, int i) {
        if (l.bFl().isSmallFlow() && hVar.fCw > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time");
            mT.append("pct", String.valueOf(hVar.fCw));
            switch (i) {
                case 0:
                    mT.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    mT.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }
}
