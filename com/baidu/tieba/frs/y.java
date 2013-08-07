package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.bm;
/* loaded from: classes.dex */
class y implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1099a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.f1099a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        az azVar;
        az azVar2;
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        az azVar3;
        if (i >= 0) {
            azVar = this.f1099a.l;
            long itemId = azVar.g().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.f1099a;
                azVar2 = this.f1099a.l;
                frsActivity.F = (bm) azVar2.g().getItem(i);
                FrsActivity frsActivity2 = this.f1099a;
                bmVar = this.f1099a.F;
                frsActivity2.j = bmVar.a();
                bmVar2 = this.f1099a.F;
                String i2 = bmVar2.i();
                if (i2 == null || i2.equals("")) {
                    this.f1099a.k = false;
                } else {
                    this.f1099a.k = true;
                }
                FrsActivity frsActivity3 = this.f1099a;
                bmVar3 = this.f1099a.F;
                frsActivity3.b(bmVar3);
                azVar3 = this.f1099a.l;
                azVar3.e();
            }
        }
        return false;
    }
}
