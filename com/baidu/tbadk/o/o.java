package com.baidu.tbadk.o;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.apg().aph()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            jC.append("ishttp", iVar.cqC ? "1" : "0");
            jC.append("issuccess", iVar.isSuccess ? "1" : "0");
            jC.append("nettype", m.apg().getNetType());
            jC.append("wt", String.valueOf(iVar.cqz));
            jC.append("qt", String.valueOf(iVar.cqs));
            jC.append("connt", String.valueOf(iVar.cqt));
            jC.append("rwt", String.valueOf(iVar.cqu));
            jC.append("fbt", String.valueOf(iVar.wu));
            jC.append("abt", String.valueOf(iVar.wv));
            jC.append("dect", String.valueOf(iVar.cqv));
            jC.append("parset", String.valueOf(iVar.cqw));
            jC.append("tqt", String.valueOf(iVar.cqx));
            jC.append("rendert", String.valueOf(iVar.cqy));
            jC.append("ss", String.valueOf(iVar.cqA));
            jC.append("hs", String.valueOf(iVar.cqB));
            if (iVar.cqC && iVar.socketErrNo != 0) {
                jC.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    jC.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.cqC) {
                jC.append("hrtn", String.valueOf(iVar.cqD));
                jC.append("hrtt", String.valueOf(iVar.cqE));
            }
            if (iVar.errCode != 0) {
                jC.f("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cqF) {
                jC.append(Config.PLATFORM_TYPE, "1");
            } else {
                jC.append("sysct", String.valueOf(iVar.cqq));
                jC.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cqr));
            }
            if (iVar.cqC) {
                jC.append("c_logid", String.valueOf(iVar.cqG));
                if (iVar.sequenceID != 0) {
                    jC.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                jC.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, jC);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.apg().aph()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "resource");
            jC.append("actype", str);
            jC.append("issuccess", hVar.isSuccess ? "1" : "0");
            jC.append("isfs", hVar.cqp ? "1" : "0");
            jC.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.Oi));
            jC.append("from", String.valueOf(hVar.Oh));
            BdStatisticsManager.getInstance().performance(this.subType, jC);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.apg().aph()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "fluency");
            jC.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, jC);
            com.baidu.adp.lib.stats.a jC2 = jC();
            jC2.append("action", "mem");
            jC2.append("memp", String.valueOf(m.apg().apj()));
            BdStatisticsManager.getInstance().performance(this.subType, jC2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.apg().aph()) {
            if (!z || iVar.cqH > 0) {
                if (z || iVar.cqI > 0) {
                    com.baidu.adp.lib.stats.a jC = jC();
                    jC.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    if (z) {
                        jC.append("put", String.valueOf(iVar.cqH));
                    } else {
                        jC.append("pdt", String.valueOf(iVar.cqI));
                    }
                    jC.append("ishttp", iVar.cqC ? "1" : "0");
                    jC.append("issuccess", iVar.isSuccess ? "1" : "0");
                    jC.append("nettype", m.apg().getNetType());
                    jC.append("qt", String.valueOf(iVar.cqs));
                    jC.append("connt", String.valueOf(iVar.cqt));
                    jC.append("rwt", String.valueOf(iVar.cqu));
                    jC.append("dect", String.valueOf(iVar.cqv));
                    jC.append("parset", String.valueOf(iVar.cqw));
                    jC.append("rendert", String.valueOf(iVar.cqy));
                    jC.append("ss", String.valueOf(iVar.cqA));
                    jC.append("hs", String.valueOf(iVar.cqB));
                    if (iVar.cqC && iVar.socketErrNo != 0) {
                        jC.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            jC.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        jC.f("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, jC);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.apg().aph() && iVar.cqJ > 0) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            jC.append("pct", String.valueOf(iVar.cqJ));
            switch (i) {
                case 0:
                    jC.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    jC.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, jC);
        }
    }
}
