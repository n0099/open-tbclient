package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity aDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.aDT = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bp bpVar;
        if (i >= 0) {
            bpVar = this.aDT.aCV;
            bpVar.eN(i);
            this.aDT.aDd = true;
            this.aDT.aDc = ((com.baidu.tbadk.core.data.k) ((GridView) adapterView).getAdapter().getItem(i)).mH();
            this.aDT.aCP = 1;
            this.aDT.eJ(3);
        }
    }
}
