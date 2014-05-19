package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class p implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        cs csVar;
        cs csVar2;
        com.baidu.tbadk.core.data.o oVar;
        com.baidu.tbadk.core.data.o oVar2;
        com.baidu.tbadk.core.data.o oVar3;
        com.baidu.tbadk.core.data.o oVar4;
        cs csVar3;
        com.baidu.tbadk.core.data.o oVar5;
        if (i >= 0) {
            csVar = this.a.w;
            long itemId = csVar.v().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                csVar2 = this.a.w;
                frsActivity.Q = (com.baidu.tbadk.core.data.o) csVar2.v().getItem(i);
                oVar = this.a.Q;
                if (oVar instanceof com.baidu.tbadk.core.data.b) {
                    oVar5 = this.a.Q;
                    com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) oVar5;
                    int g = bVar.g();
                    if (g == 0) {
                        this.a.a(bVar, i);
                    } else if (g == 2) {
                        this.a.a(bVar);
                    }
                } else {
                    FrsActivity frsActivity2 = this.a;
                    oVar2 = this.a.Q;
                    frsActivity2.u = oVar2.k();
                    oVar3 = this.a.Q;
                    String w = oVar3.w();
                    if (w == null || w.equals("")) {
                        this.a.v = false;
                    } else {
                        this.a.v = true;
                    }
                    FrsActivity frsActivity3 = this.a;
                    oVar4 = this.a.Q;
                    frsActivity3.b(oVar4);
                    csVar3 = this.a.w;
                    csVar3.s();
                }
            }
        }
        return false;
    }
}
