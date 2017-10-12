package com.baidu.tieba.frs.g;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.frs.entelechy.a.r;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    public static void a(com.baidu.tieba.frs.i iVar, com.baidu.tieba.tbadkCore.i iVar2, String str, boolean z, bh bhVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (iVar != null && iVar2 != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.xx()) {
            r ahK = iVar == null ? null : iVar.ahK();
            List<com.baidu.adp.widget.ListView.f> datas = ahK != null ? ahK.getDatas() : null;
            List<com.baidu.adp.widget.ListView.f> singletonList = bhVar != null ? Collections.singletonList(bhVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.f fVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.f fVar2 : singletonList) {
                            if (fVar == fVar2 && (fVar2 instanceof bh)) {
                                a.b bVar = new a.b();
                                bVar.cyX = ((bh) fVar2).getTid();
                                bVar.bNk = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.f fVar3 : singletonList) {
                        if (fVar3 instanceof bh) {
                            bh bhVar2 = (bh) fVar3;
                            i3++;
                            if (bhVar2.YY == 1 && !TextUtils.isEmpty(bhVar2.getTid())) {
                                bhVar2.YY = 2;
                                a.b bVar2 = new a.b();
                                bVar2.cyX = bhVar2.getTid();
                                bVar2.bNk = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, iVar2.aMZ().getFirst_class(), iVar2.aMZ().getSecond_class(), str, arrayList, adAdSense.xA());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.adh() - j, frsModelController.adf(), frsModelController.adg(), currentTimeMillis - frsModelController.ade());
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.i iVar, bh bhVar) {
        if (bhVar != null && iVar != null) {
            FrsModelController agP = fVar.agP();
            com.baidu.tieba.frs.i agU = fVar.agU();
            if (agU != null && agP != null) {
                if (bhVar.getAuthor() != null && bhVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ad("tid", bhVar.getId()));
                }
                if (iVar != null && iVar.aMZ() != null) {
                    com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
                    aVar.cFS = iVar.gek == 1;
                    aVar.cFU = iVar.aMZ().getId();
                    aVar.cFT = agP.ald();
                    com.baidu.tieba.frs.f.b.aly().a(aVar, bhVar, 1);
                }
                a(agU, iVar, fVar.getForumId(), true, bhVar);
            }
        }
    }

    public static void a(bf bfVar) {
        if (bfVar != null) {
            String pD = bfVar.pD();
            if (StringUtils.isNull(pD)) {
                pD = bfVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bfVar.getForumId(), bfVar.getForumName(), bfVar.getThreadId(), "tieba.baidu.com/p/" + bfVar.getThreadId(), pD);
        }
    }

    public static void a(com.baidu.tieba.frs.f.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.cFU)) {
            ak akVar = new ak("c11942");
            akVar.ad("fid", aVar.cFU);
            akVar.ad("obj_name", str);
            TiebaStatic.log(akVar);
        }
    }

    public static void aK(int i, int i2) {
        TiebaStatic.log(new ak("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
