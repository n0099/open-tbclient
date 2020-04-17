package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.aZA().aZB()) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("action", "dlStat");
            kW.append("c_dnum", String.valueOf(rVar.num));
            kW.append("c_dfnum", String.valueOf(rVar.failnum));
            kW.append("c_spnum", String.valueOf(rVar.slownum));
            kW.append("c_costt", String.valueOf(rVar.time));
            kW.append("c_dlsize", String.valueOf(rVar.downloadSize));
            kW.append("p_dnum", String.valueOf(rVar2.num));
            kW.append("p_dfnum", String.valueOf(rVar2.failnum));
            kW.append("p_spnum", String.valueOf(rVar2.slownum));
            kW.append("p_costt", String.valueOf(rVar2.time));
            kW.append("p_dlsize", String.valueOf(rVar2.downloadSize));
            kW.append("t_dnum", String.valueOf(rVar3.num));
            kW.append("t_dfnum", String.valueOf(rVar3.failnum));
            kW.append("t_spnum", String.valueOf(rVar3.slownum));
            kW.append("t_costt", String.valueOf(rVar3.time));
            kW.append("t_dlsize", String.valueOf(rVar3.downloadSize));
            kW.append("d_dnum", String.valueOf(rVar4.num));
            kW.append("d_dfnum", String.valueOf(rVar4.failnum));
            kW.append("d_spnum", String.valueOf(rVar4.slownum));
            kW.append("d_costt", String.valueOf(rVar4.time));
            kW.append("d_dlsize", String.valueOf(rVar4.downloadSize));
            kW.append("op_dnum", String.valueOf(rVar5.num));
            kW.append("op_dfnum", String.valueOf(rVar5.failnum));
            kW.append("op_spnum", String.valueOf(rVar5.slownum));
            kW.append("op_costt", String.valueOf(rVar5.time));
            kW.append("op_dlsize", String.valueOf(rVar5.downloadSize));
            kW.append("nettype", m.mZ(i));
            BdStatisticsManager.getInstance().performance("image", kW);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.aZA().aZB()) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("action", "dcStat");
            kW.append("dcnum", String.valueOf(i));
            kW.append("dcfnum", String.valueOf(i2));
            kW.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", kW);
        }
    }
}
