package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.aOA().aOB()) {
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("action", "time");
            gt.append("ishttp", iVar.dzx ? "1" : "0");
            gt.append("issuccess", iVar.isSuccess ? "1" : "0");
            gt.append("nettype", m.aOA().getNetType());
            gt.append("wt", String.valueOf(iVar.dzu));
            gt.append("qt", String.valueOf(iVar.dzn));
            gt.append("connt", String.valueOf(iVar.dzo));
            gt.append("rwt", String.valueOf(iVar.dzp));
            gt.append("fbt", String.valueOf(iVar.firstByteReachTime));
            gt.append("abt", String.valueOf(iVar.allDataReadTime));
            gt.append("dect", String.valueOf(iVar.dzq));
            gt.append("parset", String.valueOf(iVar.dzr));
            gt.append("tqt", String.valueOf(iVar.dzs));
            gt.append("rendert", String.valueOf(iVar.dzt));
            gt.append("ss", String.valueOf(iVar.dzv));
            gt.append("hs", String.valueOf(iVar.dzw));
            if (iVar.dzx && iVar.socketErrNo != 0) {
                gt.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    gt.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.dzx) {
                gt.append("hrtn", String.valueOf(iVar.dzy));
                gt.append("hrtt", String.valueOf(iVar.dzz));
            }
            if (iVar.errCode != 0) {
                gt.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.dzA) {
                gt.append("pt", "1");
            } else {
                gt.append("sysct", String.valueOf(iVar.dzl));
                gt.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.dzm));
            }
            if (iVar.dzx) {
                gt.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.dzB));
                if (iVar.sequenceID != 0) {
                    gt.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                gt.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, gt);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.aOA().aOB()) {
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("action", "resource");
            gt.append("actype", str);
            gt.append("issuccess", hVar.isSuccess ? "1" : "0");
            gt.append("isfs", hVar.dzk ? "1" : "0");
            gt.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            gt.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, gt);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.aOA().aOB()) {
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("action", "fluency");
            gt.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, gt);
            com.baidu.adp.lib.stats.a gt2 = gt();
            gt2.append("action", "mem");
            gt2.append("memp", String.valueOf(m.aOA().aOC()));
            BdStatisticsManager.getInstance().performance(this.subType, gt2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.aOA().aOB()) {
            if (!z || iVar.dzC > 0) {
                if (z || iVar.dzD > 0) {
                    com.baidu.adp.lib.stats.a gt = gt();
                    gt.append("action", "time");
                    if (z) {
                        gt.append("put", String.valueOf(iVar.dzC));
                    } else {
                        gt.append("pdt", String.valueOf(iVar.dzD));
                    }
                    gt.append("ishttp", iVar.dzx ? "1" : "0");
                    gt.append("issuccess", iVar.isSuccess ? "1" : "0");
                    gt.append("nettype", m.aOA().getNetType());
                    gt.append("qt", String.valueOf(iVar.dzn));
                    gt.append("connt", String.valueOf(iVar.dzo));
                    gt.append("rwt", String.valueOf(iVar.dzp));
                    gt.append("dect", String.valueOf(iVar.dzq));
                    gt.append("parset", String.valueOf(iVar.dzr));
                    gt.append("rendert", String.valueOf(iVar.dzt));
                    gt.append("ss", String.valueOf(iVar.dzv));
                    gt.append("hs", String.valueOf(iVar.dzw));
                    if (iVar.dzx && iVar.socketErrNo != 0) {
                        gt.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            gt.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        gt.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, gt);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.aOA().aOB() && iVar.dzE > 0) {
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("action", "time");
            gt.append("pct", String.valueOf(iVar.dzE));
            switch (i) {
                case 0:
                    gt.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    gt.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, gt);
        }
    }
}
