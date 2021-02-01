package com.baidu.tieba.frs.d;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.entelechy.adapter.al;
import com.baidu.tieba.frs.mc.FrsModelController;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.recapp.s;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class k {
    public static void a(q qVar, FrsViewData frsViewData, String str, boolean z, cb cbVar) {
        com.baidu.tbadk.coreExtra.data.d adAdSense;
        if (qVar != null && frsViewData != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.getInst().getAdAdSense()) != null && adAdSense.bvY()) {
            al cDU = qVar == null ? null : qVar.cDU();
            List<n> datas = cDU != null ? cDU.getDatas() : null;
            List<n> singletonList = cbVar != null ? Collections.singletonList(cbVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (n nVar : datas) {
                        int i2 = i + 1;
                        for (n nVar2 : singletonList) {
                            if (nVar == nVar2 && (nVar2 instanceof cb)) {
                                a.b bVar = new a.b();
                                bVar.amC = ((cb) nVar2).getTid();
                                bVar.iAe = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (n nVar3 : singletonList) {
                        if (nVar3 instanceof cb) {
                            cb cbVar2 = (cb) nVar3;
                            i3++;
                            if (cbVar2.eRW == 1 && !TextUtils.isEmpty(cbVar2.getTid())) {
                                cbVar2.eRW = 2;
                                a.b bVar2 = new a.b();
                                bVar2.amC = cbVar2.getTid();
                                bVar2.iAe = i3;
                                arrayList.add(bVar2);
                            }
                        }
                        i3 = i3;
                    }
                }
                if (arrayList.size() > 0) {
                    s.sendFRS(z, frsViewData.getForum().getFirst_class(), frsViewData.getForum().getSecond_class(), str, arrayList, adAdSense.bwb());
                }
            }
        }
    }

    public static void a(FrsModelController frsModelController, long j) {
        if (frsModelController != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page(TiebaInitialize.OpKey.OP_FRS_ENTER, currentTimeMillis - j, frsModelController.cwD() - j, frsModelController.cwB(), frsModelController.cwC(), currentTimeMillis - frsModelController.cwA());
        }
    }

    public static void a(FrsFragment frsFragment, FrsViewData frsViewData, cb cbVar) {
        if (cbVar != null && frsViewData != null) {
            FrsModelController cCp = frsFragment.cCp();
            q cCu = frsFragment.cCu();
            if (cCu != null && cCp != null) {
                if (cbVar.bnQ() != null && cbVar.bnQ().getGodInfo() != null) {
                    TiebaStatic.log(new ar("c10806").ap("obj_locate", 3).dR("tid", cbVar.getId()));
                }
                if (frsViewData != null && frsViewData.getForum() != null) {
                    com.baidu.tieba.frs.b.b bVar = new com.baidu.tieba.frs.b.b();
                    bVar.jHk = frsViewData.needLog == 1;
                    bVar.jHm = frsViewData.getForum().getId();
                    bVar.jHl = cCp.cJF();
                    if (com.baidu.tieba.frs.b.d.jqq != null) {
                        bVar.jHn = com.baidu.tieba.frs.b.d.jqq.jHn;
                        bVar.jHo = com.baidu.tieba.frs.b.d.jqq.jHo;
                    }
                    com.baidu.tieba.frs.b.c.cKe().a(bVar, cbVar, 1);
                    com.baidu.tieba.frs.b.a.a(cbVar, 1, frsFragment.getUniqueId(), bVar, frsFragment.getTbPageTag());
                }
                a(cCu, frsViewData, frsFragment.getForumId(), true, cbVar);
            }
        }
    }

    public static void a(bz bzVar) {
        if (bzVar != null) {
            String bnm = bzVar.bnm();
            if (StringUtils.isNull(bnm)) {
                bnm = bzVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.c("frs", "CLICK", bzVar.getForumId(), bzVar.getForumName(), bzVar.getThreadId(), "tieba.baidu.com/p/" + bzVar.getThreadId(), bnm);
        }
    }

    public static void a(com.baidu.tieba.frs.b.b bVar, String str) {
        if (!TextUtils.isEmpty(str) && bVar != null && !TextUtils.isEmpty(bVar.jHm)) {
            ar arVar = new ar("c11942");
            arVar.dR("fid", bVar.jHm);
            arVar.dR("obj_name", str);
            TiebaStatic.log(arVar);
        }
    }

    public static void cA(int i, int i2) {
        TiebaStatic.log(new ar("c10320").ap("obj_locate", i).ap("obj_type", i2).ap("obj_name", TbadkCoreApplication.getInst().getStartType()).ap(TiebaInitialize.Params.OBJ_PARAM3, 1));
    }
}
