package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.s;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(s sVar, s sVar2, s sVar3, s sVar4, s sVar5, int i) {
        if (m.KF().KG()) {
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append(AuthActivity.ACTION_KEY, "dlStat");
            ii.append("c_dnum", String.valueOf(sVar.num));
            ii.append("c_dfnum", String.valueOf(sVar.aoE));
            ii.append("c_spnum", String.valueOf(sVar.aoF));
            ii.append("c_costt", String.valueOf(sVar.time));
            ii.append("c_dlsize", String.valueOf(sVar.zy));
            ii.append("p_dnum", String.valueOf(sVar2.num));
            ii.append("p_dfnum", String.valueOf(sVar2.aoE));
            ii.append("p_spnum", String.valueOf(sVar2.aoF));
            ii.append("p_costt", String.valueOf(sVar2.time));
            ii.append("p_dlsize", String.valueOf(sVar2.zy));
            ii.append("t_dnum", String.valueOf(sVar3.num));
            ii.append("t_dfnum", String.valueOf(sVar3.aoE));
            ii.append("t_spnum", String.valueOf(sVar3.aoF));
            ii.append("t_costt", String.valueOf(sVar3.time));
            ii.append("t_dlsize", String.valueOf(sVar3.zy));
            ii.append("d_dnum", String.valueOf(sVar4.num));
            ii.append("d_dfnum", String.valueOf(sVar4.aoE));
            ii.append("d_spnum", String.valueOf(sVar4.aoF));
            ii.append("d_costt", String.valueOf(sVar4.time));
            ii.append("d_dlsize", String.valueOf(sVar4.zy));
            ii.append("op_dnum", String.valueOf(sVar5.num));
            ii.append("op_dfnum", String.valueOf(sVar5.aoE));
            ii.append("op_spnum", String.valueOf(sVar5.aoF));
            ii.append("op_costt", String.valueOf(sVar5.time));
            ii.append("op_dlsize", String.valueOf(sVar5.zy));
            ii.append("nettype", m.fo(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, ii);
        }
    }

    public static void a(int i, int i2, long j) {
        if (m.KF().KG()) {
            com.baidu.adp.lib.stats.a ii = ii();
            ii.append(AuthActivity.ACTION_KEY, "dcStat");
            ii.append("dcnum", String.valueOf(i));
            ii.append("dcfnum", String.valueOf(i2));
            ii.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, ii);
        }
    }
}
