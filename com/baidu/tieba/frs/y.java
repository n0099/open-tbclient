package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.data.bm;
/* loaded from: classes.dex */
class y implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.f1101a = frsActivity;
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
            azVar = this.f1101a.l;
            long itemId = azVar.g().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.f1101a;
                azVar2 = this.f1101a.l;
                frsActivity.F = (bm) azVar2.g().getItem(i);
                FrsActivity frsActivity2 = this.f1101a;
                bmVar = this.f1101a.F;
                frsActivity2.j = bmVar.a();
                bmVar2 = this.f1101a.F;
                String i2 = bmVar2.i();
                if (i2 == null || i2.equals("")) {
                    this.f1101a.k = false;
                } else {
                    this.f1101a.k = true;
                }
                FrsActivity frsActivity3 = this.f1101a;
                bmVar3 = this.f1101a.F;
                frsActivity3.b(bmVar3);
                azVar3 = this.f1101a.l;
                azVar3.e();
            }
        }
        return false;
    }
}
