package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class aa extends ab {
    public static void a(int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, long j3, long j4, int i7, int i8, int i9, long j5, long j6, int i10, int i11, int i12, long j7, long j8, int i13, int i14, int i15, long j9, long j10, int i16) {
        if (ac.zh().zi()) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("action", "dlStat");
            ef.r("c_dnum", String.valueOf(i));
            ef.r("c_dfnum", String.valueOf(i2));
            ef.r("c_spnum", String.valueOf(i3));
            ef.r("c_costt", String.valueOf(j));
            ef.r("c_dlsize", String.valueOf(j2));
            ef.r("p_dnum", String.valueOf(i4));
            ef.r("p_dfnum", String.valueOf(i5));
            ef.r("p_spnum", String.valueOf(i6));
            ef.r("p_costt", String.valueOf(j3));
            ef.r("p_dlsize", String.valueOf(j4));
            ef.r("t_dnum", String.valueOf(i7));
            ef.r("t_dfnum", String.valueOf(i8));
            ef.r("t_spnum", String.valueOf(i9));
            ef.r("t_costt", String.valueOf(j5));
            ef.r("t_dlsize", String.valueOf(j6));
            ef.r("d_dnum", String.valueOf(i10));
            ef.r("d_dfnum", String.valueOf(i11));
            ef.r("d_spnum", String.valueOf(i12));
            ef.r("d_costt", String.valueOf(j7));
            ef.r("d_dlsize", String.valueOf(j8));
            ef.r("op_dnum", String.valueOf(i13));
            ef.r("op_dfnum", String.valueOf(i14));
            ef.r("op_spnum", String.valueOf(i15));
            ef.r("op_costt", String.valueOf(j10));
            ef.r("op_dlsize", String.valueOf(j9));
            ef.r("nettype", ac.dS(i16));
            com.baidu.adp.lib.stats.f.es().b(TbConfig.TMP_PIC_DIR_NAME, ef);
        }
    }

    public static void a(int i, int i2, long j) {
        if (ac.zh().zi()) {
            com.baidu.adp.lib.stats.q ef = ef();
            ef.r("action", "dcStat");
            ef.r("dcnum", String.valueOf(i));
            ef.r("dcfnum", String.valueOf(i2));
            ef.r("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.f.es().b(TbConfig.TMP_PIC_DIR_NAME, ef);
        }
    }
}
