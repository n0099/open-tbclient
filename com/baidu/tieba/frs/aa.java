package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class aa implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        cu cuVar;
        if (i >= 0) {
            cuVar = this.a.z;
            cuVar.j(i);
            this.a.H = true;
            this.a.G = ((com.baidu.tbadk.core.data.h) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.a.t = 1;
            this.a.c(3);
        }
    }
}
