package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class aa extends x {
    public void a(t tVar) {
        if (y.Eo().Ep()) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            ha.q("ishttp", tVar.aze ? "1" : "0");
            ha.q("issuccess", tVar.isSuccess ? "1" : "0");
            ha.q("nettype", y.Eo().getNetType());
            ha.q("ct", String.valueOf(tVar.ayS));
            ha.q("wt", String.valueOf(tVar.ayZ));
            ha.q("qt", String.valueOf(tVar.ayT));
            ha.q("connt", String.valueOf(tVar.ayU));
            ha.q("rwt", String.valueOf(tVar.ayV));
            ha.q("dect", String.valueOf(tVar.ayW));
            ha.q("parset", String.valueOf(tVar.ayX));
            ha.q("rendert", String.valueOf(tVar.ayY));
            ha.q("ss", String.valueOf(tVar.azc));
            ha.q("hs", String.valueOf(tVar.azd));
            com.baidu.adp.lib.stats.a.hh().a(this.subType, ha);
        }
    }

    public void b(t tVar) {
        if (y.Eo().Ep() && tVar.ayZ > 0) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("action", "white");
            ha.q("ct", String.valueOf(tVar.ayS));
            ha.q("wt", String.valueOf(tVar.ayZ));
            com.baidu.adp.lib.stats.a.hh().a(this.subType, ha);
        }
    }

    public void c(t tVar) {
        if (y.Eo().Ep() && tVar.aza > 0) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("action", "readCache");
            ha.q("rct", String.valueOf(tVar.aza));
            com.baidu.adp.lib.stats.a.hh().a(this.subType, ha);
        }
    }

    public void d(t tVar) {
        if (y.Eo().Ep() && tVar.azb > 0) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("action", "writeCache");
            ha.q("wct", String.valueOf(tVar.azb));
            com.baidu.adp.lib.stats.a.hh().a(this.subType, ha);
        }
    }

    public void a(s sVar, String str) {
        if (sVar != null && str != null && y.Eo().Ep()) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("action", "resource");
            ha.q("actype", str);
            ha.q("issuccess", sVar.isSuccess ? "1" : "0");
            ha.q("isfs", sVar.ayR ? "1" : "0");
            ha.q("ct", String.valueOf(sVar.Gq));
            ha.q("from", String.valueOf(sVar.Gp));
            com.baidu.adp.lib.stats.a.hh().a(this.subType, ha);
        }
    }

    public void g(e eVar) {
        if (eVar != null && y.Eo().Ep()) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("action", "fluency");
            ha.q("fps", String.valueOf(eVar.DU()));
            ha.q("memp", String.valueOf(eVar.DW()));
            ha.q("cpu", String.valueOf(eVar.getCpuString()));
            com.baidu.adp.lib.stats.a.hh().a(this.subType, ha);
        }
    }

    public void h(e eVar) {
        if (y.Eo().Ep()) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("action", "gc");
            ha.q("gc", String.valueOf(eVar.DV()));
            com.baidu.adp.lib.stats.a.hh().a(this.subType, ha);
        }
    }
}
