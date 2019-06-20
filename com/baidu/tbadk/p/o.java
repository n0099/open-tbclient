package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.auk().aul()) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            iw.append("ishttp", iVar.cyJ ? "1" : "0");
            iw.append("issuccess", iVar.isSuccess ? "1" : "0");
            iw.append("nettype", m.auk().getNetType());
            iw.append("wt", String.valueOf(iVar.cyG));
            iw.append("qt", String.valueOf(iVar.cyz));
            iw.append("connt", String.valueOf(iVar.cyA));
            iw.append("rwt", String.valueOf(iVar.cyB));
            iw.append("fbt", String.valueOf(iVar.tZ));
            iw.append("abt", String.valueOf(iVar.ub));
            iw.append("dect", String.valueOf(iVar.cyC));
            iw.append("parset", String.valueOf(iVar.cyD));
            iw.append("tqt", String.valueOf(iVar.cyE));
            iw.append("rendert", String.valueOf(iVar.cyF));
            iw.append("ss", String.valueOf(iVar.cyH));
            iw.append("hs", String.valueOf(iVar.cyI));
            if (iVar.cyJ && iVar.socketErrNo != 0) {
                iw.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    iw.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.cyJ) {
                iw.append("hrtn", String.valueOf(iVar.cyK));
                iw.append("hrtt", String.valueOf(iVar.cyL));
            }
            if (iVar.errCode != 0) {
                iw.c("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cyM) {
                iw.append(Config.PLATFORM_TYPE, "1");
            } else {
                iw.append("sysct", String.valueOf(iVar.cyx));
                iw.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cyy));
            }
            if (iVar.cyJ) {
                iw.append("c_logid", String.valueOf(iVar.cyN));
                if (iVar.sequenceID != 0) {
                    iw.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                iw.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, iw);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.auk().aul()) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("action", "resource");
            iw.append("actype", str);
            iw.append("issuccess", hVar.isSuccess ? "1" : "0");
            iw.append("isfs", hVar.cyw ? "1" : "0");
            iw.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.LQ));
            iw.append("from", String.valueOf(hVar.LP));
            BdStatisticsManager.getInstance().performance(this.subType, iw);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.auk().aul()) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("action", "fluency");
            iw.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, iw);
            com.baidu.adp.lib.stats.a iw2 = iw();
            iw2.append("action", "mem");
            iw2.append("memp", String.valueOf(m.auk().aum()));
            BdStatisticsManager.getInstance().performance(this.subType, iw2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.auk().aul()) {
            if (!z || iVar.cyO > 0) {
                if (z || iVar.cyP > 0) {
                    com.baidu.adp.lib.stats.a iw = iw();
                    iw.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    if (z) {
                        iw.append("put", String.valueOf(iVar.cyO));
                    } else {
                        iw.append("pdt", String.valueOf(iVar.cyP));
                    }
                    iw.append("ishttp", iVar.cyJ ? "1" : "0");
                    iw.append("issuccess", iVar.isSuccess ? "1" : "0");
                    iw.append("nettype", m.auk().getNetType());
                    iw.append("qt", String.valueOf(iVar.cyz));
                    iw.append("connt", String.valueOf(iVar.cyA));
                    iw.append("rwt", String.valueOf(iVar.cyB));
                    iw.append("dect", String.valueOf(iVar.cyC));
                    iw.append("parset", String.valueOf(iVar.cyD));
                    iw.append("rendert", String.valueOf(iVar.cyF));
                    iw.append("ss", String.valueOf(iVar.cyH));
                    iw.append("hs", String.valueOf(iVar.cyI));
                    if (iVar.cyJ && iVar.socketErrNo != 0) {
                        iw.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            iw.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        iw.c("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, iw);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.auk().aul() && iVar.cyQ > 0) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            iw.append("pct", String.valueOf(iVar.cyQ));
            switch (i) {
                case 0:
                    iw.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    iw.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, iw);
        }
    }
}
