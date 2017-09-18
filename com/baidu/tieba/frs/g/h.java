package com.baidu.tieba.frs.g;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    public static void a(com.baidu.tieba.frs.i iVar, com.baidu.tieba.tbadkCore.i iVar2, String str, boolean z, bj bjVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (iVar != null && iVar2 != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.xY()) {
            q ahR = iVar == null ? null : iVar.ahR();
            List<com.baidu.adp.widget.ListView.f> datas = ahR != null ? ahR.getDatas() : null;
            List<com.baidu.adp.widget.ListView.f> singletonList = bjVar != null ? Collections.singletonList(bjVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.f fVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.f fVar2 : singletonList) {
                            if (fVar == fVar2 && (fVar2 instanceof bj)) {
                                a.b bVar = new a.b();
                                bVar.bHy = ((bj) fVar2).getTid();
                                bVar.bNG = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.f fVar3 : singletonList) {
                        if (fVar3 instanceof bj) {
                            bj bjVar2 = (bj) fVar3;
                            i3++;
                            if (bjVar2.YY == 1 && !TextUtils.isEmpty(bjVar2.getTid())) {
                                bjVar2.YY = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bHy = bjVar2.getTid();
                                bVar2.bNG = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, iVar2.aPg().getFirst_class(), iVar2.aPg().getSecond_class(), str, arrayList, adAdSense.yb());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.adu() - j, frsModelController.ads(), frsModelController.adt(), currentTimeMillis - frsModelController.adr());
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.i iVar, bj bjVar) {
        if (bjVar != null && iVar != null) {
            FrsModelController agT = fVar.agT();
            com.baidu.tieba.frs.i agY = fVar.agY();
            if (agY != null && agT != null) {
                if (bjVar.getAuthor() != null && bjVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ad("tid", bjVar.getId()));
                }
                if (iVar != null && iVar.aPg() != null) {
                    com.baidu.tieba.frs.f.a aVar = new com.baidu.tieba.frs.f.a();
                    aVar.cEZ = iVar.ggE == 1;
                    aVar.cFb = iVar.aPg().getId();
                    aVar.cFa = agT.akZ();
                    com.baidu.tieba.frs.f.b.alu().a(aVar, bjVar, 1);
                }
                a(agY, iVar, fVar.getForumId(), true, bjVar);
            }
        }
    }

    public static void a(bh bhVar) {
        if (bhVar != null) {
            String pC = bhVar.pC();
            if (StringUtils.isNull(pC)) {
                pC = bhVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bhVar.getForumId(), bhVar.getForumName(), bhVar.getThreadId(), "tieba.baidu.com/p/" + bhVar.getThreadId(), pC);
        }
    }

    public static void a(com.baidu.tieba.frs.f.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.cFb)) {
            ak akVar = new ak("c11942");
            akVar.ad("fid", aVar.cFb);
            akVar.ad("obj_name", str);
            TiebaStatic.log(akVar);
        }
    }

    public static void aF(int i, int i2) {
        TiebaStatic.log(new ak("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
