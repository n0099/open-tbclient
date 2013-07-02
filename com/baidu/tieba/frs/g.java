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
        az azVar;
        if (i >= 0) {
            azVar = this.a.l;
            azVar.i(i);
            this.a.t = true;
            this.a.s = ((com.baidu.tieba.data.u) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.a.f = 1;
            this.a.b = 3;
            this.a.z();
        }
    }
}
