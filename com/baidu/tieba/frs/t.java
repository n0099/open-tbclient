package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class t implements com.baidu.adp.widget.ListView.w {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.w
    public boolean b(View view, com.baidu.adp.widget.ListView.u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        com.baidu.tbadk.core.data.v vVar;
        com.baidu.tbadk.core.data.v vVar2;
        com.baidu.tbadk.core.data.v vVar3;
        com.baidu.tbadk.core.data.v vVar4;
        com.baidu.tbadk.core.data.v vVar5;
        bl blVar;
        if (bdUniqueId == null) {
            return false;
        }
        if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ub.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uc.getId()) {
            this.this$0.aUA = (com.baidu.tbadk.core.data.v) uVar;
            vVar = this.this$0.aUA;
            if (vVar instanceof com.baidu.tbadk.core.data.c) {
                vVar2 = this.this$0.aUA;
                com.baidu.tbadk.core.data.c cVar = (com.baidu.tbadk.core.data.c) vVar2;
                if (cVar.rx()) {
                    return false;
                }
                if (cVar.Ug == 0) {
                    this.this$0.a(cVar, i);
                }
                TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "frs_tb_arc", "");
            }
        } else if (bdUniqueId.getId() != com.baidu.tieba.tbadkCore.y.cHK.getId()) {
            if (bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ud.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Ue.getId() || bdUniqueId.getId() == com.baidu.tbadk.core.data.c.Uf.getId()) {
                if (uVar instanceof com.baidu.tbadk.core.data.c) {
                    com.baidu.tbadk.core.data.c cVar2 = (com.baidu.tbadk.core.data.c) uVar;
                    if (cVar2.rw()) {
                        if (cVar2.Ug == 0) {
                            this.this$0.a(cVar2, i);
                        }
                        TiebaStatic.eventStat(this.this$0.getPageContext().getPageActivity(), "frs_tb_arc", "");
                    }
                }
            } else if (uVar instanceof com.baidu.tbadk.core.data.v) {
                this.this$0.aUA = (com.baidu.tbadk.core.data.v) uVar;
                FrsActivity frsActivity = this.this$0;
                vVar3 = this.this$0.aUA;
                frsActivity.mThreadId = vVar3.getId();
                vVar4 = this.this$0.aUA;
                String sp = vVar4.sp();
                if (sp == null || sp.equals("")) {
                    this.this$0.aUu = false;
                } else {
                    this.this$0.aUu = true;
                }
                FrsActivity frsActivity2 = this.this$0;
                vVar5 = this.this$0.aUA;
                frsActivity2.a(vVar5);
                blVar = this.this$0.aUw;
                blVar.LX();
            }
        }
        return true;
    }
}
