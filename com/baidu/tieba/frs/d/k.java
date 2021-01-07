package com.baidu.tieba.frs.d;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.al;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class k {
    public static void a(q qVar, FrsViewData frsViewData, String str, boolean z, bz bzVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (qVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.bzz()) {
            al cGA = qVar == null ? null : qVar.cGA();
            List<n> datas = cGA != null ? cGA.getDatas() : null;
            List<n> singletonList = bzVar != null ? Collections.singletonList(bzVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (n nVar : datas) {
                        int i2 = i + 1;
                        for (n nVar2 : singletonList) {
                            if (nVar == nVar2 && (nVar2 instanceof bz)) {
                                a.b bVar = new a.b();
                                bVar.anD = ((bz) nVar2).getTid();
                                bVar.izb = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (n nVar3 : singletonList) {
                        if (nVar3 instanceof bz) {
                            bz bzVar2 = (bz) nVar3;
                            i3++;
                            if (bzVar2.eUv == 1 && !TextUtils.isEmpty(bzVar2.getTid())) {
                                bzVar2.eUv = 2;
                                a.b bVar2 = new a.b();
                                bVar2.anD = bzVar2.getTid();
                                bVar2.izb = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.bzC());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.czj() - j, frsModelController.czh(), frsModelController.czi(), currentTimeMillis - frsModelController.czg());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bz bzVar) {
        if (bzVar != null && frsViewData != null) {
            FrsModelController cEV = frsFragment.cEV();
            q cFa = frsFragment.cFa();
            if (cFa != null && cEV != null) {
                if (bzVar.brr() != null && bzVar.brr().getGodInfo() != null) {
                    TiebaStatic.log(new aq("c10806").an("obj_locate", 3).dX("tid", bzVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                    bVar.jGm = frsViewData.needLog == 1;
                    bVar.jGo = frsViewData.getForum().getId();
                    bVar.jGn = cEV.cMk();
                    if (com.baidu.tieba.frs.b.d.jpq != null) {
                        bVar.jGp = com.baidu.tieba.frs.b.d.jpq.jGp;
                        bVar.jGq = com.baidu.tieba.frs.b.d.jpq.jGq;
                    }
                    com.baidu.tieba.frs.b.c.cMJ().a(bVar, bzVar, 1);
                    com.baidu.tieba.frs.b.a.a(bzVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(cFa, frsViewData, frsFragment.getForumId(), true, bzVar);
            }
        }
    }

    public static void a(bx bxVar) {
        if (bxVar != null) {
            String bqN = bxVar.bqN();
            if (StringUtils.isNull(bqN)) {
                bqN = bxVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", bxVar.getForumId(), bxVar.getForumName(), bxVar.getThreadId(), "tieba.baidu.com/p/" + bxVar.getThreadId(), bqN);
        }
    }

    public static void a(com.baidu.tieba.frs.b.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.jGo)) {
            aq aqVar = new aq("c11942");
            aqVar.dX("fid", bVar.jGo);
            aqVar.dX("obj_name", str);
            TiebaStatic.log(aqVar);
        }
    }

    public static void cD(int i, int i2) {
        TiebaStatic.log(new aq("c10320").an("obj_locate", i).an("obj_type", i2).an("obj_name", TbadkCoreApplication.getInst().getStartType()).an(TiebaInitialize.Params.OBJ_PARAM3, 1));
    }
}
