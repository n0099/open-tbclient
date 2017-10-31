package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.frs.entelechy.a.t;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    public static void a(com.baidu.tieba.frs.i iVar, com.baidu.tieba.tbadkCore.j jVar, String str, boolean z, bh bhVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (iVar != null && jVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.xx()) {
            t ajN = iVar == null ? null : iVar.ajN();
            List<com.baidu.adp.widget.ListView.f> datas = ajN != null ? ajN.getDatas() : null;
            List<com.baidu.adp.widget.ListView.f> singletonList = bhVar != null ? Collections.singletonList(bhVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.f fVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.f fVar2 : singletonList) {
                            if (fVar == fVar2 && (fVar2 instanceof bh)) {
                                a.b bVar = new a.b();
                                bVar.aMi = ((bh) fVar2).getTid();
                                bVar.bUC = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.f fVar3 : singletonList) {
                        if (fVar3 instanceof bh) {
                            bh bhVar2 = (bh) fVar3;
                            i3++;
                            if (bhVar2.Zh == 1 && !TextUtils.isEmpty(bhVar2.getTid())) {
                                bhVar2.Zh = 2;
                                a.b bVar2 = new a.b();
                                bVar2.aMi = bhVar2.getTid();
                                bVar2.bUC = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, jVar.aPM().getFirst_class(), jVar.aPM().getSecond_class(), str, arrayList, adAdSense.xA());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.afl() - j, frsModelController.afj(), frsModelController.afk(), currentTimeMillis - frsModelController.afi());
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.j jVar, bh bhVar) {
        if (bhVar != null && jVar != null) {
            FrsModelController aiR = fVar.aiR();
            com.baidu.tieba.frs.i aiW = fVar.aiW();
            if (aiW != null && aiR != null) {
                if (bhVar.rt() != null && bhVar.rt().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", bhVar.getId()));
                }
                if (jVar != null && jVar.aPM() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.cOT = jVar.gmI == 1;
                    aVar.cOV = jVar.aPM().getId();
                    aVar.cOU = aiR.anJ();
                    com.baidu.tieba.frs.e.b.aoe().a(aVar, bhVar, 1);
                }
                a(aiW, jVar, fVar.getForumId(), true, bhVar);
            }
        }
    }

    public static void a(bf bfVar) {
        if (bfVar != null) {
            String pB = bfVar.pB();
            if (StringUtils.isNull(pB)) {
                pB = bfVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bfVar.getForumId(), bfVar.getForumName(), bfVar.getThreadId(), "tieba.baidu.com/p/" + bfVar.getThreadId(), pB);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.cOV)) {
            ak akVar = new ak("c11942");
            akVar.ac(ImageViewerConfig.FORUM_ID, aVar.cOV);
            akVar.ac("obj_name", str);
            TiebaStatic.log(akVar);
        }
    }

    public static void aL(int i, int i2) {
        TiebaStatic.log(new ak("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
