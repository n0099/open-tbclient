package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends n {
    @Override // com.baidu.tbadk.n.n
    public void a(h hVar) {
        if (l.bFl().isSmallFlow()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time_t");
            a(mT, hVar);
            mT.append("ishttp", hVar.fCp ? "1" : "0");
            mT.append("issuccess", hVar.isSuccess ? "1" : "0");
            mT.append("nettype", l.bFl().getNetType());
            mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.fCd));
            mT.append("wt", String.valueOf(hVar.fCm));
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
            if (hVar.fCp) {
                mT.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(hVar.fCt));
            } else {
                mT.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(hVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, h hVar) {
        if (hVar instanceof d) {
            aVar.append("ptype", Integer.valueOf(((d) hVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.n.n
    public void a(h hVar, boolean z) {
        if (l.bFl().isSmallFlow()) {
            if (!z || hVar.fCu > 0) {
                if (z || hVar.fCv > 0) {
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("action", "time_t");
                    a(mT, hVar);
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

    @Override // com.baidu.tbadk.n.n
    public void a(h hVar, int i) {
        if (l.bFl().isSmallFlow() && hVar.fCw > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time_t");
            a(mT, hVar);
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
