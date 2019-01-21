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
        if (kVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.GH()) {
            q aDb = kVar == null ? null : kVar.aDb();
            List<com.baidu.adp.widget.ListView.h> datas = aDb != null ? aDb.getDatas() : null;
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
                                bVar.bjn = ((bb) hVar2).getTid();
                                bVar.dbl = i2;
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
                            if (bbVar2.auN == 1 && !TextUtils.isEmpty(bbVar2.getTid())) {
                                bbVar2.auN = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bjn = bbVar2.getTid();
                                bVar2.dbl = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, lVar.bhx().getFirst_class(), lVar.bhx().getSecond_class(), str, arrayList, adAdSense.GK());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.awM() - j, frsModelController.awK(), frsModelController.awL(), currentTimeMillis - frsModelController.awJ());
        }
    }

    public static void a(FrsFragment frsFragment, l lVar, bb bbVar) {
        if (bbVar != null && lVar != null) {
            FrsModelController aBP = frsFragment.aBP();
            k aBU = frsFragment.aBU();
            if (aBU != null && aBP != null) {
                if (bbVar.zT() != null && bbVar.zT().getGodInfo() != null) {
                    TiebaStatic.log(new am("c10806").y("obj_locate", 3).aB("tid", bbVar.getId()));
                }
                if (lVar != null && lVar.bhx() != null) {
                    com.baidu.tieba.frs.e.b bVar = new com.baidu.tieba.frs.e.b();
                    bVar.eeK = lVar.hmQ == 1;
                    bVar.eeM = lVar.bhx().getId();
                    bVar.eeL = aBP.aHE();
                    if (com.baidu.tieba.frs.e.d.dTG != null) {
                        bVar.eeN = com.baidu.tieba.frs.e.d.dTG.eeN;
                        bVar.eeO = com.baidu.tieba.frs.e.d.dTG.eeO;
                    }
                    com.baidu.tieba.frs.e.c.aHW().a(bVar, bbVar, 1);
                }
                a(aBU, lVar, frsFragment.getForumId(), true, bbVar);
            }
        }
    }

    public static void a(ba baVar) {
        if (baVar != null) {
            String yt = baVar.yt();
            if (StringUtils.isNull(yt)) {
                yt = baVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", baVar.getForumId(), baVar.getForumName(), baVar.getThreadId(), "tieba.baidu.com/p/" + baVar.getThreadId(), yt);
        }
    }

    public static void a(com.baidu.tieba.frs.e.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.eeM)) {
            am amVar = new am("c11942");
            amVar.aB(ImageViewerConfig.FORUM_ID, bVar.eeM);
            amVar.aB("obj_name", str);
            TiebaStatic.log(amVar);
        }
    }

    public static void aY(int i, int i2) {
        TiebaStatic.log(new am("c10320").y("obj_locate", i).y("obj_type", i2));
    }
}
