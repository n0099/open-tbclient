package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.p.o
    public void a(i iVar) {
        if (m.avt().avu()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "time_t");
            a(iF, iVar);
            iF.append("ishttp", iVar.czZ ? "1" : "0");
            iF.append("issuccess", iVar.isSuccess ? "1" : "0");
            iF.append("nettype", m.avt().getNetType());
            iF.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.czO));
            iF.append("wt", String.valueOf(iVar.czW));
            iF.append("qt", String.valueOf(iVar.czP));
            iF.append("connt", String.valueOf(iVar.czQ));
            iF.append("rwt", String.valueOf(iVar.czR));
            iF.append("dect", String.valueOf(iVar.czS));
            iF.append("parset", String.valueOf(iVar.czT));
            iF.append("rendert", String.valueOf(iVar.czV));
            iF.append("ss", String.valueOf(iVar.czX));
            iF.append("hs", String.valueOf(iVar.czY));
            if (iVar.czZ && iVar.socketErrNo != 0) {
                iF.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    iF.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                iF.c("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.czZ) {
                iF.append("c_logid", String.valueOf(iVar.cAd));
            } else {
                iF.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }

    @Override // com.baidu.tbadk.p.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.avt().avu()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "resource_t");
            iF.append("actype", str);
            iF.append("issuccess", hVar.isSuccess ? "1" : "0");
            iF.append("isfs", hVar.czM ? "1" : "0");
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
        if (m.avt().avu()) {
            if (!z || iVar.cAe > 0) {
                if (z || iVar.cAf > 0) {
                    com.baidu.adp.lib.stats.a iF = iF();
                    iF.append("action", "time_t");
                    a(iF, iVar);
                    if (z) {
                        iF.append("put", String.valueOf(iVar.cAe));
                    } else {
                        iF.append("pdt", String.valueOf(iVar.cAf));
                    }
                    iF.append("ishttp", iVar.czZ ? "1" : "0");
                    iF.append("issuccess", iVar.isSuccess ? "1" : "0");
                    iF.append("nettype", m.avt().getNetType());
                    iF.append("qt", String.valueOf(iVar.czP));
                    iF.append("connt", String.valueOf(iVar.czQ));
                    iF.append("rwt", String.valueOf(iVar.czR));
                    iF.append("dect", String.valueOf(iVar.czS));
                    iF.append("parset", String.valueOf(iVar.czT));
                    iF.append("rendert", String.valueOf(iVar.czV));
                    iF.append("ss", String.valueOf(iVar.czX));
                    iF.append("hs", String.valueOf(iVar.czY));
                    if (iVar.czZ && iVar.socketErrNo != 0) {
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
        if (m.avt().avu() && iVar.cAg > 0) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "time_t");
            a(iF, iVar);
            iF.append("pct", String.valueOf(iVar.cAg));
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
