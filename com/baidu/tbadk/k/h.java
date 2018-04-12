package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class h extends r {
    @Override // com.baidu.tbadk.k.r
    public void a(l lVar) {
        if (p.Ha().Hb()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "time_t");
            a(fq, lVar);
            fq.append("ishttp", lVar.aLb ? "1" : "0");
            fq.append("issuccess", lVar.isSuccess ? "1" : "0");
            fq.append("nettype", p.Ha().getNetType());
            fq.append("ct", String.valueOf(lVar.aKO));
            fq.append("wt", String.valueOf(lVar.aKW));
            fq.append("qt", String.valueOf(lVar.aKP));
            fq.append("connt", String.valueOf(lVar.aKQ));
            fq.append("rwt", String.valueOf(lVar.aKR));
            fq.append("dect", String.valueOf(lVar.aKS));
            fq.append("parset", String.valueOf(lVar.aKT));
            fq.append("rendert", String.valueOf(lVar.aKV));
            fq.append("ss", String.valueOf(lVar.aKZ));
            fq.append("hs", String.valueOf(lVar.aLa));
            if (lVar.aLb && lVar.socketErrNo != 0) {
                fq.append("salno", String.valueOf(lVar.socketErrNo));
                if (lVar.socketCostTime != 0) {
                    fq.append("scosttime", String.valueOf(lVar.socketCostTime));
                }
            }
            if (lVar.errCode != 0) {
                fq.f("errcode", Integer.valueOf(lVar.errCode));
            }
            if (lVar.aLb) {
                fq.append("c_logid", String.valueOf(lVar.aLf));
            } else {
                fq.append("seq_id", String.valueOf(lVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void b(l lVar) {
        if (p.Ha().Hb() && lVar.aKX > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "readCache_t");
            a(fq, lVar);
            fq.append("rct", String.valueOf(lVar.aKX));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void c(l lVar) {
        if (p.Ha().Hb() && lVar.aKY > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "writeCache_t");
            a(fq, lVar);
            fq.append("wct", String.valueOf(lVar.aKY));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void a(k kVar, String str) {
        if (kVar != null && str != null && p.Ha().Hb()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "resource_t");
            fq.append("actype", str);
            fq.append("issuccess", kVar.isSuccess ? "1" : "0");
            fq.append("isfs", kVar.aKM ? "1" : "0");
            fq.append("ct", String.valueOf(kVar.EI));
            fq.append("from", String.valueOf(kVar.EH));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void g(d dVar) {
        if (dVar != null && p.Ha().Hb()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "fluency_t");
            a(fq, dVar);
            fq.append("fps", String.valueOf(dVar.GI()));
            fq.append("memp", String.valueOf(dVar.GK()));
            fq.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(dVar.GL()));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void h(d dVar) {
        if (p.Ha().Hb()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "gc_t");
            a(fq, dVar);
            fq.append("gc", String.valueOf(dVar.GJ()));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, d dVar) {
        if (dVar instanceof f) {
            aVar.f("ptype", Integer.valueOf(((f) dVar).pageType));
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, l lVar) {
        if (lVar instanceof g) {
            aVar.f("ptype", Integer.valueOf(((g) lVar).pageType));
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void d(l lVar) {
        if (p.Ha().Hb() && lVar.aLh > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "time_t");
            a(fq, lVar);
            fq.append("pdt", String.valueOf(lVar.aLh));
            fq.append("ishttp", lVar.aLb ? "1" : "0");
            fq.append("issuccess", lVar.isSuccess ? "1" : "0");
            fq.append("nettype", p.Ha().getNetType());
            fq.append("qt", String.valueOf(lVar.aKP));
            fq.append("connt", String.valueOf(lVar.aKQ));
            fq.append("rwt", String.valueOf(lVar.aKR));
            fq.append("dect", String.valueOf(lVar.aKS));
            fq.append("parset", String.valueOf(lVar.aKT));
            fq.append("rendert", String.valueOf(lVar.aKV));
            fq.append("ss", String.valueOf(lVar.aKZ));
            fq.append("hs", String.valueOf(lVar.aLa));
            if (lVar.aLb && lVar.socketErrNo != 0) {
                fq.append("salno", String.valueOf(lVar.socketErrNo));
                if (lVar.socketCostTime != 0) {
                    fq.append("scosttime", String.valueOf(lVar.socketCostTime));
                }
            }
            if (lVar.errCode != 0) {
                fq.f("errcode", Integer.valueOf(lVar.errCode));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void e(l lVar) {
        if (p.Ha().Hb() && lVar.aLg > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "time_t");
            a(fq, lVar);
            fq.append("put", String.valueOf(lVar.aLg));
            fq.append("ishttp", lVar.aLb ? "1" : "0");
            fq.append("issuccess", lVar.isSuccess ? "1" : "0");
            fq.append("nettype", p.Ha().getNetType());
            fq.append("qt", String.valueOf(lVar.aKP));
            fq.append("connt", String.valueOf(lVar.aKQ));
            fq.append("rwt", String.valueOf(lVar.aKR));
            fq.append("dect", String.valueOf(lVar.aKS));
            fq.append("parset", String.valueOf(lVar.aKT));
            fq.append("rendert", String.valueOf(lVar.aKV));
            fq.append("ss", String.valueOf(lVar.aKZ));
            fq.append("hs", String.valueOf(lVar.aLa));
            if (lVar.aLb && lVar.socketErrNo != 0) {
                fq.append("salno", String.valueOf(lVar.socketErrNo));
                if (lVar.socketCostTime != 0) {
                    fq.append("scosttime", String.valueOf(lVar.socketCostTime));
                }
            }
            if (lVar.errCode != 0) {
                fq.f("errcode", Integer.valueOf(lVar.errCode));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    @Override // com.baidu.tbadk.k.r
    public void a(l lVar, int i) {
        if (p.Ha().Hb() && lVar.aLi > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "time_t");
            a(fq, lVar);
            fq.append("pct", String.valueOf(lVar.aLi));
            switch (i) {
                case 0:
                    fq.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    fq.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }
}
