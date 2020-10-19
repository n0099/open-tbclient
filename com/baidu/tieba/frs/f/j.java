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
        if (qVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.bpW()) {
            al cuc = qVar == null ? null : qVar.cuc();
            List<com.baidu.adp.widget.ListView.q> datas = cuc != null ? cuc.getDatas() : null;
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
                                bVar.alS = ((bw) qVar3).getTid();
                                bVar.hIz = i2;
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
                            if (bwVar2.eqR == 1 && !TextUtils.isEmpty(bwVar2.getTid())) {
                                bwVar2.eqR = 2;
                                a.b bVar2 = new a.b();
                                bVar2.alS = bwVar2.getTid();
                                bVar2.hIz = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.bpZ());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.cmO() - j, frsModelController.cmM(), frsModelController.cmN(), currentTimeMillis - frsModelController.cmL());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bw bwVar) {
        if (bwVar != null && frsViewData != null) {
            FrsModelController csy = frsFragment.csy();
            q csD = frsFragment.csD();
            if (csD != null && csy != null) {
                if (bwVar.bih() != null && bwVar.bih().getGodInfo() != null) {
                    TiebaStatic.log(new aq("c10806").aj("obj_locate", 3).dK("tid", bwVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.iNi = frsViewData.needLog == 1;
                    bVar.iNk = frsViewData.getForum().getId();
                    bVar.iNj = csy.cyJ();
                    if (com.baidu.tieba.frs.d.d.iyS != null) {
                        bVar.iNl = com.baidu.tieba.frs.d.d.iyS.iNl;
                        bVar.iNm = com.baidu.tieba.frs.d.d.iyS.iNm;
                    }
                    com.baidu.tieba.frs.d.c.czh().a(bVar, bwVar, 1);
                    com.baidu.tieba.frs.d.a.a(bwVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(csD, frsViewData, frsFragment.getForumId(), true, bwVar);
            }
        }
    }

    public static void a(bu buVar) {
        if (buVar != null) {
            String bhD = buVar.bhD();
            if (StringUtils.isNull(bhD)) {
                bhD = buVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", buVar.getForumId(), buVar.getForumName(), buVar.getThreadId(), "tieba.baidu.com/p/" + buVar.getThreadId(), bhD);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.iNk)) {
            aq aqVar = new aq("c11942");
            aqVar.dK("fid", bVar.iNk);
            aqVar.dK("obj_name", str);
            TiebaStatic.log(aqVar);
        }
    }

    public static void cx(int i, int i2) {
        TiebaStatic.log(new aq("c10320").aj("obj_locate", i).aj("obj_type", i2));
    }
}
