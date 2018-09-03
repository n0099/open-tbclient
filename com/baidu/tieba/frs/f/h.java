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
        if (kVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.BM()) {
            q avt = kVar == null ? null : kVar.avt();
            List<com.baidu.adp.widget.ListView.h> datas = avt != null ? avt.getDatas() : null;
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
                                bVar.cBI = i2;
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
                                bVar2.cBI = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, lVar.aZg().getFirst_class(), lVar.aZg().getSecond_class(), str, arrayList, adAdSense.BP());
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
            FrsModelController aug = frsFragment.aug();
            k aul = frsFragment.aul();
            if (aul != null && aug != null) {
                if (bbVar.vj() != null && bbVar.vj().getGodInfo() != null) {
                    TiebaStatic.log(new an("c10806").r("obj_locate", 3).ae("tid", bbVar.getId()));
                }
                if (lVar != null && lVar.aZg() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.dEA = lVar.gLl == 1;
                    aVar.dEC = lVar.aZg().getId();
                    aVar.dEB = aug.azI();
                    if (com.baidu.tieba.frs.e.c.dtV != null) {
                        aVar.dED = com.baidu.tieba.frs.e.c.dtV.dED;
                        aVar.dEE = com.baidu.tieba.frs.e.c.dtV.dEE;
                    }
                    com.baidu.tieba.frs.e.b.aAa().a(aVar, bbVar, 1);
                }
                a(aul, lVar, frsFragment.getForumId(), true, bbVar);
            }
        }
    }

    public static void a(ba baVar) {
        if (baVar != null) {
            String tI = baVar.tI();
            if (StringUtils.isNull(tI)) {
                tI = baVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", baVar.getForumId(), baVar.getForumName(), baVar.getThreadId(), "tieba.baidu.com/p/" + baVar.getThreadId(), tI);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dEC)) {
            an anVar = new an("c11942");
            anVar.ae(ImageViewerConfig.FORUM_ID, aVar.dEC);
            anVar.ae("obj_name", str);
            TiebaStatic.log(anVar);
        }
    }

    public static void aO(int i, int i2) {
        TiebaStatic.log(new an("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
