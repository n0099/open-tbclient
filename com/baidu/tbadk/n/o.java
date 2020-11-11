package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.bCu().bCv()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time");
            mT.append("ishttp", iVar.fvu ? "1" : "0");
            mT.append("issuccess", iVar.isSuccess ? "1" : "0");
            mT.append("nettype", m.bCu().getNetType());
            mT.append("wt", String.valueOf(iVar.fvr));
            mT.append("qt", String.valueOf(iVar.fvj));
            mT.append("connt", String.valueOf(iVar.fvk));
            mT.append("rwt", String.valueOf(iVar.fvl));
            mT.append("fbt", String.valueOf(iVar.firstByteReachTime));
            mT.append("abt", String.valueOf(iVar.allDataReadTime));
            mT.append("dect", String.valueOf(iVar.fvm));
            mT.append("parset", String.valueOf(iVar.fvn));
            mT.append("tqt", String.valueOf(iVar.fvp));
            mT.append("rendert", String.valueOf(iVar.fvq));
            mT.append("ss", String.valueOf(iVar.fvs));
            mT.append("hs", String.valueOf(iVar.fvt));
            if (iVar.fvu && iVar.socketErrNo != 0) {
                mT.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    mT.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.fvu) {
                mT.append("hrtn", String.valueOf(iVar.fvv));
                mT.append("hrtt", String.valueOf(iVar.fvw));
            }
            if (iVar.errCode != 0) {
                mT.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.fvx) {
                mT.append("pt", "1");
            } else {
                mT.append("sysct", String.valueOf(iVar.fvg));
                mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.fvi));
                mT.append("lt", String.valueOf(iVar.fvh));
                mT.append("df", String.valueOf(iVar.fvo));
            }
            if (iVar.fvu) {
                mT.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.fvy));
                if (iVar.sequenceID != 0) {
                    mT.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                mT.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            if (iVar.extra != null && !iVar.extra.isEmpty()) {
                for (Map.Entry<String, String> entry : iVar.extra.entrySet()) {
                    mT.append(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.bCu().bCv()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "resource");
            mT.append("actype", str);
            mT.append("issuccess", hVar.isSuccess ? "1" : "0");
            mT.append("isfs", hVar.fvf ? "1" : "0");
            mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            mT.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.bCu().bCv()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "fluency");
            mT.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, mT);
            com.baidu.adp.lib.stats.a mT2 = mT();
            mT2.append("action", "mem");
            mT2.append("memp", String.valueOf(m.bCu().bCw()));
            BdStatisticsManager.getInstance().performance(this.subType, mT2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.bCu().bCv()) {
            if (!z || iVar.fvz > 0) {
                if (z || iVar.fvA > 0) {
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("action", "time");
                    if (z) {
                        mT.append("put", String.valueOf(iVar.fvz));
                    } else {
                        mT.append("pdt", String.valueOf(iVar.fvA));
                    }
                    mT.append("ishttp", iVar.fvu ? "1" : "0");
                    mT.append("issuccess", iVar.isSuccess ? "1" : "0");
                    mT.append("nettype", m.bCu().getNetType());
                    mT.append("qt", String.valueOf(iVar.fvj));
                    mT.append("connt", String.valueOf(iVar.fvk));
                    mT.append("rwt", String.valueOf(iVar.fvl));
                    mT.append("dect", String.valueOf(iVar.fvm));
                    mT.append("parset", String.valueOf(iVar.fvn));
                    mT.append("rendert", String.valueOf(iVar.fvq));
                    mT.append("ss", String.valueOf(iVar.fvs));
                    mT.append("hs", String.valueOf(iVar.fvt));
                    if (iVar.fvu && iVar.socketErrNo != 0) {
                        mT.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            mT.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        mT.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, mT);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.bCu().bCv() && iVar.fvB > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time");
            mT.append("pct", String.valueOf(iVar.fvB));
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
