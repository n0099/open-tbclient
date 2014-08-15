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
        cu cuVar;
        cu cuVar2;
        com.baidu.tbadk.core.data.n nVar;
        com.baidu.tbadk.core.data.n nVar2;
        com.baidu.tbadk.core.data.n nVar3;
        com.baidu.tbadk.core.data.n nVar4;
        com.baidu.tbadk.core.data.n nVar5;
        cu cuVar3;
        com.baidu.tbadk.core.data.n nVar6;
        if (i >= 0) {
            cuVar = this.a.z;
            long itemId = cuVar.v().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                cuVar2 = this.a.z;
                frsActivity.T = (com.baidu.tbadk.core.data.n) cuVar2.v().getItem(i);
                nVar = this.a.T;
                if (nVar instanceof com.baidu.tbadk.core.data.a) {
                    nVar6 = this.a.T;
                    com.baidu.tbadk.core.data.a aVar = (com.baidu.tbadk.core.data.a) nVar6;
                    if (!aVar.c()) {
                        int i2 = aVar.a;
                        if (i2 == 0) {
                            this.a.a(aVar, i);
                        } else if (i2 == 2) {
                            this.a.a(aVar);
                        }
                        TiebaStatic.eventStat(this.a, "frs_tb_arc", "");
                    }
                } else {
                    nVar2 = this.a.T;
                    if (!(nVar2 instanceof com.baidu.tieba.data.ag)) {
                        FrsActivity frsActivity2 = this.a;
                        nVar3 = this.a.T;
                        frsActivity2.x = nVar3.h();
                        nVar4 = this.a.T;
                        String t = nVar4.t();
                        if (t == null || t.equals("")) {
                            this.a.y = false;
                        } else {
                            this.a.y = true;
                        }
                        FrsActivity frsActivity3 = this.a;
                        nVar5 = this.a.T;
                        frsActivity3.b(nVar5);
                        cuVar3 = this.a.z;
                        cuVar3.s();
                    }
                }
            }
        }
        return false;
    }
}
