package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.aJG = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.frs.c.a aVar;
        if (i >= 0) {
            aVar = this.aJG.aJl;
            aVar.eI(i);
            this.aJG.oi().eQ(((com.baidu.tbadk.core.data.l) ((GridView) adapterView).getAdapter().getItem(i)).qc());
        }
    }
}
