package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class v extends x {
    public static void a(int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, long j3, long j4, int i7, int i8, int i9, long j5, long j6, int i10, int i11, int i12, long j7, long j8, int i13, int i14, int i15, long j9, long j10, int i16) {
        if (y.Eo().Ep()) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("action", "dlStat");
            ha.q("c_dnum", String.valueOf(i));
            ha.q("c_dfnum", String.valueOf(i2));
            ha.q("c_spnum", String.valueOf(i3));
            ha.q("c_costt", String.valueOf(j));
            ha.q("c_dlsize", String.valueOf(j2));
            ha.q("p_dnum", String.valueOf(i4));
            ha.q("p_dfnum", String.valueOf(i5));
            ha.q("p_spnum", String.valueOf(i6));
            ha.q("p_costt", String.valueOf(j3));
            ha.q("p_dlsize", String.valueOf(j4));
            ha.q("t_dnum", String.valueOf(i7));
            ha.q("t_dfnum", String.valueOf(i8));
            ha.q("t_spnum", String.valueOf(i9));
            ha.q("t_costt", String.valueOf(j5));
            ha.q("t_dlsize", String.valueOf(j6));
            ha.q("d_dnum", String.valueOf(i10));
            ha.q("d_dfnum", String.valueOf(i11));
            ha.q("d_spnum", String.valueOf(i12));
            ha.q("d_costt", String.valueOf(j7));
            ha.q("d_dlsize", String.valueOf(j8));
            ha.q("op_dnum", String.valueOf(i13));
            ha.q("op_dfnum", String.valueOf(i14));
            ha.q("op_spnum", String.valueOf(i15));
            ha.q("op_costt", String.valueOf(j10));
            ha.q("op_dlsize", String.valueOf(j9));
            ha.q("nettype", y.ez(i16));
            com.baidu.adp.lib.stats.a.hh().a(TbConfig.TMP_PIC_DIR_NAME, ha);
        }
    }

    public static void a(int i, int i2, long j) {
        if (y.Eo().Ep()) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("action", "dcStat");
            ha.q("dcnum", String.valueOf(i));
            ha.q("dcfnum", String.valueOf(i2));
            ha.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hh().a(TbConfig.TMP_PIC_DIR_NAME, ha);
        }
    }
}
