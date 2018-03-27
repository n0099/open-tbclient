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
import com.baidu.tieba.tbadkCore.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    public static void a(k kVar, m mVar, String str, boolean z, bd bdVar) {
        com.baidu.tbadk.coreExtra.data.c adAdSense;
        if (kVar != null && mVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.Fu()) {
            s avX = kVar == null ? null : kVar.avX();
            List<com.baidu.adp.widget.ListView.i> datas = avX != null ? avX.getDatas() : null;
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
                                bVar.bCV = ((bd) iVar2).getTid();
                                bVar.cZF = i2;
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
                            if (bdVar2.aPe == 1 && !TextUtils.isEmpty(bdVar2.getTid())) {
                                bdVar2.aPe = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bCV = bdVar2.getTid();
                                bVar2.cZF = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    com.baidu.tieba.recapp.s.sendFRS(z, mVar.bas().getFirst_class(), mVar.bas().getSecond_class(), str, arrayList, adAdSense.Fx());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.aqR() - j, frsModelController.aqP(), frsModelController.aqQ(), currentTimeMillis - frsModelController.aqO());
        }
    }

    public static void a(com.baidu.tieba.frs.i iVar, m mVar, bd bdVar) {
        if (bdVar != null && mVar != null) {
            FrsModelController auO = iVar.auO();
            k auT = iVar.auT();
            if (auT != null && auO != null) {
                if (bdVar.zn() != null && bdVar.zn().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", bdVar.getId()));
                }
                if (mVar != null && mVar.bas() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.dTX = mVar.gYv == 1;
                    aVar.dTZ = mVar.bas().getId();
                    aVar.dTY = auO.azy();
                    if (com.baidu.tieba.frs.e.c.dUj != null) {
                        aVar.dUa = com.baidu.tieba.frs.e.c.dUj.dUa;
                        aVar.dUb = com.baidu.tieba.frs.e.c.dUj.dUb;
                    }
                    com.baidu.tieba.frs.e.b.azS().a(aVar, bdVar, 1);
                }
                a(auT, mVar, iVar.getForumId(), true, bdVar);
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
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dTZ)) {
            ak akVar = new ak("c11942");
            akVar.ab(ImageViewerConfig.FORUM_ID, aVar.dTZ);
            akVar.ab("obj_name", str);
            TiebaStatic.log(akVar);
        }
    }

    public static void bI(int i, int i2) {
        TiebaStatic.log(new ak("c10320").s("obj_locate", i).s("obj_type", i2));
    }
}
