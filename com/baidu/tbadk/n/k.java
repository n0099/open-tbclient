package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.aOA().aOB()) {
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("action", "dlStat");
            gt.append("c_dnum", String.valueOf(rVar.num));
            gt.append("c_dfnum", String.valueOf(rVar.failnum));
            gt.append("c_spnum", String.valueOf(rVar.slownum));
            gt.append("c_costt", String.valueOf(rVar.time));
            gt.append("c_dlsize", String.valueOf(rVar.downloadSize));
            gt.append("p_dnum", String.valueOf(rVar2.num));
            gt.append("p_dfnum", String.valueOf(rVar2.failnum));
            gt.append("p_spnum", String.valueOf(rVar2.slownum));
            gt.append("p_costt", String.valueOf(rVar2.time));
            gt.append("p_dlsize", String.valueOf(rVar2.downloadSize));
            gt.append("t_dnum", String.valueOf(rVar3.num));
            gt.append("t_dfnum", String.valueOf(rVar3.failnum));
            gt.append("t_spnum", String.valueOf(rVar3.slownum));
            gt.append("t_costt", String.valueOf(rVar3.time));
            gt.append("t_dlsize", String.valueOf(rVar3.downloadSize));
            gt.append("d_dnum", String.valueOf(rVar4.num));
            gt.append("d_dfnum", String.valueOf(rVar4.failnum));
            gt.append("d_spnum", String.valueOf(rVar4.slownum));
            gt.append("d_costt", String.valueOf(rVar4.time));
            gt.append("d_dlsize", String.valueOf(rVar4.downloadSize));
            gt.append("op_dnum", String.valueOf(rVar5.num));
            gt.append("op_dfnum", String.valueOf(rVar5.failnum));
            gt.append("op_spnum", String.valueOf(rVar5.slownum));
            gt.append("op_costt", String.valueOf(rVar5.time));
            gt.append("op_dlsize", String.valueOf(rVar5.downloadSize));
            gt.append("nettype", m.mv(i));
            BdStatisticsManager.getInstance().performance("image", gt);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.aOA().aOB()) {
            com.baidu.adp.lib.stats.a gt = gt();
            gt.append("action", "dcStat");
            gt.append("dcnum", String.valueOf(i));
            gt.append("dcfnum", String.valueOf(i2));
            gt.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", gt);
        }
    }
}
