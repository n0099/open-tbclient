package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.Gu().Gv()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            eB.q("ishttp", vVar.aCR ? "1" : "0");
            eB.q("issuccess", vVar.isSuccess ? "1" : "0");
            eB.q("nettype", aa.Gu().getNetType());
            eB.q("wt", String.valueOf(vVar.aCM));
            eB.q("qt", String.valueOf(vVar.aCF));
            eB.q("connt", String.valueOf(vVar.aCG));
            eB.q("rwt", String.valueOf(vVar.aCH));
            eB.q("fbt", String.valueOf(vVar.hs));
            eB.q("abt", String.valueOf(vVar.ht));
            eB.q("dect", String.valueOf(vVar.aCI));
            eB.q("parset", String.valueOf(vVar.aCJ));
            eB.q("tqt", String.valueOf(vVar.aCK));
            eB.q("rendert", String.valueOf(vVar.aCL));
            eB.q("ss", String.valueOf(vVar.aCP));
            eB.q("hs", String.valueOf(vVar.aCQ));
            if (vVar.aCR && vVar.socketErrNo != 0) {
                eB.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    eB.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aCR) {
                eB.q("hrtn", String.valueOf(vVar.aCS));
                eB.q("hrtt", String.valueOf(vVar.aCT));
            }
            if (vVar.errCode != 0) {
                eB.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aCU) {
                eB.q("pt", "1");
            } else {
                eB.q("sysct", String.valueOf(vVar.aCD));
                eB.q("ct", String.valueOf(vVar.aCE));
            }
            if (vVar.aCR) {
                eB.q("c_logid", String.valueOf(vVar.aCV));
                if (vVar.sequenceID != 0) {
                    eB.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
                }
            } else {
                eB.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void b(v vVar) {
        if (aa.Gu().Gv() && vVar.aCN > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "readCache");
            eB.q("rct", String.valueOf(vVar.aCN));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void c(v vVar) {
        if (aa.Gu().Gv() && vVar.aCO > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "writeCache");
            eB.q("wct", String.valueOf(vVar.aCO));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.Gu().Gv()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "resource");
            eB.q("actype", str);
            eB.q("issuccess", uVar.isSuccess ? "1" : "0");
            eB.q("isfs", uVar.aCC ? "1" : "0");
            eB.q("ct", String.valueOf(uVar.AA));
            eB.q("from", String.valueOf(uVar.Az));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.Gu().Gv()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "fluency");
            eB.q("fps", String.valueOf(eVar.Ge()));
            eB.q("memp", String.valueOf(eVar.Gg()));
            eB.q("cpu", String.valueOf(eVar.Gh()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void h(e eVar) {
        if (aa.Gu().Gv()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "gc");
            eB.q("gc", String.valueOf(eVar.Gf()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }
}
