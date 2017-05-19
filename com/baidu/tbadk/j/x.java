package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.t tVar, com.baidu.tbadk.core.util.t tVar2, com.baidu.tbadk.core.util.t tVar3, com.baidu.tbadk.core.util.t tVar4, com.baidu.tbadk.core.util.t tVar5, int i) {
        if (aa.FK().FL()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "dlStat");
            fN.p("c_dnum", String.valueOf(tVar.num));
            fN.p("c_dfnum", String.valueOf(tVar.adL));
            fN.p("c_spnum", String.valueOf(tVar.adM));
            fN.p("c_costt", String.valueOf(tVar.time));
            fN.p("c_dlsize", String.valueOf(tVar.vv));
            fN.p("p_dnum", String.valueOf(tVar2.num));
            fN.p("p_dfnum", String.valueOf(tVar2.adL));
            fN.p("p_spnum", String.valueOf(tVar2.adM));
            fN.p("p_costt", String.valueOf(tVar2.time));
            fN.p("p_dlsize", String.valueOf(tVar2.vv));
            fN.p("t_dnum", String.valueOf(tVar3.num));
            fN.p("t_dfnum", String.valueOf(tVar3.adL));
            fN.p("t_spnum", String.valueOf(tVar3.adM));
            fN.p("t_costt", String.valueOf(tVar3.time));
            fN.p("t_dlsize", String.valueOf(tVar3.vv));
            fN.p("d_dnum", String.valueOf(tVar4.num));
            fN.p("d_dfnum", String.valueOf(tVar4.adL));
            fN.p("d_spnum", String.valueOf(tVar4.adM));
            fN.p("d_costt", String.valueOf(tVar4.time));
            fN.p("d_dlsize", String.valueOf(tVar4.vv));
            fN.p("op_dnum", String.valueOf(tVar5.num));
            fN.p("op_dfnum", String.valueOf(tVar5.adL));
            fN.p("op_spnum", String.valueOf(tVar5.adM));
            fN.p("op_costt", String.valueOf(tVar5.time));
            fN.p("op_dlsize", String.valueOf(tVar5.vv));
            fN.p("nettype", aa.fb(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fN);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.FK().FL()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "dcStat");
            fN.p("dcnum", String.valueOf(i));
            fN.p("dcfnum", String.valueOf(i2));
            fN.p("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fN);
        }
    }
}
