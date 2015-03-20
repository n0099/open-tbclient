package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ae extends ag {
    public static void a(int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, long j3, long j4, int i7, int i8, int i9, long j5, long j6, int i10, int i11, int i12, long j7, long j8, int i13, int i14, int i15, long j9, long j10, int i16) {
        if (ah.CK().CL()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "dlStat");
            hC.r("c_dnum", String.valueOf(i));
            hC.r("c_dfnum", String.valueOf(i2));
            hC.r("c_spnum", String.valueOf(i3));
            hC.r("c_costt", String.valueOf(j));
            hC.r("c_dlsize", String.valueOf(j2));
            hC.r("p_dnum", String.valueOf(i4));
            hC.r("p_dfnum", String.valueOf(i5));
            hC.r("p_spnum", String.valueOf(i6));
            hC.r("p_costt", String.valueOf(j3));
            hC.r("p_dlsize", String.valueOf(j4));
            hC.r("t_dnum", String.valueOf(i7));
            hC.r("t_dfnum", String.valueOf(i8));
            hC.r("t_spnum", String.valueOf(i9));
            hC.r("t_costt", String.valueOf(j5));
            hC.r("t_dlsize", String.valueOf(j6));
            hC.r("d_dnum", String.valueOf(i10));
            hC.r("d_dfnum", String.valueOf(i11));
            hC.r("d_spnum", String.valueOf(i12));
            hC.r("d_costt", String.valueOf(j7));
            hC.r("d_dlsize", String.valueOf(j8));
            hC.r("op_dnum", String.valueOf(i13));
            hC.r("op_dfnum", String.valueOf(i14));
            hC.r("op_spnum", String.valueOf(i15));
            hC.r("op_costt", String.valueOf(j10));
            hC.r("op_dlsize", String.valueOf(j9));
            hC.r("nettype", ah.ec(i16));
            com.baidu.adp.lib.stats.f.hP().b(TbConfig.TMP_PIC_DIR_NAME, hC);
        }
    }

    public static void a(int i, int i2, long j) {
        if (ah.CK().CL()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "dcStat");
            hC.r("dcnum", String.valueOf(i));
            hC.r("dcfnum", String.valueOf(i2));
            hC.r("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.f.hP().b(TbConfig.TMP_PIC_DIR_NAME, hC);
        }
    }
}
