package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.n.o
    public void a(i iVar) {
        if (m.bzV().bzW()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time_t");
            a(mT, iVar);
            mT.append("ishttp", iVar.fpA ? "1" : "0");
            mT.append("issuccess", iVar.isSuccess ? "1" : "0");
            mT.append("nettype", m.bzV().getNetType());
            mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.fpn));
            mT.append("wt", String.valueOf(iVar.fpx));
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
            if (iVar.fpA) {
                mT.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.fpE));
            } else {
                mT.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.bzV().bzW()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "resource_t");
            mT.append("actype", str);
            mT.append("issuccess", hVar.isSuccess ? "1" : "0");
            mT.append("isfs", hVar.fpk ? "1" : "0");
            mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            mT.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.append("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, boolean z) {
        if (m.bzV().bzW()) {
            if (!z || iVar.fpF > 0) {
                if (z || iVar.fpG > 0) {
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("action", "time_t");
                    a(mT, iVar);
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

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, int i) {
        if (m.bzV().bzW() && iVar.fpH > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time_t");
            a(mT, iVar);
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
