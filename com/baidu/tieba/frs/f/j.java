package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.al;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes21.dex */
public class j {
    public static void a(q qVar, FrsViewData frsViewData, String str, boolean z, bx bxVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (qVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.btF()) {
            al czn = qVar == null ? null : qVar.czn();
            List<com.baidu.adp.widget.ListView.q> datas = czn != null ? czn.getDatas() : null;
            List<com.baidu.adp.widget.ListView.q> singletonList = bxVar != null ? Collections.singletonList(bxVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.q qVar2 : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.q qVar3 : singletonList) {
                            if (qVar2 == qVar3 && (qVar3 instanceof bx)) {
                                a.b bVar = new a.b();
                                bVar.alZ = ((bx) qVar3).getTid();
                                bVar.ibH = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.q qVar4 : singletonList) {
                        if (qVar4 instanceof bx) {
                            bx bxVar2 = (bx) qVar4;
                            i3++;
                            if (bxVar2.eDz == 1 && !TextUtils.isEmpty(bxVar2.getTid())) {
                                bxVar2.eDz = 2;
                                a.b bVar2 = new a.b();
                                bVar2.alZ = bxVar2.getTid();
                                bVar2.ibH = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    r.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.btI());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.crZ() - j, frsModelController.crX(), frsModelController.crY(), currentTimeMillis - frsModelController.crW());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bx bxVar) {
        if (bxVar != null && frsViewData != null) {
            FrsModelController cxJ = frsFragment.cxJ();
            q cxO = frsFragment.cxO();
            if (cxO != null && cxJ != null) {
                if (bxVar.blC() != null && bxVar.blC().getGodInfo() != null) {
                    TiebaStatic.log(new ar("c10806").ak("obj_locate", 3).dR("tid", bxVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.jgm = frsViewData.needLog == 1;
                    bVar.jgo = frsViewData.getForum().getId();
                    bVar.jgn = cxJ.cDV();
                    if (com.baidu.tieba.frs.d.d.iRY != null) {
                        bVar.jgp = com.baidu.tieba.frs.d.d.iRY.jgp;
                        bVar.jgq = com.baidu.tieba.frs.d.d.iRY.jgq;
                    }
                    com.baidu.tieba.frs.d.c.cEu().a(bVar, bxVar, 1);
                    com.baidu.tieba.frs.d.a.a(bxVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(cxO, frsViewData, frsFragment.getForumId(), true, bxVar);
            }
        }
    }

    public static void a(bv bvVar) {
        if (bvVar != null) {
            String bkY = bvVar.bkY();
            if (StringUtils.isNull(bkY)) {
                bkY = bvVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", bvVar.getForumId(), bvVar.getForumName(), bvVar.getThreadId(), "tieba.baidu.com/p/" + bvVar.getThreadId(), bkY);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.jgo)) {
            ar arVar = new ar("c11942");
            arVar.dR("fid", bVar.jgo);
            arVar.dR("obj_name", str);
            TiebaStatic.log(arVar);
        }
    }

    public static void cB(int i, int i2) {
        TiebaStatic.log(new ar("c10320").ak("obj_locate", i).ak("obj_type", i2));
    }
}
