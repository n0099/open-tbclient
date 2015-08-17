package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class v extends x {
    public static void a(int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, long j3, long j4, int i7, int i8, int i9, long j5, long j6, int i10, int i11, int i12, long j7, long j8, int i13, int i14, int i15, long j9, long j10, int i16) {
        if (y.Ee().Ef()) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("action", "dlStat");
            hd.q("c_dnum", String.valueOf(i));
            hd.q("c_dfnum", String.valueOf(i2));
            hd.q("c_spnum", String.valueOf(i3));
            hd.q("c_costt", String.valueOf(j));
            hd.q("c_dlsize", String.valueOf(j2));
            hd.q("p_dnum", String.valueOf(i4));
            hd.q("p_dfnum", String.valueOf(i5));
            hd.q("p_spnum", String.valueOf(i6));
            hd.q("p_costt", String.valueOf(j3));
            hd.q("p_dlsize", String.valueOf(j4));
            hd.q("t_dnum", String.valueOf(i7));
            hd.q("t_dfnum", String.valueOf(i8));
            hd.q("t_spnum", String.valueOf(i9));
            hd.q("t_costt", String.valueOf(j5));
            hd.q("t_dlsize", String.valueOf(j6));
            hd.q("d_dnum", String.valueOf(i10));
            hd.q("d_dfnum", String.valueOf(i11));
            hd.q("d_spnum", String.valueOf(i12));
            hd.q("d_costt", String.valueOf(j7));
            hd.q("d_dlsize", String.valueOf(j8));
            hd.q("op_dnum", String.valueOf(i13));
            hd.q("op_dfnum", String.valueOf(i14));
            hd.q("op_spnum", String.valueOf(i15));
            hd.q("op_costt", String.valueOf(j10));
            hd.q("op_dlsize", String.valueOf(j9));
            hd.q("nettype", y.er(i16));
            com.baidu.adp.lib.stats.a.hk().a(TbConfig.TMP_PIC_DIR_NAME, hd);
        }
    }

    public static void a(int i, int i2, long j) {
        if (y.Ee().Ef()) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("action", "dcStat");
            hd.q("dcnum", String.valueOf(i));
            hd.q("dcfnum", String.valueOf(i2));
            hd.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hk().a(TbConfig.TMP_PIC_DIR_NAME, hd);
        }
    }
}
