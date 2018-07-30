package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ba;
import com.baidu.tbadk.core.data.bb;
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
    public static void a(k kVar, l lVar, String str, boolean z, bb bbVar) {
        com.baidu.tbadk.coreExtra.data.c adAdSense;
        if (kVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.BP()) {
            q avu = kVar == null ? null : kVar.avu();
            List<com.baidu.adp.widget.ListView.h> datas = avu != null ? avu.getDatas() : null;
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
                                bVar.aWq = ((bb) hVar2).getTid();
                                bVar.cBL = i2;
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
                            if (bbVar2.aiA == 1 && !TextUtils.isEmpty(bbVar2.getTid())) {
                                bbVar2.aiA = 2;
                                a.b bVar2 = new a.b();
                                bVar2.aWq = bbVar2.getTid();
                                bVar2.cBL = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, lVar.aZl().getFirst_class(), lVar.aZl().getSecond_class(), str, arrayList, adAdSense.BS());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.apf() - j, frsModelController.apd(), frsModelController.ape(), currentTimeMillis - frsModelController.apc());
        }
    }

    public static void a(FrsFragment frsFragment, l lVar, bb bbVar) {
        if (bbVar != null && lVar != null) {
            FrsModelController auh = frsFragment.auh();
            k aum = frsFragment.aum();
            if (aum != null && auh != null) {
                if (bbVar.vk() != null && bbVar.vk().getGodInfo() != null) {
                    TiebaStatic.log(new an("c10806").r("obj_locate", 3).af("tid", bbVar.getId()));
                }
                if (lVar != null && lVar.aZl() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.dED = lVar.gLj == 1;
                    aVar.dEF = lVar.aZl().getId();
                    aVar.dEE = auh.azL();
                    if (com.baidu.tieba.frs.e.c.dtY != null) {
                        aVar.dEG = com.baidu.tieba.frs.e.c.dtY.dEG;
                        aVar.dEH = com.baidu.tieba.frs.e.c.dtY.dEH;
                    }
                    com.baidu.tieba.frs.e.b.aAd().a(aVar, bbVar, 1);
                }
                a(aum, lVar, frsFragment.getForumId(), true, bbVar);
            }
        }
    }

    public static void a(ba baVar) {
        if (baVar != null) {
            String tJ = baVar.tJ();
            if (StringUtils.isNull(tJ)) {
                tJ = baVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", baVar.getForumId(), baVar.getForumName(), baVar.getThreadId(), "tieba.baidu.com/p/" + baVar.getThreadId(), tJ);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dEF)) {
            an anVar = new an("c11942");
            anVar.af(ImageViewerConfig.FORUM_ID, aVar.dEF);
            anVar.af("obj_name", str);
            TiebaStatic.log(anVar);
        }
    }

    public static void aO(int i, int i2) {
        TiebaStatic.log(new an("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
