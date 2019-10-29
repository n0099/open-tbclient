package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.awN().awO()) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "time");
            fU.append("ishttp", iVar.cMl ? "1" : "0");
            fU.append("issuccess", iVar.isSuccess ? "1" : "0");
            fU.append("nettype", m.awN().getNetType());
            fU.append("wt", String.valueOf(iVar.cMi));
            fU.append("qt", String.valueOf(iVar.cMb));
            fU.append("connt", String.valueOf(iVar.cMc));
            fU.append("rwt", String.valueOf(iVar.cMd));
            fU.append("fbt", String.valueOf(iVar.firstByteReachTime));
            fU.append("abt", String.valueOf(iVar.allDataReadTime));
            fU.append("dect", String.valueOf(iVar.cMe));
            fU.append("parset", String.valueOf(iVar.cMf));
            fU.append("tqt", String.valueOf(iVar.cMg));
            fU.append("rendert", String.valueOf(iVar.cMh));
            fU.append("ss", String.valueOf(iVar.cMj));
            fU.append("hs", String.valueOf(iVar.cMk));
            if (iVar.cMl && iVar.socketErrNo != 0) {
                fU.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    fU.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.cMl) {
                fU.append("hrtn", String.valueOf(iVar.cMm));
                fU.append("hrtt", String.valueOf(iVar.cMn));
            }
            if (iVar.errCode != 0) {
                fU.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cMo) {
                fU.append("pt", "1");
            } else {
                fU.append("sysct", String.valueOf(iVar.cLZ));
                fU.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cMa));
            }
            if (iVar.cMl) {
                fU.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.cMp));
                if (iVar.sequenceID != 0) {
                    fU.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                fU.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fU);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.awN().awO()) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "resource");
            fU.append("actype", str);
            fU.append("issuccess", hVar.isSuccess ? "1" : "0");
            fU.append("isfs", hVar.cLY ? "1" : "0");
            fU.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            fU.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, fU);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.awN().awO()) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "fluency");
            fU.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, fU);
            com.baidu.adp.lib.stats.a fU2 = fU();
            fU2.append("action", "mem");
            fU2.append("memp", String.valueOf(m.awN().awP()));
            BdStatisticsManager.getInstance().performance(this.subType, fU2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.awN().awO()) {
            if (!z || iVar.cMq > 0) {
                if (z || iVar.cMr > 0) {
                    com.baidu.adp.lib.stats.a fU = fU();
                    fU.append("action", "time");
                    if (z) {
                        fU.append("put", String.valueOf(iVar.cMq));
                    } else {
                        fU.append("pdt", String.valueOf(iVar.cMr));
                    }
                    fU.append("ishttp", iVar.cMl ? "1" : "0");
                    fU.append("issuccess", iVar.isSuccess ? "1" : "0");
                    fU.append("nettype", m.awN().getNetType());
                    fU.append("qt", String.valueOf(iVar.cMb));
                    fU.append("connt", String.valueOf(iVar.cMc));
                    fU.append("rwt", String.valueOf(iVar.cMd));
                    fU.append("dect", String.valueOf(iVar.cMe));
                    fU.append("parset", String.valueOf(iVar.cMf));
                    fU.append("rendert", String.valueOf(iVar.cMh));
                    fU.append("ss", String.valueOf(iVar.cMj));
                    fU.append("hs", String.valueOf(iVar.cMk));
                    if (iVar.cMl && iVar.socketErrNo != 0) {
                        fU.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            fU.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        fU.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, fU);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.awN().awO() && iVar.cMs > 0) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "time");
            fU.append("pct", String.valueOf(iVar.cMs));
            switch (i) {
                case 0:
                    fU.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    fU.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, fU);
        }
    }
}
