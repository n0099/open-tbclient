package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class r implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bk bkVar;
        if (i >= 0) {
            bkVar = this.a.n;
            bkVar.i(i);
            this.a.u = true;
            this.a.t = ((com.baidu.tieba.data.aa) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.a.i = 1;
            this.a.e = 3;
            this.a.A();
        }
    }
}
