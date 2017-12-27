package com.baidu.tieba.frs.e;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class g {
    public static void a(k kVar, l lVar, String str, boolean z, be beVar) {
        com.baidu.tbadk.coreExtra.data.c adAdSense;
        if (kVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.Fg()) {
            u atM = kVar == null ? null : kVar.atM();
            List<com.baidu.adp.widget.ListView.i> datas = atM != null ? atM.getDatas() : null;
            List<com.baidu.adp.widget.ListView.i> singletonList = beVar != null ? Collections.singletonList(beVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.i iVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.i iVar2 : singletonList) {
                            if (iVar == iVar2 && (iVar2 instanceof be)) {
                                a.b bVar = new a.b();
                                bVar.bAK = ((be) iVar2).getTid();
                                bVar.cSe = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.i iVar3 : singletonList) {
                        if (iVar3 instanceof be) {
                            be beVar2 = (be) iVar3;
                            i3++;
                            if (beVar2.aNW == 1 && !TextUtils.isEmpty(beVar2.getTid())) {
                                beVar2.aNW = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bAK = beVar2.getTid();
                                bVar2.cSe = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    r.sendFRS(z, lVar.aYy().getFirst_class(), lVar.aYy().getSecond_class(), str, arrayList, adAdSense.Fj());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.aoT() - j, frsModelController.aoR(), frsModelController.aoS(), currentTimeMillis - frsModelController.aoQ());
        }
    }

    public static void a(com.baidu.tieba.frs.i iVar, l lVar, be beVar) {
        if (beVar != null && lVar != null) {
            FrsModelController asQ = iVar.asQ();
            k asV = iVar.asV();
            if (asV != null && asQ != null) {
                if (beVar.yX() != null && beVar.yX().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", beVar.getId()));
                }
                if (lVar != null && lVar.aYy() != null) {
                    com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
                    aVar.dLV = lVar.hgc == 1;
                    aVar.dLX = lVar.aYy().getId();
                    aVar.dLW = asQ.axn();
                    com.baidu.tieba.frs.d.b.axH().a(aVar, beVar, 1);
                }
                a(asV, lVar, iVar.getForumId(), true, beVar);
            }
        }
    }

    public static void a(bc bcVar) {
        if (bcVar != null) {
            String xj = bcVar.xj();
            if (StringUtils.isNull(xj)) {
                xj = bcVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bcVar.getForumId(), bcVar.getForumName(), bcVar.getThreadId(), "tieba.baidu.com/p/" + bcVar.getThreadId(), xj);
        }
    }

    public static void a(com.baidu.tieba.frs.d.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dLX)) {
            ak akVar = new ak("c11942");
            akVar.ab(ImageViewerConfig.FORUM_ID, aVar.dLX);
            akVar.ab("obj_name", str);
            TiebaStatic.log(akVar);
        }
    }

    public static void bK(int i, int i2) {
        TiebaStatic.log(new ak("c10320").s("obj_locate", i).s("obj_type", i2));
    }
}
