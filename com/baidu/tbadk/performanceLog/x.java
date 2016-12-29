package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.t tVar, com.baidu.tbadk.core.util.t tVar2, com.baidu.tbadk.core.util.t tVar3, com.baidu.tbadk.core.util.t tVar4, com.baidu.tbadk.core.util.t tVar5, int i) {
        if (aa.FU().FV()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "dlStat");
            eB.q("c_dnum", String.valueOf(tVar.num));
            eB.q("c_dfnum", String.valueOf(tVar.ZA));
            eB.q("c_spnum", String.valueOf(tVar.ZB));
            eB.q("c_costt", String.valueOf(tVar.time));
            eB.q("c_dlsize", String.valueOf(tVar.oe));
            eB.q("p_dnum", String.valueOf(tVar2.num));
            eB.q("p_dfnum", String.valueOf(tVar2.ZA));
            eB.q("p_spnum", String.valueOf(tVar2.ZB));
            eB.q("p_costt", String.valueOf(tVar2.time));
            eB.q("p_dlsize", String.valueOf(tVar2.oe));
            eB.q("t_dnum", String.valueOf(tVar3.num));
            eB.q("t_dfnum", String.valueOf(tVar3.ZA));
            eB.q("t_spnum", String.valueOf(tVar3.ZB));
            eB.q("t_costt", String.valueOf(tVar3.time));
            eB.q("t_dlsize", String.valueOf(tVar3.oe));
            eB.q("d_dnum", String.valueOf(tVar4.num));
            eB.q("d_dfnum", String.valueOf(tVar4.ZA));
            eB.q("d_spnum", String.valueOf(tVar4.ZB));
            eB.q("d_costt", String.valueOf(tVar4.time));
            eB.q("d_dlsize", String.valueOf(tVar4.oe));
            eB.q("op_dnum", String.valueOf(tVar5.num));
            eB.q("op_dfnum", String.valueOf(tVar5.ZA));
            eB.q("op_spnum", String.valueOf(tVar5.ZB));
            eB.q("op_costt", String.valueOf(tVar5.time));
            eB.q("op_dlsize", String.valueOf(tVar5.oe));
            eB.q("nettype", aa.fh(i));
            com.baidu.adp.lib.stats.a.eI().a(TbConfig.TMP_PIC_DIR_NAME, eB);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.FU().FV()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "dcStat");
            eB.q("dcnum", String.valueOf(i));
            eB.q("dcfnum", String.valueOf(i2));
            eB.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.eI().a(TbConfig.TMP_PIC_DIR_NAME, eB);
        }
    }
}
