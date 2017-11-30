package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.frs.entelechy.a.u;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    public static void a(com.baidu.tieba.frs.i iVar, k kVar, String str, boolean z, bd bdVar) {
        com.baidu.tbadk.coreExtra.data.b adAdSense;
        if (iVar != null && kVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.xG()) {
            u alV = iVar == null ? null : iVar.alV();
            List<com.baidu.adp.widget.ListView.f> datas = alV != null ? alV.getDatas() : null;
            List<com.baidu.adp.widget.ListView.f> singletonList = bdVar != null ? Collections.singletonList(bdVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.f fVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.f fVar2 : singletonList) {
                            if (fVar == fVar2 && (fVar2 instanceof bd)) {
                                a.b bVar = new a.b();
                                bVar.aMR = ((bd) fVar2).getTid();
                                bVar.cdj = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.f fVar3 : singletonList) {
                        if (fVar3 instanceof bd) {
                            bd bdVar2 = (bd) fVar3;
                            i3++;
                            if (bdVar2.ZA == 1 && !TextUtils.isEmpty(bdVar2.getTid())) {
                                bdVar2.ZA = 2;
                                a.b bVar2 = new a.b();
                                bVar2.aMR = bdVar2.getTid();
                                bVar2.cdj = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    r.sendFRS(z, kVar.aRf().getFirst_class(), kVar.aRf().getSecond_class(), str, arrayList, adAdSense.xJ());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.ahl() - j, frsModelController.ahj(), frsModelController.ahk(), currentTimeMillis - frsModelController.ahi());
        }
    }

    public static void a(com.baidu.tieba.frs.f fVar, k kVar, bd bdVar) {
        if (bdVar != null && kVar != null) {
            FrsModelController akZ = fVar.akZ();
            com.baidu.tieba.frs.i ale = fVar.ale();
            if (ale != null && akZ != null) {
                if (bdVar.rx() != null && bdVar.rx().getGodInfo() != null) {
                    TiebaStatic.log(new ak("c10806").r("obj_locate", 3).ac("tid", bdVar.getId()));
                }
                if (kVar != null && kVar.aRf() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.cYC = kVar.gwD == 1;
                    aVar.cYE = kVar.aRf().getId();
                    aVar.cYD = akZ.apS();
                    com.baidu.tieba.frs.e.b.aqn().a(aVar, bdVar, 1);
                }
                a(ale, kVar, fVar.getForumId(), true, bdVar);
            }
        }
    }

    public static void a(bb bbVar) {
        if (bbVar != null) {
            String pI = bbVar.pI();
            if (StringUtils.isNull(pI)) {
                pI = bbVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bbVar.getForumId(), bbVar.getForumName(), bbVar.getThreadId(), "tieba.baidu.com/p/" + bbVar.getThreadId(), pI);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.cYE)) {
            ak akVar = new ak("c11942");
            akVar.ac(ImageViewerConfig.FORUM_ID, aVar.cYE);
            akVar.ac("obj_name", str);
            TiebaStatic.log(akVar);
        }
    }

    public static void aL(int i, int i2) {
        TiebaStatic.log(new ak("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
