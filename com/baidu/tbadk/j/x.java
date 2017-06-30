package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.v vVar, com.baidu.tbadk.core.util.v vVar2, com.baidu.tbadk.core.util.v vVar3, com.baidu.tbadk.core.util.v vVar4, com.baidu.tbadk.core.util.v vVar5, int i) {
        if (aa.Gb().Gc()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "dlStat");
            fM.p("c_dnum", String.valueOf(vVar.num));
            fM.p("c_dfnum", String.valueOf(vVar.aem));
            fM.p("c_spnum", String.valueOf(vVar.aen));
            fM.p("c_costt", String.valueOf(vVar.time));
            fM.p("c_dlsize", String.valueOf(vVar.vu));
            fM.p("p_dnum", String.valueOf(vVar2.num));
            fM.p("p_dfnum", String.valueOf(vVar2.aem));
            fM.p("p_spnum", String.valueOf(vVar2.aen));
            fM.p("p_costt", String.valueOf(vVar2.time));
            fM.p("p_dlsize", String.valueOf(vVar2.vu));
            fM.p("t_dnum", String.valueOf(vVar3.num));
            fM.p("t_dfnum", String.valueOf(vVar3.aem));
            fM.p("t_spnum", String.valueOf(vVar3.aen));
            fM.p("t_costt", String.valueOf(vVar3.time));
            fM.p("t_dlsize", String.valueOf(vVar3.vu));
            fM.p("d_dnum", String.valueOf(vVar4.num));
            fM.p("d_dfnum", String.valueOf(vVar4.aem));
            fM.p("d_spnum", String.valueOf(vVar4.aen));
            fM.p("d_costt", String.valueOf(vVar4.time));
            fM.p("d_dlsize", String.valueOf(vVar4.vu));
            fM.p("op_dnum", String.valueOf(vVar5.num));
            fM.p("op_dfnum", String.valueOf(vVar5.aem));
            fM.p("op_spnum", String.valueOf(vVar5.aen));
            fM.p("op_costt", String.valueOf(vVar5.time));
            fM.p("op_dlsize", String.valueOf(vVar5.vu));
            fM.p("nettype", aa.fe(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fM);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.Gb().Gc()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "dcStat");
            fM.p("dcnum", String.valueOf(i));
            fM.p("dcfnum", String.valueOf(i2));
            fM.p("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fM);
        }
    }
}
