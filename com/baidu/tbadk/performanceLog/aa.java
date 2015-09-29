package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class aa extends x {
    public void a(t tVar) {
        if (y.Eb().Ec()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            hb.q("ishttp", tVar.axD ? "1" : "0");
            hb.q("issuccess", tVar.isSuccess ? "1" : "0");
            hb.q("nettype", y.Eb().getNetType());
            hb.q("ct", String.valueOf(tVar.axr));
            hb.q("wt", String.valueOf(tVar.axy));
            hb.q("qt", String.valueOf(tVar.axs));
            hb.q("connt", String.valueOf(tVar.axt));
            hb.q("rwt", String.valueOf(tVar.axu));
            hb.q("dect", String.valueOf(tVar.axv));
            hb.q("parset", String.valueOf(tVar.axw));
            hb.q("rendert", String.valueOf(tVar.axx));
            hb.q("ss", String.valueOf(tVar.axB));
            hb.q("hs", String.valueOf(tVar.axC));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void b(t tVar) {
        if (y.Eb().Ec() && tVar.axy > 0) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "white");
            hb.q("ct", String.valueOf(tVar.axr));
            hb.q("wt", String.valueOf(tVar.axy));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void c(t tVar) {
        if (y.Eb().Ec() && tVar.axz > 0) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "readCache");
            hb.q("rct", String.valueOf(tVar.axz));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void d(t tVar) {
        if (y.Eb().Ec() && tVar.axA > 0) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "writeCache");
            hb.q("wct", String.valueOf(tVar.axA));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void a(s sVar, String str) {
        if (sVar != null && str != null && y.Eb().Ec()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "resource");
            hb.q("actype", str);
            hb.q("issuccess", sVar.isSuccess ? "1" : "0");
            hb.q("isfs", sVar.axq ? "1" : "0");
            hb.q("ct", String.valueOf(sVar.Gq));
            hb.q("from", String.valueOf(sVar.Gp));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void g(e eVar) {
        if (eVar != null && y.Eb().Ec()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "fluency");
            hb.q("fps", String.valueOf(eVar.DH()));
            hb.q("memp", String.valueOf(eVar.DJ()));
            hb.q("cpu", String.valueOf(eVar.getCpuString()));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void h(e eVar) {
        if (y.Eb().Ec()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "gc");
            hb.q("gc", String.valueOf(eVar.DI()));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }
}
