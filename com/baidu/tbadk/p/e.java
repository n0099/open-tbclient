package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.p.o
    public void a(i iVar) {
        if (m.avH().avI()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "time_t");
            a(iF, iVar);
            iF.append("ishttp", iVar.cBc ? "1" : "0");
            iF.append("issuccess", iVar.isSuccess ? "1" : "0");
            iF.append("nettype", m.avH().getNetType());
            iF.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cAR));
            iF.append("wt", String.valueOf(iVar.cAZ));
            iF.append("qt", String.valueOf(iVar.cAS));
            iF.append("connt", String.valueOf(iVar.cAT));
            iF.append("rwt", String.valueOf(iVar.cAU));
            iF.append("dect", String.valueOf(iVar.cAV));
            iF.append("parset", String.valueOf(iVar.cAW));
            iF.append("rendert", String.valueOf(iVar.cAY));
            iF.append("ss", String.valueOf(iVar.cBa));
            iF.append("hs", String.valueOf(iVar.cBb));
            if (iVar.cBc && iVar.socketErrNo != 0) {
                iF.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    iF.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                iF.c("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cBc) {
                iF.append("c_logid", String.valueOf(iVar.cBg));
            } else {
                iF.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }

    @Override // com.baidu.tbadk.p.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.avH().avI()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "resource_t");
            iF.append("actype", str);
            iF.append("issuccess", hVar.isSuccess ? "1" : "0");
            iF.append("isfs", hVar.cAP ? "1" : "0");
            iF.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.Me));
            iF.append("from", String.valueOf(hVar.Md));
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.c("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.p.o
    public void a(i iVar, boolean z) {
        if (m.avH().avI()) {
            if (!z || iVar.cBh > 0) {
                if (z || iVar.cBi > 0) {
                    com.baidu.adp.lib.stats.a iF = iF();
                    iF.append("action", "time_t");
                    a(iF, iVar);
                    if (z) {
                        iF.append("put", String.valueOf(iVar.cBh));
                    } else {
                        iF.append("pdt", String.valueOf(iVar.cBi));
                    }
                    iF.append("ishttp", iVar.cBc ? "1" : "0");
                    iF.append("issuccess", iVar.isSuccess ? "1" : "0");
                    iF.append("nettype", m.avH().getNetType());
                    iF.append("qt", String.valueOf(iVar.cAS));
                    iF.append("connt", String.valueOf(iVar.cAT));
                    iF.append("rwt", String.valueOf(iVar.cAU));
                    iF.append("dect", String.valueOf(iVar.cAV));
                    iF.append("parset", String.valueOf(iVar.cAW));
                    iF.append("rendert", String.valueOf(iVar.cAY));
                    iF.append("ss", String.valueOf(iVar.cBa));
                    iF.append("hs", String.valueOf(iVar.cBb));
                    if (iVar.cBc && iVar.socketErrNo != 0) {
                        iF.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            iF.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        iF.c("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, iF);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.p.o
    public void a(i iVar, int i) {
        if (m.avH().avI() && iVar.cBj > 0) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "time_t");
            a(iF, iVar);
            iF.append("pct", String.valueOf(iVar.cBj));
            switch (i) {
                case 0:
                    iF.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    iF.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }
}
