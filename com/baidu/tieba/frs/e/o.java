package com.baidu.tieba.frs.e;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.bm;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.entelechy.a.al;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.ad;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    public static void a(av avVar, com.baidu.tieba.tbadkCore.n nVar, String str, boolean z, bm bmVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (avVar != null && nVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense()) != null && adAdSense.xD()) {
            al aeI = avVar == null ? null : avVar.aeI();
            List<v> datas = aeI != null ? aeI.getDatas() : null;
            List<v> singletonList = bmVar != null ? Collections.singletonList(bmVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (v vVar : datas) {
                        int i2 = i + 1;
                        for (v vVar2 : singletonList) {
                            if (vVar == vVar2 && (vVar2 instanceof bm)) {
                                a.b bVar = new a.b();
                                bVar.bxL = ((bm) vVar2).getTid();
                                bVar.bDR = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (v vVar3 : singletonList) {
                        if (vVar3 instanceof bm) {
                            bm bmVar2 = (bm) vVar3;
                            i3++;
                            if (bmVar2.Yf == 1 && !TextUtils.isEmpty(bmVar2.getTid())) {
                                bmVar2.Yf = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bxL = bmVar2.getTid();
                                bVar2.bDR = i3;
                                arrayList.add(bVar2);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    ad.sendFRS(z, nVar.aMt().getFirst_class(), nVar.aMt().getSecond_class(), str, arrayList, adAdSense.xG());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.abb() - j, frsModelController.aaZ(), frsModelController.aba(), currentTimeMillis - frsModelController.aaY());
        }
    }

    public static void a(com.baidu.tieba.frs.r rVar, com.baidu.tieba.tbadkCore.n nVar, bm bmVar) {
        if (bmVar != null && nVar != null) {
            FrsModelController adP = rVar.adP();
            av adU = rVar.adU();
            if (adU != null && adP != null) {
                if (bmVar.getAuthor() != null && bmVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new au("c10806").r("obj_locate", 3).Z("tid", bmVar.getId()));
                }
                if (nVar != null && nVar.aMt() != null) {
                    com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
                    aVar.cnr = nVar.fJJ == 1;
                    aVar.cnu = nVar.aMt().getId();
                    aVar.cns = adP.agT();
                    com.baidu.tieba.frs.d.b.aho().a(aVar, bmVar, 1);
                }
                a(adU, nVar, rVar.getForumId(), true, bmVar);
            }
        }
    }

    public static void a(bk bkVar) {
        if (bkVar != null) {
            String pu = bkVar.pu();
            if (StringUtils.isNull(pu)) {
                pu = bkVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bkVar.getForumId(), bkVar.getForumName(), bkVar.getThreadId(), "tieba.baidu.com/p/" + bkVar.getThreadId(), pu);
        }
    }

    public static void a(com.baidu.tieba.frs.d.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.cnu)) {
            au auVar = new au("c11942");
            auVar.Z("fid", aVar.cnu);
            auVar.Z("obj_name", str);
            TiebaStatic.log(auVar);
        }
    }

    public static void au(int i, int i2) {
        TiebaStatic.log(new au("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
