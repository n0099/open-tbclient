package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class aa extends x {
    public void a(t tVar) {
        if (y.DY().DZ()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            hb.q("ishttp", tVar.axE ? "1" : "0");
            hb.q("issuccess", tVar.isSuccess ? "1" : "0");
            hb.q("nettype", y.DY().getNetType());
            hb.q("ct", String.valueOf(tVar.axs));
            hb.q("wt", String.valueOf(tVar.axz));
            hb.q("qt", String.valueOf(tVar.axt));
            hb.q("connt", String.valueOf(tVar.axu));
            hb.q("rwt", String.valueOf(tVar.axv));
            hb.q("dect", String.valueOf(tVar.axw));
            hb.q("parset", String.valueOf(tVar.axx));
            hb.q("rendert", String.valueOf(tVar.axy));
            hb.q("ss", String.valueOf(tVar.axC));
            hb.q("hs", String.valueOf(tVar.axD));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void b(t tVar) {
        if (y.DY().DZ() && tVar.axz > 0) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "white");
            hb.q("ct", String.valueOf(tVar.axs));
            hb.q("wt", String.valueOf(tVar.axz));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void c(t tVar) {
        if (y.DY().DZ() && tVar.axA > 0) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "readCache");
            hb.q("rct", String.valueOf(tVar.axA));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void d(t tVar) {
        if (y.DY().DZ() && tVar.axB > 0) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "writeCache");
            hb.q("wct", String.valueOf(tVar.axB));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void a(s sVar, String str) {
        if (sVar != null && str != null && y.DY().DZ()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "resource");
            hb.q("actype", str);
            hb.q("issuccess", sVar.isSuccess ? "1" : "0");
            hb.q("isfs", sVar.axr ? "1" : "0");
            hb.q("ct", String.valueOf(sVar.Gr));
            hb.q("from", String.valueOf(sVar.Gq));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void g(e eVar) {
        if (eVar != null && y.DY().DZ()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "fluency");
            hb.q("fps", String.valueOf(eVar.DE()));
            hb.q("memp", String.valueOf(eVar.DG()));
            hb.q("cpu", String.valueOf(eVar.getCpuString()));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void h(e eVar) {
        if (y.DY().DZ()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "gc");
            hb.q("gc", String.valueOf(eVar.DF()));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }
}
