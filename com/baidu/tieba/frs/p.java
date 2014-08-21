package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class p implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        cv cvVar;
        cv cvVar2;
        com.baidu.tbadk.core.data.n nVar;
        com.baidu.tbadk.core.data.n nVar2;
        com.baidu.tbadk.core.data.n nVar3;
        com.baidu.tbadk.core.data.n nVar4;
        com.baidu.tbadk.core.data.n nVar5;
        cv cvVar3;
        com.baidu.tbadk.core.data.n nVar6;
        if (i >= 0) {
            cvVar = this.a.B;
            long itemId = cvVar.v().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                cvVar2 = this.a.B;
                frsActivity.V = (com.baidu.tbadk.core.data.n) cvVar2.v().getItem(i);
                nVar = this.a.V;
                if (nVar instanceof com.baidu.tbadk.core.data.a) {
                    nVar6 = this.a.V;
                    com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) nVar6;
                    if (!aVar.c()) {
                        if (aVar.a == 0) {
                            this.a.a(aVar, i);
                        }
                        TiebaStatic.eventStat(this.a, "frs_tb_arc", "");
                    }
                } else {
                    nVar2 = this.a.V;
                    if (!(nVar2 instanceof com.baidu.tieba.data.ag)) {
                        FrsActivity frsActivity2 = this.a;
                        nVar3 = this.a.V;
                        frsActivity2.y = nVar3.h();
                        nVar4 = this.a.V;
                        String t = nVar4.t();
                        if (t == null || t.equals("")) {
                            this.a.A = false;
                        } else {
                            this.a.A = true;
                        }
                        FrsActivity frsActivity3 = this.a;
                        nVar5 = this.a.V;
                        frsActivity3.b(nVar5);
                        cvVar3 = this.a.B;
                        cvVar3.s();
                    }
                }
            }
        }
        return false;
    }
}
