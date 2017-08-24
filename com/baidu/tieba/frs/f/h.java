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
            q agi = iVar == null ? null : iVar.agi();
            List<com.baidu.adp.widget.ListView.f> datas = agi != null ? agi.getDatas() : null;
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
                                bVar.bDN = ((bl) fVar2).getTid();
                                bVar.bJX = i2;
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
                            if (blVar2.ZU == 1 && !TextUtils.isEmpty(blVar2.getTid())) {
                                blVar2.ZU = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bDN = blVar2.getTid();
                                bVar2.bJX = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, iVar2.aPJ().getFirst_class(), iVar2.aPJ().getSecond_class(), str, arrayList, adAdSense.xZ());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.acj() - j, frsModelController.ach(), frsModelController.aci(), currentTimeMillis - frsModelController.acg());
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.i iVar, bl blVar) {
        if (blVar != null && iVar != null) {
            FrsModelController afk = fVar.afk();
            com.baidu.tieba.frs.i afp = fVar.afp();
            if (afp != null && afk != null) {
                if (blVar.getAuthor() != null && blVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new aj("c10806").r("obj_locate", 3).aa("tid", blVar.getId()));
                }
                if (iVar != null && iVar.aPJ() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.cxE = iVar.ghi == 1;
                    aVar.cxG = iVar.aPJ().getId();
                    aVar.cxF = afk.ajf();
                    com.baidu.tieba.frs.e.b.ajz().a(aVar, blVar, 1);
                }
                a(afp, iVar, fVar.getForumId(), true, blVar);
            }
        }
    }

    public static void a(bj bjVar) {
        if (bjVar != null) {
            String pI = bjVar.pI();
            if (StringUtils.isNull(pI)) {
                pI = bjVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bjVar.getForumId(), bjVar.getForumName(), bjVar.getThreadId(), "tieba.baidu.com/p/" + bjVar.getThreadId(), pI);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.cxG)) {
            aj ajVar = new aj("c11942");
            ajVar.aa("fid", aVar.cxG);
            ajVar.aa("obj_name", str);
            TiebaStatic.log(ajVar);
        }
    }

    public static void aC(int i, int i2) {
        TiebaStatic.log(new aj("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
