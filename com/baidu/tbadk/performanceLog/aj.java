package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class aj extends ag {
    public void a(aa aaVar) {
        if (ah.CQ().CR()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            hC.r("ishttp", aaVar.apH ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hC.r("logid", String.valueOf(aaVar.apt));
            hC.r("issuccess", aaVar.isSuccess ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hC.r("nettype", ah.CQ().getNetType());
            hC.r("ct", String.valueOf(aaVar.apv));
            hC.r("wt", String.valueOf(aaVar.apC));
            hC.r("qt", String.valueOf(aaVar.apw));
            hC.r("connt", String.valueOf(aaVar.apx));
            hC.r("rwt", String.valueOf(aaVar.apy));
            hC.r("dect", String.valueOf(aaVar.apz));
            hC.r("parset", String.valueOf(aaVar.apA));
            hC.r("rendert", String.valueOf(aaVar.apB));
            hC.r("ss", String.valueOf(aaVar.apF));
            hC.r("hs", String.valueOf(aaVar.apG));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void b(aa aaVar) {
        if (ah.CQ().CR() && aaVar.apC > 0) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "white");
            hC.r("logid", String.valueOf(aaVar.apt));
            hC.r("ct", String.valueOf(aaVar.apv));
            hC.r("wt", String.valueOf(aaVar.apC));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void c(aa aaVar) {
        if (ah.CQ().CR() && aaVar.apD > 0) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "readCache");
            hC.r("rct", String.valueOf(aaVar.apD));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void d(aa aaVar) {
        if (ah.CQ().CR() && aaVar.apE > 0) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "writeCache");
            hC.r("wct", String.valueOf(aaVar.apE));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void a(z zVar, String str) {
        if (zVar != null && str != null && ah.CQ().CR()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "resource");
            hC.r("actype", str);
            hC.r("logid", String.valueOf(zVar.apt));
            hC.r("issuccess", zVar.isSuccess ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hC.r("isfs", zVar.apu ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hC.r("ct", String.valueOf(zVar.Gz));
            hC.r("from", String.valueOf(zVar.Gy));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void g(h hVar) {
        if (hVar != null && ah.CQ().CR()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "fluency");
            hC.r("logid", String.valueOf(hVar.apt));
            hC.r("fps", String.valueOf(hVar.Cw()));
            hC.r("memp", String.valueOf(hVar.Cy()));
            hC.r("cpu", String.valueOf(hVar.getCpuString()));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }

    public void h(h hVar) {
        if (ah.CQ().CR()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "gc");
            hC.r("logid", String.valueOf(hVar.apt));
            hC.r("gc", String.valueOf(hVar.Cx()));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }
}
