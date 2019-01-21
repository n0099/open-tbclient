package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.PD().PE()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "dlStat");
            jB.append("c_dnum", String.valueOf(rVar.num));
            jB.append("c_dfnum", String.valueOf(rVar.aAJ));
            jB.append("c_spnum", String.valueOf(rVar.aAK));
            jB.append("c_costt", String.valueOf(rVar.time));
            jB.append("c_dlsize", String.valueOf(rVar.CG));
            jB.append("p_dnum", String.valueOf(rVar2.num));
            jB.append("p_dfnum", String.valueOf(rVar2.aAJ));
            jB.append("p_spnum", String.valueOf(rVar2.aAK));
            jB.append("p_costt", String.valueOf(rVar2.time));
            jB.append("p_dlsize", String.valueOf(rVar2.CG));
            jB.append("t_dnum", String.valueOf(rVar3.num));
            jB.append("t_dfnum", String.valueOf(rVar3.aAJ));
            jB.append("t_spnum", String.valueOf(rVar3.aAK));
            jB.append("t_costt", String.valueOf(rVar3.time));
            jB.append("t_dlsize", String.valueOf(rVar3.CG));
            jB.append("d_dnum", String.valueOf(rVar4.num));
            jB.append("d_dfnum", String.valueOf(rVar4.aAJ));
            jB.append("d_spnum", String.valueOf(rVar4.aAK));
            jB.append("d_costt", String.valueOf(rVar4.time));
            jB.append("d_dlsize", String.valueOf(rVar4.CG));
            jB.append("op_dnum", String.valueOf(rVar5.num));
            jB.append("op_dfnum", String.valueOf(rVar5.aAJ));
            jB.append("op_spnum", String.valueOf(rVar5.aAK));
            jB.append("op_costt", String.valueOf(rVar5.time));
            jB.append("op_dlsize", String.valueOf(rVar5.CG));
            jB.append("nettype", m.gl(i));
            BdStatisticsManager.getInstance().performance("image", jB);
        }
    }

    public static void a(int i, int i2, long j) {
        if (m.PD().PE()) {
            com.baidu.adp.lib.stats.a jB = jB();
            jB.append("action", "dcStat");
            jB.append("dcnum", String.valueOf(i));
            jB.append("dcfnum", String.valueOf(i2));
            jB.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", jB);
        }
    }
}
