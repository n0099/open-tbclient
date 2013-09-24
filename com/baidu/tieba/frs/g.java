package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class g implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1148a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.f1148a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ba baVar;
        if (i >= 0) {
            baVar = this.f1148a.o;
            baVar.g(i);
            this.f1148a.v = true;
            this.f1148a.u = ((com.baidu.tieba.data.aa) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.f1148a.j = 1;
            this.f1148a.d = 3;
            this.f1148a.E();
        }
    }
}
