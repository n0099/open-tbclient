package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1412a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.f1412a = frsActivity;
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
            bnVar = this.f1412a.n;
            long itemId = bnVar.m().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.f1412a;
                bnVar2 = this.f1412a.n;
                frsActivity.H = (com.baidu.tieba.data.az) bnVar2.m().getItem(i);
                FrsActivity frsActivity2 = this.f1412a;
                azVar = this.f1412a.H;
                frsActivity2.l = azVar.a();
                azVar2 = this.f1412a.H;
                String l = azVar2.l();
                if (l == null || l.equals("")) {
                    this.f1412a.m = false;
                } else {
                    this.f1412a.m = true;
                }
                FrsActivity frsActivity3 = this.f1412a;
                azVar3 = this.f1412a.H;
                frsActivity3.b(azVar3);
                bnVar3 = this.f1412a.n;
                bnVar3.k();
            }
        }
        return false;
    }
}
