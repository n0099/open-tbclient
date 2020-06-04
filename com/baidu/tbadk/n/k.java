package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.bfJ().bfK()) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("action", "dlStat");
            kY.append("c_dnum", String.valueOf(rVar.num));
            kY.append("c_dfnum", String.valueOf(rVar.failnum));
            kY.append("c_spnum", String.valueOf(rVar.slownum));
            kY.append("c_costt", String.valueOf(rVar.time));
            kY.append("c_dlsize", String.valueOf(rVar.downloadSize));
            kY.append("p_dnum", String.valueOf(rVar2.num));
            kY.append("p_dfnum", String.valueOf(rVar2.failnum));
            kY.append("p_spnum", String.valueOf(rVar2.slownum));
            kY.append("p_costt", String.valueOf(rVar2.time));
            kY.append("p_dlsize", String.valueOf(rVar2.downloadSize));
            kY.append("t_dnum", String.valueOf(rVar3.num));
            kY.append("t_dfnum", String.valueOf(rVar3.failnum));
            kY.append("t_spnum", String.valueOf(rVar3.slownum));
            kY.append("t_costt", String.valueOf(rVar3.time));
            kY.append("t_dlsize", String.valueOf(rVar3.downloadSize));
            kY.append("d_dnum", String.valueOf(rVar4.num));
            kY.append("d_dfnum", String.valueOf(rVar4.failnum));
            kY.append("d_spnum", String.valueOf(rVar4.slownum));
            kY.append("d_costt", String.valueOf(rVar4.time));
            kY.append("d_dlsize", String.valueOf(rVar4.downloadSize));
            kY.append("op_dnum", String.valueOf(rVar5.num));
            kY.append("op_dfnum", String.valueOf(rVar5.failnum));
            kY.append("op_spnum", String.valueOf(rVar5.slownum));
            kY.append("op_costt", String.valueOf(rVar5.time));
            kY.append("op_dlsize", String.valueOf(rVar5.downloadSize));
            kY.append("nettype", m.nD(i));
            BdStatisticsManager.getInstance().performance("image", kY);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.bfJ().bfK()) {
            com.baidu.adp.lib.stats.a kY = kY();
            kY.append("action", "dcStat");
            kY.append("dcnum", String.valueOf(i));
            kY.append("dcfnum", String.valueOf(i2));
            kY.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", kY);
        }
    }
}
