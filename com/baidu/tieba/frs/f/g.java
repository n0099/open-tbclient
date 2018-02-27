package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.frs.entelechy.a.s;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    public static void a(k kVar, l lVar, String str, boolean z, bd bdVar) {
        com.baidu.tbadk.coreExtra.data.c adAdSense;
        if (kVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.Ft()) {
            s avV = kVar == null ? null : kVar.avV();
            List<com.baidu.adp.widget.ListView.i> datas = avV != null ? avV.getDatas() : null;
            List<com.baidu.adp.widget.ListView.i> singletonList = bdVar != null ? Collections.singletonList(bdVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.i iVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.i iVar2 : singletonList) {
                            if (iVar == iVar2 && (iVar2 instanceof bd)) {
                                a.b bVar = new a.b();
                                bVar.bCS = ((bd) iVar2).getTid();
                                bVar.cZC = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.i iVar3 : singletonList) {
                        if (iVar3 instanceof bd) {
                            bd bdVar2 = (bd) iVar3;
                            i3++;
                            if (bdVar2.aPd == 1 && !TextUtils.isEmpty(bdVar2.getTid())) {
                                bdVar2.aPd = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bCS = bdVar2.getTid();
                                bVar2.cZC = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    com.baidu.tieba.recapp.s.sendFRS(z, lVar.bar().getFirst_class(), lVar.bar().getSecond_class(), str, arrayList, adAdSense.Fw());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.aqQ() - j, frsModelController.aqO(), frsModelController.aqP(), currentTimeMillis - frsModelController.aqN());
        }
    }

    public static void a(com.baidu.tieba.frs.i iVar, l lVar, bd bdVar) {
        if (bdVar != null && lVar != null) {
            FrsModelController auN = iVar.auN();
            k auS = iVar.auS();
            if (auS != null && auN != null) {
                if (bdVar.zn() != null && bdVar.zn().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", bdVar.getId()));
                }
                if (lVar != null && lVar.bar() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.dTS = lVar.gYa == 1;
                    aVar.dTU = lVar.bar().getId();
                    aVar.dTT = auN.azw();
                    if (com.baidu.tieba.frs.e.c.dUe != null) {
                        aVar.dTV = com.baidu.tieba.frs.e.c.dUe.dTV;
                        aVar.dTW = com.baidu.tieba.frs.e.c.dUe.dTW;
                    }
                    com.baidu.tieba.frs.e.b.azQ().a(aVar, bdVar, 1);
                }
                a(auS, lVar, iVar.getForumId(), true, bdVar);
            }
        }
    }

    public static void a(bb bbVar) {
        if (bbVar != null) {
            String xP = bbVar.xP();
            if (StringUtils.isNull(xP)) {
                xP = bbVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bbVar.getForumId(), bbVar.getForumName(), bbVar.getThreadId(), "tieba.baidu.com/p/" + bbVar.getThreadId(), xP);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dTU)) {
            ak akVar = new ak("c11942");
            akVar.ab(ImageViewerConfig.FORUM_ID, aVar.dTU);
            akVar.ab("obj_name", str);
            TiebaStatic.log(akVar);
        }
    }

    public static void bI(int i, int i2) {
        TiebaStatic.log(new ak("c10320").s("obj_locate", i).s("obj_type", i2));
    }
}
