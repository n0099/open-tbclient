package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.bzV().bzW()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time");
            mT.append("ishttp", iVar.fpA ? "1" : "0");
            mT.append("issuccess", iVar.isSuccess ? "1" : "0");
            mT.append("nettype", m.bzV().getNetType());
            mT.append("wt", String.valueOf(iVar.fpx));
            mT.append("qt", String.valueOf(iVar.fpo));
            mT.append("connt", String.valueOf(iVar.fpp));
            mT.append("rwt", String.valueOf(iVar.fpq));
            mT.append("fbt", String.valueOf(iVar.firstByteReachTime));
            mT.append("abt", String.valueOf(iVar.allDataReadTime));
            mT.append("dect", String.valueOf(iVar.fpr));
            mT.append("parset", String.valueOf(iVar.fpt));
            mT.append("tqt", String.valueOf(iVar.fpv));
            mT.append("rendert", String.valueOf(iVar.fpw));
            mT.append("ss", String.valueOf(iVar.fpy));
            mT.append("hs", String.valueOf(iVar.fpz));
            if (iVar.fpA && iVar.socketErrNo != 0) {
                mT.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    mT.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.fpA) {
                mT.append("hrtn", String.valueOf(iVar.fpB));
                mT.append("hrtt", String.valueOf(iVar.fpC));
            }
            if (iVar.errCode != 0) {
                mT.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.fpD) {
                mT.append("pt", "1");
            } else {
                mT.append("sysct", String.valueOf(iVar.fpl));
                mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.fpn));
                mT.append("lt", String.valueOf(iVar.fpm));
                mT.append("df", String.valueOf(iVar.fpu));
            }
            if (iVar.fpA) {
                mT.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.fpE));
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
        if (hVar != null && str != null && m.bzV().bzW()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "resource");
            mT.append("actype", str);
            mT.append("issuccess", hVar.isSuccess ? "1" : "0");
            mT.append("isfs", hVar.fpk ? "1" : "0");
            mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            mT.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.bzV().bzW()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "fluency");
            mT.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, mT);
            com.baidu.adp.lib.stats.a mT2 = mT();
            mT2.append("action", "mem");
            mT2.append("memp", String.valueOf(m.bzV().bzX()));
            BdStatisticsManager.getInstance().performance(this.subType, mT2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.bzV().bzW()) {
            if (!z || iVar.fpF > 0) {
                if (z || iVar.fpG > 0) {
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("action", "time");
                    if (z) {
                        mT.append("put", String.valueOf(iVar.fpF));
                    } else {
                        mT.append("pdt", String.valueOf(iVar.fpG));
                    }
                    mT.append("ishttp", iVar.fpA ? "1" : "0");
                    mT.append("issuccess", iVar.isSuccess ? "1" : "0");
                    mT.append("nettype", m.bzV().getNetType());
                    mT.append("qt", String.valueOf(iVar.fpo));
                    mT.append("connt", String.valueOf(iVar.fpp));
                    mT.append("rwt", String.valueOf(iVar.fpq));
                    mT.append("dect", String.valueOf(iVar.fpr));
                    mT.append("parset", String.valueOf(iVar.fpt));
                    mT.append("rendert", String.valueOf(iVar.fpw));
                    mT.append("ss", String.valueOf(iVar.fpy));
                    mT.append("hs", String.valueOf(iVar.fpz));
                    if (iVar.fpA && iVar.socketErrNo != 0) {
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
        if (m.bzV().bzW() && iVar.fpH > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time");
            mT.append("pct", String.valueOf(iVar.fpH));
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
