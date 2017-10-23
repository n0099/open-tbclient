package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class o extends q {
    public static void b(com.baidu.tbadk.core.util.r rVar, com.baidu.tbadk.core.util.r rVar2, com.baidu.tbadk.core.util.r rVar3, com.baidu.tbadk.core.util.r rVar4, com.baidu.tbadk.core.util.r rVar5, int i) {
        if (r.FW().FX()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "dlStat");
            fK.p("c_dnum", String.valueOf(rVar.num));
            fK.p("c_dfnum", String.valueOf(rVar.aeH));
            fK.p("c_spnum", String.valueOf(rVar.aeI));
            fK.p("c_costt", String.valueOf(rVar.time));
            fK.p("c_dlsize", String.valueOf(rVar.uT));
            fK.p("p_dnum", String.valueOf(rVar2.num));
            fK.p("p_dfnum", String.valueOf(rVar2.aeH));
            fK.p("p_spnum", String.valueOf(rVar2.aeI));
            fK.p("p_costt", String.valueOf(rVar2.time));
            fK.p("p_dlsize", String.valueOf(rVar2.uT));
            fK.p("t_dnum", String.valueOf(rVar3.num));
            fK.p("t_dfnum", String.valueOf(rVar3.aeH));
            fK.p("t_spnum", String.valueOf(rVar3.aeI));
            fK.p("t_costt", String.valueOf(rVar3.time));
            fK.p("t_dlsize", String.valueOf(rVar3.uT));
            fK.p("d_dnum", String.valueOf(rVar4.num));
            fK.p("d_dfnum", String.valueOf(rVar4.aeH));
            fK.p("d_spnum", String.valueOf(rVar4.aeI));
            fK.p("d_costt", String.valueOf(rVar4.time));
            fK.p("d_dlsize", String.valueOf(rVar4.uT));
            fK.p("op_dnum", String.valueOf(rVar5.num));
            fK.p("op_dfnum", String.valueOf(rVar5.aeH));
            fK.p("op_spnum", String.valueOf(rVar5.aeI));
            fK.p("op_costt", String.valueOf(rVar5.time));
            fK.p("op_dlsize", String.valueOf(rVar5.uT));
            fK.p("nettype", r.ft(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fK);
        }
    }

    public static void a(int i, int i2, long j) {
        if (r.FW().FX()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "dcStat");
            fK.p("dcnum", String.valueOf(i));
            fK.p("dcfnum", String.valueOf(i2));
            fK.p("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fK);
        }
    }
}
