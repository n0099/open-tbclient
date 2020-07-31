package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.blA().blB()) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "time");
            lo.append("ishttp", iVar.eHr ? "1" : "0");
            lo.append("issuccess", iVar.isSuccess ? "1" : "0");
            lo.append("nettype", m.blA().getNetType());
            lo.append("wt", String.valueOf(iVar.eHo));
            lo.append("qt", String.valueOf(iVar.eHg));
            lo.append("connt", String.valueOf(iVar.eHh));
            lo.append("rwt", String.valueOf(iVar.eHi));
            lo.append("fbt", String.valueOf(iVar.firstByteReachTime));
            lo.append("abt", String.valueOf(iVar.allDataReadTime));
            lo.append("dect", String.valueOf(iVar.eHj));
            lo.append("parset", String.valueOf(iVar.eHk));
            lo.append("tqt", String.valueOf(iVar.eHm));
            lo.append("rendert", String.valueOf(iVar.eHn));
            lo.append("ss", String.valueOf(iVar.eHp));
            lo.append("hs", String.valueOf(iVar.eHq));
            if (iVar.eHr && iVar.socketErrNo != 0) {
                lo.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    lo.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.eHr) {
                lo.append("hrtn", String.valueOf(iVar.eHs));
                lo.append("hrtt", String.valueOf(iVar.eHt));
            }
            if (iVar.errCode != 0) {
                lo.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.eHu) {
                lo.append("pt", "1");
            } else {
                lo.append("sysct", String.valueOf(iVar.eHd));
                lo.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.eHf));
                lo.append("lt", String.valueOf(iVar.eHe));
                lo.append("df", String.valueOf(iVar.eHl));
            }
            if (iVar.eHr) {
                lo.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.eHv));
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
        if (hVar != null && str != null && m.blA().blB()) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "resource");
            lo.append("actype", str);
            lo.append("issuccess", hVar.isSuccess ? "1" : "0");
            lo.append("isfs", hVar.eHc ? "1" : "0");
            lo.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            lo.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, lo);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.blA().blB()) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "fluency");
            lo.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, lo);
            com.baidu.adp.lib.stats.a lo2 = lo();
            lo2.append("action", "mem");
            lo2.append("memp", String.valueOf(m.blA().blC()));
            BdStatisticsManager.getInstance().performance(this.subType, lo2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.blA().blB()) {
            if (!z || iVar.eHw > 0) {
                if (z || iVar.eHx > 0) {
                    com.baidu.adp.lib.stats.a lo = lo();
                    lo.append("action", "time");
                    if (z) {
                        lo.append("put", String.valueOf(iVar.eHw));
                    } else {
                        lo.append("pdt", String.valueOf(iVar.eHx));
                    }
                    lo.append("ishttp", iVar.eHr ? "1" : "0");
                    lo.append("issuccess", iVar.isSuccess ? "1" : "0");
                    lo.append("nettype", m.blA().getNetType());
                    lo.append("qt", String.valueOf(iVar.eHg));
                    lo.append("connt", String.valueOf(iVar.eHh));
                    lo.append("rwt", String.valueOf(iVar.eHi));
                    lo.append("dect", String.valueOf(iVar.eHj));
                    lo.append("parset", String.valueOf(iVar.eHk));
                    lo.append("rendert", String.valueOf(iVar.eHn));
                    lo.append("ss", String.valueOf(iVar.eHp));
                    lo.append("hs", String.valueOf(iVar.eHq));
                    if (iVar.eHr && iVar.socketErrNo != 0) {
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
        if (m.blA().blB() && iVar.eHy > 0) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "time");
            lo.append("pct", String.valueOf(iVar.eHy));
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
