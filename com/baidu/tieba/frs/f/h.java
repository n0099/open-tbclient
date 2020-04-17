package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.ai;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class h {
    public static void a(n nVar, FrsViewData frsViewData, String str, boolean z, bj bjVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (nVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.aRF()) {
            ai bPR = nVar == null ? null : nVar.bPR();
            List<m> datas = bPR != null ? bPR.getDatas() : null;
            List<m> singletonList = bjVar != null ? Collections.singletonList(bjVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (m mVar : datas) {
                        int i2 = i + 1;
                        for (m mVar2 : singletonList) {
                            if (mVar == mVar2 && (mVar2 instanceof bj)) {
                                a.b bVar = new a.b();
                                bVar.ahL = ((bj) mVar2).getTid();
                                bVar.grV = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (m mVar3 : singletonList) {
                        if (mVar3 instanceof bj) {
                            bj bjVar2 = (bj) mVar3;
                            i3++;
                            if (bjVar2.dsh == 1 && !TextUtils.isEmpty(bjVar2.getTid())) {
                                bjVar2.dsh = 2;
                                a.b bVar2 = new a.b();
                                bVar2.ahL = bjVar2.getTid();
                                bVar2.grV = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    r.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.aRI());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.bIY() - j, frsModelController.bIW(), frsModelController.bIX(), currentTimeMillis - frsModelController.bIV());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bj bjVar) {
        if (bjVar != null && frsViewData != null) {
            FrsModelController bOs = frsFragment.bOs();
            n bOx = frsFragment.bOx();
            if (bOx != null && bOs != null) {
                if (bjVar.aKE() != null && bjVar.aKE().getGodInfo() != null) {
                    TiebaStatic.log(new an("c10806").af("obj_locate", 3).cI("tid", bjVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.htU = frsViewData.needLog == 1;
                    bVar.htW = frsViewData.getForum().getId();
                    bVar.htV = bOs.bUa();
                    if (com.baidu.tieba.frs.d.d.hgG != null) {
                        bVar.htX = com.baidu.tieba.frs.d.d.hgG.htX;
                        bVar.htY = com.baidu.tieba.frs.d.d.hgG.htY;
                    }
                    com.baidu.tieba.frs.d.c.bUu().a(bVar, bjVar, 1);
                    com.baidu.tieba.frs.d.a.a(bjVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(bOx, frsViewData, frsFragment.getForumId(), true, bjVar);
            }
        }
    }

    public static void a(bh bhVar) {
        if (bhVar != null) {
            String aKb = bhVar.aKb();
            if (StringUtils.isNull(aKb)) {
                aKb = bhVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bhVar.getForumId(), bhVar.getForumName(), bhVar.getThreadId(), "tieba.baidu.com/p/" + bhVar.getThreadId(), aKb);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.htW)) {
            an anVar = new an("c11942");
            anVar.cI("fid", bVar.htW);
            anVar.cI("obj_name", str);
            TiebaStatic.log(anVar);
        }
    }

    public static void bY(int i, int i2) {
        TiebaStatic.log(new an("c10320").af("obj_locate", i).af("obj_type", i2));
    }
}
