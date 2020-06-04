package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bk;
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
    public static void a(n nVar, FrsViewData frsViewData, String str, boolean z, bk bkVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (nVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.aXK()) {
            ai bWo = nVar == null ? null : nVar.bWo();
            List<o> datas = bWo != null ? bWo.getDatas() : null;
            List<o> singletonList = bkVar != null ? Collections.singletonList(bkVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (o oVar : datas) {
                        int i2 = i + 1;
                        for (o oVar2 : singletonList) {
                            if (oVar == oVar2 && (oVar2 instanceof bk)) {
                                a.b bVar = new a.b();
                                bVar.ais = ((bk) oVar2).getTid();
                                bVar.gHb = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (o oVar3 : singletonList) {
                        if (oVar3 instanceof bk) {
                            bk bkVar2 = (bk) oVar3;
                            i3++;
                            if (bkVar2.dGg == 1 && !TextUtils.isEmpty(bkVar2.getTid())) {
                                bkVar2.dGg = 2;
                                a.b bVar2 = new a.b();
                                bVar2.ais = bkVar2.getTid();
                                bVar2.gHb = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    r.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.aXN());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.bPs() - j, frsModelController.bPq(), frsModelController.bPr(), currentTimeMillis - frsModelController.bPp());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bk bkVar) {
        if (bkVar != null && frsViewData != null) {
            FrsModelController bUO = frsFragment.bUO();
            n bUT = frsFragment.bUT();
            if (bUT != null && bUO != null) {
                if (bkVar.aQx() != null && bkVar.aQx().getGodInfo() != null) {
                    TiebaStatic.log(new an("c10806").ag("obj_locate", 3).dh("tid", bkVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.hJA = frsViewData.needLog == 1;
                    bVar.hJC = frsViewData.getForum().getId();
                    bVar.hJB = bUO.caD();
                    if (com.baidu.tieba.frs.d.d.hvL != null) {
                        bVar.hJD = com.baidu.tieba.frs.d.d.hvL.hJD;
                        bVar.hJE = com.baidu.tieba.frs.d.d.hvL.hJE;
                    }
                    com.baidu.tieba.frs.d.c.caY().a(bVar, bkVar, 1);
                    com.baidu.tieba.frs.d.a.a(bkVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(bUT, frsViewData, frsFragment.getForumId(), true, bkVar);
            }
        }
    }

    public static void a(bi biVar) {
        if (biVar != null) {
            String aPU = biVar.aPU();
            if (StringUtils.isNull(aPU)) {
                aPU = biVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", biVar.getForumId(), biVar.getForumName(), biVar.getThreadId(), "tieba.baidu.com/p/" + biVar.getThreadId(), aPU);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.hJC)) {
            an anVar = new an("c11942");
            anVar.dh("fid", bVar.hJC);
            anVar.dh("obj_name", str);
            TiebaStatic.log(anVar);
        }
    }

    public static void cd(int i, int i2) {
        TiebaStatic.log(new an("c10320").ag("obj_locate", i).ag("obj_type", i2));
    }
}
