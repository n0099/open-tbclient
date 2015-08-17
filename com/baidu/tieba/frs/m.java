package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.frs.c.a aVar;
        if (i >= 0) {
            aVar = this.this$0.aUM;
            aVar.fj(i);
            this.this$0.Lz().fx(((com.baidu.tbadk.core.data.k) ((GridView) adapterView).getAdapter().getItem(i)).rK());
        }
    }
}
