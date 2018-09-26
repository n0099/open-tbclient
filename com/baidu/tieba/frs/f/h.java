package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
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
    public static void a(k kVar, l lVar, String str, boolean z, bb bbVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (kVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.Da()) {
            q axm = kVar == null ? null : kVar.axm();
            List<com.baidu.adp.widget.ListView.h> datas = axm != null ? axm.getDatas() : null;
            List<com.baidu.adp.widget.ListView.h> singletonList = bbVar != null ? Collections.singletonList(bbVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.h hVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.h hVar2 : singletonList) {
                            if (hVar == hVar2 && (hVar2 instanceof bb)) {
                                a.b bVar = new a.b();
                                bVar.aZG = ((bb) hVar2).getTid();
                                bVar.cHA = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.h hVar3 : singletonList) {
                        if (hVar3 instanceof bb) {
                            bb bbVar2 = (bb) hVar3;
                            i3++;
                            if (bbVar2.alb == 1 && !TextUtils.isEmpty(bbVar2.getTid())) {
                                bbVar2.alb = 2;
                                a.b bVar2 = new a.b();
                                bVar2.aZG = bbVar2.getTid();
                                bVar2.cHA = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, lVar.bbH().getFirst_class(), lVar.bbH().getSecond_class(), str, arrayList, adAdSense.Dd());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.aqU() - j, frsModelController.aqS(), frsModelController.aqT(), currentTimeMillis - frsModelController.aqR());
        }
    }

    public static void a(FrsFragment frsFragment, l lVar, bb bbVar) {
        if (bbVar != null && lVar != null) {
            FrsModelController avZ = frsFragment.avZ();
            k awe = frsFragment.awe();
            if (awe != null && avZ != null) {
                if (bbVar.wm() != null && bbVar.wm().getGodInfo() != null) {
                    TiebaStatic.log(new am("c10806").w("obj_locate", 3).al("tid", bbVar.getId()));
                }
                if (lVar != null && lVar.bbH() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.dLH = lVar.gSN == 1;
                    aVar.dLJ = lVar.bbH().getId();
                    aVar.dLI = avZ.aBR();
                    if (com.baidu.tieba.frs.e.c.dAB != null) {
                        aVar.dLK = com.baidu.tieba.frs.e.c.dAB.dLK;
                        aVar.dLL = com.baidu.tieba.frs.e.c.dAB.dLL;
                    }
                    com.baidu.tieba.frs.e.b.aCj().a(aVar, bbVar, 1);
                }
                a(awe, lVar, frsFragment.getForumId(), true, bbVar);
            }
        }
    }

    public static void a(ba baVar) {
        if (baVar != null) {
            String uL = baVar.uL();
            if (StringUtils.isNull(uL)) {
                uL = baVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", baVar.getForumId(), baVar.getForumName(), baVar.getThreadId(), "tieba.baidu.com/p/" + baVar.getThreadId(), uL);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dLJ)) {
            am amVar = new am("c11942");
            amVar.al(ImageViewerConfig.FORUM_ID, aVar.dLJ);
            amVar.al("obj_name", str);
            TiebaStatic.log(amVar);
        }
    }

    public static void aS(int i, int i2) {
        TiebaStatic.log(new am("c10320").w("obj_locate", i).w("obj_type", i2));
    }
}
