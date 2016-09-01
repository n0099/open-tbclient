package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.u uVar, com.baidu.tbadk.core.util.u uVar2, com.baidu.tbadk.core.util.u uVar3, com.baidu.tbadk.core.util.u uVar4, com.baidu.tbadk.core.util.u uVar5, int i) {
        if (aa.Gp().Gq()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "dlStat");
            eB.q("c_dnum", String.valueOf(uVar.num));
            eB.q("c_dfnum", String.valueOf(uVar.Zv));
            eB.q("c_spnum", String.valueOf(uVar.Zw));
            eB.q("c_costt", String.valueOf(uVar.time));
            eB.q("c_dlsize", String.valueOf(uVar.od));
            eB.q("p_dnum", String.valueOf(uVar2.num));
            eB.q("p_dfnum", String.valueOf(uVar2.Zv));
            eB.q("p_spnum", String.valueOf(uVar2.Zw));
            eB.q("p_costt", String.valueOf(uVar2.time));
            eB.q("p_dlsize", String.valueOf(uVar2.od));
            eB.q("t_dnum", String.valueOf(uVar3.num));
            eB.q("t_dfnum", String.valueOf(uVar3.Zv));
            eB.q("t_spnum", String.valueOf(uVar3.Zw));
            eB.q("t_costt", String.valueOf(uVar3.time));
            eB.q("t_dlsize", String.valueOf(uVar3.od));
            eB.q("d_dnum", String.valueOf(uVar4.num));
            eB.q("d_dfnum", String.valueOf(uVar4.Zv));
            eB.q("d_spnum", String.valueOf(uVar4.Zw));
            eB.q("d_costt", String.valueOf(uVar4.time));
            eB.q("d_dlsize", String.valueOf(uVar4.od));
            eB.q("op_dnum", String.valueOf(uVar5.num));
            eB.q("op_dfnum", String.valueOf(uVar5.Zv));
            eB.q("op_spnum", String.valueOf(uVar5.Zw));
            eB.q("op_costt", String.valueOf(uVar5.time));
            eB.q("op_dlsize", String.valueOf(uVar5.od));
            eB.q("nettype", aa.ff(i));
            com.baidu.adp.lib.stats.a.eI().a(TbConfig.TMP_PIC_DIR_NAME, eB);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.Gp().Gq()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "dcStat");
            eB.q("dcnum", String.valueOf(i));
            eB.q("dcfnum", String.valueOf(i2));
            eB.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.eI().a(TbConfig.TMP_PIC_DIR_NAME, eB);
        }
    }
}
