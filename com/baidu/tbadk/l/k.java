package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.r;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.LZ().Ma()) {
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append(AuthActivity.ACTION_KEY, "dlStat");
            jo.append("c_dnum", String.valueOf(rVar.num));
            jo.append("c_dfnum", String.valueOf(rVar.ard));
            jo.append("c_spnum", String.valueOf(rVar.are));
            jo.append("c_costt", String.valueOf(rVar.time));
            jo.append("c_dlsize", String.valueOf(rVar.BU));
            jo.append("p_dnum", String.valueOf(rVar2.num));
            jo.append("p_dfnum", String.valueOf(rVar2.ard));
            jo.append("p_spnum", String.valueOf(rVar2.are));
            jo.append("p_costt", String.valueOf(rVar2.time));
            jo.append("p_dlsize", String.valueOf(rVar2.BU));
            jo.append("t_dnum", String.valueOf(rVar3.num));
            jo.append("t_dfnum", String.valueOf(rVar3.ard));
            jo.append("t_spnum", String.valueOf(rVar3.are));
            jo.append("t_costt", String.valueOf(rVar3.time));
            jo.append("t_dlsize", String.valueOf(rVar3.BU));
            jo.append("d_dnum", String.valueOf(rVar4.num));
            jo.append("d_dfnum", String.valueOf(rVar4.ard));
            jo.append("d_spnum", String.valueOf(rVar4.are));
            jo.append("d_costt", String.valueOf(rVar4.time));
            jo.append("d_dlsize", String.valueOf(rVar4.BU));
            jo.append("op_dnum", String.valueOf(rVar5.num));
            jo.append("op_dfnum", String.valueOf(rVar5.ard));
            jo.append("op_spnum", String.valueOf(rVar5.are));
            jo.append("op_costt", String.valueOf(rVar5.time));
            jo.append("op_dlsize", String.valueOf(rVar5.BU));
            jo.append("nettype", m.fz(i));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, jo);
        }
    }

    public static void a(int i, int i2, long j) {
        if (m.LZ().Ma()) {
            com.baidu.adp.lib.stats.a jo = jo();
            jo.append(AuthActivity.ACTION_KEY, "dcStat");
            jo.append("dcnum", String.valueOf(i));
            jo.append("dcfnum", String.valueOf(i2));
            jo.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance(TbConfig.TMP_PIC_DIR_NAME, jo);
        }
    }
}
