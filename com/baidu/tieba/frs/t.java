package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class t implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.aBu = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bu buVar;
        if (i >= 0) {
            buVar = this.aBu.aAF;
            buVar.eJ(i);
            this.aBu.aAN = true;
            this.aBu.aAM = ((com.baidu.tbadk.core.data.h) ((GridView) adapterView).getAdapter().getItem(i)).jX();
            this.aBu.aAz = 1;
            this.aBu.eF(3);
        }
    }
}
