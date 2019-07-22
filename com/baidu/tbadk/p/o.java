package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.avt().avu()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            iF.append("ishttp", iVar.czZ ? "1" : "0");
            iF.append("issuccess", iVar.isSuccess ? "1" : "0");
            iF.append("nettype", m.avt().getNetType());
            iF.append("wt", String.valueOf(iVar.czW));
            iF.append("qt", String.valueOf(iVar.czP));
            iF.append("connt", String.valueOf(iVar.czQ));
            iF.append("rwt", String.valueOf(iVar.czR));
            iF.append("fbt", String.valueOf(iVar.ud));
            iF.append("abt", String.valueOf(iVar.ue));
            iF.append("dect", String.valueOf(iVar.czS));
            iF.append("parset", String.valueOf(iVar.czT));
            iF.append("tqt", String.valueOf(iVar.czU));
            iF.append("rendert", String.valueOf(iVar.czV));
            iF.append("ss", String.valueOf(iVar.czX));
            iF.append("hs", String.valueOf(iVar.czY));
            if (iVar.czZ && iVar.socketErrNo != 0) {
                iF.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    iF.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.czZ) {
                iF.append("hrtn", String.valueOf(iVar.cAa));
                iF.append("hrtt", String.valueOf(iVar.cAb));
            }
            if (iVar.errCode != 0) {
                iF.c("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cAc) {
                iF.append(Config.PLATFORM_TYPE, "1");
            } else {
                iF.append("sysct", String.valueOf(iVar.czN));
                iF.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.czO));
            }
            if (iVar.czZ) {
                iF.append("c_logid", String.valueOf(iVar.cAd));
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
        if (hVar != null && str != null && m.avt().avu()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "resource");
            iF.append("actype", str);
            iF.append("issuccess", hVar.isSuccess ? "1" : "0");
            iF.append("isfs", hVar.czM ? "1" : "0");
            iF.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.Me));
            iF.append("from", String.valueOf(hVar.Md));
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.avt().avu()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "fluency");
            iF.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, iF);
            com.baidu.adp.lib.stats.a iF2 = iF();
            iF2.append("action", "mem");
            iF2.append("memp", String.valueOf(m.avt().avv()));
            BdStatisticsManager.getInstance().performance(this.subType, iF2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.avt().avu()) {
            if (!z || iVar.cAe > 0) {
                if (z || iVar.cAf > 0) {
                    com.baidu.adp.lib.stats.a iF = iF();
                    iF.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
                    if (z) {
                        iF.append("put", String.valueOf(iVar.cAe));
                    } else {
                        iF.append("pdt", String.valueOf(iVar.cAf));
                    }
                    iF.append("ishttp", iVar.czZ ? "1" : "0");
                    iF.append("issuccess", iVar.isSuccess ? "1" : "0");
                    iF.append("nettype", m.avt().getNetType());
                    iF.append("qt", String.valueOf(iVar.czP));
                    iF.append("connt", String.valueOf(iVar.czQ));
                    iF.append("rwt", String.valueOf(iVar.czR));
                    iF.append("dect", String.valueOf(iVar.czS));
                    iF.append("parset", String.valueOf(iVar.czT));
                    iF.append("rendert", String.valueOf(iVar.czV));
                    iF.append("ss", String.valueOf(iVar.czX));
                    iF.append("hs", String.valueOf(iVar.czY));
                    if (iVar.czZ && iVar.socketErrNo != 0) {
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
        if (m.avt().avu() && iVar.cAg > 0) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            iF.append("pct", String.valueOf(iVar.cAg));
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
