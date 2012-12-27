package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.tieba.a.as;
/* loaded from: classes.dex */
class q implements AdapterView.OnItemLongClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
        com.baidu.tieba.view.l lVar;
        ab abVar;
        ab abVar2;
        lVar = this.a.K;
        if (lVar != null) {
            i--;
        }
        if (i >= 0) {
            abVar = this.a.w;
            long itemId = abVar.getItemId(i);
            if (itemId != -1 && itemId != -2 && itemId != -3) {
                abVar2 = this.a.w;
                as asVar = (as) abVar2.getItem(i);
                this.a.n = asVar.a();
                this.a.b(asVar);
                this.a.b.show();
            }
        }
        return false;
    }
}
