package com.baidu.tieba.frs.utils;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.entelechy.a.am;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    public static void a(ax axVar, com.baidu.tieba.tbadkCore.n nVar, String str, boolean z, bh bhVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (axVar != null && nVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense()) != null && adAdSense.xm()) {
            am YH = axVar == null ? null : axVar.YH();
            List<com.baidu.adp.widget.ListView.v> datas = YH != null ? YH.getDatas() : null;
            List<com.baidu.adp.widget.ListView.v> singletonList = bhVar != null ? Collections.singletonList(bhVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.v vVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.v vVar2 : singletonList) {
                            if (vVar == vVar2 && (vVar2 instanceof bh)) {
                                a.b bVar = new a.b();
                                bVar.bjS = ((bh) vVar2).getTid();
                                bVar.bnY = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.v vVar3 : singletonList) {
                        if (vVar3 instanceof bh) {
                            bh bhVar2 = (bh) vVar3;
                            i3++;
                            if (bhVar2.Tn == 1 && !TextUtils.isEmpty(bhVar2.getTid())) {
                                bhVar2.Tn = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bjS = bhVar2.getTid();
                                bVar2.bnY = i3;
                                arrayList.add(bVar2);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    com.baidu.tieba.recapp.r.sendFRS(z, nVar.aJY().getFirst_class(), nVar.aJY().getSecond_class(), str, arrayList, adAdSense.xq());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.UN() - j, frsModelController.UL(), frsModelController.UM(), currentTimeMillis - frsModelController.UK());
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.n nVar, bh bhVar) {
        if (bhVar != null && nVar != null) {
            FrsModelController Xy = frsActivity.Xy();
            ax XF = frsActivity.XF();
            if (XF != null && Xy != null) {
                if (bhVar.getAuthor() != null && bhVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new ar("c10806").s("obj_locate", 3).ab("tid", bhVar.getId()));
                }
                if (nVar != null && nVar.aJY() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.bSZ = nVar.fnk == 1;
                    aVar.bTb = nVar.aJY().getId();
                    aVar.bTa = Xy.aca();
                    com.baidu.tieba.frs.e.b.acx().a(aVar, bhVar, 1);
                }
                a(XF, nVar, frsActivity.getForumId(), true, bhVar);
            }
        }
    }

    public static void a(bf bfVar) {
        if (bfVar != null) {
            String pp = bfVar.pp();
            if (StringUtils.isNull(pp)) {
                pp = bfVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bfVar.getForumId(), bfVar.getForumName(), bfVar.getThreadId(), "tieba.baidu.com/p/" + bfVar.getThreadId(), pp);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.bTb)) {
            ar arVar = new ar("c11942");
            arVar.ab("fid", aVar.bTb);
            arVar.ab("obj_name", str);
            TiebaStatic.log(arVar);
        }
    }

    public static void aj(int i, int i2) {
        TiebaStatic.log(new ar("c10320").s("obj_locate", i).s("obj_type", i2));
    }
}
