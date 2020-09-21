package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (m.bvs().bvt()) {
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("action", "dlStat");
            mS.append("c_dnum", String.valueOf(tVar.num));
            mS.append("c_dfnum", String.valueOf(tVar.failnum));
            mS.append("c_spnum", String.valueOf(tVar.slownum));
            mS.append("c_costt", String.valueOf(tVar.time));
            mS.append("c_dlsize", String.valueOf(tVar.downloadSize));
            mS.append("p_dnum", String.valueOf(tVar2.num));
            mS.append("p_dfnum", String.valueOf(tVar2.failnum));
            mS.append("p_spnum", String.valueOf(tVar2.slownum));
            mS.append("p_costt", String.valueOf(tVar2.time));
            mS.append("p_dlsize", String.valueOf(tVar2.downloadSize));
            mS.append("t_dnum", String.valueOf(tVar3.num));
            mS.append("t_dfnum", String.valueOf(tVar3.failnum));
            mS.append("t_spnum", String.valueOf(tVar3.slownum));
            mS.append("t_costt", String.valueOf(tVar3.time));
            mS.append("t_dlsize", String.valueOf(tVar3.downloadSize));
            mS.append("d_dnum", String.valueOf(tVar4.num));
            mS.append("d_dfnum", String.valueOf(tVar4.failnum));
            mS.append("d_spnum", String.valueOf(tVar4.slownum));
            mS.append("d_costt", String.valueOf(tVar4.time));
            mS.append("d_dlsize", String.valueOf(tVar4.downloadSize));
            mS.append("op_dnum", String.valueOf(tVar5.num));
            mS.append("op_dfnum", String.valueOf(tVar5.failnum));
            mS.append("op_spnum", String.valueOf(tVar5.slownum));
            mS.append("op_costt", String.valueOf(tVar5.time));
            mS.append("op_dlsize", String.valueOf(tVar5.downloadSize));
            mS.append("nettype", m.qS(i));
            BdStatisticsManager.getInstance().performance("image", mS);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.bvs().bvt()) {
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("action", "dcStat");
            mS.append("dcnum", String.valueOf(i));
            mS.append("dcfnum", String.valueOf(i2));
            mS.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", mS);
        }
    }
}
