package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bu buVar;
        if (i >= 0) {
            buVar = this.aBk.aAv;
            buVar.eJ(i);
            this.aBk.aAD = true;
            this.aBk.aAC = ((com.baidu.tbadk.core.data.h) ((GridView) adapterView).getAdapter().getItem(i)).jX();
            this.aBk.aAp = 1;
            this.aBk.eF(3);
        }
    }
}
