package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class o extends ac {
    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(v vVar) {
        if (aa.FO().FP()) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "time_t");
            a(ez, vVar);
            ez.q("ishttp", vVar.aBd ? "1" : "0");
            ez.q("issuccess", vVar.isSuccess ? "1" : "0");
            ez.q("nettype", aa.FO().getNetType());
            ez.q("ct", String.valueOf(vVar.aAQ));
            ez.q("wt", String.valueOf(vVar.aAY));
            ez.q("qt", String.valueOf(vVar.aAR));
            ez.q("connt", String.valueOf(vVar.aAS));
            ez.q("rwt", String.valueOf(vVar.aAT));
            ez.q("dect", String.valueOf(vVar.aAU));
            ez.q("parset", String.valueOf(vVar.aAV));
            ez.q("rendert", String.valueOf(vVar.aAX));
            ez.q("ss", String.valueOf(vVar.aBb));
            ez.q("hs", String.valueOf(vVar.aBc));
            if (vVar.aBd && vVar.socketErrNo != 0) {
                ez.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    ez.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                ez.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aBd) {
                ez.q("c_logid", String.valueOf(vVar.aBh));
            } else {
                ez.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void b(v vVar) {
        if (aa.FO().FP() && vVar.aAZ > 0) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "readCache_t");
            a(ez, vVar);
            ez.q("rct", String.valueOf(vVar.aAZ));
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void c(v vVar) {
        if (aa.FO().FP() && vVar.aBa > 0) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "writeCache_t");
            a(ez, vVar);
            ez.q("wct", String.valueOf(vVar.aBa));
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.FO().FP()) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "resource_t");
            ez.q("actype", str);
            ez.q("issuccess", uVar.isSuccess ? "1" : "0");
            ez.q("isfs", uVar.aAO ? "1" : "0");
            ez.q("ct", String.valueOf(uVar.Aq));
            ez.q("from", String.valueOf(uVar.Ap));
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void g(e eVar) {
        if (eVar != null && aa.FO().FP()) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "fluency_t");
            a(ez, eVar);
            ez.q("fps", String.valueOf(eVar.Fy()));
            ez.q("memp", String.valueOf(eVar.FA()));
            ez.q("cpu", String.valueOf(eVar.FB()));
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void h(e eVar) {
        if (aa.FO().FP()) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "gc_t");
            a(ez, eVar);
            ez.q("gc", String.valueOf(eVar.Fz()));
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    private void a(com.baidu.adp.lib.stats.d dVar, e eVar) {
        if (eVar instanceof m) {
            dVar.d("ptype", Integer.valueOf(((m) eVar).pageType));
        }
    }

    private void a(com.baidu.adp.lib.stats.d dVar, v vVar) {
        if (vVar instanceof n) {
            dVar.d("ptype", Integer.valueOf(((n) vVar).pageType));
        }
    }
}
