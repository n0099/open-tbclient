package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.awL().awM()) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "dlStat");
            fU.append("c_dnum", String.valueOf(rVar.num));
            fU.append("c_dfnum", String.valueOf(rVar.failnum));
            fU.append("c_spnum", String.valueOf(rVar.slownum));
            fU.append("c_costt", String.valueOf(rVar.time));
            fU.append("c_dlsize", String.valueOf(rVar.downloadSize));
            fU.append("p_dnum", String.valueOf(rVar2.num));
            fU.append("p_dfnum", String.valueOf(rVar2.failnum));
            fU.append("p_spnum", String.valueOf(rVar2.slownum));
            fU.append("p_costt", String.valueOf(rVar2.time));
            fU.append("p_dlsize", String.valueOf(rVar2.downloadSize));
            fU.append("t_dnum", String.valueOf(rVar3.num));
            fU.append("t_dfnum", String.valueOf(rVar3.failnum));
            fU.append("t_spnum", String.valueOf(rVar3.slownum));
            fU.append("t_costt", String.valueOf(rVar3.time));
            fU.append("t_dlsize", String.valueOf(rVar3.downloadSize));
            fU.append("d_dnum", String.valueOf(rVar4.num));
            fU.append("d_dfnum", String.valueOf(rVar4.failnum));
            fU.append("d_spnum", String.valueOf(rVar4.slownum));
            fU.append("d_costt", String.valueOf(rVar4.time));
            fU.append("d_dlsize", String.valueOf(rVar4.downloadSize));
            fU.append("op_dnum", String.valueOf(rVar5.num));
            fU.append("op_dfnum", String.valueOf(rVar5.failnum));
            fU.append("op_spnum", String.valueOf(rVar5.slownum));
            fU.append("op_costt", String.valueOf(rVar5.time));
            fU.append("op_dlsize", String.valueOf(rVar5.downloadSize));
            fU.append("nettype", m.kg(i));
            BdStatisticsManager.getInstance().performance("image", fU);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.awL().awM()) {
            com.baidu.adp.lib.stats.a fU = fU();
            fU.append("action", "dcStat");
            fU.append("dcnum", String.valueOf(i));
            fU.append("dcfnum", String.valueOf(i2));
            fU.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", fU);
        }
    }
}
