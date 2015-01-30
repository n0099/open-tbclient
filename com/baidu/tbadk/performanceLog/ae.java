package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ae extends ab {
    public void a(w wVar) {
        if (ac.zy().zz()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            ed.r("ishttp", wVar.agY ? "1" : "0");
            ed.r("logid", String.valueOf(wVar.agK));
            ed.r("issuccess", wVar.isSuccess ? "1" : "0");
            ed.r("nettype", ac.zy().getNetType());
            ed.r("ct", String.valueOf(wVar.agM));
            ed.r("wt", String.valueOf(wVar.agT));
            ed.r("qt", String.valueOf(wVar.agN));
            ed.r("connt", String.valueOf(wVar.agO));
            ed.r("rwt", String.valueOf(wVar.agP));
            ed.r("dect", String.valueOf(wVar.agQ));
            ed.r("parset", String.valueOf(wVar.agR));
            ed.r("rendert", String.valueOf(wVar.agS));
            ed.r("ss", String.valueOf(wVar.agW));
            ed.r("hs", String.valueOf(wVar.agX));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void b(w wVar) {
        if (ac.zy().zz() && wVar.agT > 0) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "white");
            ed.r("logid", String.valueOf(wVar.agK));
            ed.r("ct", String.valueOf(wVar.agM));
            ed.r("wt", String.valueOf(wVar.agT));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void c(w wVar) {
        if (ac.zy().zz() && wVar.agU > 0) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "readCache");
            ed.r("rct", String.valueOf(wVar.agU));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void d(w wVar) {
        if (ac.zy().zz() && wVar.agV > 0) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "writeCache");
            ed.r("wct", String.valueOf(wVar.agV));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void a(v vVar, String str) {
        if (vVar != null && str != null && ac.zy().zz()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "resource");
            ed.r("actype", str);
            ed.r("logid", String.valueOf(vVar.agK));
            ed.r("issuccess", vVar.isSuccess ? "1" : "0");
            ed.r("isfs", vVar.agL ? "1" : "0");
            ed.r("ct", String.valueOf(vVar.vD));
            ed.r("from", String.valueOf(vVar.vC));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void g(h hVar) {
        if (hVar != null && ac.zy().zz()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "fluency");
            ed.r("logid", String.valueOf(hVar.agK));
            ed.r("fps", String.valueOf(hVar.zi()));
            ed.r("memp", String.valueOf(hVar.zk()));
            ed.r("cpu", String.valueOf(hVar.getCpuString()));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }

    public void h(h hVar) {
        if (ac.zy().zz()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "gc");
            ed.r("logid", String.valueOf(hVar.agK));
            ed.r("gc", String.valueOf(hVar.zj()));
            com.baidu.adp.lib.stats.f.eq().b(this.subType, ed);
        }
    }
}
