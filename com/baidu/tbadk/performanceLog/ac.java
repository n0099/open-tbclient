package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.FU().FV()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            eB.q("ishttp", vVar.aCl ? "1" : "0");
            eB.q("issuccess", vVar.isSuccess ? "1" : "0");
            eB.q("nettype", aa.FU().getNetType());
            eB.q("wt", String.valueOf(vVar.aCg));
            eB.q("qt", String.valueOf(vVar.aBZ));
            eB.q("connt", String.valueOf(vVar.aCa));
            eB.q("rwt", String.valueOf(vVar.aCb));
            eB.q("fbt", String.valueOf(vVar.hs));
            eB.q("abt", String.valueOf(vVar.ht));
            eB.q("dect", String.valueOf(vVar.aCc));
            eB.q("parset", String.valueOf(vVar.aCd));
            eB.q("tqt", String.valueOf(vVar.aCe));
            eB.q("rendert", String.valueOf(vVar.aCf));
            eB.q("ss", String.valueOf(vVar.aCj));
            eB.q("hs", String.valueOf(vVar.aCk));
            if (vVar.aCl && vVar.socketErrNo != 0) {
                eB.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    eB.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aCl) {
                eB.q("hrtn", String.valueOf(vVar.aCm));
                eB.q("hrtt", String.valueOf(vVar.aCn));
            }
            if (vVar.errCode != 0) {
                eB.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aCo) {
                eB.q("pt", "1");
            } else {
                eB.q("sysct", String.valueOf(vVar.aBX));
                eB.q("ct", String.valueOf(vVar.aBY));
            }
            if (vVar.aCl) {
                eB.q("c_logid", String.valueOf(vVar.aCp));
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
        if (aa.FU().FV() && vVar.aCh > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "readCache");
            eB.q("rct", String.valueOf(vVar.aCh));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void c(v vVar) {
        if (aa.FU().FV() && vVar.aCi > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "writeCache");
            eB.q("wct", String.valueOf(vVar.aCi));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.FU().FV()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "resource");
            eB.q("actype", str);
            eB.q("issuccess", uVar.isSuccess ? "1" : "0");
            eB.q("isfs", uVar.aBW ? "1" : "0");
            eB.q("ct", String.valueOf(uVar.AA));
            eB.q("from", String.valueOf(uVar.Az));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.FU().FV()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "fluency");
            eB.q("fps", String.valueOf(eVar.FE()));
            eB.q("memp", String.valueOf(eVar.FG()));
            eB.q("cpu", String.valueOf(eVar.FH()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void h(e eVar) {
        if (aa.FU().FV()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "gc");
            eB.q("gc", String.valueOf(eVar.FF()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }
}
