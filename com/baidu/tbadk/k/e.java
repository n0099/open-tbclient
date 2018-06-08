package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class e extends o {
    @Override // com.baidu.tbadk.k.o
    public void a(i iVar) {
        if (m.Ks().Kt()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "time_t");
            a(ih, iVar);
            ih.append("ishttp", iVar.aTa ? "1" : "0");
            ih.append("issuccess", iVar.isSuccess ? "1" : "0");
            ih.append("nettype", m.Ks().getNetType());
            ih.append("ct", String.valueOf(iVar.aSP));
            ih.append("wt", String.valueOf(iVar.aSX));
            ih.append("qt", String.valueOf(iVar.aSQ));
            ih.append("connt", String.valueOf(iVar.aSR));
            ih.append("rwt", String.valueOf(iVar.aSS));
            ih.append("dect", String.valueOf(iVar.aST));
            ih.append("parset", String.valueOf(iVar.aSU));
            ih.append("rendert", String.valueOf(iVar.aSW));
            ih.append("ss", String.valueOf(iVar.aSY));
            ih.append("hs", String.valueOf(iVar.aSZ));
            if (iVar.aTa && iVar.socketErrNo != 0) {
                ih.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    ih.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.errCode != 0) {
                ih.f("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.aTa) {
                ih.append("c_logid", String.valueOf(iVar.aTe));
            } else {
                ih.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, ih);
        }
    }

    @Override // com.baidu.tbadk.k.o
    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.Ks().Kt()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "resource_t");
            ih.append("actype", str);
            ih.append("issuccess", hVar.isSuccess ? "1" : "0");
            ih.append("isfs", hVar.aSN ? "1" : "0");
            ih.append("ct", String.valueOf(hVar.KO));
            ih.append("from", String.valueOf(hVar.KN));
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
        if (m.Ks().Kt()) {
            if (!z || iVar.aTf > 0) {
                if (z || iVar.aTg > 0) {
                    com.baidu.adp.lib.stats.a ih = ih();
                    ih.append(AuthActivity.ACTION_KEY, "time_t");
                    a(ih, iVar);
                    if (z) {
                        ih.append("put", String.valueOf(iVar.aTf));
                    } else {
                        ih.append("pdt", String.valueOf(iVar.aTg));
                    }
                    ih.append("ishttp", iVar.aTa ? "1" : "0");
                    ih.append("issuccess", iVar.isSuccess ? "1" : "0");
                    ih.append("nettype", m.Ks().getNetType());
                    ih.append("qt", String.valueOf(iVar.aSQ));
                    ih.append("connt", String.valueOf(iVar.aSR));
                    ih.append("rwt", String.valueOf(iVar.aSS));
                    ih.append("dect", String.valueOf(iVar.aST));
                    ih.append("parset", String.valueOf(iVar.aSU));
                    ih.append("rendert", String.valueOf(iVar.aSW));
                    ih.append("ss", String.valueOf(iVar.aSY));
                    ih.append("hs", String.valueOf(iVar.aSZ));
                    if (iVar.aTa && iVar.socketErrNo != 0) {
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
        if (m.Ks().Kt() && iVar.aTh > 0) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "time_t");
            a(ih, iVar);
            ih.append("pct", String.valueOf(iVar.aTh));
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
