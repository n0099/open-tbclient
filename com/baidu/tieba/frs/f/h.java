package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.ai;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class h {
    public static void a(m mVar, FrsViewData frsViewData, String str, boolean z, bj bjVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (mVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.aJi()) {
            ai bFq = mVar == null ? null : mVar.bFq();
            List<com.baidu.adp.widget.ListView.m> datas = bFq != null ? bFq.getDatas() : null;
            List<com.baidu.adp.widget.ListView.m> singletonList = bjVar != null ? Collections.singletonList(bjVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.m mVar2 : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.m mVar3 : singletonList) {
                            if (mVar2 == mVar3 && (mVar3 instanceof bj)) {
                                a.b bVar = new a.b();
                                bVar.Pk = ((bj) mVar3).getTid();
                                bVar.fNo = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.m mVar4 : singletonList) {
                        if (mVar4 instanceof bj) {
                            bj bjVar2 = (bj) mVar4;
                            i3++;
                            if (bjVar2.cSY == 1 && !TextUtils.isEmpty(bjVar2.getTid())) {
                                bjVar2.cSY = 2;
                                a.b bVar2 = new a.b();
                                bVar2.Pk = bjVar2.getTid();
                                bVar2.fNo = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.aJl());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.byW() - j, frsModelController.byU(), frsModelController.byV(), currentTimeMillis - frsModelController.byT());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bj bjVar) {
        if (bjVar != null && frsViewData != null) {
            FrsModelController bDT = frsFragment.bDT();
            m bDY = frsFragment.bDY();
            if (bDY != null && bDT != null) {
                if (bjVar.aCr() != null && bjVar.aCr().getGodInfo() != null) {
                    TiebaStatic.log(new an("c10806").X("obj_locate", 3).cx("tid", bjVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.gKD = frsViewData.needLog == 1;
                    bVar.gKF = frsViewData.getForum().getId();
                    bVar.gKE = bDT.bJD();
                    if (com.baidu.tieba.frs.d.d.gxl != null) {
                        bVar.gKG = com.baidu.tieba.frs.d.d.gxl.gKG;
                        bVar.gKH = com.baidu.tieba.frs.d.d.gxl.gKH;
                    }
                    com.baidu.tieba.frs.d.c.bJX().a(bVar, bjVar, 1);
                    com.baidu.tieba.frs.d.a.a(bjVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(bDY, frsViewData, frsFragment.getForumId(), true, bjVar);
            }
        }
    }

    public static void a(bh bhVar) {
        if (bhVar != null) {
            String aBO = bhVar.aBO();
            if (StringUtils.isNull(aBO)) {
                aBO = bhVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bhVar.getForumId(), bhVar.getForumName(), bhVar.getThreadId(), "tieba.baidu.com/p/" + bhVar.getThreadId(), aBO);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.gKF)) {
            an anVar = new an("c11942");
            anVar.cx("fid", bVar.gKF);
            anVar.cx("obj_name", str);
            TiebaStatic.log(anVar);
        }
    }

    public static void bS(int i, int i2) {
        TiebaStatic.log(new an("c10320").X("obj_locate", i).X("obj_type", i2));
    }
}
