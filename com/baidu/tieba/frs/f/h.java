package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.q;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class h {
    public static void a(com.baidu.tieba.frs.i iVar, l lVar, String str, boolean z, bd bdVar) {
        com.baidu.tbadk.coreExtra.data.c adAdSense;
        if (iVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.BG()) {
            q aux = iVar == null ? null : iVar.aux();
            List<com.baidu.adp.widget.ListView.h> datas = aux != null ? aux.getDatas() : null;
            List<com.baidu.adp.widget.ListView.h> singletonList = bdVar != null ? Collections.singletonList(bdVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.h hVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.h hVar2 : singletonList) {
                            if (hVar == hVar2 && (hVar2 instanceof bd)) {
                                a.b bVar = new a.b();
                                bVar.aVt = ((bd) hVar2).getTid();
                                bVar.cBm = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.h hVar3 : singletonList) {
                        if (hVar3 instanceof bd) {
                            bd bdVar2 = (bd) hVar3;
                            i3++;
                            if (bdVar2.aiI == 1 && !TextUtils.isEmpty(bdVar2.getTid())) {
                                bdVar2.aiI = 2;
                                a.b bVar2 = new a.b();
                                bVar2.aVt = bdVar2.getTid();
                                bVar2.cBm = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, lVar.bam().getFirst_class(), lVar.bam().getSecond_class(), str, arrayList, adAdSense.BJ());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.apl() - j, frsModelController.apj(), frsModelController.apk(), currentTimeMillis - frsModelController.aph());
        }
    }

    public static void a(FrsFragment frsFragment, l lVar, bd bdVar) {
        if (bdVar != null && lVar != null) {
            FrsModelController atm = frsFragment.atm();
            com.baidu.tieba.frs.i atr = frsFragment.atr();
            if (atr != null && atm != null) {
                if (bdVar.vm() != null && bdVar.vm().getGodInfo() != null) {
                    TiebaStatic.log(new am("c10806").r("obj_locate", 3).ah("tid", bdVar.getId()));
                }
                if (lVar != null && lVar.bam() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.dyD = lVar.gGr == 1;
                    aVar.dyF = lVar.bam().getId();
                    aVar.dyE = atm.ayz();
                    if (com.baidu.tieba.frs.e.c.dyP != null) {
                        aVar.dyG = com.baidu.tieba.frs.e.c.dyP.dyG;
                        aVar.dyH = com.baidu.tieba.frs.e.c.dyP.dyH;
                    }
                    com.baidu.tieba.frs.e.b.ayQ().a(aVar, bdVar, 1);
                }
                a(atr, lVar, frsFragment.getForumId(), true, bdVar);
            }
        }
    }

    public static void a(bb bbVar) {
        if (bbVar != null) {
            String tR = bbVar.tR();
            if (StringUtils.isNull(tR)) {
                tR = bbVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bbVar.getForumId(), bbVar.getForumName(), bbVar.getThreadId(), "tieba.baidu.com/p/" + bbVar.getThreadId(), tR);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.dyF)) {
            am amVar = new am("c11942");
            amVar.ah(ImageViewerConfig.FORUM_ID, aVar.dyF);
            amVar.ah("obj_name", str);
            TiebaStatic.log(amVar);
        }
    }

    public static void aM(int i, int i2) {
        TiebaStatic.log(new am("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
