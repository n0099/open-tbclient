package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.s;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(s sVar, s sVar2, s sVar3, s sVar4, s sVar5, int i) {
        if (m.Ks().Kt()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "dlStat");
            ih.append("c_dnum", String.valueOf(sVar.num));
            ih.append("c_dfnum", String.valueOf(sVar.aoE));
            ih.append("c_spnum", String.valueOf(sVar.aoF));
            ih.append("c_costt", String.valueOf(sVar.time));
            ih.append("c_dlsize", String.valueOf(sVar.zF));
            ih.append("p_dnum", String.valueOf(sVar2.num));
            ih.append("p_dfnum", String.valueOf(sVar2.aoE));
            ih.append("p_spnum", String.valueOf(sVar2.aoF));
            ih.append("p_costt", String.valueOf(sVar2.time));
            ih.append("p_dlsize", String.valueOf(sVar2.zF));
            ih.append("t_dnum", String.valueOf(sVar3.num));
            ih.append("t_dfnum", String.valueOf(sVar3.aoE));
            ih.append("t_spnum", String.valueOf(sVar3.aoF));
            ih.append("t_costt", String.valueOf(sVar3.time));
            ih.append("t_dlsize", String.valueOf(sVar3.zF));
            ih.append("d_dnum", String.valueOf(sVar4.num));
            ih.append("d_dfnum", String.valueOf(sVar4.aoE));
            ih.append("d_spnum", String.valueOf(sVar4.aoF));
            ih.append("d_costt", String.valueOf(sVar4.time));
            ih.append("d_dlsize", String.valueOf(sVar4.zF));
            ih.append("op_dnum", String.valueOf(sVar5.num));
            ih.append("op_dfnum", String.valueOf(sVar5.aoE));
            ih.append("op_spnum", String.valueOf(sVar5.aoF));
            ih.append("op_costt", String.valueOf(sVar5.time));
            ih.append("op_dlsize", String.valueOf(sVar5.zF));
            ih.append("nettype", m.fm(i));
            BdStatisticsManager.getInstance().performance("image", ih);
        }
    }

    public static void a(int i, int i2, long j) {
        if (m.Ks().Kt()) {
            com.baidu.adp.lib.stats.a ih = ih();
            ih.append(AuthActivity.ACTION_KEY, "dcStat");
            ih.append("dcnum", String.valueOf(i));
            ih.append("dcfnum", String.valueOf(i2));
            ih.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", ih);
        }
    }
}
