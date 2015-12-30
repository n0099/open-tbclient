package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class aa extends x {
    public void a(t tVar) {
        if (y.EH().EI()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            he.q("ishttp", tVar.aAb ? "1" : "0");
            he.q("issuccess", tVar.isSuccess ? "1" : "0");
            he.q("nettype", y.EH().getNetType());
            he.q("ct", String.valueOf(tVar.azP));
            he.q("wt", String.valueOf(tVar.azW));
            he.q("qt", String.valueOf(tVar.azQ));
            he.q("connt", String.valueOf(tVar.azR));
            he.q("rwt", String.valueOf(tVar.azS));
            he.q("dect", String.valueOf(tVar.azT));
            he.q("parset", String.valueOf(tVar.azU));
            he.q("rendert", String.valueOf(tVar.azV));
            he.q("ss", String.valueOf(tVar.azZ));
            he.q("hs", String.valueOf(tVar.aAa));
            if (tVar.aAb && tVar.socketErrNo != 0) {
                he.q("salno", String.valueOf(tVar.socketErrNo));
                if (tVar.socketCostTime != 0) {
                    he.q("scosttime", String.valueOf(tVar.socketCostTime));
                }
            }
            if (tVar.errCode != 0) {
                he.e("errcode", Integer.valueOf(tVar.errCode));
            }
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void b(t tVar) {
        if (y.EH().EI() && tVar.azW > 0) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "white");
            he.q("ct", String.valueOf(tVar.azP));
            he.q("wt", String.valueOf(tVar.azW));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void c(t tVar) {
        if (y.EH().EI() && tVar.azX > 0) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "readCache");
            he.q("rct", String.valueOf(tVar.azX));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void d(t tVar) {
        if (y.EH().EI() && tVar.azY > 0) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "writeCache");
            he.q("wct", String.valueOf(tVar.azY));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void a(s sVar, String str) {
        if (sVar != null && str != null && y.EH().EI()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "resource");
            he.q("actype", str);
            he.q("issuccess", sVar.isSuccess ? "1" : "0");
            he.q("isfs", sVar.azO ? "1" : "0");
            he.q("ct", String.valueOf(sVar.Ha));
            he.q("from", String.valueOf(sVar.GZ));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void g(e eVar) {
        if (eVar != null && y.EH().EI()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "fluency");
            he.q("fps", String.valueOf(eVar.En()));
            he.q("memp", String.valueOf(eVar.Ep()));
            he.q("cpu", String.valueOf(eVar.getCpuString()));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void h(e eVar) {
        if (y.EH().EI()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "gc");
            he.q("gc", String.valueOf(eVar.Eo()));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }
}
