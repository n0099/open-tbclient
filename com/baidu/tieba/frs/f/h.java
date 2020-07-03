package com.baidu.tieba.frs.f;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bs;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.a.al;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.recapp.r;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes9.dex */
public class h {
    public static void a(p pVar, FrsViewData frsViewData, String str, boolean z, bu buVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (pVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.aZP()) {
            al bZw = pVar == null ? null : pVar.bZw();
            List<q> datas = bZw != null ? bZw.getDatas() : null;
            List<q> singletonList = buVar != null ? Collections.singletonList(buVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (q qVar : datas) {
                        int i2 = i + 1;
                        for (q qVar2 : singletonList) {
                            if (qVar == qVar2 && (qVar2 instanceof bu)) {
                                a.b bVar = new a.b();
                                bVar.ajO = ((bu) qVar2).getTid();
                                bVar.gUb = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (q qVar3 : singletonList) {
                        if (qVar3 instanceof bu) {
                            bu buVar2 = (bu) qVar3;
                            i3++;
                            if (buVar2.dMR == 1 && !TextUtils.isEmpty(buVar2.getTid())) {
                                buVar2.dMR = 2;
                                a.b bVar2 = new a.b();
                                bVar2.ajO = buVar2.getTid();
                                bVar2.gUb = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    r.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.aZS());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.bSv() - j, frsModelController.bSt(), frsModelController.bSu(), currentTimeMillis - frsModelController.bSs());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, bu buVar) {
        if (buVar != null && frsViewData != null) {
            FrsModelController bXU = frsFragment.bXU();
            p bXZ = frsFragment.bXZ();
            if (bXZ != null && bXU != null) {
                if (buVar.aSp() != null && buVar.aSp().getGodInfo() != null) {
                    TiebaStatic.log(new ao("c10806").ag("obj_locate", 3).dk("tid", buVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.d.b bVar = new com.baidu.tieba.frs.d.b();
                    bVar.hWM = frsViewData.needLog == 1;
                    bVar.hWO = frsViewData.getForum().getId();
                    bVar.hWN = bXU.cdR();
                    if (com.baidu.tieba.frs.d.d.hIE != null) {
                        bVar.hWP = com.baidu.tieba.frs.d.d.hIE.hWP;
                        bVar.hWQ = com.baidu.tieba.frs.d.d.hIE.hWQ;
                    }
                    com.baidu.tieba.frs.d.c.ceq().a(bVar, buVar, 1);
                    com.baidu.tieba.frs.d.a.a(buVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(bXZ, frsViewData, frsFragment.getForumId(), true, buVar);
            }
        }
    }

    public static void a(bs bsVar) {
        if (bsVar != null) {
            String aRL = bsVar.aRL();
            if (StringUtils.isNull(aRL)) {
                aRL = bsVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.a("frs", "CLICK", bsVar.getForumId(), bsVar.getForumName(), bsVar.getThreadId(), "tieba.baidu.com/p/" + bsVar.getThreadId(), aRL);
        }
    }

    public static void a(com.baidu.tieba.frs.d.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.hWO)) {
            ao aoVar = new ao("c11942");
            aoVar.dk("fid", bVar.hWO);
            aoVar.dk("obj_name", str);
            TiebaStatic.log(aoVar);
        }
    }

    public static void cj(int i, int i2) {
        TiebaStatic.log(new ao("c10320").ag("obj_locate", i).ag("obj_type", i2));
    }
}
