package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.avv().avw()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            iF.append("ishttp", iVar.cAg ? "1" : "0");
            iF.append("issuccess", iVar.isSuccess ? "1" : "0");
            iF.append("nettype", m.avv().getNetType());
            iF.append("wt", String.valueOf(iVar.cAd));
            iF.append("qt", String.valueOf(iVar.czW));
            iF.append("connt", String.valueOf(iVar.czX));
            iF.append("rwt", String.valueOf(iVar.czY));
            iF.append("fbt", String.valueOf(iVar.ud));
            iF.append("abt", String.valueOf(iVar.ue));
            iF.append("dect", String.valueOf(iVar.czZ));
            iF.append("parset", String.valueOf(iVar.cAa));
            iF.append("tqt", String.valueOf(iVar.cAb));
            iF.append("rendert", String.valueOf(iVar.cAc));
            iF.append("ss", String.valueOf(iVar.cAe));
            iF.append("hs", String.valueOf(iVar.cAf));
            if (iVar.cAg && iVar.socketErrNo != 0) {
                iF.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    iF.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.cAg) {
                iF.append("hrtn", String.valueOf(iVar.cAh));
                iF.append("hrtt", String.valueOf(iVar.cAi));
            }
            if (iVar.errCode != 0) {
                iF.c("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cAj) {
                iF.append(Config.PLATFORM_TYPE, "1");
            } else {
                iF.append("sysct", String.valueOf(iVar.czU));
                iF.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.czV));
            }
            if (iVar.cAg) {
                iF.append("c_logid", String.valueOf(iVar.cAk));
                if (iVar.sequenceID != 0) {
                    iF.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                iF.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.avv().avw()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "resource");
            iF.append("actype", str);
            iF.append("issuccess", hVar.isSuccess ? "1" : "0");
            iF.append("isfs", hVar.czT ? "1" : "0");
            iF.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.Me));
            iF.append("from", String.valueOf(hVar.Md));
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.avv().avw()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "fluency");
            iF.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, iF);
            com.baidu.adp.lib.stats.a iF2 = iF();
            iF2.append("action", "mem");
            iF2.append("memp", String.valueOf(m.avv().avx()));
            BdStatisticsManager.getInstance().performance(this.subType, iF2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.avv().avw()) {
            if (!z || iVar.cAl > 0) {
                if (z || iVar.cAm > 0) {
                    com.baidu.adp.lib.stats.a iF = iF();
                    iF.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    if (z) {
                        iF.append("put", String.valueOf(iVar.cAl));
                    } else {
                        iF.append("pdt", String.valueOf(iVar.cAm));
                    }
                    iF.append("ishttp", iVar.cAg ? "1" : "0");
                    iF.append("issuccess", iVar.isSuccess ? "1" : "0");
                    iF.append("nettype", m.avv().getNetType());
                    iF.append("qt", String.valueOf(iVar.czW));
                    iF.append("connt", String.valueOf(iVar.czX));
                    iF.append("rwt", String.valueOf(iVar.czY));
                    iF.append("dect", String.valueOf(iVar.czZ));
                    iF.append("parset", String.valueOf(iVar.cAa));
                    iF.append("rendert", String.valueOf(iVar.cAc));
                    iF.append("ss", String.valueOf(iVar.cAe));
                    iF.append("hs", String.valueOf(iVar.cAf));
                    if (iVar.cAg && iVar.socketErrNo != 0) {
                        iF.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            iF.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        iF.c("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, iF);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.avv().avw() && iVar.cAn > 0) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            iF.append("pct", String.valueOf(iVar.cAn));
            switch (i) {
                case 0:
                    iF.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    iF.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }
}
