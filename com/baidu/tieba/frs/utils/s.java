package com.baidu.tieba.frs.utils;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.entelechy.a.am;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public class s {
    public static void a(ax axVar, com.baidu.tieba.tbadkCore.o oVar, String str, boolean z, bg bgVar) {
        com.baidu.tbadk.coreExtra.data.a adAdSense;
        if (axVar != null && oVar != null && !TextUtils.isEmpty(str) && (adAdSense = TbadkCoreApplication.m9getInst().getAdAdSense()) != null && adAdSense.xs()) {
            am Xu = axVar == null ? null : axVar.Xu();
            List<com.baidu.adp.widget.ListView.v> datas = Xu != null ? Xu.getDatas() : null;
            List<com.baidu.adp.widget.ListView.v> singletonList = bgVar != null ? Collections.singletonList(bgVar) : datas;
            if (singletonList != null && datas != null) {
                ArrayList arrayList = new ArrayList();
                if (z) {
                    int i = 0;
                    for (com.baidu.adp.widget.ListView.v vVar : datas) {
                        int i2 = i + 1;
                        for (com.baidu.adp.widget.ListView.v vVar2 : singletonList) {
                            if (vVar == vVar2 && (vVar2 instanceof bg)) {
                                a.b bVar = new a.b();
                                bVar.aRf = ((bg) vVar2).getTid();
                                bVar.bed = i2;
                                arrayList.add(bVar);
                            }
                        }
                        i = i2;
                    }
                } else {
                    int i3 = 0;
                    for (com.baidu.adp.widget.ListView.v vVar3 : singletonList) {
                        if (vVar3 instanceof bg) {
                            bg bgVar2 = (bg) vVar3;
                            i3++;
                            if (bgVar2.Ua == 1 && !TextUtils.isEmpty(bgVar2.getTid())) {
                                bgVar2.Ua = 2;
                                a.b bVar2 = new a.b();
                                bVar2.aRf = bgVar2.getTid();
                                bVar2.bed = i3;
                                arrayList.add(bVar2);
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    com.baidu.tieba.recapp.l.sendFRS(z, oVar.aIk().getFirst_class(), oVar.aIk().getSecond_class(), str, arrayList, adAdSense.xu());
                }
            }
        }
    }

    public static void a(com.baidu.tieba.frs.d.i iVar, long j) {
        if (iVar != null) {
            long currentTimeMillis = System.currentTimeMillis();
            TiebaStatic.page("op_frs_enter", currentTimeMillis - j, iVar.Tu() - j, iVar.Ts(), iVar.Tt(), currentTimeMillis - iVar.Tr());
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.o oVar, bg bgVar) {
        if (bgVar != null && oVar != null) {
            com.baidu.tieba.frs.d.i Wh = frsActivity.Wh();
            ax Wo = frsActivity.Wo();
            if (Wo != null && Wh != null) {
                if (bgVar.getAuthor() != null && bgVar.getAuthor().getGodInfo() != null) {
                    TiebaStatic.log(new at("c10806").s("obj_locate", 3).ab("tid", bgVar.getId()));
                }
                if (oVar != null && oVar.aIk() != null) {
                    com.baidu.tieba.frs.g.a aVar = new com.baidu.tieba.frs.g.a();
                    aVar.bML = oVar.fdP == 1;
                    aVar.bMN = oVar.aIk().getId();
                    aVar.bMM = Wh.aaU();
                    com.baidu.tieba.frs.g.b.abq().a(aVar, bgVar, 1);
                }
                a(Wo, oVar, frsActivity.getForumId(), true, bgVar);
            }
        }
    }

    public static void a(be beVar) {
        if (beVar != null) {
            String pw = beVar.pw();
            if (StringUtils.isNull(pw)) {
                pw = beVar.getTaskId();
            }
            com.baidu.tieba.tbadkCore.d.a.b("frs", "CLICK", beVar.getForumId(), beVar.getForumName(), beVar.getThreadId(), "tieba.baidu.com/p/" + beVar.getThreadId(), pw);
        }
    }

    public static void a(com.baidu.tieba.frs.g.a aVar, String str) {
        if (!TextUtils.isEmpty(str) && aVar != null && !TextUtils.isEmpty(aVar.bMN)) {
            at atVar = new at("c11942");
            atVar.ab("fid", aVar.bMN);
            atVar.ab("obj_name", str);
            TiebaStatic.log(atVar);
        }
    }
}
