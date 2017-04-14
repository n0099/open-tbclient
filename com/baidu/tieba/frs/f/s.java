package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.az;
import com.baidu.tieba.frs.entelechy.a.am;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    public static void a(az azVar, com.baidu.tieba.tbadkCore.n nVar, String str, boolean z, bi biVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (azVar != null && nVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense()) != null && adAdSense.ye()) {
            am aae = azVar == null ? null : azVar.aae();
            List<com.baidu.adp.widget.ListView.v> datas = aae != null ? aae.getDatas() : null;
            List<com.baidu.adp.widget.ListView.v> singletonList = biVar != null ? Collections.singletonList(biVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.v vVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.v vVar2 : singletonList) {
                            if (vVar == vVar2 && (vVar2 instanceof bi)) {
                                a.b bVar = new a.b();
                                bVar.bqu = ((bi) vVar2).getTid();
                                bVar.buM = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.v vVar3 : singletonList) {
                        if (vVar3 instanceof bi) {
                            bi biVar2 = (bi) vVar3;
                            i3++;
                            if (biVar2.YP == 1 && !TextUtils.isEmpty(biVar2.getTid())) {
                                biVar2.YP = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bqu = biVar2.getTid();
                                bVar2.buM = i3;
                                arrayList.add(bVar2);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    com.baidu.tieba.recapp.y.sendFRS(z, nVar.aJw().getFirst_class(), nVar.aJw().getSecond_class(), str, arrayList, adAdSense.yi());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.Wj() - j, frsModelController.Wh(), frsModelController.Wi(), currentTimeMillis - frsModelController.Wg());
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.n nVar, bi biVar) {
        if (biVar != null && nVar != null) {
            FrsModelController YT = frsActivity.YT();
            az Za = frsActivity.Za();
            if (Za != null && YT != null) {
                if (biVar.getAuthor() != null && biVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new as("c10806").s("obj_locate", 3).aa("tid", biVar.getId()));
                }
                if (nVar != null && nVar.aJw() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.bYM = nVar.ftt == 1;
                    aVar.bYO = nVar.aJw().getId();
                    aVar.bYN = YT.acR();
                    com.baidu.tieba.frs.e.b.adp().a(aVar, biVar, 1);
                }
                a(Za, nVar, frsActivity.getForumId(), true, biVar);
            }
        }
    }

    public static void a(bg bgVar) {
        if (bgVar != null) {
            String qb = bgVar.qb();
            if (StringUtils.isNull(qb)) {
                qb = bgVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bgVar.getForumId(), bgVar.getForumName(), bgVar.getThreadId(), "tieba.baidu.com/p/" + bgVar.getThreadId(), qb);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.bYO)) {
            as asVar = new as("c11942");
            asVar.aa("fid", aVar.bYO);
            asVar.aa("obj_name", str);
            TiebaStatic.log(asVar);
        }
    }

    public static void an(int i, int i2) {
        TiebaStatic.log(new as("c10320").s("obj_locate", i).s("obj_type", i2));
    }
}
