package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class g implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.f1083a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        az azVar;
        if (i >= 0) {
            azVar = this.f1083a.l;
            azVar.i(i);
            this.f1083a.t = true;
            this.f1083a.s = ((com.baidu.tieba.data.y) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.f1083a.f = 1;
            this.f1083a.b = 3;
            this.f1083a.x();
        }
    }
}
