package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    public static void a(k kVar, l lVar, String str, boolean z, bc bcVar) {
        com.baidu.tbadk.coreExtra.data.c adAdSense;
        if (kVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.BX()) {
            q auQ = kVar == null ? null : kVar.auQ();
            List<com.baidu.adp.widget.ListView.h> datas = auQ != null ? auQ.getDatas() : null;
            List<com.baidu.adp.widget.ListView.h> singletonList = bcVar != null ? Collections.singletonList(bcVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.h hVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.h hVar2 : singletonList) {
                            if (hVar == hVar2 && (hVar2 instanceof bc)) {
                                a.b bVar = new a.b();
                                bVar.aWo = ((bc) hVar2).getTid();
                                bVar.czg = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.h hVar3 : singletonList) {
                        if (hVar3 instanceof bc) {
                            bc bcVar2 = (bc) hVar3;
                            i3++;
                            if (bcVar2.ajd == 1 && !TextUtils.isEmpty(bcVar2.getTid())) {
                                bcVar2.ajd = 2;
                                a.b bVar2 = new a.b();
                                bVar2.aWo = bcVar2.getTid();
                                bVar2.czg = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, lVar.baT().getFirst_class(), lVar.baT().getSecond_class(), str, arrayList, adAdSense.Ca());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.aoF() - j, frsModelController.aoD(), frsModelController.aoE(), currentTimeMillis - frsModelController.aoC());
        }
    }

    public static void a(FrsFragment frsFragment, l lVar, bc bcVar) {
        if (bcVar != null && lVar != null) {
            FrsModelController atD = frsFragment.atD();
            k atI = frsFragment.atI();
            if (atI != null && atD != null) {
                if (bcVar.vw() != null && bcVar.vw().getGodInfo() != null) {
                    TiebaStatic.log(new an("c10806").r("obj_locate", 3).ah("tid", bcVar.getId()));
                }
                if (lVar != null && lVar.baT() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.dBR = lVar.gKm == 1;
                    aVar.dBT = lVar.baT().getId();
                    aVar.dBS = atD.azf();
                    if (com.baidu.tieba.frs.e.c.drl != null) {
                        aVar.dBU = com.baidu.tieba.frs.e.c.drl.dBU;
                        aVar.dBV = com.baidu.tieba.frs.e.c.drl.dBV;
                    }
                    com.baidu.tieba.frs.e.b.azw().a(aVar, bcVar, 1);
                }
                a(atI, lVar, frsFragment.getForumId(), true, bcVar);
            }
        }
    }

    public static void a(bb bbVar) {
        if (bbVar != null) {
            String tX = bbVar.tX();
            if (StringUtils.isNull(tX)) {
                tX = bbVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bbVar.getForumId(), bbVar.getForumName(), bbVar.getThreadId(), "tieba.baidu.com/p/" + bbVar.getThreadId(), tX);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dBT)) {
            an anVar = new an("c11942");
            anVar.ah(ImageViewerConfig.FORUM_ID, aVar.dBT);
            anVar.ah("obj_name", str);
            TiebaStatic.log(anVar);
        }
    }

    public static void aL(int i, int i2) {
        TiebaStatic.log(new an("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
