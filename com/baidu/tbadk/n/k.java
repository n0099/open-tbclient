package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.s;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(s sVar, s sVar2, s sVar3, s sVar4, s sVar5, int i) {
        if (m.bhP().bhQ()) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "dlStat");
            lo.append("c_dnum", String.valueOf(sVar.num));
            lo.append("c_dfnum", String.valueOf(sVar.failnum));
            lo.append("c_spnum", String.valueOf(sVar.slownum));
            lo.append("c_costt", String.valueOf(sVar.time));
            lo.append("c_dlsize", String.valueOf(sVar.downloadSize));
            lo.append("p_dnum", String.valueOf(sVar2.num));
            lo.append("p_dfnum", String.valueOf(sVar2.failnum));
            lo.append("p_spnum", String.valueOf(sVar2.slownum));
            lo.append("p_costt", String.valueOf(sVar2.time));
            lo.append("p_dlsize", String.valueOf(sVar2.downloadSize));
            lo.append("t_dnum", String.valueOf(sVar3.num));
            lo.append("t_dfnum", String.valueOf(sVar3.failnum));
            lo.append("t_spnum", String.valueOf(sVar3.slownum));
            lo.append("t_costt", String.valueOf(sVar3.time));
            lo.append("t_dlsize", String.valueOf(sVar3.downloadSize));
            lo.append("d_dnum", String.valueOf(sVar4.num));
            lo.append("d_dfnum", String.valueOf(sVar4.failnum));
            lo.append("d_spnum", String.valueOf(sVar4.slownum));
            lo.append("d_costt", String.valueOf(sVar4.time));
            lo.append("d_dlsize", String.valueOf(sVar4.downloadSize));
            lo.append("op_dnum", String.valueOf(sVar5.num));
            lo.append("op_dfnum", String.valueOf(sVar5.failnum));
            lo.append("op_spnum", String.valueOf(sVar5.slownum));
            lo.append("op_costt", String.valueOf(sVar5.time));
            lo.append("op_dlsize", String.valueOf(sVar5.downloadSize));
            lo.append("nettype", m.nY(i));
            BdStatisticsManager.getInstance().performance("image", lo);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.bhP().bhQ()) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "dcStat");
            lo.append("dcnum", String.valueOf(i));
            lo.append("dcfnum", String.valueOf(i2));
            lo.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", lo);
        }
    }
}
