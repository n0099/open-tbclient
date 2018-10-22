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
/* loaded from: classes6.dex */
public class h {
    public static void a(k kVar, l lVar, String str, boolean z, bb bbVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (kVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.Fe()) {
            q aAI = kVar == null ? null : kVar.aAI();
            List<com.baidu.adp.widget.ListView.h> datas = aAI != null ? aAI.getDatas() : null;
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
                                bVar.beh = ((bb) hVar2).getTid();
                                bVar.cPU = i2;
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
                            if (bbVar2.apX == 1 && !TextUtils.isEmpty(bbVar2.getTid())) {
                                bbVar2.apX = 2;
                                a.b bVar2 = new a.b();
                                bVar2.beh = bbVar2.getTid();
                                bVar2.cPU = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, lVar.beT().getFirst_class(), lVar.beT().getSecond_class(), str, arrayList, adAdSense.Fh());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.aur() - j, frsModelController.aup(), frsModelController.auq(), currentTimeMillis - frsModelController.auo());
        }
    }

    public static void a(FrsFragment frsFragment, l lVar, bb bbVar) {
        if (bbVar != null && lVar != null) {
            FrsModelController azw = frsFragment.azw();
            k azB = frsFragment.azB();
            if (azB != null && azw != null) {
                if (bbVar.yv() != null && bbVar.yv().getGodInfo() != null) {
                    TiebaStatic.log(new am("c10806").x("obj_locate", 3).ax("tid", bbVar.getId()));
                }
                if (lVar != null && lVar.beT() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.dTD = lVar.haj == 1;
                    aVar.dTF = lVar.beT().getId();
                    aVar.dTE = azw.aFk();
                    if (com.baidu.tieba.frs.e.c.dIB != null) {
                        aVar.dTG = com.baidu.tieba.frs.e.c.dIB.dTG;
                        aVar.dTH = com.baidu.tieba.frs.e.c.dIB.dTH;
                    }
                    com.baidu.tieba.frs.e.b.aFC().a(aVar, bbVar, 1);
                }
                a(azB, lVar, frsFragment.getForumId(), true, bbVar);
            }
        }
    }

    public static void a(ba baVar) {
        if (baVar != null) {
            String wU = baVar.wU();
            if (StringUtils.isNull(wU)) {
                wU = baVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", baVar.getForumId(), baVar.getForumName(), baVar.getThreadId(), "tieba.baidu.com/p/" + baVar.getThreadId(), wU);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dTF)) {
            am amVar = new am("c11942");
            amVar.ax(ImageViewerConfig.FORUM_ID, aVar.dTF);
            amVar.ax("obj_name", str);
            TiebaStatic.log(amVar);
        }
    }

    public static void aV(int i, int i2) {
        TiebaStatic.log(new am("c10320").x("obj_locate", i).x("obj_type", i2));
    }
}
