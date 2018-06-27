package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.k.o
    public void a(i iVar) {
        if (m.KK().KL()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "time_t");
            a(ih, iVar);
            ih.append("ishttp", iVar.aTW ? "1" : "0");
            ih.append("issuccess", iVar.isSuccess ? "1" : "0");
            ih.append("nettype", m.KK().getNetType());
            ih.append("ct", String.valueOf(iVar.aTL));
            ih.append("wt", String.valueOf(iVar.aTT));
            ih.append("qt", String.valueOf(iVar.aTM));
            ih.append("connt", String.valueOf(iVar.aTN));
            ih.append("rwt", String.valueOf(iVar.aTO));
            ih.append("dect", String.valueOf(iVar.aTP));
            ih.append("parset", String.valueOf(iVar.aTQ));
            ih.append("rendert", String.valueOf(iVar.aTS));
            ih.append("ss", String.valueOf(iVar.aTU));
            ih.append("hs", String.valueOf(iVar.aTV));
            if (iVar.aTW && iVar.socketErrNo != 0) {
                ih.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    ih.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                ih.f("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.aTW) {
                ih.append("c_logid", String.valueOf(iVar.aUa));
            } else {
                ih.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, ih);
        }
    }

    @Override // com.baidu.tbadk.k.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.KK().KL()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "resource_t");
            ih.append("actype", str);
            ih.append("issuccess", hVar.isSuccess ? "1" : "0");
            ih.append("isfs", hVar.aTJ ? "1" : "0");
            ih.append("ct", String.valueOf(hVar.KQ));
            ih.append("from", String.valueOf(hVar.KP));
            BdStatisticsManager.getInstance().performance(this.subType, ih);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.f("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.k.o
    public void a(i iVar, boolean z) {
        if (m.KK().KL()) {
            if (!z || iVar.aUb > 0) {
                if (z || iVar.aUc > 0) {
                    com.baidu.adp.lib.stats.a ih = ih();
                    ih.append(AuthActivity.ACTION_KEY, "time_t");
                    a(ih, iVar);
                    if (z) {
                        ih.append("put", String.valueOf(iVar.aUb));
                    } else {
                        ih.append("pdt", String.valueOf(iVar.aUc));
                    }
                    ih.append("ishttp", iVar.aTW ? "1" : "0");
                    ih.append("issuccess", iVar.isSuccess ? "1" : "0");
                    ih.append("nettype", m.KK().getNetType());
                    ih.append("qt", String.valueOf(iVar.aTM));
                    ih.append("connt", String.valueOf(iVar.aTN));
                    ih.append("rwt", String.valueOf(iVar.aTO));
                    ih.append("dect", String.valueOf(iVar.aTP));
                    ih.append("parset", String.valueOf(iVar.aTQ));
                    ih.append("rendert", String.valueOf(iVar.aTS));
                    ih.append("ss", String.valueOf(iVar.aTU));
                    ih.append("hs", String.valueOf(iVar.aTV));
                    if (iVar.aTW && iVar.socketErrNo != 0) {
                        ih.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            ih.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        ih.f("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, ih);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.k.o
    public void a(i iVar, int i) {
        if (m.KK().KL() && iVar.aUd > 0) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "time_t");
            a(ih, iVar);
            ih.append("pct", String.valueOf(iVar.aUd));
            switch (i) {
                case 0:
                    ih.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    ih.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, ih);
        }
    }
}
