package com.baidu.tbadk.o;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.o.o
    public void a(i iVar) {
        if (m.apl().apm()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "time_t");
            a(jC, iVar);
            jC.append("ishttp", iVar.cqz ? "1" : "0");
            jC.append("issuccess", iVar.isSuccess ? "1" : "0");
            jC.append("nettype", m.apl().getNetType());
            jC.append("ct", String.valueOf(iVar.cqo));
            jC.append("wt", String.valueOf(iVar.cqw));
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
            if (iVar.cqz) {
                jC.append("c_logid", String.valueOf(iVar.cqD));
            } else {
                jC.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, jC);
        }
    }

    @Override // com.baidu.tbadk.o.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.apl().apm()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "resource_t");
            jC.append("actype", str);
            jC.append("issuccess", hVar.isSuccess ? "1" : "0");
            jC.append("isfs", hVar.cqm ? "1" : "0");
            jC.append("ct", String.valueOf(hVar.Oh));
            jC.append("from", String.valueOf(hVar.Og));
            BdStatisticsManager.getInstance().performance(this.subType, jC);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.f("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.o.o
    public void a(i iVar, boolean z) {
        if (m.apl().apm()) {
            if (!z || iVar.cqE > 0) {
                if (z || iVar.cqF > 0) {
                    com.baidu.adp.lib.stats.a jC = jC();
                    jC.append("action", "time_t");
                    a(jC, iVar);
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

    @Override // com.baidu.tbadk.o.o
    public void a(i iVar, int i) {
        if (m.apl().apm() && iVar.cqG > 0) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "time_t");
            a(jC, iVar);
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
