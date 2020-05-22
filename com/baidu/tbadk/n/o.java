package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.bfI().bfJ()) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("action", "time");
            kY.append("ishttp", iVar.esk ? "1" : "0");
            kY.append("issuccess", iVar.isSuccess ? "1" : "0");
            kY.append("nettype", m.bfI().getNetType());
            kY.append("wt", String.valueOf(iVar.esh));
            kY.append("qt", String.valueOf(iVar.erZ));
            kY.append("connt", String.valueOf(iVar.esa));
            kY.append("rwt", String.valueOf(iVar.esb));
            kY.append("fbt", String.valueOf(iVar.firstByteReachTime));
            kY.append("abt", String.valueOf(iVar.allDataReadTime));
            kY.append("dect", String.valueOf(iVar.esc));
            kY.append("parset", String.valueOf(iVar.esd));
            kY.append("tqt", String.valueOf(iVar.esf));
            kY.append("rendert", String.valueOf(iVar.esg));
            kY.append("ss", String.valueOf(iVar.esi));
            kY.append("hs", String.valueOf(iVar.esj));
            if (iVar.esk && iVar.socketErrNo != 0) {
                kY.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    kY.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.esk) {
                kY.append("hrtn", String.valueOf(iVar.esl));
                kY.append("hrtt", String.valueOf(iVar.esm));
            }
            if (iVar.errCode != 0) {
                kY.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.esn) {
                kY.append("pt", "1");
            } else {
                kY.append("sysct", String.valueOf(iVar.erW));
                kY.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.erY));
                kY.append("lt", String.valueOf(iVar.erX));
                kY.append("df", String.valueOf(iVar.ese));
            }
            if (iVar.esk) {
                kY.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.eso));
                if (iVar.sequenceID != 0) {
                    kY.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                kY.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, kY);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.bfI().bfJ()) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("action", "resource");
            kY.append("actype", str);
            kY.append("issuccess", hVar.isSuccess ? "1" : "0");
            kY.append("isfs", hVar.erV ? "1" : "0");
            kY.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            kY.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, kY);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.bfI().bfJ()) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("action", "fluency");
            kY.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, kY);
            com.baidu.adp.lib.stats.a kY2 = kY();
            kY2.append("action", "mem");
            kY2.append("memp", String.valueOf(m.bfI().bfK()));
            BdStatisticsManager.getInstance().performance(this.subType, kY2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.bfI().bfJ()) {
            if (!z || iVar.esp > 0) {
                if (z || iVar.esq > 0) {
                    com.baidu.adp.lib.stats.a kY = kY();
                    kY.append("action", "time");
                    if (z) {
                        kY.append("put", String.valueOf(iVar.esp));
                    } else {
                        kY.append("pdt", String.valueOf(iVar.esq));
                    }
                    kY.append("ishttp", iVar.esk ? "1" : "0");
                    kY.append("issuccess", iVar.isSuccess ? "1" : "0");
                    kY.append("nettype", m.bfI().getNetType());
                    kY.append("qt", String.valueOf(iVar.erZ));
                    kY.append("connt", String.valueOf(iVar.esa));
                    kY.append("rwt", String.valueOf(iVar.esb));
                    kY.append("dect", String.valueOf(iVar.esc));
                    kY.append("parset", String.valueOf(iVar.esd));
                    kY.append("rendert", String.valueOf(iVar.esg));
                    kY.append("ss", String.valueOf(iVar.esi));
                    kY.append("hs", String.valueOf(iVar.esj));
                    if (iVar.esk && iVar.socketErrNo != 0) {
                        kY.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            kY.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        kY.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, kY);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.bfI().bfJ() && iVar.esr > 0) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("action", "time");
            kY.append("pct", String.valueOf(iVar.esr));
            switch (i) {
                case 0:
                    kY.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    kY.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, kY);
        }
    }
}
