package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes2.dex */
public class e extends o {
    @Override // com.baidu.tbadk.n.o
    public void a(i iVar) {
        if (m.bun().buo()) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("action", "time_t");
            a(mN, iVar);
            mN.append("ishttp", iVar.eRX ? "1" : "0");
            mN.append("issuccess", iVar.isSuccess ? "1" : "0");
            mN.append("nettype", m.bun().getNetType());
            mN.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.eRL));
            mN.append("wt", String.valueOf(iVar.eRU));
            mN.append("qt", String.valueOf(iVar.eRM));
            mN.append("connt", String.valueOf(iVar.eRN));
            mN.append("rwt", String.valueOf(iVar.eRO));
            mN.append("dect", String.valueOf(iVar.eRP));
            mN.append("parset", String.valueOf(iVar.eRQ));
            mN.append("rendert", String.valueOf(iVar.eRT));
            mN.append("ss", String.valueOf(iVar.eRV));
            mN.append("hs", String.valueOf(iVar.eRW));
            if (iVar.eRX && iVar.socketErrNo != 0) {
                mN.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    mN.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                mN.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.eRX) {
                mN.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.eSb));
            } else {
                mN.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, mN);
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.bun().buo()) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("action", "resource_t");
            mN.append("actype", str);
            mN.append("issuccess", hVar.isSuccess ? "1" : "0");
            mN.append("isfs", hVar.eRI ? "1" : "0");
            mN.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            mN.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, mN);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.append("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, boolean z) {
        if (m.bun().buo()) {
            if (!z || iVar.eSc > 0) {
                if (z || iVar.eSd > 0) {
                    com.baidu.adp.lib.stats.a mN = mN();
                    mN.append("action", "time_t");
                    a(mN, iVar);
                    if (z) {
                        mN.append("put", String.valueOf(iVar.eSc));
                    } else {
                        mN.append("pdt", String.valueOf(iVar.eSd));
                    }
                    mN.append("ishttp", iVar.eRX ? "1" : "0");
                    mN.append("issuccess", iVar.isSuccess ? "1" : "0");
                    mN.append("nettype", m.bun().getNetType());
                    mN.append("qt", String.valueOf(iVar.eRM));
                    mN.append("connt", String.valueOf(iVar.eRN));
                    mN.append("rwt", String.valueOf(iVar.eRO));
                    mN.append("dect", String.valueOf(iVar.eRP));
                    mN.append("parset", String.valueOf(iVar.eRQ));
                    mN.append("rendert", String.valueOf(iVar.eRT));
                    mN.append("ss", String.valueOf(iVar.eRV));
                    mN.append("hs", String.valueOf(iVar.eRW));
                    if (iVar.eRX && iVar.socketErrNo != 0) {
                        mN.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            mN.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        mN.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, mN);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.n.o
    public void a(i iVar, int i) {
        if (m.bun().buo() && iVar.eSe > 0) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("action", "time_t");
            a(mN, iVar);
            mN.append("pct", String.valueOf(iVar.eSe));
            switch (i) {
                case 0:
                    mN.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    mN.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, mN);
        }
    }
}
