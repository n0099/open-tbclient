package com.baidu.tbadk.performanceLog;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.t tVar, com.baidu.tbadk.core.util.t tVar2, com.baidu.tbadk.core.util.t tVar3, com.baidu.tbadk.core.util.t tVar4, com.baidu.tbadk.core.util.t tVar5, int i) {
        if (aa.Gi().Gj()) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "dlStat");
            fH.p("c_dnum", String.valueOf(tVar.num));
            fH.p("c_dfnum", String.valueOf(tVar.aee));
            fH.p("c_spnum", String.valueOf(tVar.aef));
            fH.p("c_costt", String.valueOf(tVar.time));
            fH.p("c_dlsize", String.valueOf(tVar.vM));
            fH.p("p_dnum", String.valueOf(tVar2.num));
            fH.p("p_dfnum", String.valueOf(tVar2.aee));
            fH.p("p_spnum", String.valueOf(tVar2.aef));
            fH.p("p_costt", String.valueOf(tVar2.time));
            fH.p("p_dlsize", String.valueOf(tVar2.vM));
            fH.p("t_dnum", String.valueOf(tVar3.num));
            fH.p("t_dfnum", String.valueOf(tVar3.aee));
            fH.p("t_spnum", String.valueOf(tVar3.aef));
            fH.p("t_costt", String.valueOf(tVar3.time));
            fH.p("t_dlsize", String.valueOf(tVar3.vM));
            fH.p("d_dnum", String.valueOf(tVar4.num));
            fH.p("d_dfnum", String.valueOf(tVar4.aee));
            fH.p("d_spnum", String.valueOf(tVar4.aef));
            fH.p("d_costt", String.valueOf(tVar4.time));
            fH.p("d_dlsize", String.valueOf(tVar4.vM));
            fH.p("op_dnum", String.valueOf(tVar5.num));
            fH.p("op_dfnum", String.valueOf(tVar5.aee));
            fH.p("op_spnum", String.valueOf(tVar5.aef));
            fH.p("op_costt", String.valueOf(tVar5.time));
            fH.p("op_dlsize", String.valueOf(tVar5.vM));
            fH.p("nettype", aa.fc(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fH);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.Gi().Gj()) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "dcStat");
            fH.p("dcnum", String.valueOf(i));
            fH.p("dcfnum", String.valueOf(i2));
            fH.p("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fH);
        }
    }
}
