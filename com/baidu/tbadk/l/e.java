package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.l.o
    public void a(i iVar) {
        if (m.KJ().KK()) {
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append(AuthActivity.ACTION_KEY, "time_t");
            a(ii, iVar);
            ii.append("ishttp", iVar.aTX ? "1" : "0");
            ii.append("issuccess", iVar.isSuccess ? "1" : "0");
            ii.append("nettype", m.KJ().getNetType());
            ii.append("ct", String.valueOf(iVar.aTM));
            ii.append("wt", String.valueOf(iVar.aTU));
            ii.append("qt", String.valueOf(iVar.aTN));
            ii.append("connt", String.valueOf(iVar.aTO));
            ii.append("rwt", String.valueOf(iVar.aTP));
            ii.append("dect", String.valueOf(iVar.aTQ));
            ii.append("parset", String.valueOf(iVar.aTR));
            ii.append("rendert", String.valueOf(iVar.aTT));
            ii.append("ss", String.valueOf(iVar.aTV));
            ii.append("hs", String.valueOf(iVar.aTW));
            if (iVar.aTX && iVar.socketErrNo != 0) {
                ii.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    ii.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                ii.f("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.aTX) {
                ii.append("c_logid", String.valueOf(iVar.aUb));
            } else {
                ii.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, ii);
        }
    }

    @Override // com.baidu.tbadk.l.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.KJ().KK()) {
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append(AuthActivity.ACTION_KEY, "resource_t");
            ii.append("actype", str);
            ii.append("issuccess", hVar.isSuccess ? "1" : "0");
            ii.append("isfs", hVar.aTK ? "1" : "0");
            ii.append("ct", String.valueOf(hVar.KM));
            ii.append("from", String.valueOf(hVar.KL));
            BdStatisticsManager.getInstance().performance(this.subType, ii);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, i iVar) {
        if (iVar instanceof d) {
            aVar.f("ptype", Integer.valueOf(((d) iVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.l.o
    public void a(i iVar, boolean z) {
        if (m.KJ().KK()) {
            if (!z || iVar.aUc > 0) {
                if (z || iVar.aUd > 0) {
                    com.baidu.adp.lib.stats.a ii = ii();
                    ii.append(AuthActivity.ACTION_KEY, "time_t");
                    a(ii, iVar);
                    if (z) {
                        ii.append("put", String.valueOf(iVar.aUc));
                    } else {
                        ii.append("pdt", String.valueOf(iVar.aUd));
                    }
                    ii.append("ishttp", iVar.aTX ? "1" : "0");
                    ii.append("issuccess", iVar.isSuccess ? "1" : "0");
                    ii.append("nettype", m.KJ().getNetType());
                    ii.append("qt", String.valueOf(iVar.aTN));
                    ii.append("connt", String.valueOf(iVar.aTO));
                    ii.append("rwt", String.valueOf(iVar.aTP));
                    ii.append("dect", String.valueOf(iVar.aTQ));
                    ii.append("parset", String.valueOf(iVar.aTR));
                    ii.append("rendert", String.valueOf(iVar.aTT));
                    ii.append("ss", String.valueOf(iVar.aTV));
                    ii.append("hs", String.valueOf(iVar.aTW));
                    if (iVar.aTX && iVar.socketErrNo != 0) {
                        ii.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            ii.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        ii.f("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, ii);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.l.o
    public void a(i iVar, int i) {
        if (m.KJ().KK() && iVar.aUe > 0) {
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append(AuthActivity.ACTION_KEY, "time_t");
            a(ii, iVar);
            ii.append("pct", String.valueOf(iVar.aUe));
            switch (i) {
                case 0:
                    ii.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    ii.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, ii);
        }
    }
}
