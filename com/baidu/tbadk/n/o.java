package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.aRq().aRr()) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "time");
            gs.append("ishttp", iVar.dEl ? "1" : "0");
            gs.append("issuccess", iVar.isSuccess ? "1" : "0");
            gs.append("nettype", m.aRq().getNetType());
            gs.append("wt", String.valueOf(iVar.dEi));
            gs.append("qt", String.valueOf(iVar.dEa));
            gs.append("connt", String.valueOf(iVar.dEb));
            gs.append("rwt", String.valueOf(iVar.dEc));
            gs.append("fbt", String.valueOf(iVar.firstByteReachTime));
            gs.append("abt", String.valueOf(iVar.allDataReadTime));
            gs.append("dect", String.valueOf(iVar.dEd));
            gs.append("parset", String.valueOf(iVar.dEe));
            gs.append("tqt", String.valueOf(iVar.dEg));
            gs.append("rendert", String.valueOf(iVar.dEh));
            gs.append("ss", String.valueOf(iVar.dEj));
            gs.append("hs", String.valueOf(iVar.dEk));
            if (iVar.dEl && iVar.socketErrNo != 0) {
                gs.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    gs.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.dEl) {
                gs.append("hrtn", String.valueOf(iVar.dEm));
                gs.append("hrtt", String.valueOf(iVar.dEn));
            }
            if (iVar.errCode != 0) {
                gs.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.dEo) {
                gs.append("pt", "1");
            } else {
                gs.append("sysct", String.valueOf(iVar.dDX));
                gs.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.dDZ));
                gs.append("lt", String.valueOf(iVar.dDY));
                gs.append("df", String.valueOf(iVar.dEf));
            }
            if (iVar.dEl) {
                gs.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.dEp));
                if (iVar.sequenceID != 0) {
                    gs.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                gs.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, gs);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.aRq().aRr()) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "resource");
            gs.append("actype", str);
            gs.append("issuccess", hVar.isSuccess ? "1" : "0");
            gs.append("isfs", hVar.dDW ? "1" : "0");
            gs.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            gs.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, gs);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.aRq().aRr()) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "fluency");
            gs.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, gs);
            com.baidu.adp.lib.stats.a gs2 = gs();
            gs2.append("action", "mem");
            gs2.append("memp", String.valueOf(m.aRq().aRs()));
            BdStatisticsManager.getInstance().performance(this.subType, gs2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.aRq().aRr()) {
            if (!z || iVar.dEq > 0) {
                if (z || iVar.dEr > 0) {
                    com.baidu.adp.lib.stats.a gs = gs();
                    gs.append("action", "time");
                    if (z) {
                        gs.append("put", String.valueOf(iVar.dEq));
                    } else {
                        gs.append("pdt", String.valueOf(iVar.dEr));
                    }
                    gs.append("ishttp", iVar.dEl ? "1" : "0");
                    gs.append("issuccess", iVar.isSuccess ? "1" : "0");
                    gs.append("nettype", m.aRq().getNetType());
                    gs.append("qt", String.valueOf(iVar.dEa));
                    gs.append("connt", String.valueOf(iVar.dEb));
                    gs.append("rwt", String.valueOf(iVar.dEc));
                    gs.append("dect", String.valueOf(iVar.dEd));
                    gs.append("parset", String.valueOf(iVar.dEe));
                    gs.append("rendert", String.valueOf(iVar.dEh));
                    gs.append("ss", String.valueOf(iVar.dEj));
                    gs.append("hs", String.valueOf(iVar.dEk));
                    if (iVar.dEl && iVar.socketErrNo != 0) {
                        gs.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            gs.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        gs.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, gs);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.aRq().aRr() && iVar.dEs > 0) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "time");
            gs.append("pct", String.valueOf(iVar.dEs));
            switch (i) {
                case 0:
                    gs.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    gs.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, gs);
        }
    }
}
