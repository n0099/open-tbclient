package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class g implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f859a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.f859a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        az azVar;
        if (i >= 0) {
            azVar = this.f859a.l;
            azVar.i(i);
            this.f859a.t = true;
            this.f859a.s = ((com.baidu.tieba.data.u) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.f859a.f = 1;
            this.f859a.b = 3;
            this.f859a.z();
        }
    }
}
