package com.baidu.tieba.frs.utils;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.entelechy.a.aj;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class t {
    public static void a(au auVar, com.baidu.tieba.tbadkCore.p pVar, String str, boolean z, bk bkVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (auVar != null && pVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense()) != null && adAdSense.xF()) {
            aj ade = auVar == null ? null : auVar.ade();
            List<com.baidu.adp.widget.ListView.v> datas = ade != null ? ade.getDatas() : null;
            List<com.baidu.adp.widget.ListView.v> singletonList = bkVar != null ? Collections.singletonList(bkVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.v vVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.v vVar2 : singletonList) {
                            if (vVar == vVar2 && (vVar2 instanceof bk)) {
                                a.b bVar = new a.b();
                                bVar.aRO = ((bk) vVar2).getTid();
                                bVar.beM = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.v vVar3 : singletonList) {
                        if (vVar3 instanceof bk) {
                            bk bkVar2 = (bk) vVar3;
                            i3++;
                            if (bkVar2.UB == 1 && !TextUtils.isEmpty(bkVar2.getTid())) {
                                bkVar2.UB = 2;
                                a.b bVar2 = new a.b();
                                bVar2.aRO = bkVar2.getTid();
                                bVar2.beM = i3;
                                arrayList.add(bVar2);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    com.baidu.tieba.recapp.g.sendFRS(z, pVar.aOk().getFirst_class(), pVar.aOk().getSecond_class(), str, arrayList, adAdSense.xG());
                }
            }
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.data.f fVar, boolean z, int i, int i2) {
        if (frsActivity != null && frsActivity.acr() != null && fVar != null) {
            com.baidu.tieba.tbadkCore.p acr = frsActivity.acr();
            au abZ = frsActivity.abZ();
            int bkX = acr.bkX();
            int headerViewsCount = ((i + i2) - abZ.acW().getHeaderViewsCount()) - bkX;
            int i3 = (headerViewsCount - 1) + bkX;
            int sc = fVar.sc(headerViewsCount);
            if (sc >= 0 && i3 >= 0 && i3 < acr.getThreadList().size()) {
                com.baidu.adp.widget.ListView.v vVar = acr.getThreadList().get(i3);
                if (vVar instanceof com.baidu.tbadk.core.data.c) {
                    fVar.c(headerViewsCount, 1, frsActivity.getForumId(), sc);
                    com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a((com.baidu.tbadk.core.data.c) vVar, 3, frsActivity.getPageNum());
                    a.bP("isCache", String.valueOf(z));
                    com.baidu.tieba.recapp.report.b.beF().a(a);
                    return;
                }
                ForumData aOk = acr.aOk();
                AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
                fVar.c(headerViewsCount, 2, frsActivity.getForumId(), sc);
                com.baidu.tieba.recapp.report.a P = com.baidu.tieba.recapp.report.e.P(13, sc, frsActivity.getPageNum());
                P.bP("page", "FRS");
                P.bP("isCache", String.valueOf(z));
                if (aOk != null) {
                    P.bP("fid", aOk.getId());
                    P.bP("fc1", aOk.getFirst_class());
                    P.bP("fc2", aOk.getSecond_class());
                }
                if (currentAccountObj != null) {
                    P.bP("vc", String.valueOf(currentAccountObj.isMemberCloseAdIsOpen()));
                }
                com.baidu.tieba.recapp.report.b.beF().a(P);
            }
        }
    }

    public static void a(com.baidu.tieba.frs.e.i iVar, long j) {
        if (iVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, iVar.Zh() - j, iVar.Zf(), iVar.Zg(), currentTimeMillis - iVar.Ze());
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, bk bkVar) {
        if (bkVar != null && pVar != null) {
            com.baidu.tieba.frs.e.i abS = frsActivity.abS();
            au abZ = frsActivity.abZ();
            if (abZ != null && abS != null) {
                if (bkVar.getAuthor() != null && bkVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new av("c10806").s("obj_locate", 3).ab("tid", bkVar.getId()));
                }
                if (pVar != null && pVar.aOk() != null) {
                    com.baidu.tieba.frs.h.a aVar = new com.baidu.tieba.frs.h.a();
                    aVar.chc = pVar.fzN == 1;
                    aVar.che = pVar.aOk().getId();
                    aVar.chd = abS.agx();
                    com.baidu.tieba.frs.h.b.agV().a(aVar, bkVar, 1);
                }
                if (bkVar.Ve != null) {
                    av avVar = new av("c11430");
                    avVar.ab("tid", bkVar.getTid());
                    avVar.ab("obj_id", new StringBuilder(String.valueOf(bkVar.Ve.productId)).toString());
                    TiebaStatic.log(avVar);
                }
                a(abZ, pVar, frsActivity.getForumId(), true, bkVar);
            }
        }
    }

    public static void a(bi biVar) {
        if (biVar != null) {
            String pw = biVar.pw();
            if (StringUtils.isNull(pw)) {
                pw = biVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.b("frs", "CLICK", biVar.getForumId(), biVar.getForumName(), biVar.getThreadId(), "tieba.baidu.com/p/" + biVar.getThreadId(), pw);
        }
    }
}
