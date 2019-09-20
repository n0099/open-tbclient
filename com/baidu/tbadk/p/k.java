package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.r;
/* loaded from: classes.dex */
public class k extends l {
    public static void b(r rVar, r rVar2, r rVar3, r rVar4, r rVar5, int i) {
        if (m.avH().avI()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "dlStat");
            iF.append("c_dnum", String.valueOf(rVar.num));
            iF.append("c_dfnum", String.valueOf(rVar.bRZ));
            iF.append("c_spnum", String.valueOf(rVar.bSa));
            iF.append("c_costt", String.valueOf(rVar.time));
            iF.append("c_dlsize", String.valueOf(rVar.Au));
            iF.append("p_dnum", String.valueOf(rVar2.num));
            iF.append("p_dfnum", String.valueOf(rVar2.bRZ));
            iF.append("p_spnum", String.valueOf(rVar2.bSa));
            iF.append("p_costt", String.valueOf(rVar2.time));
            iF.append("p_dlsize", String.valueOf(rVar2.Au));
            iF.append("t_dnum", String.valueOf(rVar3.num));
            iF.append("t_dfnum", String.valueOf(rVar3.bRZ));
            iF.append("t_spnum", String.valueOf(rVar3.bSa));
            iF.append("t_costt", String.valueOf(rVar3.time));
            iF.append("t_dlsize", String.valueOf(rVar3.Au));
            iF.append("d_dnum", String.valueOf(rVar4.num));
            iF.append("d_dfnum", String.valueOf(rVar4.bRZ));
            iF.append("d_spnum", String.valueOf(rVar4.bSa));
            iF.append("d_costt", String.valueOf(rVar4.time));
            iF.append("d_dlsize", String.valueOf(rVar4.Au));
            iF.append("op_dnum", String.valueOf(rVar5.num));
            iF.append("op_dfnum", String.valueOf(rVar5.bRZ));
            iF.append("op_spnum", String.valueOf(rVar5.bSa));
            iF.append("op_costt", String.valueOf(rVar5.time));
            iF.append("op_dlsize", String.valueOf(rVar5.Au));
            iF.append("nettype", m.kW(i));
            BdStatisticsManager.getInstance().performance("image", iF);
        }
    }

    public static void b(int i, int i2, long j) {
        if (m.avH().avI()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "dcStat");
            iF.append("dcnum", String.valueOf(i));
            iF.append("dcfnum", String.valueOf(i2));
            iF.append("dcstime", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("image", iF);
        }
    }
}
