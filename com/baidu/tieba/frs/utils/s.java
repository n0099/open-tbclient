package com.baidu.tieba.frs.utils;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
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
    public static void a(ax axVar, com.baidu.tieba.tbadkCore.n nVar, String str, boolean z, bj bjVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (axVar != null && nVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense()) != null && adAdSense.xI()) {
            am ZG = axVar == null ? null : axVar.ZG();
            List<com.baidu.adp.widget.ListView.v> datas = ZG != null ? ZG.getDatas() : null;
            List<com.baidu.adp.widget.ListView.v> singletonList = bjVar != null ? Collections.singletonList(bjVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.v vVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.v vVar2 : singletonList) {
                            if (vVar == vVar2 && (vVar2 instanceof bj)) {
                                a.b bVar = new a.b();
                                bVar.bqB = ((bj) vVar2).getTid();
                                bVar.buU = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.v vVar3 : singletonList) {
                        if (vVar3 instanceof bj) {
                            bj bjVar2 = (bj) vVar3;
                            i3++;
                            if (bjVar2.Yz == 1 && !TextUtils.isEmpty(bjVar2.getTid())) {
                                bjVar2.Yz = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bqB = bjVar2.getTid();
                                bVar2.buU = i3;
                                arrayList.add(bVar2);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    com.baidu.tieba.recapp.t.sendFRS(z, nVar.aJp().getFirst_class(), nVar.aJp().getSecond_class(), str, arrayList, adAdSense.xM());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.VL() - j, frsModelController.VJ(), frsModelController.VK(), currentTimeMillis - frsModelController.VI());
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.n nVar, bj bjVar) {
        if (bjVar != null && nVar != null) {
            FrsModelController Yx = frsActivity.Yx();
            ax YE = frsActivity.YE();
            if (YE != null && Yx != null) {
                if (bjVar.getAuthor() != null && bjVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new as("c10806").s("obj_locate", 3).Z("tid", bjVar.getId()));
                }
                if (nVar != null && nVar.aJp() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.cal = nVar.frI == 1;
                    aVar.can = nVar.aJp().getId();
                    aVar.cam = Yx.acX();
                    com.baidu.tieba.frs.e.b.adv().a(aVar, bjVar, 1);
                }
                a(YE, nVar, frsActivity.getForumId(), true, bjVar);
            }
        }
    }

    public static void a(bh bhVar) {
        if (bhVar != null) {
            String pD = bhVar.pD();
            if (StringUtils.isNull(pD)) {
                pD = bhVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bhVar.getForumId(), bhVar.getForumName(), bhVar.getThreadId(), "tieba.baidu.com/p/" + bhVar.getThreadId(), pD);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.can)) {
            as asVar = new as("c11942");
            asVar.Z("fid", aVar.can);
            asVar.Z("obj_name", str);
            TiebaStatic.log(asVar);
        }
    }

    public static void ap(int i, int i2) {
        TiebaStatic.log(new as("c10320").s("obj_locate", i).s("obj_type", i2));
    }
}
