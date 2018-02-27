package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class r extends o {
    public void a(l lVar) {
        if (p.Ov().Ow()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            nn.append("ishttp", lVar.bAC ? "1" : "0");
            nn.append("issuccess", lVar.isSuccess ? "1" : "0");
            nn.append("nettype", p.Ov().getNetType());
            nn.append("wt", String.valueOf(lVar.bAx));
            nn.append("qt", String.valueOf(lVar.bAq));
            nn.append("connt", String.valueOf(lVar.bAr));
            nn.append("rwt", String.valueOf(lVar.bAs));
            nn.append("fbt", String.valueOf(lVar.acF));
            nn.append("abt", String.valueOf(lVar.acG));
            nn.append("dect", String.valueOf(lVar.bAt));
            nn.append("parset", String.valueOf(lVar.bAu));
            nn.append("tqt", String.valueOf(lVar.bAv));
            nn.append("rendert", String.valueOf(lVar.bAw));
            nn.append("ss", String.valueOf(lVar.bAA));
            nn.append("hs", String.valueOf(lVar.bAB));
            if (lVar.bAC && lVar.socketErrNo != 0) {
                nn.append("salno", String.valueOf(lVar.socketErrNo));
                if (lVar.socketCostTime != 0) {
                    nn.append("scosttime", String.valueOf(lVar.socketCostTime));
                }
            }
            if (lVar.bAC) {
                nn.append("hrtn", String.valueOf(lVar.bAD));
                nn.append("hrtt", String.valueOf(lVar.bAE));
            }
            if (lVar.errCode != 0) {
                nn.h("errcode", Integer.valueOf(lVar.errCode));
            }
            if (lVar.bAF) {
                nn.append("pt", "1");
            } else {
                nn.append("sysct", String.valueOf(lVar.bAo));
                nn.append("ct", String.valueOf(lVar.bAp));
            }
            if (lVar.bAC) {
                nn.append("c_logid", String.valueOf(lVar.bAG));
                if (lVar.sequenceID != 0) {
                    nn.append("seq_id", String.valueOf(lVar.sequenceID & 4294967295L));
                }
            } else {
                nn.append("seq_id", String.valueOf(lVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    public void b(l lVar) {
        if (p.Ov().Ow() && lVar.bAy > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "readCache");
            nn.append("rct", String.valueOf(lVar.bAy));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    public void c(l lVar) {
        if (p.Ov().Ow() && lVar.bAz > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "writeCache");
            nn.append("wct", String.valueOf(lVar.bAz));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    public void a(k kVar, String str) {
        if (kVar != null && str != null && p.Ov().Ow()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "resource");
            nn.append("actype", str);
            nn.append("issuccess", kVar.isSuccess ? "1" : "0");
            nn.append("isfs", kVar.bAn ? "1" : "0");
            nn.append("ct", String.valueOf(kVar.aue));
            nn.append("from", String.valueOf(kVar.aud));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    public void g(d dVar) {
        if (dVar != null && p.Ov().Ow()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "fluency");
            nn.append("fps", String.valueOf(dVar.Of()));
            nn.append("memp", String.valueOf(dVar.Oh()));
            nn.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(dVar.Oi()));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    public void h(d dVar) {
        if (p.Ov().Ow()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "gc");
            nn.append("gc", String.valueOf(dVar.Og()));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }
}
