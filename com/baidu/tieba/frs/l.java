package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class l implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1356a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.f1356a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        bn bnVar;
        bn bnVar2;
        com.baidu.tieba.data.ba baVar;
        com.baidu.tieba.data.ba baVar2;
        com.baidu.tieba.data.ba baVar3;
        bn bnVar3;
        if (i >= 0) {
            bnVar = this.f1356a.n;
            long itemId = bnVar.l().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.f1356a;
                bnVar2 = this.f1356a.n;
                frsActivity.H = (com.baidu.tieba.data.ba) bnVar2.l().getItem(i);
                FrsActivity frsActivity2 = this.f1356a;
                baVar = this.f1356a.H;
                frsActivity2.l = baVar.a();
                baVar2 = this.f1356a.H;
                String l = baVar2.l();
                if (l == null || l.equals("")) {
                    this.f1356a.m = false;
                } else {
                    this.f1356a.m = true;
                }
                FrsActivity frsActivity3 = this.f1356a;
                baVar3 = this.f1356a.H;
                frsActivity3.b(baVar3);
                bnVar3 = this.f1356a.n;
                bnVar3.j();
            }
        }
        return false;
    }
}
