package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity aUS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.aUS = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.frs.b.a aVar;
        if (i >= 0) {
            aVar = this.aUS.aUs;
            aVar.fE(i);
            this.aUS.Ly().fU(((com.baidu.tbadk.core.data.k) ((GridView) adapterView).getAdapter().getItem(i)).rD());
        }
    }
}
