package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.t;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, int i) {
        if (m.bCu().bCv()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "dlStat");
            mT.append("c_dnum", String.valueOf(tVar.num));
            mT.append("c_dfnum", String.valueOf(tVar.failnum));
            mT.append("c_spnum", String.valueOf(tVar.slownum));
            mT.append("c_costt", String.valueOf(tVar.time));
            mT.append("c_dlsize", String.valueOf(tVar.downloadSize));
            mT.append("p_dnum", String.valueOf(tVar2.num));
            mT.append("p_dfnum", String.valueOf(tVar2.failnum));
            mT.append("p_spnum", String.valueOf(tVar2.slownum));
            mT.append("p_costt", String.valueOf(tVar2.time));
            mT.append("p_dlsize", String.valueOf(tVar2.downloadSize));
            mT.append("t_dnum", String.valueOf(tVar3.num));
            mT.append("t_dfnum", String.valueOf(tVar3.failnum));
            mT.append("t_spnum", String.valueOf(tVar3.slownum));
            mT.append("t_costt", String.valueOf(tVar3.time));
            mT.append("t_dlsize", String.valueOf(tVar3.downloadSize));
            mT.append("d_dnum", String.valueOf(tVar4.num));
            mT.append("d_dfnum", String.valueOf(tVar4.failnum));
            mT.append("d_spnum", String.valueOf(tVar4.slownum));
            mT.append("d_costt", String.valueOf(tVar4.time));
            mT.append("d_dlsize", String.valueOf(tVar4.downloadSize));
            mT.append("op_dnum", String.valueOf(tVar5.num));
            mT.append("op_dfnum", String.valueOf(tVar5.failnum));
            mT.append("op_spnum", String.valueOf(tVar5.slownum));
            mT.append("op_costt", String.valueOf(tVar5.time));
            mT.append("op_dlsize", String.valueOf(tVar5.downloadSize));
            mT.append("nettype", m.rL(i));
            BdStatisticsManager.getInstance().performance("image", mT);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.bCu().bCv()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "dcStat");
            mT.append("dcnum", String.valueOf(i));
            mT.append("dcfnum", String.valueOf(i2));
            mT.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", mT);
        }
    }
}
