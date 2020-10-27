package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.al;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes22.dex */
public class j {
    public static void a(q qVar, FrsViewData frsViewData, String str, boolean z, bw bwVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (qVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.brP()) {
            al cxj = qVar == null ? null : qVar.cxj();
            List<com.baidu.adp.widget.ListView.q> datas = cxj != null ? cxj.getDatas() : null;
            List<com.baidu.adp.widget.ListView.q> singletonList = bwVar != null ? Collections.singletonList(bwVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.q qVar2 : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.q qVar3 : singletonList) {
                            if (qVar2 == qVar3 && (qVar3 instanceof bw)) {
                                a.b bVar = new a.b();
                                bVar.alT = ((bw) qVar3).getTid();
                                bVar.hUW = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.q qVar4 : singletonList) {
                        if (qVar4 instanceof bw) {
                            bw bwVar2 = (bw) qVar4;
                            i3++;
                            if (bwVar2.ezs == 1 && !TextUtils.isEmpty(bwVar2.getTid())) {
                                bwVar2.ezs = 2;
                                a.b bVar2 = new a.b();
                                bVar2.alT = bwVar2.getTid();
                                bVar2.hUW = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.brS());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.cpV() - j, frsModelController.cpT(), frsModelController.cpU(), currentTimeMillis - frsModelController.cpS());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bw bwVar) {
        if (bwVar != null && frsViewData != null) {
            FrsModelController cvF = frsFragment.cvF();
            q cvK = frsFragment.cvK();
            if (cvK != null && cvF != null) {
                if (bwVar.bka() != null && bwVar.bka().getGodInfo() != null) {
                    TiebaStatic.log(new aq("c10806").aj("obj_locate", 3).dR("tid", bwVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.iZE = frsViewData.needLog == 1;
                    bVar.iZG = frsViewData.getForum().getId();
                    bVar.iZF = cvF.cBQ();
                    if (com.baidu.tieba.frs.d.d.iLo != null) {
                        bVar.iZH = com.baidu.tieba.frs.d.d.iLo.iZH;
                        bVar.iZI = com.baidu.tieba.frs.d.d.iLo.iZI;
                    }
                    com.baidu.tieba.frs.d.c.cCo().a(bVar, bwVar, 1);
                    com.baidu.tieba.frs.d.a.a(bwVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(cvK, frsViewData, frsFragment.getForumId(), true, bwVar);
            }
        }
    }

    public static void a(bu buVar) {
        if (buVar != null) {
            String bjw = buVar.bjw();
            if (StringUtils.isNull(bjw)) {
                bjw = buVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", buVar.getForumId(), buVar.getForumName(), buVar.getThreadId(), "tieba.baidu.com/p/" + buVar.getThreadId(), bjw);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.iZG)) {
            aq aqVar = new aq("c11942");
            aqVar.dR("fid", bVar.iZG);
            aqVar.dR("obj_name", str);
            TiebaStatic.log(aqVar);
        }
    }

    public static void cz(int i, int i2) {
        TiebaStatic.log(new aq("c10320").aj("obj_locate", i).aj("obj_type", i2));
    }
}
