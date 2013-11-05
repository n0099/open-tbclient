package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class s implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1295a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.f1295a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ba baVar;
        if (i >= 0) {
            baVar = this.f1295a.o;
            baVar.g(i);
            this.f1295a.v = true;
            this.f1295a.u = ((com.baidu.tieba.data.aa) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.f1295a.j = 1;
            this.f1295a.d = 3;
            this.f1295a.D();
        }
    }
}
