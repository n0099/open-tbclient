package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class aa extends x {
    public void a(t tVar) {
        if (y.Ee().Ef()) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            hd.q("ishttp", tVar.axw ? "1" : "0");
            hd.q("issuccess", tVar.isSuccess ? "1" : "0");
            hd.q("nettype", y.Ee().getNetType());
            hd.q("ct", String.valueOf(tVar.axk));
            hd.q("wt", String.valueOf(tVar.axr));
            hd.q("qt", String.valueOf(tVar.axl));
            hd.q("connt", String.valueOf(tVar.axm));
            hd.q("rwt", String.valueOf(tVar.axn));
            hd.q("dect", String.valueOf(tVar.axo));
            hd.q("parset", String.valueOf(tVar.axp));
            hd.q("rendert", String.valueOf(tVar.axq));
            hd.q("ss", String.valueOf(tVar.axu));
            hd.q("hs", String.valueOf(tVar.axv));
            com.baidu.adp.lib.stats.a.hk().a(this.subType, hd);
        }
    }

    public void b(t tVar) {
        if (y.Ee().Ef() && tVar.axr > 0) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("action", "white");
            hd.q("ct", String.valueOf(tVar.axk));
            hd.q("wt", String.valueOf(tVar.axr));
            com.baidu.adp.lib.stats.a.hk().a(this.subType, hd);
        }
    }

    public void c(t tVar) {
        if (y.Ee().Ef() && tVar.axs > 0) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("action", "readCache");
            hd.q("rct", String.valueOf(tVar.axs));
            com.baidu.adp.lib.stats.a.hk().a(this.subType, hd);
        }
    }

    public void d(t tVar) {
        if (y.Ee().Ef() && tVar.axt > 0) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("action", "writeCache");
            hd.q("wct", String.valueOf(tVar.axt));
            com.baidu.adp.lib.stats.a.hk().a(this.subType, hd);
        }
    }

    public void a(s sVar, String str) {
        if (sVar != null && str != null && y.Ee().Ef()) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("action", "resource");
            hd.q("actype", str);
            hd.q("issuccess", sVar.isSuccess ? "1" : "0");
            hd.q("isfs", sVar.axj ? "1" : "0");
            hd.q("ct", String.valueOf(sVar.Gq));
            hd.q("from", String.valueOf(sVar.Gp));
            com.baidu.adp.lib.stats.a.hk().a(this.subType, hd);
        }
    }

    public void g(e eVar) {
        if (eVar != null && y.Ee().Ef()) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("action", "fluency");
            hd.q("fps", String.valueOf(eVar.DK()));
            hd.q("memp", String.valueOf(eVar.DM()));
            hd.q("cpu", String.valueOf(eVar.getCpuString()));
            com.baidu.adp.lib.stats.a.hk().a(this.subType, hd);
        }
    }

    public void h(e eVar) {
        if (y.Ee().Ef()) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("action", "gc");
            hd.q("gc", String.valueOf(eVar.DL()));
            com.baidu.adp.lib.stats.a.hk().a(this.subType, hd);
        }
    }
}
