package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
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
public class g {
    public static void a(com.baidu.tieba.frs.i iVar, l lVar, String str, boolean z, bd bdVar) {
        com.baidu.tbadk.coreExtra.data.c adAdSense;
        if (iVar != null && lVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.yh()) {
            q aqt = iVar == null ? null : iVar.aqt();
            List<com.baidu.adp.widget.ListView.h> datas = aqt != null ? aqt.getDatas() : null;
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
                                bVar.aNu = ((bd) hVar2).getTid();
                                bVar.crD = i2;
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
                            if (bdVar2.aaC == 1 && !TextUtils.isEmpty(bdVar2.getTid())) {
                                bdVar2.aaC = 2;
                                a.b bVar2 = new a.b();
                                bVar2.aNu = bdVar2.getTid();
                                bVar2.crD = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, lVar.aVq().getFirst_class(), lVar.aVq().getSecond_class(), str, arrayList, adAdSense.yk());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, frsModelController.alf() - j, frsModelController.ald(), frsModelController.ale(), currentTimeMillis - frsModelController.alc());
        }
    }

    public static void a(FrsFragment frsFragment, l lVar, bd bdVar) {
        if (bdVar != null && lVar != null) {
            FrsModelController aph = frsFragment.aph();
            com.baidu.tieba.frs.i apn = frsFragment.apn();
            if (apn != null && aph != null) {
                if (bdVar.rQ() != null && bdVar.rQ().getGodInfo() != null) {
                    TiebaStatic.log(new al("c10806").r("obj_locate", 3).ac("tid", bdVar.getId()));
                }
                if (lVar != null && lVar.aVq() != null) {
                    com.baidu.tieba.frs.e.a aVar = new com.baidu.tieba.frs.e.a();
                    aVar.dom = lVar.gtS == 1;
                    aVar.doo = lVar.aVq().getId();
                    aVar.don = aph.aun();
                    if (com.baidu.tieba.frs.e.c.doy != null) {
                        aVar.dop = com.baidu.tieba.frs.e.c.doy.dop;
                        aVar.doq = com.baidu.tieba.frs.e.c.doy.doq;
                    }
                    com.baidu.tieba.frs.e.b.auH().a(aVar, bdVar, 1);
                }
                a(apn, lVar, frsFragment.getForumId(), true, bdVar);
            }
        }
    }

    public static void a(bb bbVar) {
        if (bbVar != null) {
            String qw = bbVar.qw();
            if (StringUtils.isNull(qw)) {
                qw = bbVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bbVar.getForumId(), bbVar.getForumName(), bbVar.getThreadId(), "tieba.baidu.com/p/" + bbVar.getThreadId(), qw);
        }
    }

    public static void a(com.baidu.tieba.frs.e.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.doo)) {
            al alVar = new al("c11942");
            alVar.ac(ImageViewerConfig.FORUM_ID, aVar.doo);
            alVar.ac("obj_name", str);
            TiebaStatic.log(alVar);
        }
    }

    public static void aL(int i, int i2) {
        TiebaStatic.log(new al("c10320").r("obj_locate", i).r("obj_type", i2));
    }
}
