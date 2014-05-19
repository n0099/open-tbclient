package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        cs csVar;
        if (i >= 0) {
            csVar = this.a.w;
            csVar.i(i);
            this.a.E = true;
            this.a.D = ((com.baidu.tbadk.core.data.g) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.a.q = 1;
            this.a.m = 3;
            this.a.E();
        }
    }
}
