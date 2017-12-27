package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class o extends q {
    public static void b(com.baidu.tbadk.core.util.r rVar, com.baidu.tbadk.core.util.r rVar2, com.baidu.tbadk.core.util.r rVar3, com.baidu.tbadk.core.util.r rVar4, com.baidu.tbadk.core.util.r rVar5, int i) {
        if (r.Oa().Ob()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "dlStat");
            nm.append("c_dnum", String.valueOf(rVar.num));
            nm.append("c_dfnum", String.valueOf(rVar.aTH));
            nm.append("c_spnum", String.valueOf(rVar.aTI));
            nm.append("c_costt", String.valueOf(rVar.time));
            nm.append("c_dlsize", String.valueOf(rVar.aje));
            nm.append("p_dnum", String.valueOf(rVar2.num));
            nm.append("p_dfnum", String.valueOf(rVar2.aTH));
            nm.append("p_spnum", String.valueOf(rVar2.aTI));
            nm.append("p_costt", String.valueOf(rVar2.time));
            nm.append("p_dlsize", String.valueOf(rVar2.aje));
            nm.append("t_dnum", String.valueOf(rVar3.num));
            nm.append("t_dfnum", String.valueOf(rVar3.aTH));
            nm.append("t_spnum", String.valueOf(rVar3.aTI));
            nm.append("t_costt", String.valueOf(rVar3.time));
            nm.append("t_dlsize", String.valueOf(rVar3.aje));
            nm.append("d_dnum", String.valueOf(rVar4.num));
            nm.append("d_dfnum", String.valueOf(rVar4.aTH));
            nm.append("d_spnum", String.valueOf(rVar4.aTI));
            nm.append("d_costt", String.valueOf(rVar4.time));
            nm.append("d_dlsize", String.valueOf(rVar4.aje));
            nm.append("op_dnum", String.valueOf(rVar5.num));
            nm.append("op_dfnum", String.valueOf(rVar5.aTH));
            nm.append("op_spnum", String.valueOf(rVar5.aTI));
            nm.append("op_costt", String.valueOf(rVar5.time));
            nm.append("op_dlsize", String.valueOf(rVar5.aje));
            nm.append("nettype", r.ir(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, nm);
        }
    }

    public static void a(int i, int i2, long j) {
        if (r.Oa().Ob()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "dcStat");
            nm.append("dcnum", String.valueOf(i));
            nm.append("dcfnum", String.valueOf(i2));
            nm.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, nm);
        }
    }
}
