package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class ai implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        br brVar;
        br brVar2;
        com.baidu.tieba.data.az azVar;
        com.baidu.tieba.data.az azVar2;
        com.baidu.tieba.data.az azVar3;
        com.baidu.tieba.data.az azVar4;
        br brVar3;
        com.baidu.tieba.data.az azVar5;
        if (i >= 0) {
            brVar = this.a.p;
            long itemId = brVar.n().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                brVar2 = this.a.p;
                frsActivity.K = (com.baidu.tieba.data.az) brVar2.n().getItem(i);
                azVar = this.a.K;
                if (azVar instanceof g) {
                    azVar5 = this.a.K;
                    g gVar = (g) azVar5;
                    int A = gVar.A();
                    if (A == 0) {
                        this.a.a(gVar, i);
                    } else if (A == 2) {
                        this.a.a(gVar);
                    }
                } else {
                    FrsActivity frsActivity2 = this.a;
                    azVar2 = this.a.K;
                    frsActivity2.n = azVar2.a();
                    azVar3 = this.a.K;
                    String l = azVar3.l();
                    if (l == null || l.equals("")) {
                        this.a.o = false;
                    } else {
                        this.a.o = true;
                    }
                    FrsActivity frsActivity3 = this.a;
                    azVar4 = this.a.K;
                    frsActivity3.b(azVar4);
                    brVar3 = this.a.p;
                    brVar3.k();
                }
            }
        }
        return false;
    }
}
