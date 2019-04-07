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
            jC.append("ishttp", iVar.cqB ? "1" : "0");
            jC.append("issuccess", iVar.isSuccess ? "1" : "0");
            jC.append("nettype", m.apg().getNetType());
            jC.append("wt", String.valueOf(iVar.cqy));
            jC.append("qt", String.valueOf(iVar.cqr));
            jC.append("connt", String.valueOf(iVar.cqs));
            jC.append("rwt", String.valueOf(iVar.cqt));
            jC.append("fbt", String.valueOf(iVar.wu));
            jC.append("abt", String.valueOf(iVar.wv));
            jC.append("dect", String.valueOf(iVar.cqu));
            jC.append("parset", String.valueOf(iVar.cqv));
            jC.append("tqt", String.valueOf(iVar.cqw));
            jC.append("rendert", String.valueOf(iVar.cqx));
            jC.append("ss", String.valueOf(iVar.cqz));
            jC.append("hs", String.valueOf(iVar.cqA));
            if (iVar.cqB && iVar.socketErrNo != 0) {
                jC.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    jC.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.cqB) {
                jC.append("hrtn", String.valueOf(iVar.cqC));
                jC.append("hrtt", String.valueOf(iVar.cqD));
            }
            if (iVar.errCode != 0) {
                jC.f("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cqE) {
                jC.append(Config.PLATFORM_TYPE, "1");
            } else {
                jC.append("sysct", String.valueOf(iVar.cqp));
                jC.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cqq));
            }
            if (iVar.cqB) {
                jC.append("c_logid", String.valueOf(iVar.cqF));
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
            jC.append("isfs", hVar.cqo ? "1" : "0");
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
            if (!z || iVar.cqG > 0) {
                if (z || iVar.cqH > 0) {
                    com.baidu.adp.lib.stats.a jC = jC();
                    jC.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    if (z) {
                        jC.append("put", String.valueOf(iVar.cqG));
                    } else {
                        jC.append("pdt", String.valueOf(iVar.cqH));
                    }
                    jC.append("ishttp", iVar.cqB ? "1" : "0");
                    jC.append("issuccess", iVar.isSuccess ? "1" : "0");
                    jC.append("nettype", m.apg().getNetType());
                    jC.append("qt", String.valueOf(iVar.cqr));
                    jC.append("connt", String.valueOf(iVar.cqs));
                    jC.append("rwt", String.valueOf(iVar.cqt));
                    jC.append("dect", String.valueOf(iVar.cqu));
                    jC.append("parset", String.valueOf(iVar.cqv));
                    jC.append("rendert", String.valueOf(iVar.cqx));
                    jC.append("ss", String.valueOf(iVar.cqz));
                    jC.append("hs", String.valueOf(iVar.cqA));
                    if (iVar.cqB && iVar.socketErrNo != 0) {
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
        if (m.apg().aph() && iVar.cqI > 0) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            jC.append("pct", String.valueOf(iVar.cqI));
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
