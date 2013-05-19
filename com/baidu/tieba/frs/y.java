package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class y implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        ba baVar;
        ba baVar2;
        com.baidu.tieba.a.bb bbVar;
        com.baidu.tieba.a.bb bbVar2;
        com.baidu.tieba.a.bb bbVar3;
        ba baVar3;
        if (i >= 0) {
            baVar = this.a.l;
            long itemId = baVar.g().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                baVar2 = this.a.l;
                frsActivity.F = (com.baidu.tieba.a.bb) baVar2.g().getItem(i);
                FrsActivity frsActivity2 = this.a;
                bbVar = this.a.F;
                frsActivity2.j = bbVar.a();
                bbVar2 = this.a.F;
                String i2 = bbVar2.i();
                if (i2 == null || i2.equals("")) {
                    this.a.k = false;
                } else {
                    this.a.k = true;
                }
                FrsActivity frsActivity3 = this.a;
                bbVar3 = this.a.F;
                frsActivity3.b(bbVar3);
                baVar3 = this.a.l;
                baVar3.e();
            }
        }
        return false;
    }
}
