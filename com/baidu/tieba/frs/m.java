package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.frs.c.a aVar;
        if (i >= 0) {
            aVar = this.aVz.aVb;
            aVar.fr(i);
            this.aVz.Lq().fG(((com.baidu.tbadk.core.data.k) ((GridView) adapterView).getAdapter().getItem(i)).rJ());
        }
    }
}
