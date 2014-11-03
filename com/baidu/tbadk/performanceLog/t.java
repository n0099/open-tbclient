package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class t extends u {
    public static void a(int i, int i2, int i3, long j, int i4, int i5, int i6, long j2, int i7, int i8, int i9, long j3, int i10, int i11, int i12, long j4, int i13, int i14, int i15, long j5, int i16) {
        if (v.uP().uQ()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "dlStat");
            logItem.n("c_dnum", String.valueOf(i));
            logItem.n("c_dfnum", String.valueOf(i2));
            logItem.n("c_spnum", String.valueOf(i3));
            logItem.n("c_costt", String.valueOf(j));
            logItem.n("p_dnum", String.valueOf(i4));
            logItem.n("p_dfnum", String.valueOf(i5));
            logItem.n("p_spnum", String.valueOf(i6));
            logItem.n("p_costt", String.valueOf(j2));
            logItem.n("t_dnum", String.valueOf(i7));
            logItem.n("t_dfnum", String.valueOf(i8));
            logItem.n("t_spnum", String.valueOf(i9));
            logItem.n("t_costt", String.valueOf(j3));
            logItem.n("d_dnum", String.valueOf(i10));
            logItem.n("d_dfnum", String.valueOf(i11));
            logItem.n("d_spnum", String.valueOf(i12));
            logItem.n("d_costt", String.valueOf(j4));
            logItem.n("op_dnum", String.valueOf(i13));
            logItem.n("op_dfnum", String.valueOf(i14));
            logItem.n("op_spnum", String.valueOf(i15));
            logItem.n("op_costt", String.valueOf(j5));
            logItem.n("nettype", v.dn(i16));
            com.baidu.adp.lib.stats.f.er().b(TbConfig.TMP_PIC_DIR_NAME, logItem);
        }
    }

    public static void a(int i, int i2, long j) {
        if (v.uP().uQ()) {
            com.baidu.adp.lib.stats.q logItem = getLogItem();
            logItem.n("action", "dcStat");
            logItem.n("dcnum", String.valueOf(i));
            logItem.n("dcfnum", String.valueOf(i2));
            logItem.n("dcstime", String.valueOf(j));
            com.baidu.adp.lib.stats.f.er().b(TbConfig.TMP_PIC_DIR_NAME, logItem);
        }
    }
}
