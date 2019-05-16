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
            iw.append("ishttp", iVar.cyI ? "1" : "0");
            iw.append("issuccess", iVar.isSuccess ? "1" : "0");
            iw.append("nettype", m.auk().getNetType());
            iw.append("wt", String.valueOf(iVar.cyF));
            iw.append("qt", String.valueOf(iVar.cyy));
            iw.append("connt", String.valueOf(iVar.cyz));
            iw.append("rwt", String.valueOf(iVar.cyA));
            iw.append("fbt", String.valueOf(iVar.ub));
            iw.append("abt", String.valueOf(iVar.uc));
            iw.append("dect", String.valueOf(iVar.cyB));
            iw.append("parset", String.valueOf(iVar.cyC));
            iw.append("tqt", String.valueOf(iVar.cyD));
            iw.append("rendert", String.valueOf(iVar.cyE));
            iw.append("ss", String.valueOf(iVar.cyG));
            iw.append("hs", String.valueOf(iVar.cyH));
            if (iVar.cyI && iVar.socketErrNo != 0) {
                iw.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    iw.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.cyI) {
                iw.append("hrtn", String.valueOf(iVar.cyJ));
                iw.append("hrtt", String.valueOf(iVar.cyK));
            }
            if (iVar.errCode != 0) {
                iw.c("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cyL) {
                iw.append(Config.PLATFORM_TYPE, "1");
            } else {
                iw.append("sysct", String.valueOf(iVar.cyw));
                iw.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cyx));
            }
            if (iVar.cyI) {
                iw.append("c_logid", String.valueOf(iVar.cyM));
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
            iw.append("isfs", hVar.cyv ? "1" : "0");
            iw.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.LR));
            iw.append("from", String.valueOf(hVar.LQ));
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
            if (!z || iVar.cyN > 0) {
                if (z || iVar.cyO > 0) {
                    com.baidu.adp.lib.stats.a iw = iw();
                    iw.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    if (z) {
                        iw.append("put", String.valueOf(iVar.cyN));
                    } else {
                        iw.append("pdt", String.valueOf(iVar.cyO));
                    }
                    iw.append("ishttp", iVar.cyI ? "1" : "0");
                    iw.append("issuccess", iVar.isSuccess ? "1" : "0");
                    iw.append("nettype", m.auk().getNetType());
                    iw.append("qt", String.valueOf(iVar.cyy));
                    iw.append("connt", String.valueOf(iVar.cyz));
                    iw.append("rwt", String.valueOf(iVar.cyA));
                    iw.append("dect", String.valueOf(iVar.cyB));
                    iw.append("parset", String.valueOf(iVar.cyC));
                    iw.append("rendert", String.valueOf(iVar.cyE));
                    iw.append("ss", String.valueOf(iVar.cyG));
                    iw.append("hs", String.valueOf(iVar.cyH));
                    if (iVar.cyI && iVar.socketErrNo != 0) {
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
        if (m.auk().aul() && iVar.cyP > 0) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            iw.append("pct", String.valueOf(iVar.cyP));
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
