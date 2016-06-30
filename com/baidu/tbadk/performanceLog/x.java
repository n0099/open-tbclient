package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.u uVar, com.baidu.tbadk.core.util.u uVar2, com.baidu.tbadk.core.util.u uVar3, com.baidu.tbadk.core.util.u uVar4, com.baidu.tbadk.core.util.u uVar5, int i) {
        if (aa.EW().EX()) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "dlStat");
            dH.q("c_dnum", String.valueOf(uVar.num));
            dH.q("c_dfnum", String.valueOf(uVar.VY));
            dH.q("c_spnum", String.valueOf(uVar.VZ));
            dH.q("c_costt", String.valueOf(uVar.time));
            dH.q("c_dlsize", String.valueOf(uVar.lf));
            dH.q("p_dnum", String.valueOf(uVar2.num));
            dH.q("p_dfnum", String.valueOf(uVar2.VY));
            dH.q("p_spnum", String.valueOf(uVar2.VZ));
            dH.q("p_costt", String.valueOf(uVar2.time));
            dH.q("p_dlsize", String.valueOf(uVar2.lf));
            dH.q("t_dnum", String.valueOf(uVar3.num));
            dH.q("t_dfnum", String.valueOf(uVar3.VY));
            dH.q("t_spnum", String.valueOf(uVar3.VZ));
            dH.q("t_costt", String.valueOf(uVar3.time));
            dH.q("t_dlsize", String.valueOf(uVar3.lf));
            dH.q("d_dnum", String.valueOf(uVar4.num));
            dH.q("d_dfnum", String.valueOf(uVar4.VY));
            dH.q("d_spnum", String.valueOf(uVar4.VZ));
            dH.q("d_costt", String.valueOf(uVar4.time));
            dH.q("d_dlsize", String.valueOf(uVar4.lf));
            dH.q("op_dnum", String.valueOf(uVar5.num));
            dH.q("op_dfnum", String.valueOf(uVar5.VY));
            dH.q("op_spnum", String.valueOf(uVar5.VZ));
            dH.q("op_costt", String.valueOf(uVar5.time));
            dH.q("op_dlsize", String.valueOf(uVar5.lf));
            dH.q("nettype", aa.eR(i));
            com.baidu.adp.lib.stats.a.dO().a(TbConfig.TMP_PIC_DIR_NAME, dH);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.EW().EX()) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "dcStat");
            dH.q("dcnum", String.valueOf(i));
            dH.q("dcfnum", String.valueOf(i2));
            dH.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.dO().a(TbConfig.TMP_PIC_DIR_NAME, dH);
        }
    }
}
