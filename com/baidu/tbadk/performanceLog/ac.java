package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.FO().FP()) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            ez.q("ishttp", vVar.aBd ? "1" : "0");
            ez.q("issuccess", vVar.isSuccess ? "1" : "0");
            ez.q("nettype", aa.FO().getNetType());
            ez.q("wt", String.valueOf(vVar.aAY));
            ez.q("qt", String.valueOf(vVar.aAR));
            ez.q("connt", String.valueOf(vVar.aAS));
            ez.q("rwt", String.valueOf(vVar.aAT));
            ez.q("fbt", String.valueOf(vVar.hp));
            ez.q("abt", String.valueOf(vVar.hq));
            ez.q("dect", String.valueOf(vVar.aAU));
            ez.q("parset", String.valueOf(vVar.aAV));
            ez.q("tqt", String.valueOf(vVar.aAW));
            ez.q("rendert", String.valueOf(vVar.aAX));
            ez.q("ss", String.valueOf(vVar.aBb));
            ez.q("hs", String.valueOf(vVar.aBc));
            if (vVar.aBd && vVar.socketErrNo != 0) {
                ez.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    ez.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aBd) {
                ez.q("hrtn", String.valueOf(vVar.aBe));
                ez.q("hrtt", String.valueOf(vVar.aBf));
            }
            if (vVar.errCode != 0) {
                ez.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aBg) {
                ez.q("pt", "1");
            } else {
                ez.q("sysct", String.valueOf(vVar.aAP));
                ez.q("ct", String.valueOf(vVar.aAQ));
            }
            if (vVar.aBd) {
                ez.q("c_logid", String.valueOf(vVar.aBh));
                if (vVar.sequenceID != 0) {
                    ez.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
                }
            } else {
                ez.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    public void b(v vVar) {
        if (aa.FO().FP() && vVar.aAZ > 0) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "readCache");
            ez.q("rct", String.valueOf(vVar.aAZ));
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    public void c(v vVar) {
        if (aa.FO().FP() && vVar.aBa > 0) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "writeCache");
            ez.q("wct", String.valueOf(vVar.aBa));
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.FO().FP()) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "resource");
            ez.q("actype", str);
            ez.q("issuccess", uVar.isSuccess ? "1" : "0");
            ez.q("isfs", uVar.aAO ? "1" : "0");
            ez.q("ct", String.valueOf(uVar.Aq));
            ez.q("from", String.valueOf(uVar.Ap));
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.FO().FP()) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "fluency");
            ez.q("fps", String.valueOf(eVar.Fy()));
            ez.q("memp", String.valueOf(eVar.FA()));
            ez.q("cpu", String.valueOf(eVar.FB()));
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }

    public void h(e eVar) {
        if (aa.FO().FP()) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "gc");
            ez.q("gc", String.valueOf(eVar.Fz()));
            com.baidu.adp.lib.stats.a.eG().a(this.subType, ez);
        }
    }
}
