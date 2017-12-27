package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.Oa().Ob()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            nm.append("ishttp", mVar.byt ? "1" : "0");
            nm.append("issuccess", mVar.isSuccess ? "1" : "0");
            nm.append("nettype", r.Oa().getNetType());
            nm.append("wt", String.valueOf(mVar.byo));
            nm.append("qt", String.valueOf(mVar.byh));
            nm.append("connt", String.valueOf(mVar.byi));
            nm.append("rwt", String.valueOf(mVar.byj));
            nm.append("fbt", String.valueOf(mVar.acN));
            nm.append("abt", String.valueOf(mVar.acO));
            nm.append("dect", String.valueOf(mVar.byk));
            nm.append("parset", String.valueOf(mVar.byl));
            nm.append("tqt", String.valueOf(mVar.bym));
            nm.append("rendert", String.valueOf(mVar.byn));
            nm.append("ss", String.valueOf(mVar.byr));
            nm.append("hs", String.valueOf(mVar.bys));
            if (mVar.byt && mVar.socketErrNo != 0) {
                nm.append("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    nm.append("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.byt) {
                nm.append("hrtn", String.valueOf(mVar.byu));
                nm.append("hrtt", String.valueOf(mVar.byv));
            }
            if (mVar.errCode != 0) {
                nm.h("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.byw) {
                nm.append("pt", "1");
            } else {
                nm.append("sysct", String.valueOf(mVar.byf));
                nm.append("ct", String.valueOf(mVar.byg));
            }
            if (mVar.byt) {
                nm.append("c_logid", String.valueOf(mVar.byx));
                if (mVar.sequenceID != 0) {
                    nm.append("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
                }
            } else {
                nm.append("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    public void b(m mVar) {
        if (r.Oa().Ob() && mVar.byp > 0) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "readCache");
            nm.append("rct", String.valueOf(mVar.byp));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    public void c(m mVar) {
        if (r.Oa().Ob() && mVar.byq > 0) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "writeCache");
            nm.append("wct", String.valueOf(mVar.byq));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Oa().Ob()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "resource");
            nm.append("actype", str);
            nm.append("issuccess", lVar.isSuccess ? "1" : "0");
            nm.append("isfs", lVar.bye ? "1" : "0");
            nm.append("ct", String.valueOf(lVar.auq));
            nm.append("from", String.valueOf(lVar.aup));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    public void g(d dVar) {
        if (dVar != null && r.Oa().Ob()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "fluency");
            nm.append("fps", String.valueOf(dVar.NK()));
            nm.append("memp", String.valueOf(dVar.NM()));
            nm.append("cpu", String.valueOf(dVar.NN()));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    public void h(d dVar) {
        if (r.Oa().Ob()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "gc");
            nm.append("gc", String.valueOf(dVar.NL()));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }
}
