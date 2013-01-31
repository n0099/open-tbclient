package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.a.av;
/* loaded from: classes.dex */
class p implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.view.l lVar;
        aa aaVar;
        aa aaVar2;
        lVar = this.a.L;
        if (lVar != null) {
            i--;
        }
        if (i >= 0) {
            aaVar = this.a.x;
            long itemId = aaVar.getItemId(i);
            if (itemId != -1 && itemId != -2 && itemId != -3) {
                aaVar2 = this.a.x;
                av avVar = (av) aaVar2.getItem(i);
                this.a.o = avVar.a();
                this.a.b(avVar);
                this.a.c.show();
            }
        }
        return false;
    }
}
