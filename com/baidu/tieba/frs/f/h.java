package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.aa;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class h {
    public static void a(k kVar, FrsViewData frsViewData, String str, boolean z, bg bgVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (kVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.akW()) {
            aa blc = kVar == null ? null : kVar.blc();
            List<m> datas = blc != null ? blc.getDatas() : null;
            List<m> singletonList = bgVar != null ? Collections.singletonList(bgVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (m mVar : datas) {
                        int i2 = i + 1;
                        for (m mVar2 : singletonList) {
                            if (mVar == mVar2 && (mVar2 instanceof bg)) {
                                a.b bVar = new a.b();
                                bVar.bVM = ((bg) mVar2).getTid();
                                bVar.eAv = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (m mVar3 : singletonList) {
                        if (mVar3 instanceof bg) {
                            bg bgVar2 = (bg) mVar3;
                            i3++;
                            if (bgVar2.bJB == 1 && !TextUtils.isEmpty(bgVar2.getTid())) {
                                bgVar2.bJB = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bVM = bgVar2.getTid();
                                bVar2.eAv = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.akZ());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.bej() - j, frsModelController.beh(), frsModelController.bei(), currentTimeMillis - frsModelController.beg());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bg bgVar) {
        if (bgVar != null && frsViewData != null) {
            FrsModelController bjK = frsFragment.bjK();
            k bjP = frsFragment.bjP();
            if (bjP != null && bjK != null) {
                if (bgVar.adv() != null && bgVar.adv().getGodInfo() != null) {
                    TiebaStatic.log(new am("c10806").P("obj_locate", 3).bT("tid", bgVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.fJF = frsViewData.needLog == 1;
                    bVar.fJH = frsViewData.getForum().getId();
                    bVar.fJG = bjK.bpl();
                    if (com.baidu.tieba.frs.d.d.fxl != null) {
                        bVar.fJI = com.baidu.tieba.frs.d.d.fxl.fJI;
                        bVar.fJJ = com.baidu.tieba.frs.d.d.fxl.fJJ;
                    }
                    com.baidu.tieba.frs.d.c.bpE().a(bVar, bgVar, 1);
                    com.baidu.tieba.frs.d.a.a(bgVar, 1, frsFragment.getUniqueId(), bVar);
                }
                a(bjP, frsViewData, frsFragment.getForumId(), true, bgVar);
            }
        }
    }

    public static void a(be beVar) {
        if (beVar != null) {
            String acS = beVar.acS();
            if (StringUtils.isNull(acS)) {
                acS = beVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", beVar.getForumId(), beVar.getForumName(), beVar.getThreadId(), "tieba.baidu.com/p/" + beVar.getThreadId(), acS);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.fJH)) {
            am amVar = new am("c11942");
            amVar.bT("fid", bVar.fJH);
            amVar.bT("obj_name", str);
            TiebaStatic.log(amVar);
        }
    }

    public static void bA(int i, int i2) {
        TiebaStatic.log(new am("c10320").P("obj_locate", i).P("obj_type", i2));
    }
}
