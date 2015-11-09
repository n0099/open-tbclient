package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class v extends x {
    public static void a(int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, long j3, long j4, int i7, int i8, int i9, long j5, long j6, int i10, int i11, int i12, long j7, long j8, int i13, int i14, int i15, long j9, long j10, int i16) {
        if (y.DR().DS()) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("action", "dlStat");
            hc.q("c_dnum", String.valueOf(i));
            hc.q("c_dfnum", String.valueOf(i2));
            hc.q("c_spnum", String.valueOf(i3));
            hc.q("c_costt", String.valueOf(j));
            hc.q("c_dlsize", String.valueOf(j2));
            hc.q("p_dnum", String.valueOf(i4));
            hc.q("p_dfnum", String.valueOf(i5));
            hc.q("p_spnum", String.valueOf(i6));
            hc.q("p_costt", String.valueOf(j3));
            hc.q("p_dlsize", String.valueOf(j4));
            hc.q("t_dnum", String.valueOf(i7));
            hc.q("t_dfnum", String.valueOf(i8));
            hc.q("t_spnum", String.valueOf(i9));
            hc.q("t_costt", String.valueOf(j5));
            hc.q("t_dlsize", String.valueOf(j6));
            hc.q("d_dnum", String.valueOf(i10));
            hc.q("d_dfnum", String.valueOf(i11));
            hc.q("d_spnum", String.valueOf(i12));
            hc.q("d_costt", String.valueOf(j7));
            hc.q("d_dlsize", String.valueOf(j8));
            hc.q("op_dnum", String.valueOf(i13));
            hc.q("op_dfnum", String.valueOf(i14));
            hc.q("op_spnum", String.valueOf(i15));
            hc.q("op_costt", String.valueOf(j10));
            hc.q("op_dlsize", String.valueOf(j9));
            hc.q("nettype", y.ey(i16));
            com.baidu.adp.lib.stats.a.hj().a(TbConfig.TMP_PIC_DIR_NAME, hc);
        }
    }

    public static void a(int i, int i2, long j) {
        if (y.DR().DS()) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("action", "dcStat");
            hc.q("dcnum", String.valueOf(i));
            hc.q("dcfnum", String.valueOf(i2));
            hc.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hj().a(TbConfig.TMP_PIC_DIR_NAME, hc);
        }
    }
}
