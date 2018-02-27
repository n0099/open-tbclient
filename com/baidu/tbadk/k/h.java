package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class h extends r {
    @Override // com.baidu.tbadk.k.r
    public void a(l lVar) {
        if (p.Ov().Ow()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "time_t");
            a(nn, lVar);
            nn.append("ishttp", lVar.bAC ? "1" : "0");
            nn.append("issuccess", lVar.isSuccess ? "1" : "0");
            nn.append("nettype", p.Ov().getNetType());
            nn.append("ct", String.valueOf(lVar.bAp));
            nn.append("wt", String.valueOf(lVar.bAx));
            nn.append("qt", String.valueOf(lVar.bAq));
            nn.append("connt", String.valueOf(lVar.bAr));
            nn.append("rwt", String.valueOf(lVar.bAs));
            nn.append("dect", String.valueOf(lVar.bAt));
            nn.append("parset", String.valueOf(lVar.bAu));
            nn.append("rendert", String.valueOf(lVar.bAw));
            nn.append("ss", String.valueOf(lVar.bAA));
            nn.append("hs", String.valueOf(lVar.bAB));
            if (lVar.bAC && lVar.socketErrNo != 0) {
                nn.append("salno", String.valueOf(lVar.socketErrNo));
                if (lVar.socketCostTime != 0) {
                    nn.append("scosttime", String.valueOf(lVar.socketCostTime));
                }
            }
            if (lVar.errCode != 0) {
                nn.h("errcode", Integer.valueOf(lVar.errCode));
            }
            if (lVar.bAC) {
                nn.append("c_logid", String.valueOf(lVar.bAG));
            } else {
                nn.append("seq_id", String.valueOf(lVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void b(l lVar) {
        if (p.Ov().Ow() && lVar.bAy > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "readCache_t");
            a(nn, lVar);
            nn.append("rct", String.valueOf(lVar.bAy));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void c(l lVar) {
        if (p.Ov().Ow() && lVar.bAz > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "writeCache_t");
            a(nn, lVar);
            nn.append("wct", String.valueOf(lVar.bAz));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void a(k kVar, String str) {
        if (kVar != null && str != null && p.Ov().Ow()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "resource_t");
            nn.append("actype", str);
            nn.append("issuccess", kVar.isSuccess ? "1" : "0");
            nn.append("isfs", kVar.bAn ? "1" : "0");
            nn.append("ct", String.valueOf(kVar.aue));
            nn.append("from", String.valueOf(kVar.aud));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void g(d dVar) {
        if (dVar != null && p.Ov().Ow()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "fluency_t");
            a(nn, dVar);
            nn.append("fps", String.valueOf(dVar.Of()));
            nn.append("memp", String.valueOf(dVar.Oh()));
            nn.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(dVar.Oi()));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void h(d dVar) {
        if (p.Ov().Ow()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "gc_t");
            a(nn, dVar);
            nn.append("gc", String.valueOf(dVar.Og()));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, d dVar) {
        if (dVar instanceof f) {
            aVar.h("ptype", Integer.valueOf(((f) dVar).pageType));
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, l lVar) {
        if (lVar instanceof g) {
            aVar.h("ptype", Integer.valueOf(((g) lVar).pageType));
        }
    }
}
