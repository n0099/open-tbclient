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
        if (nVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.aRC()) {
            ai bPQ = nVar == null ? null : nVar.bPQ();
            List<m> datas = bPQ != null ? bPQ.getDatas() : null;
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
                                bVar.ahO = ((bj) mVar2).getTid();
                                bVar.gsb = i2;
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
                            if (bjVar2.dsl == 1 && !TextUtils.isEmpty(bjVar2.getTid())) {
                                bjVar2.dsl = 2;
                                a.b bVar2 = new a.b();
                                bVar2.ahO = bjVar2.getTid();
                                bVar2.gsb = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    r.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.aRF());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.bIX() - j, frsModelController.bIV(), frsModelController.bIW(), currentTimeMillis - frsModelController.bIU());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bj bjVar) {
        if (bjVar != null && frsViewData != null) {
            FrsModelController bOr = frsFragment.bOr();
            n bOw = frsFragment.bOw();
            if (bOw != null && bOr != null) {
                if (bjVar.aKC() != null && bjVar.aKC().getGodInfo() != null) {
                    TiebaStatic.log(new an("c10806").af("obj_locate", 3).cI("tid", bjVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.hua = frsViewData.needLog == 1;
                    bVar.huc = frsViewData.getForum().getId();
                    bVar.hub = bOr.bTZ();
                    if (com.baidu.tieba.frs.d.d.hgM != null) {
                        bVar.hud = com.baidu.tieba.frs.d.d.hgM.hud;
                        bVar.hue = com.baidu.tieba.frs.d.d.hgM.hue;
                    }
                    com.baidu.tieba.frs.d.c.bUt().a(bVar, bjVar, 1);
                    com.baidu.tieba.frs.d.a.a(bjVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(bOw, frsViewData, frsFragment.getForumId(), true, bjVar);
            }
        }
    }

    public static void a(bh bhVar) {
        if (bhVar != null) {
            String aJZ = bhVar.aJZ();
            if (StringUtils.isNull(aJZ)) {
                aJZ = bhVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bhVar.getForumId(), bhVar.getForumName(), bhVar.getThreadId(), "tieba.baidu.com/p/" + bhVar.getThreadId(), aJZ);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.huc)) {
            an anVar = new an("c11942");
            anVar.cI("fid", bVar.huc);
            anVar.cI("obj_name", str);
            TiebaStatic.log(anVar);
        }
    }

    public static void bY(int i, int i2) {
        TiebaStatic.log(new an("c10320").af("obj_locate", i).af("obj_type", i2));
    }
}
