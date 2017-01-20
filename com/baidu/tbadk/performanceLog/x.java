package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.s sVar, com.baidu.tbadk.core.util.s sVar2, com.baidu.tbadk.core.util.s sVar3, com.baidu.tbadk.core.util.s sVar4, com.baidu.tbadk.core.util.s sVar5, int i) {
        if (aa.FO().FP()) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "dlStat");
            ez.q("c_dnum", String.valueOf(sVar.num));
            ez.q("c_dfnum", String.valueOf(sVar.YO));
            ez.q("c_spnum", String.valueOf(sVar.YP));
            ez.q("c_costt", String.valueOf(sVar.time));
            ez.q("c_dlsize", String.valueOf(sVar.nX));
            ez.q("p_dnum", String.valueOf(sVar2.num));
            ez.q("p_dfnum", String.valueOf(sVar2.YO));
            ez.q("p_spnum", String.valueOf(sVar2.YP));
            ez.q("p_costt", String.valueOf(sVar2.time));
            ez.q("p_dlsize", String.valueOf(sVar2.nX));
            ez.q("t_dnum", String.valueOf(sVar3.num));
            ez.q("t_dfnum", String.valueOf(sVar3.YO));
            ez.q("t_spnum", String.valueOf(sVar3.YP));
            ez.q("t_costt", String.valueOf(sVar3.time));
            ez.q("t_dlsize", String.valueOf(sVar3.nX));
            ez.q("d_dnum", String.valueOf(sVar4.num));
            ez.q("d_dfnum", String.valueOf(sVar4.YO));
            ez.q("d_spnum", String.valueOf(sVar4.YP));
            ez.q("d_costt", String.valueOf(sVar4.time));
            ez.q("d_dlsize", String.valueOf(sVar4.nX));
            ez.q("op_dnum", String.valueOf(sVar5.num));
            ez.q("op_dfnum", String.valueOf(sVar5.YO));
            ez.q("op_spnum", String.valueOf(sVar5.YP));
            ez.q("op_costt", String.valueOf(sVar5.time));
            ez.q("op_dlsize", String.valueOf(sVar5.nX));
            ez.q("nettype", aa.fi(i));
            com.baidu.adp.lib.stats.a.eG().a(TbConfig.TMP_PIC_DIR_NAME, ez);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.FO().FP()) {
            com.baidu.adp.lib.stats.d ez = ez();
            ez.q("action", "dcStat");
            ez.q("dcnum", String.valueOf(i));
            ez.q("dcfnum", String.valueOf(i2));
            ez.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.eG().a(TbConfig.TMP_PIC_DIR_NAME, ez);
        }
    }
}
