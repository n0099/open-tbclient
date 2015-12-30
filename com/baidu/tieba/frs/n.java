package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class n implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity bed;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.bed = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.frs.b.a aVar;
        if (i >= 0) {
            aVar = this.bed.bdB;
            aVar.fW(i);
            this.bed.Nr().gj(((com.baidu.tbadk.core.data.m) ((GridView) adapterView).getAdapter().getItem(i)).rH());
        }
    }
}
