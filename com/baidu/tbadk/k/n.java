package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class n extends o {
    public static void b(com.baidu.tbadk.core.util.r rVar, com.baidu.tbadk.core.util.r rVar2, com.baidu.tbadk.core.util.r rVar3, com.baidu.tbadk.core.util.r rVar4, com.baidu.tbadk.core.util.r rVar5, int i) {
        if (p.Ha().Hb()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "dlStat");
            fq.append("c_dnum", String.valueOf(rVar.num));
            fq.append("c_dfnum", String.valueOf(rVar.agy));
            fq.append("c_spnum", String.valueOf(rVar.agz));
            fq.append("c_costt", String.valueOf(rVar.time));
            fq.append("c_dlsize", String.valueOf(rVar.tB));
            fq.append("p_dnum", String.valueOf(rVar2.num));
            fq.append("p_dfnum", String.valueOf(rVar2.agy));
            fq.append("p_spnum", String.valueOf(rVar2.agz));
            fq.append("p_costt", String.valueOf(rVar2.time));
            fq.append("p_dlsize", String.valueOf(rVar2.tB));
            fq.append("t_dnum", String.valueOf(rVar3.num));
            fq.append("t_dfnum", String.valueOf(rVar3.agy));
            fq.append("t_spnum", String.valueOf(rVar3.agz));
            fq.append("t_costt", String.valueOf(rVar3.time));
            fq.append("t_dlsize", String.valueOf(rVar3.tB));
            fq.append("d_dnum", String.valueOf(rVar4.num));
            fq.append("d_dfnum", String.valueOf(rVar4.agy));
            fq.append("d_spnum", String.valueOf(rVar4.agz));
            fq.append("d_costt", String.valueOf(rVar4.time));
            fq.append("d_dlsize", String.valueOf(rVar4.tB));
            fq.append("op_dnum", String.valueOf(rVar5.num));
            fq.append("op_dfnum", String.valueOf(rVar5.agy));
            fq.append("op_spnum", String.valueOf(rVar5.agz));
            fq.append("op_costt", String.valueOf(rVar5.time));
            fq.append("op_dlsize", String.valueOf(rVar5.tB));
            fq.append("nettype", p.fl(i));
            BdStatisticsManager.getInstance().performance("image", fq);
        }
    }

    public static void a(int i, int i2, long j) {
        if (p.Ha().Hb()) {
            com.baidu.adp.lib.stats.a fq = fq();
            fq.append(AuthActivity.ACTION_KEY, "dcStat");
            fq.append("dcnum", String.valueOf(i));
            fq.append("dcfnum", String.valueOf(i2));
            fq.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", fq);
        }
    }
}
