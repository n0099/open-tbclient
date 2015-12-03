package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class aa extends x {
    public void a(t tVar) {
        if (y.ES().ET()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            he.q("ishttp", tVar.ayy ? "1" : "0");
            he.q("issuccess", tVar.isSuccess ? "1" : "0");
            he.q("nettype", y.ES().getNetType());
            he.q("ct", String.valueOf(tVar.aym));
            he.q("wt", String.valueOf(tVar.ayt));
            he.q("qt", String.valueOf(tVar.ayn));
            he.q("connt", String.valueOf(tVar.ayo));
            he.q("rwt", String.valueOf(tVar.ayp));
            he.q("dect", String.valueOf(tVar.ayq));
            he.q("parset", String.valueOf(tVar.ayr));
            he.q("rendert", String.valueOf(tVar.ays));
            he.q("ss", String.valueOf(tVar.ayw));
            he.q("hs", String.valueOf(tVar.ayx));
            if (tVar.ayy && tVar.socketErrNo != 0) {
                he.q("salno", String.valueOf(tVar.socketErrNo));
            }
            if (tVar.errCode != 0) {
                he.e("errcode", Integer.valueOf(tVar.errCode));
            }
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void b(t tVar) {
        if (y.ES().ET() && tVar.ayt > 0) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "white");
            he.q("ct", String.valueOf(tVar.aym));
            he.q("wt", String.valueOf(tVar.ayt));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void c(t tVar) {
        if (y.ES().ET() && tVar.ayu > 0) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "readCache");
            he.q("rct", String.valueOf(tVar.ayu));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void d(t tVar) {
        if (y.ES().ET() && tVar.ayv > 0) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "writeCache");
            he.q("wct", String.valueOf(tVar.ayv));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void a(s sVar, String str) {
        if (sVar != null && str != null && y.ES().ET()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "resource");
            he.q("actype", str);
            he.q("issuccess", sVar.isSuccess ? "1" : "0");
            he.q("isfs", sVar.ayl ? "1" : "0");
            he.q("ct", String.valueOf(sVar.GJ));
            he.q("from", String.valueOf(sVar.GI));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void g(e eVar) {
        if (eVar != null && y.ES().ET()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "fluency");
            he.q("fps", String.valueOf(eVar.Ey()));
            he.q("memp", String.valueOf(eVar.EA()));
            he.q("cpu", String.valueOf(eVar.getCpuString()));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void h(e eVar) {
        if (y.ES().ET()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "gc");
            he.q("gc", String.valueOf(eVar.Ez()));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }
}
