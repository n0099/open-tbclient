package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.buo().bup()) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("action", "time");
            mN.append("ishttp", iVar.eSb ? "1" : "0");
            mN.append("issuccess", iVar.isSuccess ? "1" : "0");
            mN.append("nettype", m.buo().getNetType());
            mN.append("wt", String.valueOf(iVar.eRY));
            mN.append("qt", String.valueOf(iVar.eRQ));
            mN.append("connt", String.valueOf(iVar.eRR));
            mN.append("rwt", String.valueOf(iVar.eRS));
            mN.append("fbt", String.valueOf(iVar.firstByteReachTime));
            mN.append("abt", String.valueOf(iVar.allDataReadTime));
            mN.append("dect", String.valueOf(iVar.eRT));
            mN.append("parset", String.valueOf(iVar.eRU));
            mN.append("tqt", String.valueOf(iVar.eRW));
            mN.append("rendert", String.valueOf(iVar.eRX));
            mN.append("ss", String.valueOf(iVar.eRZ));
            mN.append("hs", String.valueOf(iVar.eSa));
            if (iVar.eSb && iVar.socketErrNo != 0) {
                mN.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    mN.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.eSb) {
                mN.append("hrtn", String.valueOf(iVar.eSc));
                mN.append("hrtt", String.valueOf(iVar.eSd));
            }
            if (iVar.errCode != 0) {
                mN.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.eSe) {
                mN.append("pt", "1");
            } else {
                mN.append("sysct", String.valueOf(iVar.eRN));
                mN.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.eRP));
                mN.append("lt", String.valueOf(iVar.eRO));
                mN.append("df", String.valueOf(iVar.eRV));
            }
            if (iVar.eSb) {
                mN.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.eSf));
                if (iVar.sequenceID != 0) {
                    mN.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                mN.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            if (iVar.extra != null && !iVar.extra.isEmpty()) {
                for (Map.Entry<String, String> entry : iVar.extra.entrySet()) {
                    mN.append(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.subType, mN);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.buo().bup()) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("action", "resource");
            mN.append("actype", str);
            mN.append("issuccess", hVar.isSuccess ? "1" : "0");
            mN.append("isfs", hVar.eRM ? "1" : "0");
            mN.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            mN.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, mN);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.buo().bup()) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("action", "fluency");
            mN.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, mN);
            com.baidu.adp.lib.stats.a mN2 = mN();
            mN2.append("action", "mem");
            mN2.append("memp", String.valueOf(m.buo().buq()));
            BdStatisticsManager.getInstance().performance(this.subType, mN2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.buo().bup()) {
            if (!z || iVar.eSg > 0) {
                if (z || iVar.eSh > 0) {
                    com.baidu.adp.lib.stats.a mN = mN();
                    mN.append("action", "time");
                    if (z) {
                        mN.append("put", String.valueOf(iVar.eSg));
                    } else {
                        mN.append("pdt", String.valueOf(iVar.eSh));
                    }
                    mN.append("ishttp", iVar.eSb ? "1" : "0");
                    mN.append("issuccess", iVar.isSuccess ? "1" : "0");
                    mN.append("nettype", m.buo().getNetType());
                    mN.append("qt", String.valueOf(iVar.eRQ));
                    mN.append("connt", String.valueOf(iVar.eRR));
                    mN.append("rwt", String.valueOf(iVar.eRS));
                    mN.append("dect", String.valueOf(iVar.eRT));
                    mN.append("parset", String.valueOf(iVar.eRU));
                    mN.append("rendert", String.valueOf(iVar.eRX));
                    mN.append("ss", String.valueOf(iVar.eRZ));
                    mN.append("hs", String.valueOf(iVar.eSa));
                    if (iVar.eSb && iVar.socketErrNo != 0) {
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

    public void a(i iVar, int i) {
        if (m.buo().bup() && iVar.eSi > 0) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("action", "time");
            mN.append("pct", String.valueOf(iVar.eSi));
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
