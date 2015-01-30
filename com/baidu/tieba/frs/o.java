package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.aDW = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bp bpVar;
        if (i >= 0) {
            bpVar = this.aDW.aCY;
            bpVar.eN(i);
            this.aDW.aDg = true;
            this.aDW.aDf = ((com.baidu.tbadk.core.data.k) ((GridView) adapterView).getAdapter().getItem(i)).mO();
            this.aDW.aCS = 1;
            this.aDW.eJ(3);
        }
    }
}
