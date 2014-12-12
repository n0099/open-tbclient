package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ae extends ab {
    public void a(w wVar) {
        if (ac.zh().zi()) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            ef.r("ishttp", wVar.agA ? "1" : "0");
            ef.r("logid", String.valueOf(wVar.agm));
            ef.r("issuccess", wVar.isSuccess ? "1" : "0");
            ef.r("nettype", ac.zh().getNetType());
            ef.r("ct", String.valueOf(wVar.ago));
            ef.r("wt", String.valueOf(wVar.agv));
            ef.r("qt", String.valueOf(wVar.agp));
            ef.r("connt", String.valueOf(wVar.agq));
            ef.r("rwt", String.valueOf(wVar.agr));
            ef.r("dect", String.valueOf(wVar.ags));
            ef.r("parset", String.valueOf(wVar.agt));
            ef.r("rendert", String.valueOf(wVar.agu));
            ef.r("ss", String.valueOf(wVar.agy));
            ef.r("hs", String.valueOf(wVar.agz));
            com.baidu.adp.lib.stats.f.es().b(this.subType, ef);
        }
    }

    public void b(w wVar) {
        if (ac.zh().zi() && wVar.agv > 0) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("action", "white");
            ef.r("logid", String.valueOf(wVar.agm));
            ef.r("ct", String.valueOf(wVar.ago));
            ef.r("wt", String.valueOf(wVar.agv));
            com.baidu.adp.lib.stats.f.es().b(this.subType, ef);
        }
    }

    public void c(w wVar) {
        if (ac.zh().zi() && wVar.agw > 0) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("action", "readCache");
            ef.r("rct", String.valueOf(wVar.agw));
            com.baidu.adp.lib.stats.f.es().b(this.subType, ef);
        }
    }

    public void d(w wVar) {
        if (ac.zh().zi() && wVar.agx > 0) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("action", "writeCache");
            ef.r("wct", String.valueOf(wVar.agx));
            com.baidu.adp.lib.stats.f.es().b(this.subType, ef);
        }
    }

    public void a(v vVar, String str) {
        if (vVar != null && str != null && ac.zh().zi()) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("action", "resource");
            ef.r("actype", str);
            ef.r("logid", String.valueOf(vVar.agm));
            ef.r("issuccess", vVar.isSuccess ? "1" : "0");
            ef.r("isfs", vVar.agn ? "1" : "0");
            ef.r("ct", String.valueOf(vVar.vx));
            ef.r("from", String.valueOf(vVar.vw));
            com.baidu.adp.lib.stats.f.es().b(this.subType, ef);
        }
    }

    public void g(h hVar) {
        if (hVar != null && ac.zh().zi()) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("action", "fluency");
            ef.r("logid", String.valueOf(hVar.agm));
            ef.r("fps", String.valueOf(hVar.yR()));
            ef.r("memp", String.valueOf(hVar.yT()));
            ef.r("cpu", String.valueOf(hVar.getCpuString()));
            com.baidu.adp.lib.stats.f.es().b(this.subType, ef);
        }
    }

    public void h(h hVar) {
        if (ac.zh().zi()) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("action", "gc");
            ef.r("logid", String.valueOf(hVar.agm));
            ef.r("gc", String.valueOf(hVar.yS()));
            com.baidu.adp.lib.stats.f.es().b(this.subType, ef);
        }
    }
}
