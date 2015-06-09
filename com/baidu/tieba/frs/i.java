package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class i implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsActivity frsActivity) {
        this.aLY = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.frs.c.a aVar;
        if (i >= 0) {
            aVar = this.aLY.aLB;
            aVar.eW(i);
            this.aLY.oy().ff(((com.baidu.tbadk.core.data.l) ((GridView) adapterView).getAdapter().getItem(i)).qI());
        }
    }
}
