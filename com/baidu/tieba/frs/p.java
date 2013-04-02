package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.a.ax;
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
        lVar = this.a.M;
        if (lVar != null) {
            i--;
        }
        if (i >= 0) {
            aaVar = this.a.y;
            long itemId = aaVar.getItemId(i);
            if (itemId != -1 && itemId != -2 && itemId != -3) {
                aaVar2 = this.a.y;
                ax axVar = (ax) aaVar2.getItem(i);
                this.a.o = axVar.a();
                String k = axVar.k();
                if (k == null || k.equals("")) {
                    this.a.p = false;
                } else {
                    this.a.p = true;
                }
                this.a.b(axVar);
                this.a.c.show();
            }
        }
        return false;
    }
}
