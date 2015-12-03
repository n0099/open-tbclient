package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity bag;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.bag = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.frs.b.a aVar;
        if (i >= 0) {
            aVar = this.bag.aZF;
            aVar.gb(i);
            this.bag.MX().gq(((com.baidu.tbadk.core.data.m) ((GridView) adapterView).getAdapter().getItem(i)).rY());
        }
    }
}
