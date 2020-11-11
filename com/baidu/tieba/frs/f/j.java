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
        if (qVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.bup()) {
            al czK = qVar == null ? null : qVar.czK();
            List<com.baidu.adp.widget.ListView.q> datas = czK != null ? czK.getDatas() : null;
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
                                bVar.iaT = i2;
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
                            if (bwVar2.eFh == 1 && !TextUtils.isEmpty(bwVar2.getTid())) {
                                bwVar2.eFh = 2;
                                a.b bVar2 = new a.b();
                                bVar2.alT = bwVar2.getTid();
                                bVar2.iaT = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.bus());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.csw() - j, frsModelController.csu(), frsModelController.csv(), currentTimeMillis - frsModelController.cst());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bw bwVar) {
        if (bwVar != null && frsViewData != null) {
            FrsModelController cyg = frsFragment.cyg();
            q cyl = frsFragment.cyl();
            if (cyl != null && cyg != null) {
                if (bwVar.bmA() != null && bwVar.bmA().getGodInfo() != null) {
                    TiebaStatic.log(new aq("c10806").al("obj_locate", 3).dR("tid", bwVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.jfB = frsViewData.needLog == 1;
                    bVar.jfD = frsViewData.getForum().getId();
                    bVar.jfC = cyg.cEr();
                    if (com.baidu.tieba.frs.d.d.iRl != null) {
                        bVar.jfE = com.baidu.tieba.frs.d.d.iRl.jfE;
                        bVar.jfF = com.baidu.tieba.frs.d.d.iRl.jfF;
                    }
                    com.baidu.tieba.frs.d.c.cEP().a(bVar, bwVar, 1);
                    com.baidu.tieba.frs.d.a.a(bwVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(cyl, frsViewData, frsFragment.getForumId(), true, bwVar);
            }
        }
    }

    public static void a(bu buVar) {
        if (buVar != null) {
            String blW = buVar.blW();
            if (StringUtils.isNull(blW)) {
                blW = buVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", buVar.getForumId(), buVar.getForumName(), buVar.getThreadId(), "tieba.baidu.com/p/" + buVar.getThreadId(), blW);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.jfD)) {
            aq aqVar = new aq("c11942");
            aqVar.dR("fid", bVar.jfD);
            aqVar.dR("obj_name", str);
            TiebaStatic.log(aqVar);
        }
    }

    public static void cB(int i, int i2) {
        TiebaStatic.log(new aq("c10320").al("obj_locate", i).al("obj_type", i2));
    }
}
