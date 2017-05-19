package com.baidu.tieba.frs.d;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.entelechy.a.am;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.aa;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class o {
    public static void a(at atVar, com.baidu.tieba.tbadkCore.n nVar, String str, boolean z, bk bkVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (atVar != null && nVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense()) != null && adAdSense.xs()) {
            am ZO = atVar == null ? null : atVar.ZO();
            List<v> datas = ZO != null ? ZO.getDatas() : null;
            List<v> singletonList = bkVar != null ? Collections.singletonList(bkVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (v vVar : datas) {
                        int i2 = i + 1;
                        for (v vVar2 : singletonList) {
                            if (vVar == vVar2 && (vVar2 instanceof bk)) {
                                a.b bVar = new a.b();
                                bVar.bti = ((bk) vVar2).getTid();
                                bVar.bxb = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (v vVar3 : singletonList) {
                        if (vVar3 instanceof bk) {
                            bk bkVar2 = (bk) vVar3;
                            i3++;
                            if (bkVar2.Yi == 1 && !TextUtils.isEmpty(bkVar2.getTid())) {
                                bkVar2.Yi = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bti = bkVar2.getTid();
                                bVar2.bxb = i3;
                                arrayList.add(bVar2);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    aa.sendFRS(z, nVar.aHE().getFirst_class(), nVar.aHE().getSecond_class(), str, arrayList, adAdSense.xw());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.WA() - j, frsModelController.Wy(), frsModelController.Wz(), currentTimeMillis - frsModelController.Wx());
        }
    }

    public static void a(com.baidu.tieba.frs.r rVar, com.baidu.tieba.tbadkCore.n nVar, bk bkVar) {
        if (bkVar != null && nVar != null) {
            FrsModelController YU = rVar.YU();
            at YZ = rVar.YZ();
            if (YZ != null && YU != null) {
                if (bkVar.getAuthor() != null && bkVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new as("c10806").s("obj_locate", 3).aa("tid", bkVar.getId()));
                }
                if (nVar != null && nVar.aHE() != null) {
                    com.baidu.tieba.frs.c.a aVar = new com.baidu.tieba.frs.c.a();
                    aVar.bYR = nVar.frQ == 1;
                    aVar.bYT = nVar.aHE().getId();
                    aVar.bYS = YU.abW();
                    com.baidu.tieba.frs.c.b.acs().a(aVar, bkVar, 1);
                }
                a(YZ, nVar, rVar.getForumId(), true, bkVar);
            }
        }
    }

    public static void a(bi biVar) {
        if (biVar != null) {
            String pF = biVar.pF();
            if (StringUtils.isNull(pF)) {
                pF = biVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", biVar.getForumId(), biVar.getForumName(), biVar.getThreadId(), "tieba.baidu.com/p/" + biVar.getThreadId(), pF);
        }
    }

    public static void a(com.baidu.tieba.frs.c.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.bYT)) {
            as asVar = new as("c11942");
            asVar.aa("fid", aVar.bYT);
            asVar.aa("obj_name", str);
            TiebaStatic.log(asVar);
        }
    }

    public static void ao(int i, int i2) {
        TiebaStatic.log(new as("c10320").s("obj_locate", i).s("obj_type", i2));
    }
}
