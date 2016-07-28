package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.u uVar, com.baidu.tbadk.core.util.u uVar2, com.baidu.tbadk.core.util.u uVar3, com.baidu.tbadk.core.util.u uVar4, com.baidu.tbadk.core.util.u uVar5, int i) {
        if (aa.EV().EW()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "dlStat");
            dG.q("c_dnum", String.valueOf(uVar.num));
            dG.q("c_dfnum", String.valueOf(uVar.WH));
            dG.q("c_spnum", String.valueOf(uVar.WI));
            dG.q("c_costt", String.valueOf(uVar.time));
            dG.q("c_dlsize", String.valueOf(uVar.lK));
            dG.q("p_dnum", String.valueOf(uVar2.num));
            dG.q("p_dfnum", String.valueOf(uVar2.WH));
            dG.q("p_spnum", String.valueOf(uVar2.WI));
            dG.q("p_costt", String.valueOf(uVar2.time));
            dG.q("p_dlsize", String.valueOf(uVar2.lK));
            dG.q("t_dnum", String.valueOf(uVar3.num));
            dG.q("t_dfnum", String.valueOf(uVar3.WH));
            dG.q("t_spnum", String.valueOf(uVar3.WI));
            dG.q("t_costt", String.valueOf(uVar3.time));
            dG.q("t_dlsize", String.valueOf(uVar3.lK));
            dG.q("d_dnum", String.valueOf(uVar4.num));
            dG.q("d_dfnum", String.valueOf(uVar4.WH));
            dG.q("d_spnum", String.valueOf(uVar4.WI));
            dG.q("d_costt", String.valueOf(uVar4.time));
            dG.q("d_dlsize", String.valueOf(uVar4.lK));
            dG.q("op_dnum", String.valueOf(uVar5.num));
            dG.q("op_dfnum", String.valueOf(uVar5.WH));
            dG.q("op_spnum", String.valueOf(uVar5.WI));
            dG.q("op_costt", String.valueOf(uVar5.time));
            dG.q("op_dlsize", String.valueOf(uVar5.lK));
            dG.q("nettype", aa.eR(i));
            com.baidu.adp.lib.stats.a.dN().a(TbConfig.TMP_PIC_DIR_NAME, dG);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.EV().EW()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "dcStat");
            dG.q("dcnum", String.valueOf(i));
            dG.q("dcfnum", String.valueOf(i2));
            dG.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.dN().a(TbConfig.TMP_PIC_DIR_NAME, dG);
        }
    }
}
