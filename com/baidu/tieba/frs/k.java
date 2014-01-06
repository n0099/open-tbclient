package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class k implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        bo boVar;
        bo boVar2;
        com.baidu.tieba.data.bb bbVar;
        com.baidu.tieba.data.bb bbVar2;
        com.baidu.tieba.data.bb bbVar3;
        bo boVar3;
        if (i >= 0) {
            boVar = this.a.n;
            long itemId = boVar.n().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                boVar2 = this.a.n;
                frsActivity.G = (com.baidu.tieba.data.bb) boVar2.n().getItem(i);
                FrsActivity frsActivity2 = this.a;
                bbVar = this.a.G;
                frsActivity2.l = bbVar.a();
                bbVar2 = this.a.G;
                String l = bbVar2.l();
                if (l == null || l.equals("")) {
                    this.a.m = false;
                } else {
                    this.a.m = true;
                }
                FrsActivity frsActivity3 = this.a;
                bbVar3 = this.a.G;
                frsActivity3.b(bbVar3);
                boVar3 = this.a.n;
                boVar3.k();
            }
        }
        return false;
    }
}
