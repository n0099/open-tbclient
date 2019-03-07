package com.baidu.tbadk.o;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.apl().apm()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "dlStat");
            jC.append("c_dnum", String.valueOf(rVar.num));
            jC.append("c_dfnum", String.valueOf(rVar.bID));
            jC.append("c_spnum", String.valueOf(rVar.bIE));
            jC.append("c_costt", String.valueOf(rVar.time));
            jC.append("c_dlsize", String.valueOf(rVar.CF));
            jC.append("p_dnum", String.valueOf(rVar2.num));
            jC.append("p_dfnum", String.valueOf(rVar2.bID));
            jC.append("p_spnum", String.valueOf(rVar2.bIE));
            jC.append("p_costt", String.valueOf(rVar2.time));
            jC.append("p_dlsize", String.valueOf(rVar2.CF));
            jC.append("t_dnum", String.valueOf(rVar3.num));
            jC.append("t_dfnum", String.valueOf(rVar3.bID));
            jC.append("t_spnum", String.valueOf(rVar3.bIE));
            jC.append("t_costt", String.valueOf(rVar3.time));
            jC.append("t_dlsize", String.valueOf(rVar3.CF));
            jC.append("d_dnum", String.valueOf(rVar4.num));
            jC.append("d_dfnum", String.valueOf(rVar4.bID));
            jC.append("d_spnum", String.valueOf(rVar4.bIE));
            jC.append("d_costt", String.valueOf(rVar4.time));
            jC.append("d_dlsize", String.valueOf(rVar4.CF));
            jC.append("op_dnum", String.valueOf(rVar5.num));
            jC.append("op_dfnum", String.valueOf(rVar5.bID));
            jC.append("op_spnum", String.valueOf(rVar5.bIE));
            jC.append("op_costt", String.valueOf(rVar5.time));
            jC.append("op_dlsize", String.valueOf(rVar5.CF));
            jC.append("nettype", m.jZ(i));
            BdStatisticsManager.getInstance().performance("image", jC);
        }
    }

    public static void a(int i, int i2, long j) {
        if (m.apl().apm()) {
            com.baidu.adp.lib.stats.a jC = jC();
            jC.append("action", "dcStat");
            jC.append("dcnum", String.valueOf(i));
            jC.append("dcfnum", String.valueOf(i2));
            jC.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", jC);
        }
    }
}
