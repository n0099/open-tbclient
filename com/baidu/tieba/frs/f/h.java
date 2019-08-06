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
        if (kVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.amd()) {
            aa bno = kVar == null ? null : kVar.bno();
            List<m> datas = bno != null ? bno.getDatas() : null;
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
                                bVar.bWU = ((bh) mVar2).getTid();
                                bVar.eFy = i2;
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
                            if (bhVar2.bKG == 1 && !TextUtils.isEmpty(bhVar2.getTid())) {
                                bhVar2.bKG = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bWU = bhVar2.getTid();
                                bVar2.eFy = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.amg());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.bgp() - j, frsModelController.bgn(), frsModelController.bgo(), currentTimeMillis - frsModelController.bgm());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bh bhVar) {
        if (bhVar != null && frsViewData != null) {
            FrsModelController blT = frsFragment.blT();
            k blY = frsFragment.blY();
            if (blY != null && blT != null) {
                if (bhVar.aey() != null && bhVar.aey().getGodInfo() != null) {
                    TiebaStatic.log(new an("c10806").P("obj_locate", 3).bT("tid", bhVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.fPr = frsViewData.needLog == 1;
                    bVar.fPt = frsViewData.getForum().getId();
                    bVar.fPs = blT.brz();
                    if (com.baidu.tieba.frs.d.d.fCV != null) {
                        bVar.fPu = com.baidu.tieba.frs.d.d.fCV.fPu;
                        bVar.fPv = com.baidu.tieba.frs.d.d.fCV.fPv;
                    }
                    com.baidu.tieba.frs.d.c.brS().a(bVar, bhVar, 1);
                    com.baidu.tieba.frs.d.a.a(bhVar, 1, frsFragment.getUniqueId(), bVar);
                }
                a(blY, frsViewData, frsFragment.getForumId(), true, bhVar);
            }
        }
    }

    public static void a(bf bfVar) {
        if (bfVar != null) {
            String adV = bfVar.adV();
            if (StringUtils.isNull(adV)) {
                adV = bfVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bfVar.getForumId(), bfVar.getForumName(), bfVar.getThreadId(), "tieba.baidu.com/p/" + bfVar.getThreadId(), adV);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.fPt)) {
            an anVar = new an("c11942");
            anVar.bT("fid", bVar.fPt);
            anVar.bT("obj_name", str);
            TiebaStatic.log(anVar);
        }
    }

    public static void bF(int i, int i2) {
        TiebaStatic.log(new an("c10320").P("obj_locate", i).P("obj_type", i2));
    }
}
