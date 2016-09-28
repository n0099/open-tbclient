package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.Go().Gp()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            eB.q("ishttp", vVar.aCa ? "1" : "0");
            eB.q("issuccess", vVar.isSuccess ? "1" : "0");
            eB.q("nettype", aa.Go().getNetType());
            eB.q("wt", String.valueOf(vVar.aBV));
            eB.q("qt", String.valueOf(vVar.aBO));
            eB.q("connt", String.valueOf(vVar.aBP));
            eB.q("rwt", String.valueOf(vVar.aBQ));
            eB.q("fbt", String.valueOf(vVar.hr));
            eB.q("abt", String.valueOf(vVar.hs));
            eB.q("dect", String.valueOf(vVar.aBR));
            eB.q("parset", String.valueOf(vVar.aBS));
            eB.q("tqt", String.valueOf(vVar.aBT));
            eB.q("rendert", String.valueOf(vVar.aBU));
            eB.q("ss", String.valueOf(vVar.aBY));
            eB.q("hs", String.valueOf(vVar.aBZ));
            if (vVar.aCa && vVar.socketErrNo != 0) {
                eB.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    eB.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aCa) {
                eB.q("hrtn", String.valueOf(vVar.aCb));
                eB.q("hrtt", String.valueOf(vVar.aCc));
            }
            if (vVar.errCode != 0) {
                eB.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aCd) {
                eB.q("pt", "1");
            } else {
                eB.q("sysct", String.valueOf(vVar.aBM));
                eB.q("ct", String.valueOf(vVar.aBN));
            }
            if (vVar.aCa) {
                eB.q("c_logid", String.valueOf(vVar.aCe));
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
        if (aa.Go().Gp() && vVar.aBW > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "readCache");
            eB.q("rct", String.valueOf(vVar.aBW));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void c(v vVar) {
        if (aa.Go().Gp() && vVar.aBX > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "writeCache");
            eB.q("wct", String.valueOf(vVar.aBX));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.Go().Gp()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "resource");
            eB.q("actype", str);
            eB.q("issuccess", uVar.isSuccess ? "1" : "0");
            eB.q("isfs", uVar.aBL ? "1" : "0");
            eB.q("ct", String.valueOf(uVar.AA));
            eB.q("from", String.valueOf(uVar.Az));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.Go().Gp()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "fluency");
            eB.q("fps", String.valueOf(eVar.FY()));
            eB.q("memp", String.valueOf(eVar.Ga()));
            eB.q("cpu", String.valueOf(eVar.Gb()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    public void h(e eVar) {
        if (aa.Go().Gp()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "gc");
            eB.q("gc", String.valueOf(eVar.FZ()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }
}
