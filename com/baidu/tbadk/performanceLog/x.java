package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class x extends z {
    public static void b(com.baidu.tbadk.core.util.u uVar, com.baidu.tbadk.core.util.u uVar2, com.baidu.tbadk.core.util.u uVar3, com.baidu.tbadk.core.util.u uVar4, com.baidu.tbadk.core.util.u uVar5, int i) {
        if (aa.GU().GV()) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("action", "dlStat");
            hs.r("c_dnum", String.valueOf(uVar.num));
            hs.r("c_dfnum", String.valueOf(uVar.aaj));
            hs.r("c_spnum", String.valueOf(uVar.aak));
            hs.r("c_costt", String.valueOf(uVar.time));
            hs.r("c_dlsize", String.valueOf(uVar.vq));
            hs.r("p_dnum", String.valueOf(uVar2.num));
            hs.r("p_dfnum", String.valueOf(uVar2.aaj));
            hs.r("p_spnum", String.valueOf(uVar2.aak));
            hs.r("p_costt", String.valueOf(uVar2.time));
            hs.r("p_dlsize", String.valueOf(uVar2.vq));
            hs.r("t_dnum", String.valueOf(uVar3.num));
            hs.r("t_dfnum", String.valueOf(uVar3.aaj));
            hs.r("t_spnum", String.valueOf(uVar3.aak));
            hs.r("t_costt", String.valueOf(uVar3.time));
            hs.r("t_dlsize", String.valueOf(uVar3.vq));
            hs.r("d_dnum", String.valueOf(uVar4.num));
            hs.r("d_dfnum", String.valueOf(uVar4.aaj));
            hs.r("d_spnum", String.valueOf(uVar4.aak));
            hs.r("d_costt", String.valueOf(uVar4.time));
            hs.r("d_dlsize", String.valueOf(uVar4.vq));
            hs.r("op_dnum", String.valueOf(uVar5.num));
            hs.r("op_dfnum", String.valueOf(uVar5.aaj));
            hs.r("op_spnum", String.valueOf(uVar5.aak));
            hs.r("op_costt", String.valueOf(uVar5.time));
            hs.r("op_dlsize", String.valueOf(uVar5.vq));
            hs.r("nettype", aa.fi(i));
            com.baidu.adp.lib.stats.a.hz().a(TbConfig.TMP_PIC_DIR_NAME, hs);
        }
    }

    public static void a(int i, int i2, long j) {
        if (aa.GU().GV()) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("action", "dcStat");
            hs.r("dcnum", String.valueOf(i));
            hs.r("dcfnum", String.valueOf(i2));
            hs.r("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hz().a(TbConfig.TMP_PIC_DIR_NAME, hs);
        }
    }
}
