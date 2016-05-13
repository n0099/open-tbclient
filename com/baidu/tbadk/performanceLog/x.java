package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.u uVar, com.baidu.tbadk.core.util.u uVar2, com.baidu.tbadk.core.util.u uVar3, com.baidu.tbadk.core.util.u uVar4, com.baidu.tbadk.core.util.u uVar5, int i) {
        if (aa.EN().EO()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "dlStat");
            dG.q("c_dnum", String.valueOf(uVar.num));
            dG.q("c_dfnum", String.valueOf(uVar.VI));
            dG.q("c_spnum", String.valueOf(uVar.VJ));
            dG.q("c_costt", String.valueOf(uVar.time));
            dG.q("c_dlsize", String.valueOf(uVar.lh));
            dG.q("p_dnum", String.valueOf(uVar2.num));
            dG.q("p_dfnum", String.valueOf(uVar2.VI));
            dG.q("p_spnum", String.valueOf(uVar2.VJ));
            dG.q("p_costt", String.valueOf(uVar2.time));
            dG.q("p_dlsize", String.valueOf(uVar2.lh));
            dG.q("t_dnum", String.valueOf(uVar3.num));
            dG.q("t_dfnum", String.valueOf(uVar3.VI));
            dG.q("t_spnum", String.valueOf(uVar3.VJ));
            dG.q("t_costt", String.valueOf(uVar3.time));
            dG.q("t_dlsize", String.valueOf(uVar3.lh));
            dG.q("d_dnum", String.valueOf(uVar4.num));
            dG.q("d_dfnum", String.valueOf(uVar4.VI));
            dG.q("d_spnum", String.valueOf(uVar4.VJ));
            dG.q("d_costt", String.valueOf(uVar4.time));
            dG.q("d_dlsize", String.valueOf(uVar4.lh));
            dG.q("op_dnum", String.valueOf(uVar5.num));
            dG.q("op_dfnum", String.valueOf(uVar5.VI));
            dG.q("op_spnum", String.valueOf(uVar5.VJ));
            dG.q("op_costt", String.valueOf(uVar5.time));
            dG.q("op_dlsize", String.valueOf(uVar5.lh));
            dG.q("nettype", aa.eM(i));
            com.baidu.adp.lib.stats.a.dN().a(TbConfig.TMP_PIC_DIR_NAME, dG);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.EN().EO()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "dcStat");
            dG.q("dcnum", String.valueOf(i));
            dG.q("dcfnum", String.valueOf(i2));
            dG.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.dN().a(TbConfig.TMP_PIC_DIR_NAME, dG);
        }
    }
}
