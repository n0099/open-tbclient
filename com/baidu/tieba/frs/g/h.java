package com.baidu.tieba.frs.g;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    public static void a(com.baidu.tieba.frs.i iVar, com.baidu.tieba.tbadkCore.i iVar2, String str, boolean z, bl blVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (iVar != null && iVar2 != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.xO()) {
            q afM = iVar == null ? null : iVar.afM();
            List<com.baidu.adp.widget.ListView.f> datas = afM != null ? afM.getDatas() : null;
            List<com.baidu.adp.widget.ListView.f> singletonList = blVar != null ? Collections.singletonList(blVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.f fVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.f fVar2 : singletonList) {
                            if (fVar == fVar2 && (fVar2 instanceof bl)) {
                                a.b bVar = new a.b();
                                bVar.bBT = ((bl) fVar2).getTid();
                                bVar.bId = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.f fVar3 : singletonList) {
                        if (fVar3 instanceof bl) {
                            bl blVar2 = (bl) fVar3;
                            i3++;
                            if (blVar2.Yw == 1 && !TextUtils.isEmpty(blVar2.getTid())) {
                                blVar2.Yw = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bBT = blVar2.getTid();
                                bVar2.bId = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, iVar2.aOW().getFirst_class(), iVar2.aOW().getSecond_class(), str, arrayList, adAdSense.xR());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.abN() - j, frsModelController.abL(), frsModelController.abM(), currentTimeMillis - frsModelController.abK());
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.i iVar, bl blVar) {
        if (blVar != null && iVar != null) {
            FrsModelController aeP = fVar.aeP();
            com.baidu.tieba.frs.i aeU = fVar.aeU();
            if (aeU != null && aeP != null) {
                if (blVar.getAuthor() != null && blVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new aj("c10806").r("obj_locate", 3).aa("tid", blVar.getId()));
                }
                if (iVar != null && iVar.aOW() != null) {
                    com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
                    aVar.cuj = iVar.gef == 1;
                    aVar.cul = iVar.aOW().getId();
                    aVar.cuk = aeP.ais();
                    com.baidu.tieba.frs.f.b.aiM().a(aVar, blVar, 1);
                }
                a(aeU, iVar, fVar.getForumId(), true, blVar);
            }
        }
    }

    public static void a(bj bjVar) {
        if (bjVar != null) {
            String px = bjVar.px();
            if (StringUtils.isNull(px)) {
                px = bjVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bjVar.getForumId(), bjVar.getForumName(), bjVar.getThreadId(), "tieba.baidu.com/p/" + bjVar.getThreadId(), px);
        }
    }

    public static void a(com.baidu.tieba.frs.f.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.cul)) {
            aj ajVar = new aj("c11942");
            ajVar.aa("fid", aVar.cul);
            ajVar.aa("obj_name", str);
            TiebaStatic.log(ajVar);
        }
    }

    public static void at(int i, int i2) {
        TiebaStatic.log(new aj("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
