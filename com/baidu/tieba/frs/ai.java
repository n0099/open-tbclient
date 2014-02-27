package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
/* loaded from: classes.dex */
final class ai implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        bs bsVar;
        bs bsVar2;
        com.baidu.tieba.data.az azVar;
        com.baidu.tieba.data.az azVar2;
        com.baidu.tieba.data.az azVar3;
        com.baidu.tieba.data.az azVar4;
        bs bsVar3;
        com.baidu.tieba.data.az azVar5;
        if (i >= 0) {
            bsVar = this.a.p;
            long itemId = bsVar.m().getItemId(i);
            if (itemId != -1 && itemId != -2) {
                FrsActivity frsActivity = this.a;
                bsVar2 = this.a.p;
                frsActivity.K = (com.baidu.tieba.data.az) bsVar2.m().getItem(i);
                azVar = this.a.K;
                if (azVar instanceof g) {
                    azVar5 = this.a.K;
                    g gVar = (g) azVar5;
                    int x = gVar.x();
                    if (x == 0) {
                        this.a.a(gVar, i);
                    } else if (x == 2) {
                        this.a.a(gVar);
                    }
                } else {
                    FrsActivity frsActivity2 = this.a;
                    azVar2 = this.a.K;
                    frsActivity2.n = azVar2.a();
                    azVar3 = this.a.K;
                    String j2 = azVar3.j();
                    if (j2 == null || j2.equals("")) {
                        this.a.o = false;
                    } else {
                        this.a.o = true;
                    }
                    FrsActivity frsActivity3 = this.a;
                    azVar4 = this.a.K;
                    FrsActivity.b(frsActivity3, azVar4);
                    bsVar3 = this.a.p;
                    if (bsVar3.a != null) {
                        bsVar3.a.show();
                    }
                }
            }
        }
        return false;
    }
}
