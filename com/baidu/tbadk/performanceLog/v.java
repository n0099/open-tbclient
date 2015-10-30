package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class v extends x {
    public static void a(int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, long j3, long j4, int i7, int i8, int i9, long j5, long j6, int i10, int i11, int i12, long j7, long j8, int i13, int i14, int i15, long j9, long j10, int i16) {
        if (y.DY().DZ()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "dlStat");
            hb.q("c_dnum", String.valueOf(i));
            hb.q("c_dfnum", String.valueOf(i2));
            hb.q("c_spnum", String.valueOf(i3));
            hb.q("c_costt", String.valueOf(j));
            hb.q("c_dlsize", String.valueOf(j2));
            hb.q("p_dnum", String.valueOf(i4));
            hb.q("p_dfnum", String.valueOf(i5));
            hb.q("p_spnum", String.valueOf(i6));
            hb.q("p_costt", String.valueOf(j3));
            hb.q("p_dlsize", String.valueOf(j4));
            hb.q("t_dnum", String.valueOf(i7));
            hb.q("t_dfnum", String.valueOf(i8));
            hb.q("t_spnum", String.valueOf(i9));
            hb.q("t_costt", String.valueOf(j5));
            hb.q("t_dlsize", String.valueOf(j6));
            hb.q("d_dnum", String.valueOf(i10));
            hb.q("d_dfnum", String.valueOf(i11));
            hb.q("d_spnum", String.valueOf(i12));
            hb.q("d_costt", String.valueOf(j7));
            hb.q("d_dlsize", String.valueOf(j8));
            hb.q("op_dnum", String.valueOf(i13));
            hb.q("op_dfnum", String.valueOf(i14));
            hb.q("op_spnum", String.valueOf(i15));
            hb.q("op_costt", String.valueOf(j10));
            hb.q("op_dlsize", String.valueOf(j9));
            hb.q("nettype", y.eA(i16));
            com.baidu.adp.lib.stats.a.hi().a(TbConfig.TMP_PIC_DIR_NAME, hb);
        }
    }

    public static void a(int i, int i2, long j) {
        if (y.DY().DZ()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "dcStat");
            hb.q("dcnum", String.valueOf(i));
            hb.q("dcfnum", String.valueOf(i2));
            hb.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hi().a(TbConfig.TMP_PIC_DIR_NAME, hb);
        }
    }
}
