package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class o implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ct ctVar;
        ct ctVar2;
        com.baidu.tbadk.core.data.n nVar;
        com.baidu.tbadk.core.data.n nVar2;
        com.baidu.tbadk.core.data.n nVar3;
        com.baidu.tbadk.core.data.n nVar4;
        ct ctVar3;
        com.baidu.tbadk.core.data.n nVar5;
        if (i >= 0) {
            ctVar = this.a.w;
            long itemId = ctVar.v().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                ctVar2 = this.a.w;
                frsActivity.Q = (com.baidu.tbadk.core.data.n) ctVar2.v().getItem(i);
                nVar = this.a.Q;
                if (nVar instanceof com.baidu.tbadk.core.data.b) {
                    nVar5 = this.a.Q;
                    com.baidu.tbadk.core.data.b bVar = (com.baidu.tbadk.core.data.b) nVar5;
                    int k = bVar.k();
                    if (k == 0) {
                        this.a.a(bVar, i);
                    } else if (k == 2) {
                        this.a.a(bVar);
                    }
                    TiebaStatic.eventStat(this.a, "frs_tb_arc", "");
                } else {
                    FrsActivity frsActivity2 = this.a;
                    nVar2 = this.a.Q;
                    frsActivity2.u = nVar2.p();
                    nVar3 = this.a.Q;
                    String B = nVar3.B();
                    if (B == null || B.equals("")) {
                        this.a.v = false;
                    } else {
                        this.a.v = true;
                    }
                    FrsActivity frsActivity3 = this.a;
                    nVar4 = this.a.Q;
                    frsActivity3.b(nVar4);
                    ctVar3 = this.a.w;
                    ctVar3.s();
                }
            }
        }
        return false;
    }
}
