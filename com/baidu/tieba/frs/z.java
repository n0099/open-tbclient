package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class z implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1167a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(FrsActivity frsActivity) {
        this.f1167a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ba baVar;
        ba baVar2;
        com.baidu.tieba.data.bh bhVar;
        com.baidu.tieba.data.bh bhVar2;
        com.baidu.tieba.data.bh bhVar3;
        ba baVar3;
        if (i >= 0) {
            baVar = this.f1167a.o;
            long itemId = baVar.g().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.f1167a;
                baVar2 = this.f1167a.o;
                frsActivity.H = (com.baidu.tieba.data.bh) baVar2.g().getItem(i);
                FrsActivity frsActivity2 = this.f1167a;
                bhVar = this.f1167a.H;
                frsActivity2.m = bhVar.a();
                bhVar2 = this.f1167a.H;
                String i2 = bhVar2.i();
                if (i2 == null || i2.equals("")) {
                    this.f1167a.n = false;
                } else {
                    this.f1167a.n = true;
                }
                FrsActivity frsActivity3 = this.f1167a;
                bhVar3 = this.f1167a.H;
                frsActivity3.b(bhVar3);
                baVar3 = this.f1167a.o;
                baVar3.e();
            }
        }
        return false;
    }
}
