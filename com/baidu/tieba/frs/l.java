package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.data.az azVar;
        com.baidu.tieba.data.az azVar2;
        com.baidu.tieba.data.az azVar3;
        bn bnVar3;
        if (i >= 0) {
            bnVar = this.a.n;
            long itemId = bnVar.m().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                bnVar2 = this.a.n;
                frsActivity.H = (com.baidu.tieba.data.az) bnVar2.m().getItem(i);
                FrsActivity frsActivity2 = this.a;
                azVar = this.a.H;
                frsActivity2.l = azVar.a();
                azVar2 = this.a.H;
                String l = azVar2.l();
                if (l == null || l.equals("")) {
                    this.a.m = false;
                } else {
                    this.a.m = true;
                }
                FrsActivity frsActivity3 = this.a;
                azVar3 = this.a.H;
                frsActivity3.b(azVar3);
                bnVar3 = this.a.n;
                bnVar3.k();
            }
        }
        return false;
    }
}
