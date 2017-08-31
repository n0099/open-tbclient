package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class o extends q {
    public static void b(com.baidu.tbadk.core.util.r rVar, com.baidu.tbadk.core.util.r rVar2, com.baidu.tbadk.core.util.r rVar3, com.baidu.tbadk.core.util.r rVar4, com.baidu.tbadk.core.util.r rVar5, int i) {
        if (r.Gx().Gy()) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "dlStat");
            fL.p("c_dnum", String.valueOf(rVar.num));
            fL.p("c_dfnum", String.valueOf(rVar.afx));
            fL.p("c_spnum", String.valueOf(rVar.afy));
            fL.p("c_costt", String.valueOf(rVar.time));
            fL.p("c_dlsize", String.valueOf(rVar.uQ));
            fL.p("p_dnum", String.valueOf(rVar2.num));
            fL.p("p_dfnum", String.valueOf(rVar2.afx));
            fL.p("p_spnum", String.valueOf(rVar2.afy));
            fL.p("p_costt", String.valueOf(rVar2.time));
            fL.p("p_dlsize", String.valueOf(rVar2.uQ));
            fL.p("t_dnum", String.valueOf(rVar3.num));
            fL.p("t_dfnum", String.valueOf(rVar3.afx));
            fL.p("t_spnum", String.valueOf(rVar3.afy));
            fL.p("t_costt", String.valueOf(rVar3.time));
            fL.p("t_dlsize", String.valueOf(rVar3.uQ));
            fL.p("d_dnum", String.valueOf(rVar4.num));
            fL.p("d_dfnum", String.valueOf(rVar4.afx));
            fL.p("d_spnum", String.valueOf(rVar4.afy));
            fL.p("d_costt", String.valueOf(rVar4.time));
            fL.p("d_dlsize", String.valueOf(rVar4.uQ));
            fL.p("op_dnum", String.valueOf(rVar5.num));
            fL.p("op_dfnum", String.valueOf(rVar5.afx));
            fL.p("op_spnum", String.valueOf(rVar5.afy));
            fL.p("op_costt", String.valueOf(rVar5.time));
            fL.p("op_dlsize", String.valueOf(rVar5.uQ));
            fL.p("nettype", r.fj(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fL);
        }
    }

    public static void a(int i, int i2, long j) {
        if (r.Gx().Gy()) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "dcStat");
            fL.p("dcnum", String.valueOf(i));
            fL.p("dcfnum", String.valueOf(i2));
            fL.p("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fL);
        }
    }
}
