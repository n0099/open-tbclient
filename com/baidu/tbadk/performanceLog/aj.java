package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class aj extends ag {
    public void a(aa aaVar) {
        if (ah.CK().CL()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            hC.r("ishttp", aaVar.apz ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hC.r("logid", String.valueOf(aaVar.apk));
            hC.r("issuccess", aaVar.isSuccess ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hC.r("nettype", ah.CK().getNetType());
            hC.r("ct", String.valueOf(aaVar.apm));
            hC.r("wt", String.valueOf(aaVar.apu));
            hC.r("qt", String.valueOf(aaVar.apn));
            hC.r("connt", String.valueOf(aaVar.apo));
            hC.r("rwt", String.valueOf(aaVar.apq));
            hC.r("dect", String.valueOf(aaVar.apr));
            hC.r("parset", String.valueOf(aaVar.aps));
            hC.r("rendert", String.valueOf(aaVar.apt));
            hC.r("ss", String.valueOf(aaVar.apx));
            hC.r("hs", String.valueOf(aaVar.apy));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void b(aa aaVar) {
        if (ah.CK().CL() && aaVar.apu > 0) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "white");
            hC.r("logid", String.valueOf(aaVar.apk));
            hC.r("ct", String.valueOf(aaVar.apm));
            hC.r("wt", String.valueOf(aaVar.apu));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void c(aa aaVar) {
        if (ah.CK().CL() && aaVar.apv > 0) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "readCache");
            hC.r("rct", String.valueOf(aaVar.apv));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void d(aa aaVar) {
        if (ah.CK().CL() && aaVar.apw > 0) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "writeCache");
            hC.r("wct", String.valueOf(aaVar.apw));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void a(z zVar, String str) {
        if (zVar != null && str != null && ah.CK().CL()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "resource");
            hC.r("actype", str);
            hC.r("logid", String.valueOf(zVar.apk));
            hC.r("issuccess", zVar.isSuccess ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hC.r("isfs", zVar.apl ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hC.r("ct", String.valueOf(zVar.Gx));
            hC.r("from", String.valueOf(zVar.Gw));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void g(h hVar) {
        if (hVar != null && ah.CK().CL()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "fluency");
            hC.r("logid", String.valueOf(hVar.apk));
            hC.r("fps", String.valueOf(hVar.Cq()));
            hC.r("memp", String.valueOf(hVar.Cs()));
            hC.r("cpu", String.valueOf(hVar.getCpuString()));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void h(h hVar) {
        if (ah.CK().CL()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "gc");
            hC.r("logid", String.valueOf(hVar.apk));
            hC.r("gc", String.valueOf(hVar.Cr()));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }
}
