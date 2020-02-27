package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.aRj().aRk()) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "time");
            gs.append("ishttp", iVar.dDH ? "1" : "0");
            gs.append("issuccess", iVar.isSuccess ? "1" : "0");
            gs.append("nettype", m.aRj().getNetType());
            gs.append("wt", String.valueOf(iVar.dDE));
            gs.append("qt", String.valueOf(iVar.dDx));
            gs.append("connt", String.valueOf(iVar.dDy));
            gs.append("rwt", String.valueOf(iVar.dDz));
            gs.append("fbt", String.valueOf(iVar.firstByteReachTime));
            gs.append("abt", String.valueOf(iVar.allDataReadTime));
            gs.append("dect", String.valueOf(iVar.dDA));
            gs.append("parset", String.valueOf(iVar.dDB));
            gs.append("tqt", String.valueOf(iVar.dDC));
            gs.append("rendert", String.valueOf(iVar.dDD));
            gs.append("ss", String.valueOf(iVar.dDF));
            gs.append("hs", String.valueOf(iVar.dDG));
            if (iVar.dDH && iVar.socketErrNo != 0) {
                gs.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    gs.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.dDH) {
                gs.append("hrtn", String.valueOf(iVar.dDI));
                gs.append("hrtt", String.valueOf(iVar.dDJ));
            }
            if (iVar.errCode != 0) {
                gs.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.dDK) {
                gs.append("pt", "1");
            } else {
                gs.append("sysct", String.valueOf(iVar.dDv));
                gs.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.dDw));
            }
            if (iVar.dDH) {
                gs.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.dDL));
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
        if (hVar != null && str != null && m.aRj().aRk()) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "resource");
            gs.append("actype", str);
            gs.append("issuccess", hVar.isSuccess ? "1" : "0");
            gs.append("isfs", hVar.dDu ? "1" : "0");
            gs.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            gs.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, gs);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.aRj().aRk()) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "fluency");
            gs.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, gs);
            com.baidu.adp.lib.stats.a gs2 = gs();
            gs2.append("action", "mem");
            gs2.append("memp", String.valueOf(m.aRj().aRl()));
            BdStatisticsManager.getInstance().performance(this.subType, gs2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.aRj().aRk()) {
            if (!z || iVar.dDM > 0) {
                if (z || iVar.dDN > 0) {
                    com.baidu.adp.lib.stats.a gs = gs();
                    gs.append("action", "time");
                    if (z) {
                        gs.append("put", String.valueOf(iVar.dDM));
                    } else {
                        gs.append("pdt", String.valueOf(iVar.dDN));
                    }
                    gs.append("ishttp", iVar.dDH ? "1" : "0");
                    gs.append("issuccess", iVar.isSuccess ? "1" : "0");
                    gs.append("nettype", m.aRj().getNetType());
                    gs.append("qt", String.valueOf(iVar.dDx));
                    gs.append("connt", String.valueOf(iVar.dDy));
                    gs.append("rwt", String.valueOf(iVar.dDz));
                    gs.append("dect", String.valueOf(iVar.dDA));
                    gs.append("parset", String.valueOf(iVar.dDB));
                    gs.append("rendert", String.valueOf(iVar.dDD));
                    gs.append("ss", String.valueOf(iVar.dDF));
                    gs.append("hs", String.valueOf(iVar.dDG));
                    if (iVar.dDH && iVar.socketErrNo != 0) {
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
        if (m.aRj().aRk() && iVar.dDO > 0) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "time");
            gs.append("pct", String.valueOf(iVar.dDO));
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
