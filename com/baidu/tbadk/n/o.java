package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.byc().byd()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time");
            mT.append("ishttp", iVar.fha ? "1" : "0");
            mT.append("issuccess", iVar.isSuccess ? "1" : "0");
            mT.append("nettype", m.byc().getNetType());
            mT.append("wt", String.valueOf(iVar.fgX));
            mT.append("qt", String.valueOf(iVar.fgP));
            mT.append("connt", String.valueOf(iVar.fgQ));
            mT.append("rwt", String.valueOf(iVar.fgR));
            mT.append("fbt", String.valueOf(iVar.firstByteReachTime));
            mT.append("abt", String.valueOf(iVar.allDataReadTime));
            mT.append("dect", String.valueOf(iVar.fgS));
            mT.append("parset", String.valueOf(iVar.fgT));
            mT.append("tqt", String.valueOf(iVar.fgV));
            mT.append("rendert", String.valueOf(iVar.fgW));
            mT.append("ss", String.valueOf(iVar.fgY));
            mT.append("hs", String.valueOf(iVar.fgZ));
            if (iVar.fha && iVar.socketErrNo != 0) {
                mT.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    mT.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.fha) {
                mT.append("hrtn", String.valueOf(iVar.fhb));
                mT.append("hrtt", String.valueOf(iVar.fhc));
            }
            if (iVar.errCode != 0) {
                mT.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.fhd) {
                mT.append("pt", "1");
            } else {
                mT.append("sysct", String.valueOf(iVar.fgM));
                mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.fgO));
                mT.append("lt", String.valueOf(iVar.fgN));
                mT.append("df", String.valueOf(iVar.fgU));
            }
            if (iVar.fha) {
                mT.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.fhe));
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
        if (hVar != null && str != null && m.byc().byd()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "resource");
            mT.append("actype", str);
            mT.append("issuccess", hVar.isSuccess ? "1" : "0");
            mT.append("isfs", hVar.fgL ? "1" : "0");
            mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            mT.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.byc().byd()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "fluency");
            mT.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, mT);
            com.baidu.adp.lib.stats.a mT2 = mT();
            mT2.append("action", "mem");
            mT2.append("memp", String.valueOf(m.byc().bye()));
            BdStatisticsManager.getInstance().performance(this.subType, mT2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.byc().byd()) {
            if (!z || iVar.fhf > 0) {
                if (z || iVar.fhg > 0) {
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("action", "time");
                    if (z) {
                        mT.append("put", String.valueOf(iVar.fhf));
                    } else {
                        mT.append("pdt", String.valueOf(iVar.fhg));
                    }
                    mT.append("ishttp", iVar.fha ? "1" : "0");
                    mT.append("issuccess", iVar.isSuccess ? "1" : "0");
                    mT.append("nettype", m.byc().getNetType());
                    mT.append("qt", String.valueOf(iVar.fgP));
                    mT.append("connt", String.valueOf(iVar.fgQ));
                    mT.append("rwt", String.valueOf(iVar.fgR));
                    mT.append("dect", String.valueOf(iVar.fgS));
                    mT.append("parset", String.valueOf(iVar.fgT));
                    mT.append("rendert", String.valueOf(iVar.fgW));
                    mT.append("ss", String.valueOf(iVar.fgY));
                    mT.append("hs", String.valueOf(iVar.fgZ));
                    if (iVar.fha && iVar.socketErrNo != 0) {
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
        if (m.byc().byd() && iVar.fhh > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time");
            mT.append("pct", String.valueOf(iVar.fhh));
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
