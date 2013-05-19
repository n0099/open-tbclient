package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class g implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        ba baVar;
        if (i >= 0) {
            baVar = this.a.l;
            baVar.i(i);
            this.a.t = true;
            this.a.s = ((com.baidu.tieba.a.v) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.a.h = 1;
            this.a.d = 3;
            this.a.z();
        }
    }
}
