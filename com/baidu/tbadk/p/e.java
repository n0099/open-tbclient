package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.p.o
    public void a(i iVar) {
        if (m.auk().aul()) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("action", "time_t");
            a(iw, iVar);
            iw.append("ishttp", iVar.cyJ ? "1" : "0");
            iw.append("issuccess", iVar.isSuccess ? "1" : "0");
            iw.append("nettype", m.auk().getNetType());
            iw.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cyy));
            iw.append("wt", String.valueOf(iVar.cyG));
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
            if (iVar.cyJ) {
                iw.append("c_logid", String.valueOf(iVar.cyN));
            } else {
                iw.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, iw);
        }
    }

    @Override // com.baidu.tbadk.p.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.auk().aul()) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("action", "resource_t");
            iw.append("actype", str);
            iw.append("issuccess", hVar.isSuccess ? "1" : "0");
            iw.append("isfs", hVar.cyw ? "1" : "0");
            iw.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.LQ));
            iw.append("from", String.valueOf(hVar.LP));
            BdStatisticsManager.getInstance().performance(this.subType, iw);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.c("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.p.o
    public void a(i iVar, boolean z) {
        if (m.auk().aul()) {
            if (!z || iVar.cyO > 0) {
                if (z || iVar.cyP > 0) {
                    com.baidu.adp.lib.stats.a iw = iw();
                    iw.append("action", "time_t");
                    a(iw, iVar);
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

    @Override // com.baidu.tbadk.p.o
    public void a(i iVar, int i) {
        if (m.auk().aul() && iVar.cyQ > 0) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("action", "time_t");
            a(iw, iVar);
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
