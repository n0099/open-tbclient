package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class r extends o {
    public void a(l lVar) {
        if (p.Ha().Hb()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fq.append("ishttp", lVar.aLb ? "1" : "0");
            fq.append("issuccess", lVar.isSuccess ? "1" : "0");
            fq.append("nettype", p.Ha().getNetType());
            fq.append("wt", String.valueOf(lVar.aKW));
            fq.append("qt", String.valueOf(lVar.aKP));
            fq.append("connt", String.valueOf(lVar.aKQ));
            fq.append("rwt", String.valueOf(lVar.aKR));
            fq.append("fbt", String.valueOf(lVar.mW));
            fq.append("abt", String.valueOf(lVar.mZ));
            fq.append("dect", String.valueOf(lVar.aKS));
            fq.append("parset", String.valueOf(lVar.aKT));
            fq.append("tqt", String.valueOf(lVar.aKU));
            fq.append("rendert", String.valueOf(lVar.aKV));
            fq.append("ss", String.valueOf(lVar.aKZ));
            fq.append("hs", String.valueOf(lVar.aLa));
            if (lVar.aLb && lVar.socketErrNo != 0) {
                fq.append("salno", String.valueOf(lVar.socketErrNo));
                if (lVar.socketCostTime != 0) {
                    fq.append("scosttime", String.valueOf(lVar.socketCostTime));
                }
            }
            if (lVar.aLb) {
                fq.append("hrtn", String.valueOf(lVar.aLc));
                fq.append("hrtt", String.valueOf(lVar.aLd));
            }
            if (lVar.errCode != 0) {
                fq.f("errcode", Integer.valueOf(lVar.errCode));
            }
            if (lVar.aLe) {
                fq.append("pt", "1");
            } else {
                fq.append("sysct", String.valueOf(lVar.aKN));
                fq.append("ct", String.valueOf(lVar.aKO));
            }
            if (lVar.aLb) {
                fq.append("c_logid", String.valueOf(lVar.aLf));
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
        if (p.Ha().Hb() && lVar.aKX > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "readCache");
            fq.append("rct", String.valueOf(lVar.aKX));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    public void c(l lVar) {
        if (p.Ha().Hb() && lVar.aKY > 0) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "writeCache");
            fq.append("wct", String.valueOf(lVar.aKY));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    public void a(k kVar, String str) {
        if (kVar != null && str != null && p.Ha().Hb()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "resource");
            fq.append("actype", str);
            fq.append("issuccess", kVar.isSuccess ? "1" : "0");
            fq.append("isfs", kVar.aKM ? "1" : "0");
            fq.append("ct", String.valueOf(kVar.EI));
            fq.append("from", String.valueOf(kVar.EH));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    public void g(d dVar) {
        if (dVar != null && p.Ha().Hb()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "fluency");
            fq.append("fps", String.valueOf(dVar.GI()));
            fq.append("memp", String.valueOf(dVar.GK()));
            fq.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(dVar.GL()));
            BdStatisticsManager.getInstance().performance(this.subType, fq);
        }
    }

    public void h(d dVar) {
        if (p.Ha().Hb()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "gc");
            fq.append("gc", String.valueOf(dVar.GJ()));
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
