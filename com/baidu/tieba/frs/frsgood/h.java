package com.baidu.tieba.frs.frsgood;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class h implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(FrsGoodActivity frsGoodActivity) {
        this.aZp = frsGoodActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.v vVar;
        com.baidu.tbadk.core.data.v vVar2;
        com.baidu.tbadk.core.data.v vVar3;
        com.baidu.tbadk.core.data.v vVar4;
        com.baidu.tbadk.core.data.v vVar5;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ub.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uc.getId()) {
            this.aZp.aUA = (com.baidu.tbadk.core.data.v) uVar;
            vVar = this.aZp.aUA;
            if (vVar instanceof com.baidu.tbadk.core.data.c) {
                vVar2 = this.aZp.aUA;
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) vVar2;
                if (cVar.rx()) {
                    return false;
                }
                if (cVar.Ug == 0) {
                    this.aZp.a(cVar, i);
                }
                TiebaStatic.eventStat(this.aZp.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Ud.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Ue.getId() && bdUniqueId.getId() != com.baidu.tbadk.core.data.c.Uf.getId()) {
            this.aZp.aUA = (com.baidu.tbadk.core.data.v) uVar;
            FrsGoodActivity frsGoodActivity = this.aZp;
            vVar3 = this.aZp.aUA;
            frsGoodActivity.mThreadId = vVar3.getId();
            vVar4 = this.aZp.aUA;
            String sp = vVar4.sp();
            if (sp == null || sp.equals("")) {
                this.aZp.aUu = false;
            } else {
                this.aZp.aUu = true;
            }
            FrsGoodActivity frsGoodActivity2 = this.aZp;
            vVar5 = this.aZp.aUA;
            frsGoodActivity2.a(vVar5);
            this.aZp.aZj.LX();
        } else if (uVar instanceof com.baidu.tbadk.core.data.c) {
            com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) uVar;
            if (cVar2.rw()) {
                if (cVar2.Ug == 0) {
                    this.aZp.a(cVar2, i);
                }
                TiebaStatic.eventStat(this.aZp.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        }
        return true;
    }
}
