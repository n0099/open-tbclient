package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.awL().awM()) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "time");
            fU.append("ishttp", iVar.cLu ? "1" : "0");
            fU.append("issuccess", iVar.isSuccess ? "1" : "0");
            fU.append("nettype", m.awL().getNetType());
            fU.append("wt", String.valueOf(iVar.cLr));
            fU.append("qt", String.valueOf(iVar.cLk));
            fU.append("connt", String.valueOf(iVar.cLl));
            fU.append("rwt", String.valueOf(iVar.cLm));
            fU.append("fbt", String.valueOf(iVar.firstByteReachTime));
            fU.append("abt", String.valueOf(iVar.allDataReadTime));
            fU.append("dect", String.valueOf(iVar.cLn));
            fU.append("parset", String.valueOf(iVar.cLo));
            fU.append("tqt", String.valueOf(iVar.cLp));
            fU.append("rendert", String.valueOf(iVar.cLq));
            fU.append("ss", String.valueOf(iVar.cLs));
            fU.append("hs", String.valueOf(iVar.cLt));
            if (iVar.cLu && iVar.socketErrNo != 0) {
                fU.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    fU.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.cLu) {
                fU.append("hrtn", String.valueOf(iVar.cLv));
                fU.append("hrtt", String.valueOf(iVar.cLw));
            }
            if (iVar.errCode != 0) {
                fU.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cLx) {
                fU.append("pt", "1");
            } else {
                fU.append("sysct", String.valueOf(iVar.cLi));
                fU.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cLj));
            }
            if (iVar.cLu) {
                fU.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.cLy));
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
        if (hVar != null && str != null && m.awL().awM()) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "resource");
            fU.append("actype", str);
            fU.append("issuccess", hVar.isSuccess ? "1" : "0");
            fU.append("isfs", hVar.cLh ? "1" : "0");
            fU.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            fU.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, fU);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.awL().awM()) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "fluency");
            fU.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, fU);
            com.baidu.adp.lib.stats.a fU2 = fU();
            fU2.append("action", "mem");
            fU2.append("memp", String.valueOf(m.awL().awN()));
            BdStatisticsManager.getInstance().performance(this.subType, fU2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.awL().awM()) {
            if (!z || iVar.cLz > 0) {
                if (z || iVar.cLA > 0) {
                    com.baidu.adp.lib.stats.a fU = fU();
                    fU.append("action", "time");
                    if (z) {
                        fU.append("put", String.valueOf(iVar.cLz));
                    } else {
                        fU.append("pdt", String.valueOf(iVar.cLA));
                    }
                    fU.append("ishttp", iVar.cLu ? "1" : "0");
                    fU.append("issuccess", iVar.isSuccess ? "1" : "0");
                    fU.append("nettype", m.awL().getNetType());
                    fU.append("qt", String.valueOf(iVar.cLk));
                    fU.append("connt", String.valueOf(iVar.cLl));
                    fU.append("rwt", String.valueOf(iVar.cLm));
                    fU.append("dect", String.valueOf(iVar.cLn));
                    fU.append("parset", String.valueOf(iVar.cLo));
                    fU.append("rendert", String.valueOf(iVar.cLq));
                    fU.append("ss", String.valueOf(iVar.cLs));
                    fU.append("hs", String.valueOf(iVar.cLt));
                    if (iVar.cLu && iVar.socketErrNo != 0) {
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
        if (m.awL().awM() && iVar.cLB > 0) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "time");
            fU.append("pct", String.valueOf(iVar.cLB));
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
