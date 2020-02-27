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
import com.baidu.tieba.frs.entelechy.a.af;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class h {
    public static void a(l lVar, FrsViewData frsViewData, String str, boolean z, bj bjVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (lVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.aJb()) {
            af bFd = lVar == null ? null : lVar.bFd();
            List<m> datas = bFd != null ? bFd.getDatas() : null;
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
                                bVar.Pj = ((bj) mVar2).getTid();
                                bVar.fMr = i2;
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
                            if (bjVar2.cSJ == 1 && !TextUtils.isEmpty(bjVar2.getTid())) {
                                bjVar2.cSJ = 2;
                                a.b bVar2 = new a.b();
                                bVar2.Pj = bjVar2.getTid();
                                bVar2.fMr = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.aJe());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.byN() - j, frsModelController.byL(), frsModelController.byM(), currentTimeMillis - frsModelController.byK());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bj bjVar) {
        if (bjVar != null && frsViewData != null) {
            FrsModelController bDI = frsFragment.bDI();
            l bDN = frsFragment.bDN();
            if (bDN != null && bDI != null) {
                if (bjVar.aCm() != null && bjVar.aCm().getGodInfo() != null) {
                    TiebaStatic.log(new an("c10806").X("obj_locate", 3).cy("tid", bjVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.gJk = frsViewData.needLog == 1;
                    bVar.gJm = frsViewData.getForum().getId();
                    bVar.gJl = bDI.bJn();
                    if (com.baidu.tieba.frs.d.d.gwo != null) {
                        bVar.gJn = com.baidu.tieba.frs.d.d.gwo.gJn;
                        bVar.gJo = com.baidu.tieba.frs.d.d.gwo.gJo;
                    }
                    com.baidu.tieba.frs.d.c.bJH().a(bVar, bjVar, 1);
                    com.baidu.tieba.frs.d.a.a(bjVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(bDN, frsViewData, frsFragment.getForumId(), true, bjVar);
            }
        }
    }

    public static void a(bh bhVar) {
        if (bhVar != null) {
            String aBJ = bhVar.aBJ();
            if (StringUtils.isNull(aBJ)) {
                aBJ = bhVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bhVar.getForumId(), bhVar.getForumName(), bhVar.getThreadId(), "tieba.baidu.com/p/" + bhVar.getThreadId(), aBJ);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.gJm)) {
            an anVar = new an("c11942");
            anVar.cy("fid", bVar.gJm);
            anVar.cy("obj_name", str);
            TiebaStatic.log(anVar);
        }
    }

    public static void bR(int i, int i2) {
        TiebaStatic.log(new an("c10320").X("obj_locate", i).X("obj_type", i2));
    }
}
