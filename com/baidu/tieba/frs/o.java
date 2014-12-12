package com.baidu.tieba.frs;

import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
/* loaded from: classes.dex */
class o implements AdapterView.OnItemClickListener {
    final /* synthetic */ FrsActivity aCV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.aCV = frsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        bq bqVar;
        if (i >= 0) {
            bqVar = this.aCV.aBX;
            bqVar.eH(i);
            this.aCV.aCf = true;
            this.aCV.aCe = ((com.baidu.tbadk.core.data.j) ((GridView) adapterView).getAdapter().getItem(i)).mM();
            this.aCV.aBR = 1;
            this.aCV.eD(3);
        }
    }
}
