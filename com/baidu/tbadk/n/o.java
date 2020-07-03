package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.bhP().bhQ()) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "time");
            lo.append("ishttp", iVar.eBc ? "1" : "0");
            lo.append("issuccess", iVar.isSuccess ? "1" : "0");
            lo.append("nettype", m.bhP().getNetType());
            lo.append("wt", String.valueOf(iVar.eAZ));
            lo.append("qt", String.valueOf(iVar.eAR));
            lo.append("connt", String.valueOf(iVar.eAS));
            lo.append("rwt", String.valueOf(iVar.eAT));
            lo.append("fbt", String.valueOf(iVar.firstByteReachTime));
            lo.append("abt", String.valueOf(iVar.allDataReadTime));
            lo.append("dect", String.valueOf(iVar.eAU));
            lo.append("parset", String.valueOf(iVar.eAV));
            lo.append("tqt", String.valueOf(iVar.eAX));
            lo.append("rendert", String.valueOf(iVar.eAY));
            lo.append("ss", String.valueOf(iVar.eBa));
            lo.append("hs", String.valueOf(iVar.eBb));
            if (iVar.eBc && iVar.socketErrNo != 0) {
                lo.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    lo.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.eBc) {
                lo.append("hrtn", String.valueOf(iVar.eBd));
                lo.append("hrtt", String.valueOf(iVar.eBe));
            }
            if (iVar.errCode != 0) {
                lo.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.eBf) {
                lo.append("pt", "1");
            } else {
                lo.append("sysct", String.valueOf(iVar.eAO));
                lo.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.eAQ));
                lo.append("lt", String.valueOf(iVar.eAP));
                lo.append("df", String.valueOf(iVar.eAW));
            }
            if (iVar.eBc) {
                lo.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.eBg));
                if (iVar.sequenceID != 0) {
                    lo.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                lo.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, lo);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.bhP().bhQ()) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "resource");
            lo.append("actype", str);
            lo.append("issuccess", hVar.isSuccess ? "1" : "0");
            lo.append("isfs", hVar.eAN ? "1" : "0");
            lo.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            lo.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, lo);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.bhP().bhQ()) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "fluency");
            lo.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, lo);
            com.baidu.adp.lib.stats.a lo2 = lo();
            lo2.append("action", "mem");
            lo2.append("memp", String.valueOf(m.bhP().bhR()));
            BdStatisticsManager.getInstance().performance(this.subType, lo2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.bhP().bhQ()) {
            if (!z || iVar.eBh > 0) {
                if (z || iVar.eBi > 0) {
                    com.baidu.adp.lib.stats.a lo = lo();
                    lo.append("action", "time");
                    if (z) {
                        lo.append("put", String.valueOf(iVar.eBh));
                    } else {
                        lo.append("pdt", String.valueOf(iVar.eBi));
                    }
                    lo.append("ishttp", iVar.eBc ? "1" : "0");
                    lo.append("issuccess", iVar.isSuccess ? "1" : "0");
                    lo.append("nettype", m.bhP().getNetType());
                    lo.append("qt", String.valueOf(iVar.eAR));
                    lo.append("connt", String.valueOf(iVar.eAS));
                    lo.append("rwt", String.valueOf(iVar.eAT));
                    lo.append("dect", String.valueOf(iVar.eAU));
                    lo.append("parset", String.valueOf(iVar.eAV));
                    lo.append("rendert", String.valueOf(iVar.eAY));
                    lo.append("ss", String.valueOf(iVar.eBa));
                    lo.append("hs", String.valueOf(iVar.eBb));
                    if (iVar.eBc && iVar.socketErrNo != 0) {
                        lo.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            lo.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        lo.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, lo);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.bhP().bhQ() && iVar.eBj > 0) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "time");
            lo.append("pct", String.valueOf(iVar.eBj));
            switch (i) {
                case 0:
                    lo.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    lo.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, lo);
        }
    }
}
