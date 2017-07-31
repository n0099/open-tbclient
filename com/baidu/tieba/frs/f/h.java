package com.baidu.tieba.frs.f;

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
        if (iVar != null && iVar2 != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.xW()) {
            q afR = iVar == null ? null : iVar.afR();
            List<com.baidu.adp.widget.ListView.f> datas = afR != null ? afR.getDatas() : null;
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
                                bVar.bDd = ((bl) fVar2).getTid();
                                bVar.bJn = i2;
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
                            if (blVar2.ZS == 1 && !TextUtils.isEmpty(blVar2.getTid())) {
                                blVar2.ZS = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bDd = blVar2.getTid();
                                bVar2.bJn = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, iVar2.aPh().getFirst_class(), iVar2.aPh().getSecond_class(), str, arrayList, adAdSense.xZ());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.abS() - j, frsModelController.abQ(), frsModelController.abR(), currentTimeMillis - frsModelController.abP());
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.i iVar, bl blVar) {
        if (blVar != null && iVar != null) {
            FrsModelController aeU = fVar.aeU();
            com.baidu.tieba.frs.i aeZ = fVar.aeZ();
            if (aeZ != null && aeU != null) {
                if (blVar.getAuthor() != null && blVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new aj("c10806").r("obj_locate", 3).aa("tid", blVar.getId()));
                }
                if (iVar != null && iVar.aPh() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.cvB = iVar.gfq == 1;
                    aVar.cvD = iVar.aPh().getId();
                    aVar.cvC = aeU.aiE();
                    com.baidu.tieba.frs.e.b.aiY().a(aVar, blVar, 1);
                }
                a(aeZ, iVar, fVar.getForumId(), true, blVar);
            }
        }
    }

    public static void a(bj bjVar) {
        if (bjVar != null) {
            String pH = bjVar.pH();
            if (StringUtils.isNull(pH)) {
                pH = bjVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bjVar.getForumId(), bjVar.getForumName(), bjVar.getThreadId(), "tieba.baidu.com/p/" + bjVar.getThreadId(), pH);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.cvD)) {
            aj ajVar = new aj("c11942");
            ajVar.aa("fid", aVar.cvD);
            ajVar.aa("obj_name", str);
            TiebaStatic.log(ajVar);
        }
    }

    public static void au(int i, int i2) {
        TiebaStatic.log(new aj("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
