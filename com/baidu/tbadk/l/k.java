package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.NX().NY()) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("action", "dlStat");
            jD.append("c_dnum", String.valueOf(rVar.num));
            jD.append("c_dfnum", String.valueOf(rVar.avT));
            jD.append("c_spnum", String.valueOf(rVar.avU));
            jD.append("c_costt", String.valueOf(rVar.time));
            jD.append("c_dlsize", String.valueOf(rVar.CC));
            jD.append("p_dnum", String.valueOf(rVar2.num));
            jD.append("p_dfnum", String.valueOf(rVar2.avT));
            jD.append("p_spnum", String.valueOf(rVar2.avU));
            jD.append("p_costt", String.valueOf(rVar2.time));
            jD.append("p_dlsize", String.valueOf(rVar2.CC));
            jD.append("t_dnum", String.valueOf(rVar3.num));
            jD.append("t_dfnum", String.valueOf(rVar3.avT));
            jD.append("t_spnum", String.valueOf(rVar3.avU));
            jD.append("t_costt", String.valueOf(rVar3.time));
            jD.append("t_dlsize", String.valueOf(rVar3.CC));
            jD.append("d_dnum", String.valueOf(rVar4.num));
            jD.append("d_dfnum", String.valueOf(rVar4.avT));
            jD.append("d_spnum", String.valueOf(rVar4.avU));
            jD.append("d_costt", String.valueOf(rVar4.time));
            jD.append("d_dlsize", String.valueOf(rVar4.CC));
            jD.append("op_dnum", String.valueOf(rVar5.num));
            jD.append("op_dfnum", String.valueOf(rVar5.avT));
            jD.append("op_spnum", String.valueOf(rVar5.avU));
            jD.append("op_costt", String.valueOf(rVar5.time));
            jD.append("op_dlsize", String.valueOf(rVar5.CC));
            jD.append("nettype", m.fI(i));
            BdStatisticsManager.getInstance().performance("image", jD);
        }
    }

    public static void a(int i, int i2, long j) {
        if (m.NX().NY()) {
            com.baidu.adp.lib.stats.a jD = jD();
            jD.append("action", "dcStat");
            jD.append("dcnum", String.valueOf(i));
            jD.append("dcfnum", String.valueOf(i2));
            jD.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", jD);
        }
    }
}
