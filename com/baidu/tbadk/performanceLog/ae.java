package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ae extends ab {
    public void a(w wVar) {
        if (ac.zs().zt()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            ed.r("ishttp", wVar.agV ? "1" : "0");
            ed.r("logid", String.valueOf(wVar.agH));
            ed.r("issuccess", wVar.isSuccess ? "1" : "0");
            ed.r("nettype", ac.zs().getNetType());
            ed.r("ct", String.valueOf(wVar.agJ));
            ed.r("wt", String.valueOf(wVar.agQ));
            ed.r("qt", String.valueOf(wVar.agK));
            ed.r("connt", String.valueOf(wVar.agL));
            ed.r("rwt", String.valueOf(wVar.agM));
            ed.r("dect", String.valueOf(wVar.agN));
            ed.r("parset", String.valueOf(wVar.agO));
            ed.r("rendert", String.valueOf(wVar.agP));
            ed.r("ss", String.valueOf(wVar.agT));
            ed.r("hs", String.valueOf(wVar.agU));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void b(w wVar) {
        if (ac.zs().zt() && wVar.agQ > 0) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "white");
            ed.r("logid", String.valueOf(wVar.agH));
            ed.r("ct", String.valueOf(wVar.agJ));
            ed.r("wt", String.valueOf(wVar.agQ));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void c(w wVar) {
        if (ac.zs().zt() && wVar.agR > 0) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "readCache");
            ed.r("rct", String.valueOf(wVar.agR));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void d(w wVar) {
        if (ac.zs().zt() && wVar.agS > 0) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "writeCache");
            ed.r("wct", String.valueOf(wVar.agS));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void a(v vVar, String str) {
        if (vVar != null && str != null && ac.zs().zt()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "resource");
            ed.r("actype", str);
            ed.r("logid", String.valueOf(vVar.agH));
            ed.r("issuccess", vVar.isSuccess ? "1" : "0");
            ed.r("isfs", vVar.agI ? "1" : "0");
            ed.r("ct", String.valueOf(vVar.vA));
            ed.r("from", String.valueOf(vVar.vz));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void g(h hVar) {
        if (hVar != null && ac.zs().zt()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "fluency");
            ed.r("logid", String.valueOf(hVar.agH));
            ed.r("fps", String.valueOf(hVar.zc()));
            ed.r("memp", String.valueOf(hVar.ze()));
            ed.r("cpu", String.valueOf(hVar.getCpuString()));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void h(h hVar) {
        if (ac.zs().zt()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "gc");
            ed.r("logid", String.valueOf(hVar.agH));
            ed.r("gc", String.valueOf(hVar.zd()));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }
}
