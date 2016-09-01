package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.Gp().Gq()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            eB.q("ishttp", vVar.aCx ? "1" : "0");
            eB.q("issuccess", vVar.isSuccess ? "1" : "0");
            eB.q("nettype", aa.Gp().getNetType());
            eB.q("wt", String.valueOf(vVar.aCs));
            eB.q("qt", String.valueOf(vVar.aCl));
            eB.q("connt", String.valueOf(vVar.aCm));
            eB.q("rwt", String.valueOf(vVar.aCn));
            eB.q("fbt", String.valueOf(vVar.hr));
            eB.q("abt", String.valueOf(vVar.hs));
            eB.q("dect", String.valueOf(vVar.aCo));
            eB.q("parset", String.valueOf(vVar.aCp));
            eB.q("tqt", String.valueOf(vVar.aCq));
            eB.q("rendert", String.valueOf(vVar.aCr));
            eB.q("ss", String.valueOf(vVar.aCv));
            eB.q("hs", String.valueOf(vVar.aCw));
            if (vVar.aCx && vVar.socketErrNo != 0) {
                eB.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    eB.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aCx) {
                eB.q("hrtn", String.valueOf(vVar.aCy));
                eB.q("hrtt", String.valueOf(vVar.aCz));
            }
            if (vVar.errCode != 0) {
                eB.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aCA) {
                eB.q("pt", "1");
            } else {
                eB.q("sysct", String.valueOf(vVar.aCj));
                eB.q("ct", String.valueOf(vVar.aCk));
            }
            if (vVar.aCx) {
                eB.q("c_logid", String.valueOf(vVar.aCB));
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
        if (aa.Gp().Gq() && vVar.aCt > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "readCache");
            eB.q("rct", String.valueOf(vVar.aCt));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void c(v vVar) {
        if (aa.Gp().Gq() && vVar.aCu > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "writeCache");
            eB.q("wct", String.valueOf(vVar.aCu));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.Gp().Gq()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "resource");
            eB.q("actype", str);
            eB.q("issuccess", uVar.isSuccess ? "1" : "0");
            eB.q("isfs", uVar.aCi ? "1" : "0");
            eB.q("ct", String.valueOf(uVar.AA));
            eB.q("from", String.valueOf(uVar.Az));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.Gp().Gq()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "fluency");
            eB.q("fps", String.valueOf(eVar.FZ()));
            eB.q("memp", String.valueOf(eVar.Gb()));
            eB.q("cpu", String.valueOf(eVar.Gc()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void h(e eVar) {
        if (aa.Gp().Gq()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "gc");
            eB.q("gc", String.valueOf(eVar.Ga()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }
}
