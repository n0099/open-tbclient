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
/* loaded from: classes16.dex */
public class h {
    public static void a(q qVar, FrsViewData frsViewData, String str, boolean z, bw bwVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (qVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.bms()) {
            al cnr = qVar == null ? null : qVar.cnr();
            List<com.baidu.adp.widget.ListView.q> datas = cnr != null ? cnr.getDatas() : null;
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
                                bVar.akY = ((bw) qVar3).getTid();
                                bVar.hmy = i2;
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
                            if (bwVar2.ecy == 1 && !TextUtils.isEmpty(bwVar2.getTid())) {
                                bwVar2.ecy = 2;
                                a.b bVar2 = new a.b();
                                bVar2.akY = bwVar2.getTid();
                                bVar2.hmy = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.bmv());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.cga() - j, frsModelController.cfY(), frsModelController.cfZ(), currentTimeMillis - frsModelController.cfX());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bw bwVar) {
        if (bwVar != null && frsViewData != null) {
            FrsModelController clN = frsFragment.clN();
            q clS = frsFragment.clS();
            if (clS != null && clN != null) {
                if (bwVar.beE() != null && bwVar.beE().getGodInfo() != null) {
                    TiebaStatic.log(new aq("c10806").ai("obj_locate", 3).dD("tid", bwVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.iqT = frsViewData.needLog == 1;
                    bVar.iqV = frsViewData.getForum().getId();
                    bVar.iqU = clN.crW();
                    if (com.baidu.tieba.frs.d.d.icL != null) {
                        bVar.iqW = com.baidu.tieba.frs.d.d.icL.iqW;
                        bVar.iqX = com.baidu.tieba.frs.d.d.icL.iqX;
                    }
                    com.baidu.tieba.frs.d.c.csu().a(bVar, bwVar, 1);
                    com.baidu.tieba.frs.d.a.a(bwVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(clS, frsViewData, frsFragment.getForumId(), true, bwVar);
            }
        }
    }

    public static void a(bu buVar) {
        if (buVar != null) {
            String bea = buVar.bea();
            if (StringUtils.isNull(bea)) {
                bea = buVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", buVar.getForumId(), buVar.getForumName(), buVar.getThreadId(), "tieba.baidu.com/p/" + buVar.getThreadId(), bea);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.iqV)) {
            aq aqVar = new aq("c11942");
            aqVar.dD("fid", bVar.iqV);
            aqVar.dD("obj_name", str);
            TiebaStatic.log(aqVar);
        }
    }

    public static void cu(int i, int i2) {
        TiebaStatic.log(new aq("c10320").ai("obj_locate", i).ai("obj_type", i2));
    }
}
