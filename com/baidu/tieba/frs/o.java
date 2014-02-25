package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        br brVar;
        if (i >= 0) {
            brVar = this.a.p;
            brVar.i(i);
            this.a.w = true;
            this.a.v = ((com.baidu.tieba.data.z) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.a.j = 1;
            this.a.f = 3;
            this.a.D();
        }
    }
}
