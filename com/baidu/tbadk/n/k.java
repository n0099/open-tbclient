package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (m.blA().blB()) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "dlStat");
            lo.append("c_dnum", String.valueOf(tVar.num));
            lo.append("c_dfnum", String.valueOf(tVar.failnum));
            lo.append("c_spnum", String.valueOf(tVar.slownum));
            lo.append("c_costt", String.valueOf(tVar.time));
            lo.append("c_dlsize", String.valueOf(tVar.downloadSize));
            lo.append("p_dnum", String.valueOf(tVar2.num));
            lo.append("p_dfnum", String.valueOf(tVar2.failnum));
            lo.append("p_spnum", String.valueOf(tVar2.slownum));
            lo.append("p_costt", String.valueOf(tVar2.time));
            lo.append("p_dlsize", String.valueOf(tVar2.downloadSize));
            lo.append("t_dnum", String.valueOf(tVar3.num));
            lo.append("t_dfnum", String.valueOf(tVar3.failnum));
            lo.append("t_spnum", String.valueOf(tVar3.slownum));
            lo.append("t_costt", String.valueOf(tVar3.time));
            lo.append("t_dlsize", String.valueOf(tVar3.downloadSize));
            lo.append("d_dnum", String.valueOf(tVar4.num));
            lo.append("d_dfnum", String.valueOf(tVar4.failnum));
            lo.append("d_spnum", String.valueOf(tVar4.slownum));
            lo.append("d_costt", String.valueOf(tVar4.time));
            lo.append("d_dlsize", String.valueOf(tVar4.downloadSize));
            lo.append("op_dnum", String.valueOf(tVar5.num));
            lo.append("op_dfnum", String.valueOf(tVar5.failnum));
            lo.append("op_spnum", String.valueOf(tVar5.slownum));
            lo.append("op_costt", String.valueOf(tVar5.time));
            lo.append("op_dlsize", String.valueOf(tVar5.downloadSize));
            lo.append("nettype", m.oq(i));
            BdStatisticsManager.getInstance().performance("image", lo);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.blA().blB()) {
            com.baidu.adp.lib.stats.a lo = lo();
            lo.append("action", "dcStat");
            lo.append("dcnum", String.valueOf(i));
            lo.append("dcfnum", String.valueOf(i2));
            lo.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", lo);
        }
    }
}
