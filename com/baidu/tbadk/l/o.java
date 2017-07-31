package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class o extends q {
    public static void b(com.baidu.tbadk.core.util.q qVar, com.baidu.tbadk.core.util.q qVar2, com.baidu.tbadk.core.util.q qVar3, com.baidu.tbadk.core.util.q qVar4, com.baidu.tbadk.core.util.q qVar5, int i) {
        if (r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "dlStat");
            fV.p("c_dnum", String.valueOf(qVar.num));
            fV.p("c_dfnum", String.valueOf(qVar.agc));
            fV.p("c_spnum", String.valueOf(qVar.agd));
            fV.p("c_costt", String.valueOf(qVar.time));
            fV.p("c_dlsize", String.valueOf(qVar.wY));
            fV.p("p_dnum", String.valueOf(qVar2.num));
            fV.p("p_dfnum", String.valueOf(qVar2.agc));
            fV.p("p_spnum", String.valueOf(qVar2.agd));
            fV.p("p_costt", String.valueOf(qVar2.time));
            fV.p("p_dlsize", String.valueOf(qVar2.wY));
            fV.p("t_dnum", String.valueOf(qVar3.num));
            fV.p("t_dfnum", String.valueOf(qVar3.agc));
            fV.p("t_spnum", String.valueOf(qVar3.agd));
            fV.p("t_costt", String.valueOf(qVar3.time));
            fV.p("t_dlsize", String.valueOf(qVar3.wY));
            fV.p("d_dnum", String.valueOf(qVar4.num));
            fV.p("d_dfnum", String.valueOf(qVar4.agc));
            fV.p("d_spnum", String.valueOf(qVar4.agd));
            fV.p("d_costt", String.valueOf(qVar4.time));
            fV.p("d_dlsize", String.valueOf(qVar4.wY));
            fV.p("op_dnum", String.valueOf(qVar5.num));
            fV.p("op_dfnum", String.valueOf(qVar5.agc));
            fV.p("op_spnum", String.valueOf(qVar5.agd));
            fV.p("op_costt", String.valueOf(qVar5.time));
            fV.p("op_dlsize", String.valueOf(qVar5.wY));
            fV.p("nettype", r.fj(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fV);
        }
    }

    public static void a(int i, int i2, long j) {
        if (r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "dcStat");
            fV.p("dcnum", String.valueOf(i));
            fV.p("dcfnum", String.valueOf(i2));
            fV.p("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fV);
        }
    }
}
