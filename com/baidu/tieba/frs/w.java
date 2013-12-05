package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class w implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1423a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.f1423a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bn bnVar;
        if (i >= 0) {
            bnVar = this.f1423a.n;
            bnVar.i(i);
            this.f1423a.u = true;
            this.f1423a.t = ((com.baidu.tieba.data.z) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.f1423a.i = 1;
            this.f1423a.e = 3;
            this.f1423a.B();
        }
    }
}
