package com.baidu.tieba.frs.e;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
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
    public static void a(k kVar, l lVar, String str, boolean z, bd bdVar) {
        com.baidu.tbadk.coreExtra.data.c adAdSense;
        if (kVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.EX()) {
            u auP = kVar == null ? null : kVar.auP();
            List<com.baidu.adp.widget.ListView.i> datas = auP != null ? auP.getDatas() : null;
            List<com.baidu.adp.widget.ListView.i> singletonList = bdVar != null ? Collections.singletonList(bdVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.i iVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.i iVar2 : singletonList) {
                            if (iVar == iVar2 && (iVar2 instanceof bd)) {
                                a.b bVar = new a.b();
                                bVar.bAT = ((bd) iVar2).getTid();
                                bVar.cWG = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.i iVar3 : singletonList) {
                        if (iVar3 instanceof bd) {
                            bd bdVar2 = (bd) iVar3;
                            i3++;
                            if (bdVar2.aNS == 1 && !TextUtils.isEmpty(bdVar2.getTid())) {
                                bdVar2.aNS = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bAT = bdVar2.getTid();
                                bVar2.cWG = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    r.sendFRS(z, lVar.aYE().getFirst_class(), lVar.aYE().getSecond_class(), str, arrayList, adAdSense.Fa());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.apW() - j, frsModelController.apU(), frsModelController.apV(), currentTimeMillis - frsModelController.apT());
        }
    }

    public static void a(com.baidu.tieba.frs.i iVar, l lVar, bd bdVar) {
        if (bdVar != null && lVar != null) {
            FrsModelController atT = iVar.atT();
            k atY = iVar.atY();
            if (atY != null && atT != null) {
                if (bdVar.yS() != null && bdVar.yS().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").s("obj_locate", 3).ab("tid", bdVar.getId()));
                }
                if (lVar != null && lVar.aYE() != null) {
                    com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
                    aVar.dQx = lVar.gVC == 1;
                    aVar.dQz = lVar.aYE().getId();
                    aVar.dQy = atT.ayq();
                    com.baidu.tieba.frs.d.b.ayK().a(aVar, bdVar, 1);
                }
                a(atY, lVar, iVar.getForumId(), true, bdVar);
            }
        }
    }

    public static void a(bb bbVar) {
        if (bbVar != null) {
            String xi = bbVar.xi();
            if (StringUtils.isNull(xi)) {
                xi = bbVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bbVar.getForumId(), bbVar.getForumName(), bbVar.getThreadId(), "tieba.baidu.com/p/" + bbVar.getThreadId(), xi);
        }
    }

    public static void a(com.baidu.tieba.frs.d.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dQz)) {
            ak akVar = new ak("c11942");
            akVar.ab(ImageViewerConfig.FORUM_ID, aVar.dQz);
            akVar.ab("obj_name", str);
            TiebaStatic.log(akVar);
        }
    }

    public static void bK(int i, int i2) {
        TiebaStatic.log(new ak("c10320").s("obj_locate", i).s("obj_type", i2));
    }
}
