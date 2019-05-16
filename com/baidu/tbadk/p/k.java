package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.auk().aul()) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("action", "dlStat");
            iw.append("c_dnum", String.valueOf(rVar.num));
            iw.append("c_dfnum", String.valueOf(rVar.bQr));
            iw.append("c_spnum", String.valueOf(rVar.bQs));
            iw.append("c_costt", String.valueOf(rVar.time));
            iw.append("c_dlsize", String.valueOf(rVar.Ap));
            iw.append("p_dnum", String.valueOf(rVar2.num));
            iw.append("p_dfnum", String.valueOf(rVar2.bQr));
            iw.append("p_spnum", String.valueOf(rVar2.bQs));
            iw.append("p_costt", String.valueOf(rVar2.time));
            iw.append("p_dlsize", String.valueOf(rVar2.Ap));
            iw.append("t_dnum", String.valueOf(rVar3.num));
            iw.append("t_dfnum", String.valueOf(rVar3.bQr));
            iw.append("t_spnum", String.valueOf(rVar3.bQs));
            iw.append("t_costt", String.valueOf(rVar3.time));
            iw.append("t_dlsize", String.valueOf(rVar3.Ap));
            iw.append("d_dnum", String.valueOf(rVar4.num));
            iw.append("d_dfnum", String.valueOf(rVar4.bQr));
            iw.append("d_spnum", String.valueOf(rVar4.bQs));
            iw.append("d_costt", String.valueOf(rVar4.time));
            iw.append("d_dlsize", String.valueOf(rVar4.Ap));
            iw.append("op_dnum", String.valueOf(rVar5.num));
            iw.append("op_dfnum", String.valueOf(rVar5.bQr));
            iw.append("op_spnum", String.valueOf(rVar5.bQs));
            iw.append("op_costt", String.valueOf(rVar5.time));
            iw.append("op_dlsize", String.valueOf(rVar5.Ap));
            iw.append("nettype", m.kM(i));
            BdStatisticsManager.getInstance().performance("image", iw);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.auk().aul()) {
            com.baidu.adp.lib.stats.a iw = iw();
            iw.append("action", "dcStat");
            iw.append("dcnum", String.valueOf(i));
            iw.append("dcfnum", String.valueOf(i2));
            iw.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", iw);
        }
    }
}
