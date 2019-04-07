package com.baidu.tbadk.o;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.o.o
    public void a(i iVar) {
        if (m.apg().aph()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "time_t");
            a(jC, iVar);
            jC.append("ishttp", iVar.cqB ? "1" : "0");
            jC.append("issuccess", iVar.isSuccess ? "1" : "0");
            jC.append("nettype", m.apg().getNetType());
            jC.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cqq));
            jC.append("wt", String.valueOf(iVar.cqy));
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
            if (iVar.cqB) {
                jC.append("c_logid", String.valueOf(iVar.cqF));
            } else {
                jC.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, jC);
        }
    }

    @Override // com.baidu.tbadk.o.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.apg().aph()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "resource_t");
            jC.append("actype", str);
            jC.append("issuccess", hVar.isSuccess ? "1" : "0");
            jC.append("isfs", hVar.cqo ? "1" : "0");
            jC.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.Oi));
            jC.append("from", String.valueOf(hVar.Oh));
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
        if (m.apg().aph()) {
            if (!z || iVar.cqG > 0) {
                if (z || iVar.cqH > 0) {
                    com.baidu.adp.lib.stats.a jC = jC();
                    jC.append("action", "time_t");
                    a(jC, iVar);
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

    @Override // com.baidu.tbadk.o.o
    public void a(i iVar, int i) {
        if (m.apg().aph() && iVar.cqI > 0) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "time_t");
            a(jC, iVar);
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
