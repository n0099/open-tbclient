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
        az azVar;
        az azVar2;
        com.baidu.tieba.data.ba baVar;
        com.baidu.tieba.data.ba baVar2;
        com.baidu.tieba.data.ba baVar3;
        az azVar3;
        if (i >= 0) {
            azVar = this.a.l;
            long itemId = azVar.g().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                azVar2 = this.a.l;
                frsActivity.F = (com.baidu.tieba.data.ba) azVar2.g().getItem(i);
                FrsActivity frsActivity2 = this.a;
                baVar = this.a.F;
                frsActivity2.j = baVar.a();
                baVar2 = this.a.F;
                String i2 = baVar2.i();
                if (i2 == null || i2.equals("")) {
                    this.a.k = false;
                } else {
                    this.a.k = true;
                }
                FrsActivity frsActivity3 = this.a;
                baVar3 = this.a.F;
                frsActivity3.b(baVar3);
                azVar3 = this.a.l;
                azVar3.e();
            }
        }
        return false;
    }
}
