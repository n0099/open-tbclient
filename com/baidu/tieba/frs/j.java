package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class j implements AdapterView.OnItemLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1286a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(FrsActivity frsActivity) {
        this.f1286a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        ba baVar;
        ba baVar2;
        com.baidu.tieba.data.bf bfVar;
        com.baidu.tieba.data.bf bfVar2;
        com.baidu.tieba.data.bf bfVar3;
        ba baVar3;
        if (i >= 0) {
            baVar = this.f1286a.o;
            long itemId = baVar.h().getItemId(i);
            if (itemId != -100 && itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.f1286a;
                baVar2 = this.f1286a.o;
                frsActivity.H = (com.baidu.tieba.data.bf) baVar2.h().getItem(i);
                FrsActivity frsActivity2 = this.f1286a;
                bfVar = this.f1286a.H;
                frsActivity2.m = bfVar.a();
                bfVar2 = this.f1286a.H;
                String i2 = bfVar2.i();
                if (i2 == null || i2.equals("")) {
                    this.f1286a.n = false;
                } else {
                    this.f1286a.n = true;
                }
                FrsActivity frsActivity3 = this.f1286a;
                bfVar3 = this.f1286a.H;
                frsActivity3.b(bfVar3);
                baVar3 = this.f1286a.o;
                baVar3.f();
            }
        }
        return false;
    }
}
