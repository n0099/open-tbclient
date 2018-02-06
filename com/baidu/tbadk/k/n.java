package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class n extends o {
    public static void b(com.baidu.tbadk.core.util.r rVar, com.baidu.tbadk.core.util.r rVar2, com.baidu.tbadk.core.util.r rVar3, com.baidu.tbadk.core.util.r rVar4, com.baidu.tbadk.core.util.r rVar5, int i) {
        if (p.Ow().Ox()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "dlStat");
            nn.append("c_dnum", String.valueOf(rVar.num));
            nn.append("c_dfnum", String.valueOf(rVar.aVo));
            nn.append("c_spnum", String.valueOf(rVar.aVp));
            nn.append("c_costt", String.valueOf(rVar.time));
            nn.append("c_dlsize", String.valueOf(rVar.ajg));
            nn.append("p_dnum", String.valueOf(rVar2.num));
            nn.append("p_dfnum", String.valueOf(rVar2.aVo));
            nn.append("p_spnum", String.valueOf(rVar2.aVp));
            nn.append("p_costt", String.valueOf(rVar2.time));
            nn.append("p_dlsize", String.valueOf(rVar2.ajg));
            nn.append("t_dnum", String.valueOf(rVar3.num));
            nn.append("t_dfnum", String.valueOf(rVar3.aVo));
            nn.append("t_spnum", String.valueOf(rVar3.aVp));
            nn.append("t_costt", String.valueOf(rVar3.time));
            nn.append("t_dlsize", String.valueOf(rVar3.ajg));
            nn.append("d_dnum", String.valueOf(rVar4.num));
            nn.append("d_dfnum", String.valueOf(rVar4.aVo));
            nn.append("d_spnum", String.valueOf(rVar4.aVp));
            nn.append("d_costt", String.valueOf(rVar4.time));
            nn.append("d_dlsize", String.valueOf(rVar4.ajg));
            nn.append("op_dnum", String.valueOf(rVar5.num));
            nn.append("op_dfnum", String.valueOf(rVar5.aVo));
            nn.append("op_spnum", String.valueOf(rVar5.aVp));
            nn.append("op_costt", String.valueOf(rVar5.time));
            nn.append("op_dlsize", String.valueOf(rVar5.ajg));
            nn.append("nettype", p.ik(i));
            BdStatisticsManager.getInstance().performance("image", nn);
        }
    }

    public static void a(int i, int i2, long j) {
        if (p.Ow().Ox()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "dcStat");
            nn.append("dcnum", String.valueOf(i));
            nn.append("dcfnum", String.valueOf(i2));
            nn.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", nn);
        }
    }
}
