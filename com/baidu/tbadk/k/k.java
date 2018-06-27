package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.s;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(s sVar, s sVar2, s sVar3, s sVar4, s sVar5, int i) {
        if (m.KK().KL()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "dlStat");
            ih.append("c_dnum", String.valueOf(sVar.num));
            ih.append("c_dfnum", String.valueOf(sVar.apd));
            ih.append("c_spnum", String.valueOf(sVar.ape));
            ih.append("c_costt", String.valueOf(sVar.time));
            ih.append("c_dlsize", String.valueOf(sVar.zD));
            ih.append("p_dnum", String.valueOf(sVar2.num));
            ih.append("p_dfnum", String.valueOf(sVar2.apd));
            ih.append("p_spnum", String.valueOf(sVar2.ape));
            ih.append("p_costt", String.valueOf(sVar2.time));
            ih.append("p_dlsize", String.valueOf(sVar2.zD));
            ih.append("t_dnum", String.valueOf(sVar3.num));
            ih.append("t_dfnum", String.valueOf(sVar3.apd));
            ih.append("t_spnum", String.valueOf(sVar3.ape));
            ih.append("t_costt", String.valueOf(sVar3.time));
            ih.append("t_dlsize", String.valueOf(sVar3.zD));
            ih.append("d_dnum", String.valueOf(sVar4.num));
            ih.append("d_dfnum", String.valueOf(sVar4.apd));
            ih.append("d_spnum", String.valueOf(sVar4.ape));
            ih.append("d_costt", String.valueOf(sVar4.time));
            ih.append("d_dlsize", String.valueOf(sVar4.zD));
            ih.append("op_dnum", String.valueOf(sVar5.num));
            ih.append("op_dfnum", String.valueOf(sVar5.apd));
            ih.append("op_spnum", String.valueOf(sVar5.ape));
            ih.append("op_costt", String.valueOf(sVar5.time));
            ih.append("op_dlsize", String.valueOf(sVar5.zD));
            ih.append("nettype", m.fn(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, ih);
        }
    }

    public static void a(int i, int i2, long j) {
        if (m.KK().KL()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "dcStat");
            ih.append("dcnum", String.valueOf(i));
            ih.append("dcfnum", String.valueOf(i2));
            ih.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, ih);
        }
    }
}
