package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.LZ().Ma()) {
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append(AuthActivity.ACTION_KEY, "time");
            jo.append("ishttp", iVar.aXm ? "1" : "0");
            jo.append("issuccess", iVar.isSuccess ? "1" : "0");
            jo.append("nettype", m.LZ().getNetType());
            jo.append("wt", String.valueOf(iVar.aXj));
            jo.append("qt", String.valueOf(iVar.aXc));
            jo.append("connt", String.valueOf(iVar.aXd));
            jo.append("rwt", String.valueOf(iVar.aXe));
            jo.append("fbt", String.valueOf(iVar.vH));
            jo.append("abt", String.valueOf(iVar.vI));
            jo.append("dect", String.valueOf(iVar.aXf));
            jo.append("parset", String.valueOf(iVar.aXg));
            jo.append("tqt", String.valueOf(iVar.aXh));
            jo.append("rendert", String.valueOf(iVar.aXi));
            jo.append("ss", String.valueOf(iVar.aXk));
            jo.append("hs", String.valueOf(iVar.aXl));
            if (iVar.aXm && iVar.socketErrNo != 0) {
                jo.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    jo.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.aXm) {
                jo.append("hrtn", String.valueOf(iVar.aXn));
                jo.append("hrtt", String.valueOf(iVar.aXo));
            }
            if (iVar.errCode != 0) {
                jo.f("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.aXp) {
                jo.append(Config.PLATFORM_TYPE, "1");
            } else {
                jo.append("sysct", String.valueOf(iVar.aXa));
                jo.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.aXb));
            }
            if (iVar.aXm) {
                jo.append("c_logid", String.valueOf(iVar.aXq));
                if (iVar.sequenceID != 0) {
                    jo.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                jo.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, jo);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.LZ().Ma()) {
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append(AuthActivity.ACTION_KEY, "resource");
            jo.append("actype", str);
            jo.append("issuccess", hVar.isSuccess ? "1" : "0");
            jo.append("isfs", hVar.aWZ ? "1" : "0");
            jo.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.Nm));
            jo.append("from", String.valueOf(hVar.Nl));
            BdStatisticsManager.getInstance().performance(this.subType, jo);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.LZ().Ma()) {
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append(AuthActivity.ACTION_KEY, "fluency");
            jo.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, jo);
            com.baidu.adp.lib.stats.a jo2 = jo();
            jo2.append(AuthActivity.ACTION_KEY, "mem");
            jo2.append("memp", String.valueOf(m.LZ().Mb()));
            BdStatisticsManager.getInstance().performance(this.subType, jo2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.LZ().Ma()) {
            if (!z || iVar.aXr > 0) {
                if (z || iVar.aXs > 0) {
                    com.baidu.adp.lib.stats.a jo = jo();
                    jo.append(AuthActivity.ACTION_KEY, "time");
                    if (z) {
                        jo.append("put", String.valueOf(iVar.aXr));
                    } else {
                        jo.append("pdt", String.valueOf(iVar.aXs));
                    }
                    jo.append("ishttp", iVar.aXm ? "1" : "0");
                    jo.append("issuccess", iVar.isSuccess ? "1" : "0");
                    jo.append("nettype", m.LZ().getNetType());
                    jo.append("qt", String.valueOf(iVar.aXc));
                    jo.append("connt", String.valueOf(iVar.aXd));
                    jo.append("rwt", String.valueOf(iVar.aXe));
                    jo.append("dect", String.valueOf(iVar.aXf));
                    jo.append("parset", String.valueOf(iVar.aXg));
                    jo.append("rendert", String.valueOf(iVar.aXi));
                    jo.append("ss", String.valueOf(iVar.aXk));
                    jo.append("hs", String.valueOf(iVar.aXl));
                    if (iVar.aXm && iVar.socketErrNo != 0) {
                        jo.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            jo.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        jo.f("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, jo);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.LZ().Ma() && iVar.aXt > 0) {
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append(AuthActivity.ACTION_KEY, "time");
            jo.append("pct", String.valueOf(iVar.aXt));
            switch (i) {
                case 0:
                    jo.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    jo.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, jo);
        }
    }
}
