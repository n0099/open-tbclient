package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.PD().PE()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "time");
            jB.append("ishttp", iVar.bgO ? "1" : "0");
            jB.append("issuccess", iVar.isSuccess ? "1" : "0");
            jB.append("nettype", m.PD().getNetType());
            jB.append("wt", String.valueOf(iVar.bgL));
            jB.append("qt", String.valueOf(iVar.bgE));
            jB.append("connt", String.valueOf(iVar.bgF));
            jB.append("rwt", String.valueOf(iVar.bgG));
            jB.append("fbt", String.valueOf(iVar.wx));
            jB.append("abt", String.valueOf(iVar.wy));
            jB.append("dect", String.valueOf(iVar.bgH));
            jB.append("parset", String.valueOf(iVar.bgI));
            jB.append("tqt", String.valueOf(iVar.bgJ));
            jB.append("rendert", String.valueOf(iVar.bgK));
            jB.append("ss", String.valueOf(iVar.bgM));
            jB.append("hs", String.valueOf(iVar.bgN));
            if (iVar.bgO && iVar.socketErrNo != 0) {
                jB.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    jB.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.bgO) {
                jB.append("hrtn", String.valueOf(iVar.bgP));
                jB.append("hrtt", String.valueOf(iVar.bgQ));
            }
            if (iVar.errCode != 0) {
                jB.f(AiAppsUBCStatistic.EXT_KEY_ERRCODE, Integer.valueOf(iVar.errCode));
            }
            if (iVar.bgR) {
                jB.append(Config.PLATFORM_TYPE, "1");
            } else {
                jB.append("sysct", String.valueOf(iVar.bgC));
                jB.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.bgD));
            }
            if (iVar.bgO) {
                jB.append("c_logid", String.valueOf(iVar.bgS));
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
        if (hVar != null && str != null && m.PD().PE()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "resource");
            jB.append("actype", str);
            jB.append("issuccess", hVar.isSuccess ? "1" : "0");
            jB.append("isfs", hVar.bgB ? "1" : "0");
            jB.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.NW));
            jB.append("from", String.valueOf(hVar.NV));
            BdStatisticsManager.getInstance().performance(this.subType, jB);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.PD().PE()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "fluency");
            jB.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, jB);
            com.baidu.adp.lib.stats.a jB2 = jB();
            jB2.append("action", "mem");
            jB2.append("memp", String.valueOf(m.PD().PF()));
            BdStatisticsManager.getInstance().performance(this.subType, jB2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.PD().PE()) {
            if (!z || iVar.bgT > 0) {
                if (z || iVar.bgU > 0) {
                    com.baidu.adp.lib.stats.a jB = jB();
                    jB.append("action", "time");
                    if (z) {
                        jB.append("put", String.valueOf(iVar.bgT));
                    } else {
                        jB.append("pdt", String.valueOf(iVar.bgU));
                    }
                    jB.append("ishttp", iVar.bgO ? "1" : "0");
                    jB.append("issuccess", iVar.isSuccess ? "1" : "0");
                    jB.append("nettype", m.PD().getNetType());
                    jB.append("qt", String.valueOf(iVar.bgE));
                    jB.append("connt", String.valueOf(iVar.bgF));
                    jB.append("rwt", String.valueOf(iVar.bgG));
                    jB.append("dect", String.valueOf(iVar.bgH));
                    jB.append("parset", String.valueOf(iVar.bgI));
                    jB.append("rendert", String.valueOf(iVar.bgK));
                    jB.append("ss", String.valueOf(iVar.bgM));
                    jB.append("hs", String.valueOf(iVar.bgN));
                    if (iVar.bgO && iVar.socketErrNo != 0) {
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
        if (m.PD().PE() && iVar.bgV > 0) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "time");
            jB.append("pct", String.valueOf(iVar.bgV));
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
