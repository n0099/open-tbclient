package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class g implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.f1100a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        bb bbVar;
        if (i >= 0) {
            bbVar = this.f1100a.l;
            bbVar.i(i);
            this.f1100a.t = true;
            this.f1100a.s = ((com.baidu.tieba.data.aa) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.f1100a.f = 1;
            this.f1100a.b = 3;
            this.f1100a.B();
        }
    }
}
