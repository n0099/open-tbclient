package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.n.o
    public void a(i iVar) {
        if (m.bBK().isSmallFlow()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time_t");
            a(mT, iVar);
            mT.append("ishttp", iVar.fuE ? "1" : "0");
            mT.append("issuccess", iVar.isSuccess ? "1" : "0");
            mT.append("nettype", m.bBK().getNetType());
            mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.fus));
            mT.append("wt", String.valueOf(iVar.fuB));
            mT.append("qt", String.valueOf(iVar.fut));
            mT.append("connt", String.valueOf(iVar.fuu));
            mT.append("rwt", String.valueOf(iVar.fuv));
            mT.append("dect", String.valueOf(iVar.fuw));
            mT.append("parset", String.valueOf(iVar.fux));
            mT.append("rendert", String.valueOf(iVar.fuA));
            mT.append("ss", String.valueOf(iVar.fuC));
            mT.append("hs", String.valueOf(iVar.fuD));
            if (iVar.fuE && iVar.socketErrNo != 0) {
                mT.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    mT.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                mT.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.fuE) {
                mT.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.fuI));
            } else {
                mT.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.bBK().isSmallFlow()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "resource_t");
            mT.append("actype", str);
            mT.append("issuccess", hVar.isSuccess ? "1" : "0");
            mT.append("isfs", hVar.fup ? "1" : "0");
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
        if (m.bBK().isSmallFlow()) {
            if (!z || iVar.fuJ > 0) {
                if (z || iVar.fuK > 0) {
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("action", "time_t");
                    a(mT, iVar);
                    if (z) {
                        mT.append("put", String.valueOf(iVar.fuJ));
                    } else {
                        mT.append("pdt", String.valueOf(iVar.fuK));
                    }
                    mT.append("ishttp", iVar.fuE ? "1" : "0");
                    mT.append("issuccess", iVar.isSuccess ? "1" : "0");
                    mT.append("nettype", m.bBK().getNetType());
                    mT.append("qt", String.valueOf(iVar.fut));
                    mT.append("connt", String.valueOf(iVar.fuu));
                    mT.append("rwt", String.valueOf(iVar.fuv));
                    mT.append("dect", String.valueOf(iVar.fuw));
                    mT.append("parset", String.valueOf(iVar.fux));
                    mT.append("rendert", String.valueOf(iVar.fuA));
                    mT.append("ss", String.valueOf(iVar.fuC));
                    mT.append("hs", String.valueOf(iVar.fuD));
                    if (iVar.fuE && iVar.socketErrNo != 0) {
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
        if (m.bBK().isSmallFlow() && iVar.fuL > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time_t");
            a(mT, iVar);
            mT.append("pct", String.valueOf(iVar.fuL));
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
