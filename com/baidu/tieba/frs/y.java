package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
final class y implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        cm cmVar;
        if (i >= 0) {
            cmVar = this.a.r;
            cmVar.i(i);
            this.a.z = true;
            this.a.y = ((com.baidu.tbadk.core.data.g) ((GridView) adapterView).getAdapter().getItem(i)).b();
            this.a.l = 1;
            this.a.h = 3;
            this.a.o();
        }
    }
}
