package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class ae extends ag {
    public static void a(int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, long j3, long j4, int i7, int i8, int i9, long j5, long j6, int i10, int i11, int i12, long j7, long j8, int i13, int i14, int i15, long j9, long j10, int i16) {
        if (ah.DC().DD()) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", "dlStat");
            hm.r("c_dnum", String.valueOf(i));
            hm.r("c_dfnum", String.valueOf(i2));
            hm.r("c_spnum", String.valueOf(i3));
            hm.r("c_costt", String.valueOf(j));
            hm.r("c_dlsize", String.valueOf(j2));
            hm.r("p_dnum", String.valueOf(i4));
            hm.r("p_dfnum", String.valueOf(i5));
            hm.r("p_spnum", String.valueOf(i6));
            hm.r("p_costt", String.valueOf(j3));
            hm.r("p_dlsize", String.valueOf(j4));
            hm.r("t_dnum", String.valueOf(i7));
            hm.r("t_dfnum", String.valueOf(i8));
            hm.r("t_spnum", String.valueOf(i9));
            hm.r("t_costt", String.valueOf(j5));
            hm.r("t_dlsize", String.valueOf(j6));
            hm.r("d_dnum", String.valueOf(i10));
            hm.r("d_dfnum", String.valueOf(i11));
            hm.r("d_spnum", String.valueOf(i12));
            hm.r("d_costt", String.valueOf(j7));
            hm.r("d_dlsize", String.valueOf(j8));
            hm.r("op_dnum", String.valueOf(i13));
            hm.r("op_dfnum", String.valueOf(i14));
            hm.r("op_spnum", String.valueOf(i15));
            hm.r("op_costt", String.valueOf(j10));
            hm.r("op_dlsize", String.valueOf(j9));
            hm.r("nettype", ah.em(i16));
            com.baidu.adp.lib.stats.f.hz().b(TbConfig.TMP_PIC_DIR_NAME, hm);
        }
    }

    public static void a(int i, int i2, long j) {
        if (ah.DC().DD()) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", "dcStat");
            hm.r("dcnum", String.valueOf(i));
            hm.r("dcfnum", String.valueOf(i2));
            hm.r("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.f.hz().b(TbConfig.TMP_PIC_DIR_NAME, hm);
        }
    }
}
