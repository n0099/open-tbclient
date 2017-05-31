package com.baidu.tieba.frs.e;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.entelechy.a.al;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.ac;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    public static void a(au auVar, com.baidu.tieba.tbadkCore.n nVar, String str, boolean z, bl blVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (auVar != null && nVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense()) != null && adAdSense.xl()) {
            al aaR = auVar == null ? null : auVar.aaR();
            List<v> datas = aaR != null ? aaR.getDatas() : null;
            List<v> singletonList = blVar != null ? Collections.singletonList(blVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (v vVar : datas) {
                        int i2 = i + 1;
                        for (v vVar2 : singletonList) {
                            if (vVar == vVar2 && (vVar2 instanceof bl)) {
                                a.b bVar = new a.b();
                                bVar.buq = ((bl) vVar2).getTid();
                                bVar.bCY = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (v vVar3 : singletonList) {
                        if (vVar3 instanceof bl) {
                            bl blVar2 = (bl) vVar3;
                            i3++;
                            if (blVar2.Ye == 1 && !TextUtils.isEmpty(blVar2.getTid())) {
                                blVar2.Ye = 2;
                                a.b bVar2 = new a.b();
                                bVar2.buq = blVar2.getTid();
                                bVar2.bCY = i3;
                                arrayList.add(bVar2);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    ac.sendFRS(z, nVar.aIz().getFirst_class(), nVar.aIz().getSecond_class(), str, arrayList, adAdSense.xp());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.XD() - j, frsModelController.XB(), frsModelController.XC(), currentTimeMillis - frsModelController.XA());
        }
    }

    public static void a(com.baidu.tieba.frs.r rVar, com.baidu.tieba.tbadkCore.n nVar, bl blVar) {
        if (blVar != null && nVar != null) {
            FrsModelController ZY = rVar.ZY();
            au aad = rVar.aad();
            if (aad != null && ZY != null) {
                if (blVar.getAuthor() != null && blVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new as("c10806").r("obj_locate", 3).Z("tid", blVar.getId()));
                }
                if (nVar != null && nVar.aIz() != null) {
                    com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
                    aVar.cfc = nVar.fzF == 1;
                    aVar.cfe = nVar.aIz().getId();
                    aVar.cfd = ZY.ada();
                    com.baidu.tieba.frs.d.b.adw().a(aVar, blVar, 1);
                }
                a(aad, nVar, rVar.getForumId(), true, blVar);
            }
        }
    }

    public static void a(bj bjVar) {
        if (bjVar != null) {
            String px = bjVar.px();
            if (StringUtils.isNull(px)) {
                px = bjVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bjVar.getForumId(), bjVar.getForumName(), bjVar.getThreadId(), "tieba.baidu.com/p/" + bjVar.getThreadId(), px);
        }
    }

    public static void a(com.baidu.tieba.frs.d.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.cfe)) {
            as asVar = new as("c11942");
            asVar.Z("fid", aVar.cfe);
            asVar.Z("obj_name", str);
            TiebaStatic.log(asVar);
        }
    }

    public static void ao(int i, int i2) {
        TiebaStatic.log(new as("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
