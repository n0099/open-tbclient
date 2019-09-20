package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
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
    public static void a(k kVar, FrsViewData frsViewData, String str, boolean z, bh bhVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (kVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.amp()) {
            aa bnZ = kVar == null ? null : kVar.bnZ();
            List<m> datas = bnZ != null ? bnZ.getDatas() : null;
            List<m> singletonList = bhVar != null ? Collections.singletonList(bhVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (m mVar : datas) {
                        int i2 = i + 1;
                        for (m mVar2 : singletonList) {
                            if (mVar == mVar2 && (mVar2 instanceof bh)) {
                                a.b bVar = new a.b();
                                bVar.bXN = ((bh) mVar2).getTid();
                                bVar.eHh = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (m mVar3 : singletonList) {
                        if (mVar3 instanceof bh) {
                            bh bhVar2 = (bh) mVar3;
                            i3++;
                            if (bhVar2.bLe == 1 && !TextUtils.isEmpty(bhVar2.getTid())) {
                                bhVar2.bLe = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bXN = bhVar2.getTid();
                                bVar2.eHh = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.ams());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.bgV() - j, frsModelController.bgT(), frsModelController.bgU(), currentTimeMillis - frsModelController.bgS());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bh bhVar) {
        if (bhVar != null && frsViewData != null) {
            FrsModelController bmE = frsFragment.bmE();
            k bmJ = frsFragment.bmJ();
            if (bmJ != null && bmE != null) {
                if (bhVar.aeC() != null && bhVar.aeC().getGodInfo() != null) {
                    TiebaStatic.log(new an("c10806").P("obj_locate", 3).bT("tid", bhVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.fRi = frsViewData.needLog == 1;
                    bVar.fRk = frsViewData.getForum().getId();
                    bVar.fRj = bmE.bsl();
                    if (com.baidu.tieba.frs.d.d.fEI != null) {
                        bVar.fRl = com.baidu.tieba.frs.d.d.fEI.fRl;
                        bVar.fRm = com.baidu.tieba.frs.d.d.fEI.fRm;
                    }
                    com.baidu.tieba.frs.d.c.bsF().a(bVar, bhVar, 1);
                    com.baidu.tieba.frs.d.a.a(bhVar, 1, frsFragment.getUniqueId(), bVar);
                }
                a(bmJ, frsViewData, frsFragment.getForumId(), true, bhVar);
            }
        }
    }

    public static void a(bf bfVar) {
        if (bfVar != null) {
            String adZ = bfVar.adZ();
            if (StringUtils.isNull(adZ)) {
                adZ = bfVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bfVar.getForumId(), bfVar.getForumName(), bfVar.getThreadId(), "tieba.baidu.com/p/" + bfVar.getThreadId(), adZ);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.fRk)) {
            an anVar = new an("c11942");
            anVar.bT("fid", bVar.fRk);
            anVar.bT("obj_name", str);
            TiebaStatic.log(anVar);
        }
    }

    public static void bF(int i, int i2) {
        TiebaStatic.log(new an("c10320").P("obj_locate", i).P("obj_type", i2));
    }
}
