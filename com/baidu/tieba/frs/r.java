package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class r implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity blk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.blk = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.frs.c.a aVar;
        if (i >= 0) {
            aVar = this.blk.bkD;
            aVar.gK(i);
            this.blk.Rd().gX(((com.baidu.tbadk.core.data.t) ((GridView) adapterView).getAdapter().getItem(i)).rR());
        }
    }
}
