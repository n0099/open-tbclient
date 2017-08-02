package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class o extends q {
    public static void b(com.baidu.tbadk.core.util.q qVar, com.baidu.tbadk.core.util.q qVar2, com.baidu.tbadk.core.util.q qVar3, com.baidu.tbadk.core.util.q qVar4, com.baidu.tbadk.core.util.q qVar5, int i) {
        if (r.Gr().Gs()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "dlStat");
            fK.p("c_dnum", String.valueOf(qVar.num));
            fK.p("c_dfnum", String.valueOf(qVar.aeI));
            fK.p("c_spnum", String.valueOf(qVar.aeJ));
            fK.p("c_costt", String.valueOf(qVar.time));
            fK.p("c_dlsize", String.valueOf(qVar.vv));
            fK.p("p_dnum", String.valueOf(qVar2.num));
            fK.p("p_dfnum", String.valueOf(qVar2.aeI));
            fK.p("p_spnum", String.valueOf(qVar2.aeJ));
            fK.p("p_costt", String.valueOf(qVar2.time));
            fK.p("p_dlsize", String.valueOf(qVar2.vv));
            fK.p("t_dnum", String.valueOf(qVar3.num));
            fK.p("t_dfnum", String.valueOf(qVar3.aeI));
            fK.p("t_spnum", String.valueOf(qVar3.aeJ));
            fK.p("t_costt", String.valueOf(qVar3.time));
            fK.p("t_dlsize", String.valueOf(qVar3.vv));
            fK.p("d_dnum", String.valueOf(qVar4.num));
            fK.p("d_dfnum", String.valueOf(qVar4.aeI));
            fK.p("d_spnum", String.valueOf(qVar4.aeJ));
            fK.p("d_costt", String.valueOf(qVar4.time));
            fK.p("d_dlsize", String.valueOf(qVar4.vv));
            fK.p("op_dnum", String.valueOf(qVar5.num));
            fK.p("op_dfnum", String.valueOf(qVar5.aeI));
            fK.p("op_spnum", String.valueOf(qVar5.aeJ));
            fK.p("op_costt", String.valueOf(qVar5.time));
            fK.p("op_dlsize", String.valueOf(qVar5.vv));
            fK.p("nettype", r.fh(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fK);
        }
    }

    public static void a(int i, int i2, long j) {
        if (r.Gr().Gs()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "dcStat");
            fK.p("dcnum", String.valueOf(i));
            fK.p("dcfnum", String.valueOf(i2));
            fK.p("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, fK);
        }
    }
}
