package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class r extends o {
    public void a(l lVar) {
        if (p.GY().GZ()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fq.append("ishttp", lVar.aLc ? "1" : "0");
            fq.append("issuccess", lVar.isSuccess ? "1" : "0");
            fq.append("nettype", p.GY().getNetType());
            fq.append("wt", String.valueOf(lVar.aKX));
            fq.append("qt", String.valueOf(lVar.aKQ));
            fq.append("connt", String.valueOf(lVar.aKR));
            fq.append("rwt", String.valueOf(lVar.aKS));
            fq.append("fbt", String.valueOf(lVar.mW));
            fq.append("abt", String.valueOf(lVar.mZ));
            fq.append("dect", String.valueOf(lVar.aKT));
            fq.append("parset", String.valueOf(lVar.aKU));
            fq.append("tqt", String.valueOf(lVar.aKV));
            fq.append("rendert", String.valueOf(lVar.aKW));
            fq.append("ss", String.valueOf(lVar.aLa));
            fq.append("hs", String.valueOf(lVar.aLb));
            if (lVar.aLc && lVar.socketErrNo != 0) {
                fq.append("salno", String.valueOf(lVar.socketErrNo));
                if (lVar.socketCostTime != 0) {
                    fq.append("scosttime", String.valueOf(lVar.socketCostTime));
                }
            }
            if (lVar.aLc) {
                fq.append("hrtn", String.valueOf(lVar.aLd));
                fq.append("hrtt", String.valueOf(lVar.aLe));
            }
            if (lVar.errCode != 0) {
                fq.f("errcode", Integer.valueOf(lVar.errCode));
            }
            if (lVar.aLf) {
                fq.append("pt", "1");
            } else {
                fq.append("sysct", String.valueOf(lVar.aKO));
                fq.append("ct", String.valueOf(lVar.aKP));
            }
            if (lVar.aLc) {
                fq.append("c_logid", String.valueOf(lVar.aLg));
                if (lVar.sequenceID != 0) {
                    fq.append("seq_id", String.valueOf(lVar.sequenceID & 4294967295L));
                }
            } else {
                fq.append("seq_id", String.valueOf(lVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    public void b(l lVar) {
        if (p.GY().GZ() && lVar.aKY > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "readCache");
            fq.append("rct", String.valueOf(lVar.aKY));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    public void c(l lVar) {
        if (p.GY().GZ() && lVar.aKZ > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "writeCache");
            fq.append("wct", String.valueOf(lVar.aKZ));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    public void a(k kVar, String str) {
        if (kVar != null && str != null && p.GY().GZ()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "resource");
            fq.append("actype", str);
            fq.append("issuccess", kVar.isSuccess ? "1" : "0");
            fq.append("isfs", kVar.aKN ? "1" : "0");
            fq.append("ct", String.valueOf(kVar.EE));
            fq.append("from", String.valueOf(kVar.ED));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    public void g(d dVar) {
        if (dVar != null && p.GY().GZ()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "fluency");
            fq.append("fps", String.valueOf(dVar.GG()));
            fq.append("memp", String.valueOf(dVar.GI()));
            fq.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(dVar.GJ()));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    public void h(d dVar) {
        if (p.GY().GZ()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "gc");
            fq.append("gc", String.valueOf(dVar.GH()));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    public void d(l lVar) {
    }

    public void e(l lVar) {
    }

    public void a(l lVar, int i) {
    }
}
