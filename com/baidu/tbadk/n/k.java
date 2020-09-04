package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (m.buo().bup()) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("action", "dlStat");
            mN.append("c_dnum", String.valueOf(tVar.num));
            mN.append("c_dfnum", String.valueOf(tVar.failnum));
            mN.append("c_spnum", String.valueOf(tVar.slownum));
            mN.append("c_costt", String.valueOf(tVar.time));
            mN.append("c_dlsize", String.valueOf(tVar.downloadSize));
            mN.append("p_dnum", String.valueOf(tVar2.num));
            mN.append("p_dfnum", String.valueOf(tVar2.failnum));
            mN.append("p_spnum", String.valueOf(tVar2.slownum));
            mN.append("p_costt", String.valueOf(tVar2.time));
            mN.append("p_dlsize", String.valueOf(tVar2.downloadSize));
            mN.append("t_dnum", String.valueOf(tVar3.num));
            mN.append("t_dfnum", String.valueOf(tVar3.failnum));
            mN.append("t_spnum", String.valueOf(tVar3.slownum));
            mN.append("t_costt", String.valueOf(tVar3.time));
            mN.append("t_dlsize", String.valueOf(tVar3.downloadSize));
            mN.append("d_dnum", String.valueOf(tVar4.num));
            mN.append("d_dfnum", String.valueOf(tVar4.failnum));
            mN.append("d_spnum", String.valueOf(tVar4.slownum));
            mN.append("d_costt", String.valueOf(tVar4.time));
            mN.append("d_dlsize", String.valueOf(tVar4.downloadSize));
            mN.append("op_dnum", String.valueOf(tVar5.num));
            mN.append("op_dfnum", String.valueOf(tVar5.failnum));
            mN.append("op_spnum", String.valueOf(tVar5.slownum));
            mN.append("op_costt", String.valueOf(tVar5.time));
            mN.append("op_dlsize", String.valueOf(tVar5.downloadSize));
            mN.append("nettype", m.qB(i));
            BdStatisticsManager.getInstance().performance("image", mN);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.buo().bup()) {
            com.baidu.adp.lib.stats.a mN = mN();
            mN.append("action", "dcStat");
            mN.append("dcnum", String.valueOf(i));
            mN.append("dcfnum", String.valueOf(i2));
            mN.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", mN);
        }
    }
}
