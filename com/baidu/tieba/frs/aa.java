package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class aa implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1065a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.f1065a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        bb bbVar;
        bb bbVar2;
        com.baidu.tieba.data.bh bhVar;
        com.baidu.tieba.data.bh bhVar2;
        com.baidu.tieba.data.bh bhVar3;
        bb bbVar3;
        if (i >= 0) {
            bbVar = this.f1065a.l;
            long itemId = bbVar.i().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.f1065a;
                bbVar2 = this.f1065a.l;
                frsActivity.F = (com.baidu.tieba.data.bh) bbVar2.i().getItem(i);
                FrsActivity frsActivity2 = this.f1065a;
                bhVar = this.f1065a.F;
                frsActivity2.j = bhVar.a();
                bhVar2 = this.f1065a.F;
                String i2 = bhVar2.i();
                if (i2 == null || i2.equals("")) {
                    this.f1065a.k = false;
                } else {
                    this.f1065a.k = true;
                }
                FrsActivity frsActivity3 = this.f1065a;
                bhVar3 = this.f1065a.F;
                frsActivity3.b(bhVar3);
                bbVar3 = this.f1065a.l;
                bbVar3.g();
            }
        }
        return false;
    }
}
