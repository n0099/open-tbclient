package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class o extends q {
    public static void b(com.baidu.tbadk.core.util.r rVar, com.baidu.tbadk.core.util.r rVar2, com.baidu.tbadk.core.util.r rVar3, com.baidu.tbadk.core.util.r rVar4, com.baidu.tbadk.core.util.r rVar5, int i) {
        if (r.NQ().NR()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("action", "dlStat");
            nn.append("c_dnum", String.valueOf(rVar.num));
            nn.append("c_dfnum", String.valueOf(rVar.aTJ));
            nn.append("c_spnum", String.valueOf(rVar.aTK));
            nn.append("c_costt", String.valueOf(rVar.time));
            nn.append("c_dlsize", String.valueOf(rVar.ajh));
            nn.append("p_dnum", String.valueOf(rVar2.num));
            nn.append("p_dfnum", String.valueOf(rVar2.aTJ));
            nn.append("p_spnum", String.valueOf(rVar2.aTK));
            nn.append("p_costt", String.valueOf(rVar2.time));
            nn.append("p_dlsize", String.valueOf(rVar2.ajh));
            nn.append("t_dnum", String.valueOf(rVar3.num));
            nn.append("t_dfnum", String.valueOf(rVar3.aTJ));
            nn.append("t_spnum", String.valueOf(rVar3.aTK));
            nn.append("t_costt", String.valueOf(rVar3.time));
            nn.append("t_dlsize", String.valueOf(rVar3.ajh));
            nn.append("d_dnum", String.valueOf(rVar4.num));
            nn.append("d_dfnum", String.valueOf(rVar4.aTJ));
            nn.append("d_spnum", String.valueOf(rVar4.aTK));
            nn.append("d_costt", String.valueOf(rVar4.time));
            nn.append("d_dlsize", String.valueOf(rVar4.ajh));
            nn.append("op_dnum", String.valueOf(rVar5.num));
            nn.append("op_dfnum", String.valueOf(rVar5.aTJ));
            nn.append("op_spnum", String.valueOf(rVar5.aTK));
            nn.append("op_costt", String.valueOf(rVar5.time));
            nn.append("op_dlsize", String.valueOf(rVar5.ajh));
            nn.append("nettype", r.in(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, nn);
        }
    }

    public static void a(int i, int i2, long j) {
        if (r.NQ().NR()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("action", "dcStat");
            nn.append("dcnum", String.valueOf(i));
            nn.append("dcfnum", String.valueOf(i2));
            nn.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, nn);
        }
    }
}
