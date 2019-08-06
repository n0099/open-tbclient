package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.p.o
    public void a(i iVar) {
        if (m.avv().avw()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "time_t");
            a(iF, iVar);
            iF.append("ishttp", iVar.cAg ? "1" : "0");
            iF.append("issuccess", iVar.isSuccess ? "1" : "0");
            iF.append("nettype", m.avv().getNetType());
            iF.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.czV));
            iF.append("wt", String.valueOf(iVar.cAd));
            iF.append("qt", String.valueOf(iVar.czW));
            iF.append("connt", String.valueOf(iVar.czX));
            iF.append("rwt", String.valueOf(iVar.czY));
            iF.append("dect", String.valueOf(iVar.czZ));
            iF.append("parset", String.valueOf(iVar.cAa));
            iF.append("rendert", String.valueOf(iVar.cAc));
            iF.append("ss", String.valueOf(iVar.cAe));
            iF.append("hs", String.valueOf(iVar.cAf));
            if (iVar.cAg && iVar.socketErrNo != 0) {
                iF.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    iF.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                iF.c("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cAg) {
                iF.append("c_logid", String.valueOf(iVar.cAk));
            } else {
                iF.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }

    @Override // com.baidu.tbadk.p.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.avv().avw()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "resource_t");
            iF.append("actype", str);
            iF.append("issuccess", hVar.isSuccess ? "1" : "0");
            iF.append("isfs", hVar.czT ? "1" : "0");
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
        if (m.avv().avw()) {
            if (!z || iVar.cAl > 0) {
                if (z || iVar.cAm > 0) {
                    com.baidu.adp.lib.stats.a iF = iF();
                    iF.append("action", "time_t");
                    a(iF, iVar);
                    if (z) {
                        iF.append("put", String.valueOf(iVar.cAl));
                    } else {
                        iF.append("pdt", String.valueOf(iVar.cAm));
                    }
                    iF.append("ishttp", iVar.cAg ? "1" : "0");
                    iF.append("issuccess", iVar.isSuccess ? "1" : "0");
                    iF.append("nettype", m.avv().getNetType());
                    iF.append("qt", String.valueOf(iVar.czW));
                    iF.append("connt", String.valueOf(iVar.czX));
                    iF.append("rwt", String.valueOf(iVar.czY));
                    iF.append("dect", String.valueOf(iVar.czZ));
                    iF.append("parset", String.valueOf(iVar.cAa));
                    iF.append("rendert", String.valueOf(iVar.cAc));
                    iF.append("ss", String.valueOf(iVar.cAe));
                    iF.append("hs", String.valueOf(iVar.cAf));
                    if (iVar.cAg && iVar.socketErrNo != 0) {
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
        if (m.avv().avw() && iVar.cAn > 0) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "time_t");
            a(iF, iVar);
            iF.append("pct", String.valueOf(iVar.cAn));
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
