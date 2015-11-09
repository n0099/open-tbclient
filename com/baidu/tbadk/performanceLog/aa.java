package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class aa extends x {
    public void a(t tVar) {
        if (y.DR().DS()) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            hc.q("ishttp", tVar.awt ? "1" : "0");
            hc.q("issuccess", tVar.isSuccess ? "1" : "0");
            hc.q("nettype", y.DR().getNetType());
            hc.q("ct", String.valueOf(tVar.awh));
            hc.q("wt", String.valueOf(tVar.awo));
            hc.q("qt", String.valueOf(tVar.awi));
            hc.q("connt", String.valueOf(tVar.awj));
            hc.q("rwt", String.valueOf(tVar.awk));
            hc.q("dect", String.valueOf(tVar.awl));
            hc.q("parset", String.valueOf(tVar.awm));
            hc.q("rendert", String.valueOf(tVar.awn));
            hc.q("ss", String.valueOf(tVar.awr));
            hc.q("hs", String.valueOf(tVar.aws));
            com.baidu.adp.lib.stats.a.hj().a(this.subType, hc);
        }
    }

    public void b(t tVar) {
        if (y.DR().DS() && tVar.awo > 0) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("action", "white");
            hc.q("ct", String.valueOf(tVar.awh));
            hc.q("wt", String.valueOf(tVar.awo));
            com.baidu.adp.lib.stats.a.hj().a(this.subType, hc);
        }
    }

    public void c(t tVar) {
        if (y.DR().DS() && tVar.awp > 0) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("action", "readCache");
            hc.q("rct", String.valueOf(tVar.awp));
            com.baidu.adp.lib.stats.a.hj().a(this.subType, hc);
        }
    }

    public void d(t tVar) {
        if (y.DR().DS() && tVar.awq > 0) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("action", "writeCache");
            hc.q("wct", String.valueOf(tVar.awq));
            com.baidu.adp.lib.stats.a.hj().a(this.subType, hc);
        }
    }

    public void a(s sVar, String str) {
        if (sVar != null && str != null && y.DR().DS()) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("action", "resource");
            hc.q("actype", str);
            hc.q("issuccess", sVar.isSuccess ? "1" : "0");
            hc.q("isfs", sVar.awg ? "1" : "0");
            hc.q("ct", String.valueOf(sVar.Gs));
            hc.q("from", String.valueOf(sVar.Gr));
            com.baidu.adp.lib.stats.a.hj().a(this.subType, hc);
        }
    }

    public void g(e eVar) {
        if (eVar != null && y.DR().DS()) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("action", "fluency");
            hc.q("fps", String.valueOf(eVar.Dx()));
            hc.q("memp", String.valueOf(eVar.Dz()));
            hc.q("cpu", String.valueOf(eVar.getCpuString()));
            com.baidu.adp.lib.stats.a.hj().a(this.subType, hc);
        }
    }

    public void h(e eVar) {
        if (y.DR().DS()) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("action", "gc");
            hc.q("gc", String.valueOf(eVar.Dy()));
            com.baidu.adp.lib.stats.a.hj().a(this.subType, hc);
        }
    }
}
