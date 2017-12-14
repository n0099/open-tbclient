package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class o extends q {
    public static void b(com.baidu.tbadk.core.util.r rVar, com.baidu.tbadk.core.util.r rVar2, com.baidu.tbadk.core.util.r rVar3, com.baidu.tbadk.core.util.r rVar4, com.baidu.tbadk.core.util.r rVar5, int i) {
        if (r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "dlStat");
            fK.p("c_dnum", String.valueOf(rVar.num));
            fK.p("c_dfnum", String.valueOf(rVar.aft));
            fK.p("c_spnum", String.valueOf(rVar.afu));
            fK.p("c_costt", String.valueOf(rVar.time));
            fK.p("c_dlsize", String.valueOf(rVar.uQ));
            fK.p("p_dnum", String.valueOf(rVar2.num));
            fK.p("p_dfnum", String.valueOf(rVar2.aft));
            fK.p("p_spnum", String.valueOf(rVar2.afu));
            fK.p("p_costt", String.valueOf(rVar2.time));
            fK.p("p_dlsize", String.valueOf(rVar2.uQ));
            fK.p("t_dnum", String.valueOf(rVar3.num));
            fK.p("t_dfnum", String.valueOf(rVar3.aft));
            fK.p("t_spnum", String.valueOf(rVar3.afu));
            fK.p("t_costt", String.valueOf(rVar3.time));
            fK.p("t_dlsize", String.valueOf(rVar3.uQ));
            fK.p("d_dnum", String.valueOf(rVar4.num));
            fK.p("d_dfnum", String.valueOf(rVar4.aft));
            fK.p("d_spnum", String.valueOf(rVar4.afu));
            fK.p("d_costt", String.valueOf(rVar4.time));
            fK.p("d_dlsize", String.valueOf(rVar4.uQ));
            fK.p("op_dnum", String.valueOf(rVar5.num));
            fK.p("op_dfnum", String.valueOf(rVar5.aft));
            fK.p("op_spnum", String.valueOf(rVar5.afu));
            fK.p("op_costt", String.valueOf(rVar5.time));
            fK.p("op_dlsize", String.valueOf(rVar5.uQ));
            fK.p("nettype", r.fs(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fK);
        }
    }

    public static void a(int i, int i2, long j) {
        if (r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "dcStat");
            fK.p("dcnum", String.valueOf(i));
            fK.p("dcfnum", String.valueOf(i2));
            fK.p("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fK);
        }
    }
}
