package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
final class p implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        cm cmVar;
        cm cmVar2;
        com.baidu.tbadk.core.data.o oVar;
        com.baidu.tbadk.core.data.o oVar2;
        com.baidu.tbadk.core.data.o oVar3;
        com.baidu.tbadk.core.data.o oVar4;
        cm cmVar3;
        com.baidu.tbadk.core.data.o oVar5;
        if (i >= 0) {
            cmVar = this.a.r;
            long itemId = cmVar.t().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                cmVar2 = this.a.r;
                frsActivity.L = (com.baidu.tbadk.core.data.o) cmVar2.t().getItem(i);
                oVar = this.a.L;
                if (oVar instanceof com.baidu.tbadk.core.data.b) {
                    oVar5 = this.a.L;
                    com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) oVar5;
                    int g = bVar.g();
                    if (g == 0) {
                        this.a.a(bVar, i);
                    } else if (g == 2) {
                        this.a.a(bVar);
                    }
                } else {
                    FrsActivity frsActivity2 = this.a;
                    oVar2 = this.a.L;
                    frsActivity2.p = oVar2.l();
                    oVar3 = this.a.L;
                    String v = oVar3.v();
                    if (v == null || v.equals("")) {
                        this.a.q = false;
                    } else {
                        this.a.q = true;
                    }
                    FrsActivity frsActivity3 = this.a;
                    oVar4 = this.a.L;
                    FrsActivity.b(frsActivity3, oVar4);
                    cmVar3 = this.a.r;
                    if (cmVar3.a != null) {
                        cmVar3.a.show();
                    }
                }
            }
        }
        return false;
    }
}
