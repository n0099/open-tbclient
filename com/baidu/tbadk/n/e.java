package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.n.o
    public void a(i iVar) {
        if (m.bCu().bCv()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time_t");
            a(mT, iVar);
            mT.append("ishttp", iVar.fvu ? "1" : "0");
            mT.append("issuccess", iVar.isSuccess ? "1" : "0");
            mT.append("nettype", m.bCu().getNetType());
            mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.fvi));
            mT.append("wt", String.valueOf(iVar.fvr));
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
            if (iVar.fvu) {
                mT.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.fvy));
            } else {
                mT.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.bCu().bCv()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "resource_t");
            mT.append("actype", str);
            mT.append("issuccess", hVar.isSuccess ? "1" : "0");
            mT.append("isfs", hVar.fvf ? "1" : "0");
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
        if (m.bCu().bCv()) {
            if (!z || iVar.fvz > 0) {
                if (z || iVar.fvA > 0) {
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("action", "time_t");
                    a(mT, iVar);
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

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, int i) {
        if (m.bCu().bCv() && iVar.fvB > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time_t");
            a(mT, iVar);
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
