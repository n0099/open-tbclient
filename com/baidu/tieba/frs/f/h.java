package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bt;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.al;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes16.dex */
public class h {
    public static void a(p pVar, FrsViewData frsViewData, String str, boolean z, bv bvVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (pVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.bdM()) {
            al ccU = pVar == null ? null : pVar.ccU();
            List<q> datas = ccU != null ? ccU.getDatas() : null;
            List<q> singletonList = bvVar != null ? Collections.singletonList(bvVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (q qVar : datas) {
                        int i2 = i + 1;
                        for (q qVar2 : singletonList) {
                            if (qVar == qVar2 && (qVar2 instanceof bv)) {
                                a.b bVar = new a.b();
                                bVar.ajJ = ((bv) qVar2).getTid();
                                bVar.gZF = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (q qVar3 : singletonList) {
                        if (qVar3 instanceof bv) {
                            bv bvVar2 = (bv) qVar3;
                            i3++;
                            if (bvVar2.dTc == 1 && !TextUtils.isEmpty(bvVar2.getTid())) {
                                bvVar2.dTc = 2;
                                a.b bVar2 = new a.b();
                                bVar2.ajJ = bvVar2.getTid();
                                bVar2.gZF = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.bdP());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.bVN() - j, frsModelController.bVL(), frsModelController.bVM(), currentTimeMillis - frsModelController.bVK());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bv bvVar) {
        if (bvVar != null && frsViewData != null) {
            FrsModelController cbr = frsFragment.cbr();
            p cbw = frsFragment.cbw();
            if (cbw != null && cbr != null) {
                if (bvVar.aWl() != null && bvVar.aWl().getGodInfo() != null) {
                    TiebaStatic.log(new ap("c10806").ah("obj_locate", 3).dn("tid", bvVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.icK = frsViewData.needLog == 1;
                    bVar.icM = frsViewData.getForum().getId();
                    bVar.icL = cbr.chr();
                    if (com.baidu.tieba.frs.d.d.hOE != null) {
                        bVar.icN = com.baidu.tieba.frs.d.d.hOE.icN;
                        bVar.icO = com.baidu.tieba.frs.d.d.hOE.icO;
                    }
                    com.baidu.tieba.frs.d.c.chQ().a(bVar, bvVar, 1);
                    com.baidu.tieba.frs.d.a.a(bvVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(cbw, frsViewData, frsFragment.getForumId(), true, bvVar);
            }
        }
    }

    public static void a(bt btVar) {
        if (btVar != null) {
            String aVH = btVar.aVH();
            if (StringUtils.isNull(aVH)) {
                aVH = btVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", btVar.getForumId(), btVar.getForumName(), btVar.getThreadId(), "tieba.baidu.com/p/" + btVar.getThreadId(), aVH);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.icM)) {
            ap apVar = new ap("c11942");
            apVar.dn("fid", bVar.icM);
            apVar.dn("obj_name", str);
            TiebaStatic.log(apVar);
        }
    }

    public static void cm(int i, int i2) {
        TiebaStatic.log(new ap("c10320").ah("obj_locate", i).ah("obj_type", i2));
    }
}
