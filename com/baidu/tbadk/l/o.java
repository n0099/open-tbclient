package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.Pl().Pm()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "time");
            jB.append("ishttp", iVar.bgc ? "1" : "0");
            jB.append("issuccess", iVar.isSuccess ? "1" : "0");
            jB.append("nettype", m.Pl().getNetType());
            jB.append("wt", String.valueOf(iVar.bfZ));
            jB.append("qt", String.valueOf(iVar.bfS));
            jB.append("connt", String.valueOf(iVar.bfT));
            jB.append("rwt", String.valueOf(iVar.bfU));
            jB.append("fbt", String.valueOf(iVar.wx));
            jB.append("abt", String.valueOf(iVar.wy));
            jB.append("dect", String.valueOf(iVar.bfV));
            jB.append("parset", String.valueOf(iVar.bfW));
            jB.append("tqt", String.valueOf(iVar.bfX));
            jB.append("rendert", String.valueOf(iVar.bfY));
            jB.append("ss", String.valueOf(iVar.bga));
            jB.append("hs", String.valueOf(iVar.bgb));
            if (iVar.bgc && iVar.socketErrNo != 0) {
                jB.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    jB.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.bgc) {
                jB.append("hrtn", String.valueOf(iVar.bgd));
                jB.append("hrtt", String.valueOf(iVar.bge));
            }
            if (iVar.errCode != 0) {
                jB.f(AiAppsUBCStatistic.EXT_KEY_ERRCODE, Integer.valueOf(iVar.errCode));
            }
            if (iVar.bgf) {
                jB.append(Config.PLATFORM_TYPE, "1");
            } else {
                jB.append("sysct", String.valueOf(iVar.bfQ));
                jB.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.bfR));
            }
            if (iVar.bgc) {
                jB.append("c_logid", String.valueOf(iVar.bgg));
                if (iVar.sequenceID != 0) {
                    jB.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                jB.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, jB);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.Pl().Pm()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "resource");
            jB.append("actype", str);
            jB.append("issuccess", hVar.isSuccess ? "1" : "0");
            jB.append("isfs", hVar.bfP ? "1" : "0");
            jB.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.NL));
            jB.append("from", String.valueOf(hVar.NK));
            BdStatisticsManager.getInstance().performance(this.subType, jB);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.Pl().Pm()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "fluency");
            jB.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, jB);
            com.baidu.adp.lib.stats.a jB2 = jB();
            jB2.append("action", "mem");
            jB2.append("memp", String.valueOf(m.Pl().Pn()));
            BdStatisticsManager.getInstance().performance(this.subType, jB2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.Pl().Pm()) {
            if (!z || iVar.bgh > 0) {
                if (z || iVar.bgi > 0) {
                    com.baidu.adp.lib.stats.a jB = jB();
                    jB.append("action", "time");
                    if (z) {
                        jB.append("put", String.valueOf(iVar.bgh));
                    } else {
                        jB.append("pdt", String.valueOf(iVar.bgi));
                    }
                    jB.append("ishttp", iVar.bgc ? "1" : "0");
                    jB.append("issuccess", iVar.isSuccess ? "1" : "0");
                    jB.append("nettype", m.Pl().getNetType());
                    jB.append("qt", String.valueOf(iVar.bfS));
                    jB.append("connt", String.valueOf(iVar.bfT));
                    jB.append("rwt", String.valueOf(iVar.bfU));
                    jB.append("dect", String.valueOf(iVar.bfV));
                    jB.append("parset", String.valueOf(iVar.bfW));
                    jB.append("rendert", String.valueOf(iVar.bfY));
                    jB.append("ss", String.valueOf(iVar.bga));
                    jB.append("hs", String.valueOf(iVar.bgb));
                    if (iVar.bgc && iVar.socketErrNo != 0) {
                        jB.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            jB.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        jB.f(AiAppsUBCStatistic.EXT_KEY_ERRCODE, Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, jB);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.Pl().Pm() && iVar.bgj > 0) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "time");
            jB.append("pct", String.valueOf(iVar.bgj));
            switch (i) {
                case 0:
                    jB.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    jB.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, jB);
        }
    }
}
