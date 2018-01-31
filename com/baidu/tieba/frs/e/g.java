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
        if (kVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.EZ()) {
            u auU = kVar == null ? null : kVar.auU();
            List<com.baidu.adp.widget.ListView.i> datas = auU != null ? auU.getDatas() : null;
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
                                bVar.bBb = ((bd) iVar2).getTid();
                                bVar.cXb = i2;
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
                            if (bdVar2.aNV == 1 && !TextUtils.isEmpty(bdVar2.getTid())) {
                                bdVar2.aNV = 2;
                                a.b bVar2 = new a.b();
                                bVar2.bBb = bdVar2.getTid();
                                bVar2.cXb = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    r.sendFRS(z, lVar.aYJ().getFirst_class(), lVar.aYJ().getSecond_class(), str, arrayList, adAdSense.Fc());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.aqb() - j, frsModelController.apZ(), frsModelController.aqa(), currentTimeMillis - frsModelController.apY());
        }
    }

    public static void a(com.baidu.tieba.frs.i iVar, l lVar, bd bdVar) {
        if (bdVar != null && lVar != null) {
            FrsModelController atY = iVar.atY();
            k aud = iVar.aud();
            if (aud != null && atY != null) {
                if (bdVar.yT() != null && bdVar.yT().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").s("obj_locate", 3).aa("tid", bdVar.getId()));
                }
                if (lVar != null && lVar.aYJ() != null) {
                    com.baidu.tieba.frs.d.a aVar = new com.baidu.tieba.frs.d.a();
                    aVar.dQS = lVar.gVW == 1;
                    aVar.dQU = lVar.aYJ().getId();
                    aVar.dQT = atY.ayv();
                    com.baidu.tieba.frs.d.b.ayP().a(aVar, bdVar, 1);
                }
                a(aud, lVar, iVar.getForumId(), true, bdVar);
            }
        }
    }

    public static void a(bb bbVar) {
        if (bbVar != null) {
            String xj = bbVar.xj();
            if (StringUtils.isNull(xj)) {
                xj = bbVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bbVar.getForumId(), bbVar.getForumName(), bbVar.getThreadId(), "tieba.baidu.com/p/" + bbVar.getThreadId(), xj);
        }
    }

    public static void a(com.baidu.tieba.frs.d.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dQU)) {
            ak akVar = new ak("c11942");
            akVar.aa(ImageViewerConfig.FORUM_ID, aVar.dQU);
            akVar.aa("obj_name", str);
            TiebaStatic.log(akVar);
        }
    }

    public static void bK(int i, int i2) {
        TiebaStatic.log(new ak("c10320").s("obj_locate", i).s("obj_type", i2));
    }
}
