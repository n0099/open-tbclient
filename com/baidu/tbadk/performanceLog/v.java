package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class v extends x {
    public static void a(int i, int i2, int i3, long j, long j2, int i4, int i5, int i6, long j3, long j4, int i7, int i8, int i9, long j5, long j6, int i10, int i11, int i12, long j7, long j8, int i13, int i14, int i15, long j9, long j10, int i16) {
        if (y.EH().EI()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "dlStat");
            he.q("c_dnum", String.valueOf(i));
            he.q("c_dfnum", String.valueOf(i2));
            he.q("c_spnum", String.valueOf(i3));
            he.q("c_costt", String.valueOf(j));
            he.q("c_dlsize", String.valueOf(j2));
            he.q("p_dnum", String.valueOf(i4));
            he.q("p_dfnum", String.valueOf(i5));
            he.q("p_spnum", String.valueOf(i6));
            he.q("p_costt", String.valueOf(j3));
            he.q("p_dlsize", String.valueOf(j4));
            he.q("t_dnum", String.valueOf(i7));
            he.q("t_dfnum", String.valueOf(i8));
            he.q("t_spnum", String.valueOf(i9));
            he.q("t_costt", String.valueOf(j5));
            he.q("t_dlsize", String.valueOf(j6));
            he.q("d_dnum", String.valueOf(i10));
            he.q("d_dfnum", String.valueOf(i11));
            he.q("d_spnum", String.valueOf(i12));
            he.q("d_costt", String.valueOf(j7));
            he.q("d_dlsize", String.valueOf(j8));
            he.q("op_dnum", String.valueOf(i13));
            he.q("op_dfnum", String.valueOf(i14));
            he.q("op_spnum", String.valueOf(i15));
            he.q("op_costt", String.valueOf(j10));
            he.q("op_dlsize", String.valueOf(j9));
            he.q("nettype", y.eG(i16));
            com.baidu.adp.lib.stats.a.hl().a(TbConfig.TMP_PIC_DIR_NAME, he);
        }
    }

    public static void a(int i, int i2, long j) {
        if (y.EH().EI()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "dcStat");
            he.q("dcnum", String.valueOf(i));
            he.q("dcfnum", String.valueOf(i2));
            he.q("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.a.hl().a(TbConfig.TMP_PIC_DIR_NAME, he);
        }
    }
}
