package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.am;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes22.dex */
public class k {
    public static void a(q qVar, FrsViewData frsViewData, String str, boolean z, by byVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (qVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.bxf()) {
            am cDE = qVar == null ? null : qVar.cDE();
            List<com.baidu.adp.widget.ListView.q> datas = cDE != null ? cDE.getDatas() : null;
            List<com.baidu.adp.widget.ListView.q> singletonList = byVar != null ? Collections.singletonList(byVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.q qVar2 : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.q qVar3 : singletonList) {
                            if (qVar2 == qVar3 && (qVar3 instanceof by)) {
                                a.b bVar = new a.b();
                                bVar.amY = ((by) qVar3).getTid();
                                bVar.imE = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.q qVar4 : singletonList) {
                        if (qVar4 instanceof by) {
                            by byVar2 = (by) qVar4;
                            i3++;
                            if (byVar2.eKB == 1 && !TextUtils.isEmpty(byVar2.getTid())) {
                                byVar2.eKB = 2;
                                a.b bVar2 = new a.b();
                                bVar2.amY = byVar2.getTid();
                                bVar2.imE = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.bxi());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.cwo() - j, frsModelController.cwm(), frsModelController.cwn(), currentTimeMillis - frsModelController.cwl());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, by byVar) {
        if (byVar != null && frsViewData != null) {
            FrsModelController cBZ = frsFragment.cBZ();
            q cCe = frsFragment.cCe();
            if (cCe != null && cBZ != null) {
                if (byVar.boP() != null && byVar.boP().getGodInfo() != null) {
                    TiebaStatic.log(new ar("c10806").al("obj_locate", 3).dY("tid", byVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.jtP = frsViewData.needLog == 1;
                    bVar.jtR = frsViewData.getForum().getId();
                    bVar.jtQ = cBZ.cJi();
                    if (com.baidu.tieba.frs.d.d.jcS != null) {
                        bVar.jtS = com.baidu.tieba.frs.d.d.jcS.jtS;
                        bVar.jtT = com.baidu.tieba.frs.d.d.jcS.jtT;
                    }
                    com.baidu.tieba.frs.d.c.cJH().a(bVar, byVar, 1);
                    com.baidu.tieba.frs.d.a.a(byVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(cCe, frsViewData, frsFragment.getForumId(), true, byVar);
            }
        }
    }

    public static void a(bw bwVar) {
        if (bwVar != null) {
            String bol = bwVar.bol();
            if (StringUtils.isNull(bol)) {
                bol = bwVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", bwVar.getForumId(), bwVar.getForumName(), bwVar.getThreadId(), "tieba.baidu.com/p/" + bwVar.getThreadId(), bol);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.jtR)) {
            ar arVar = new ar("c11942");
            arVar.dY("fid", bVar.jtR);
            arVar.dY("obj_name", str);
            TiebaStatic.log(arVar);
        }
    }

    public static void cG(int i, int i2) {
        TiebaStatic.log(new ar("c10320").al("obj_locate", i).al("obj_type", i2));
    }
}
