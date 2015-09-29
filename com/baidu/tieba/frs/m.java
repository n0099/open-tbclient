package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class m implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity aUz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.aUz = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.baidu.tieba.frs.b.a aVar;
        if (i >= 0) {
            aVar = this.aUz.aTZ;
            aVar.fw(i);
            this.aUz.Lm().fL(((com.baidu.tbadk.core.data.j) ((GridView) adapterView).getAdapter().getItem(i)).rE());
        }
    }
}
