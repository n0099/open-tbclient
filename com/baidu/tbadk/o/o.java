package com.baidu.tbadk.o;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.apl().apm()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            jC.append("ishttp", iVar.cqz ? "1" : "0");
            jC.append("issuccess", iVar.isSuccess ? "1" : "0");
            jC.append("nettype", m.apl().getNetType());
            jC.append("wt", String.valueOf(iVar.cqw));
            jC.append("qt", String.valueOf(iVar.cqp));
            jC.append("connt", String.valueOf(iVar.cqq));
            jC.append("rwt", String.valueOf(iVar.cqr));
            jC.append("fbt", String.valueOf(iVar.wu));
            jC.append("abt", String.valueOf(iVar.wv));
            jC.append("dect", String.valueOf(iVar.cqs));
            jC.append("parset", String.valueOf(iVar.cqt));
            jC.append("tqt", String.valueOf(iVar.cqu));
            jC.append("rendert", String.valueOf(iVar.cqv));
            jC.append("ss", String.valueOf(iVar.cqx));
            jC.append("hs", String.valueOf(iVar.cqy));
            if (iVar.cqz && iVar.socketErrNo != 0) {
                jC.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    jC.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.cqz) {
                jC.append("hrtn", String.valueOf(iVar.cqA));
                jC.append("hrtt", String.valueOf(iVar.cqB));
            }
            if (iVar.errCode != 0) {
                jC.f("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cqC) {
                jC.append("pt", "1");
            } else {
                jC.append("sysct", String.valueOf(iVar.cqn));
                jC.append("ct", String.valueOf(iVar.cqo));
            }
            if (iVar.cqz) {
                jC.append("c_logid", String.valueOf(iVar.cqD));
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
        if (hVar != null && str != null && m.apl().apm()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "resource");
            jC.append("actype", str);
            jC.append("issuccess", hVar.isSuccess ? "1" : "0");
            jC.append("isfs", hVar.cqm ? "1" : "0");
            jC.append("ct", String.valueOf(hVar.Oh));
            jC.append("from", String.valueOf(hVar.Og));
            BdStatisticsManager.getInstance().performance(this.subType, jC);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.apl().apm()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "fluency");
            jC.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, jC);
            com.baidu.adp.lib.stats.a jC2 = jC();
            jC2.append("action", "mem");
            jC2.append("memp", String.valueOf(m.apl().apn()));
            BdStatisticsManager.getInstance().performance(this.subType, jC2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.apl().apm()) {
            if (!z || iVar.cqE > 0) {
                if (z || iVar.cqF > 0) {
                    com.baidu.adp.lib.stats.a jC = jC();
                    jC.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    if (z) {
                        jC.append("put", String.valueOf(iVar.cqE));
                    } else {
                        jC.append("pdt", String.valueOf(iVar.cqF));
                    }
                    jC.append("ishttp", iVar.cqz ? "1" : "0");
                    jC.append("issuccess", iVar.isSuccess ? "1" : "0");
                    jC.append("nettype", m.apl().getNetType());
                    jC.append("qt", String.valueOf(iVar.cqp));
                    jC.append("connt", String.valueOf(iVar.cqq));
                    jC.append("rwt", String.valueOf(iVar.cqr));
                    jC.append("dect", String.valueOf(iVar.cqs));
                    jC.append("parset", String.valueOf(iVar.cqt));
                    jC.append("rendert", String.valueOf(iVar.cqv));
                    jC.append("ss", String.valueOf(iVar.cqx));
                    jC.append("hs", String.valueOf(iVar.cqy));
                    if (iVar.cqz && iVar.socketErrNo != 0) {
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
        if (m.apl().apm() && iVar.cqG > 0) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            jC.append("pct", String.valueOf(iVar.cqG));
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
