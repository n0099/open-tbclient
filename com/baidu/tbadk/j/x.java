package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.t tVar, com.baidu.tbadk.core.util.t tVar2, com.baidu.tbadk.core.util.t tVar3, com.baidu.tbadk.core.util.t tVar4, com.baidu.tbadk.core.util.t tVar5, int i) {
        if (aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "dlStat");
            fM.p("c_dnum", String.valueOf(tVar.num));
            fM.p("c_dfnum", String.valueOf(tVar.aes));
            fM.p("c_spnum", String.valueOf(tVar.aet));
            fM.p("c_costt", String.valueOf(tVar.time));
            fM.p("c_dlsize", String.valueOf(tVar.vp));
            fM.p("p_dnum", String.valueOf(tVar2.num));
            fM.p("p_dfnum", String.valueOf(tVar2.aes));
            fM.p("p_spnum", String.valueOf(tVar2.aet));
            fM.p("p_costt", String.valueOf(tVar2.time));
            fM.p("p_dlsize", String.valueOf(tVar2.vp));
            fM.p("t_dnum", String.valueOf(tVar3.num));
            fM.p("t_dfnum", String.valueOf(tVar3.aes));
            fM.p("t_spnum", String.valueOf(tVar3.aet));
            fM.p("t_costt", String.valueOf(tVar3.time));
            fM.p("t_dlsize", String.valueOf(tVar3.vp));
            fM.p("d_dnum", String.valueOf(tVar4.num));
            fM.p("d_dfnum", String.valueOf(tVar4.aes));
            fM.p("d_spnum", String.valueOf(tVar4.aet));
            fM.p("d_costt", String.valueOf(tVar4.time));
            fM.p("d_dlsize", String.valueOf(tVar4.vp));
            fM.p("op_dnum", String.valueOf(tVar5.num));
            fM.p("op_dfnum", String.valueOf(tVar5.aes));
            fM.p("op_spnum", String.valueOf(tVar5.aet));
            fM.p("op_costt", String.valueOf(tVar5.time));
            fM.p("op_dlsize", String.valueOf(tVar5.vp));
            fM.p("nettype", aa.ff(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fM);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "dcStat");
            fM.p("dcnum", String.valueOf(i));
            fM.p("dcfnum", String.valueOf(i2));
            fM.p("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fM);
        }
    }
}
