package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aa extends ab {
    public static void a(int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, long j3, long j4, int i7, int i8, int i9, long j5, long j6, int i10, int i11, int i12, long j7, long j8, int i13, int i14, int i15, long j9, long j10, int i16) {
        if (ac.zs().zt()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "dlStat");
            ed.r("c_dnum", String.valueOf(i));
            ed.r("c_dfnum", String.valueOf(i2));
            ed.r("c_spnum", String.valueOf(i3));
            ed.r("c_costt", String.valueOf(j));
            ed.r("c_dlsize", String.valueOf(j2));
            ed.r("p_dnum", String.valueOf(i4));
            ed.r("p_dfnum", String.valueOf(i5));
            ed.r("p_spnum", String.valueOf(i6));
            ed.r("p_costt", String.valueOf(j3));
            ed.r("p_dlsize", String.valueOf(j4));
            ed.r("t_dnum", String.valueOf(i7));
            ed.r("t_dfnum", String.valueOf(i8));
            ed.r("t_spnum", String.valueOf(i9));
            ed.r("t_costt", String.valueOf(j5));
            ed.r("t_dlsize", String.valueOf(j6));
            ed.r("d_dnum", String.valueOf(i10));
            ed.r("d_dfnum", String.valueOf(i11));
            ed.r("d_spnum", String.valueOf(i12));
            ed.r("d_costt", String.valueOf(j7));
            ed.r("d_dlsize", String.valueOf(j8));
            ed.r("op_dnum", String.valueOf(i13));
            ed.r("op_dfnum", String.valueOf(i14));
            ed.r("op_spnum", String.valueOf(i15));
            ed.r("op_costt", String.valueOf(j10));
            ed.r("op_dlsize", String.valueOf(j9));
            ed.r("nettype", ac.dY(i16));
            com.baidu.adp.lib.stats.f.eq().b(TbConfig.TMP_PIC_DIR_NAME, ed);
        }
    }

    public static void a(int i, int i2, long j) {
        if (ac.zs().zt()) {
            com.baidu.adp.lib.stats.q ed = ed();
            ed.r("action", "dcStat");
            ed.r("dcnum", String.valueOf(i));
            ed.r("dcfnum", String.valueOf(i2));
            ed.r("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.f.eq().b(TbConfig.TMP_PIC_DIR_NAME, ed);
        }
    }
}
