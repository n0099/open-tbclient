package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tbadk.game.GameInfoData;
/* loaded from: classes.dex */
public class aj extends ag {
    public void a(aa aaVar) {
        if (ah.DB().DC()) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            hm.r("ishttp", aaVar.aqJ ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hm.r("issuccess", aaVar.isSuccess ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hm.r("nettype", ah.DB().getNetType());
            hm.r("ct", String.valueOf(aaVar.aqx));
            hm.r("wt", String.valueOf(aaVar.aqE));
            hm.r("qt", String.valueOf(aaVar.aqy));
            hm.r("connt", String.valueOf(aaVar.aqz));
            hm.r("rwt", String.valueOf(aaVar.aqA));
            hm.r("dect", String.valueOf(aaVar.aqB));
            hm.r("parset", String.valueOf(aaVar.aqC));
            hm.r("rendert", String.valueOf(aaVar.aqD));
            hm.r("ss", String.valueOf(aaVar.aqH));
            hm.r("hs", String.valueOf(aaVar.aqI));
            com.baidu.adp.lib.stats.f.hz().a(this.subType, -1L, (String) null, hm);
        }
    }

    public void b(aa aaVar) {
        if (ah.DB().DC() && aaVar.aqE > 0) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", "white");
            hm.r("ct", String.valueOf(aaVar.aqx));
            hm.r("wt", String.valueOf(aaVar.aqE));
            com.baidu.adp.lib.stats.f.hz().a(this.subType, -1L, (String) null, hm);
        }
    }

    public void c(aa aaVar) {
        if (ah.DB().DC() && aaVar.aqF > 0) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", "readCache");
            hm.r("rct", String.valueOf(aaVar.aqF));
            com.baidu.adp.lib.stats.f.hz().a(this.subType, -1L, (String) null, hm);
        }
    }

    public void d(aa aaVar) {
        if (ah.DB().DC() && aaVar.aqG > 0) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", "writeCache");
            hm.r("wct", String.valueOf(aaVar.aqG));
            com.baidu.adp.lib.stats.f.hz().a(this.subType, -1L, (String) null, hm);
        }
    }

    public void a(z zVar, String str) {
        if (zVar != null && str != null && ah.DB().DC()) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", "resource");
            hm.r("actype", str);
            hm.r("issuccess", zVar.isSuccess ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hm.r("isfs", zVar.aqw ? "1" : GameInfoData.NOT_FROM_DETAIL);
            hm.r("ct", String.valueOf(zVar.Gp));
            hm.r("from", String.valueOf(zVar.Go));
            com.baidu.adp.lib.stats.f.hz().a(this.subType, -1L, (String) null, hm);
        }
    }

    public void g(h hVar) {
        if (hVar != null && ah.DB().DC()) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", "fluency");
            hm.r("fps", String.valueOf(hVar.Dh()));
            hm.r("memp", String.valueOf(hVar.Dj()));
            hm.r("cpu", String.valueOf(hVar.getCpuString()));
            com.baidu.adp.lib.stats.f.hz().a(this.subType, -1L, (String) null, hm);
        }
    }

    public void h(h hVar) {
        if (ah.DB().DC()) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", "gc");
            hm.r("gc", String.valueOf(hVar.Di()));
            com.baidu.adp.lib.stats.f.hz().a(this.subType, -1L, (String) null, hm);
        }
    }
}
