package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.aRq().aRr()) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "dlStat");
            gs.append("c_dnum", String.valueOf(rVar.num));
            gs.append("c_dfnum", String.valueOf(rVar.failnum));
            gs.append("c_spnum", String.valueOf(rVar.slownum));
            gs.append("c_costt", String.valueOf(rVar.time));
            gs.append("c_dlsize", String.valueOf(rVar.downloadSize));
            gs.append("p_dnum", String.valueOf(rVar2.num));
            gs.append("p_dfnum", String.valueOf(rVar2.failnum));
            gs.append("p_spnum", String.valueOf(rVar2.slownum));
            gs.append("p_costt", String.valueOf(rVar2.time));
            gs.append("p_dlsize", String.valueOf(rVar2.downloadSize));
            gs.append("t_dnum", String.valueOf(rVar3.num));
            gs.append("t_dfnum", String.valueOf(rVar3.failnum));
            gs.append("t_spnum", String.valueOf(rVar3.slownum));
            gs.append("t_costt", String.valueOf(rVar3.time));
            gs.append("t_dlsize", String.valueOf(rVar3.downloadSize));
            gs.append("d_dnum", String.valueOf(rVar4.num));
            gs.append("d_dfnum", String.valueOf(rVar4.failnum));
            gs.append("d_spnum", String.valueOf(rVar4.slownum));
            gs.append("d_costt", String.valueOf(rVar4.time));
            gs.append("d_dlsize", String.valueOf(rVar4.downloadSize));
            gs.append("op_dnum", String.valueOf(rVar5.num));
            gs.append("op_dfnum", String.valueOf(rVar5.failnum));
            gs.append("op_spnum", String.valueOf(rVar5.slownum));
            gs.append("op_costt", String.valueOf(rVar5.time));
            gs.append("op_dlsize", String.valueOf(rVar5.downloadSize));
            gs.append("nettype", m.mO(i));
            BdStatisticsManager.getInstance().performance("image", gs);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.aRq().aRr()) {
            com.baidu.adp.lib.stats.a gs = gs();
            gs.append("action", "dcStat");
            gs.append("dcnum", String.valueOf(i));
            gs.append("dcfnum", String.valueOf(i2));
            gs.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", gs);
        }
    }
}
