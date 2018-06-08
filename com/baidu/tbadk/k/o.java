package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.Ks().Kt()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "time");
            ih.append("ishttp", iVar.aTa ? "1" : "0");
            ih.append("issuccess", iVar.isSuccess ? "1" : "0");
            ih.append("nettype", m.Ks().getNetType());
            ih.append("wt", String.valueOf(iVar.aSX));
            ih.append("qt", String.valueOf(iVar.aSQ));
            ih.append("connt", String.valueOf(iVar.aSR));
            ih.append("rwt", String.valueOf(iVar.aSS));
            ih.append("fbt", String.valueOf(iVar.tt));
            ih.append("abt", String.valueOf(iVar.tu));
            ih.append("dect", String.valueOf(iVar.aST));
            ih.append("parset", String.valueOf(iVar.aSU));
            ih.append("tqt", String.valueOf(iVar.aSV));
            ih.append("rendert", String.valueOf(iVar.aSW));
            ih.append("ss", String.valueOf(iVar.aSY));
            ih.append("hs", String.valueOf(iVar.aSZ));
            if (iVar.aTa && iVar.socketErrNo != 0) {
                ih.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    ih.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.aTa) {
                ih.append("hrtn", String.valueOf(iVar.aTb));
                ih.append("hrtt", String.valueOf(iVar.aTc));
            }
            if (iVar.errCode != 0) {
                ih.f("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.aTd) {
                ih.append("pt", "1");
            } else {
                ih.append("sysct", String.valueOf(iVar.aSO));
                ih.append("ct", String.valueOf(iVar.aSP));
            }
            if (iVar.aTa) {
                ih.append("c_logid", String.valueOf(iVar.aTe));
                if (iVar.sequenceID != 0) {
                    ih.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                ih.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, ih);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.Ks().Kt()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "resource");
            ih.append("actype", str);
            ih.append("issuccess", hVar.isSuccess ? "1" : "0");
            ih.append("isfs", hVar.aSN ? "1" : "0");
            ih.append("ct", String.valueOf(hVar.KO));
            ih.append("from", String.valueOf(hVar.KN));
            BdStatisticsManager.getInstance().performance(this.subType, ih);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.Ks().Kt()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "fluency");
            ih.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, ih);
            com.baidu.adp.lib.stats.a ih2 = ih();
            ih2.append(AuthActivity.ACTION_KEY, "mem");
            ih2.append("memp", String.valueOf(m.Ks().Ku()));
            BdStatisticsManager.getInstance().performance(this.subType, ih2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.Ks().Kt()) {
            if (!z || iVar.aTf > 0) {
                if (z || iVar.aTg > 0) {
                    com.baidu.adp.lib.stats.a ih = ih();
                    ih.append(AuthActivity.ACTION_KEY, "time");
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

    public void a(i iVar, int i) {
        if (m.Ks().Kt() && iVar.aTh > 0) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "time");
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
