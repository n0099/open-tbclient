package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements View.OnClickListener {
    final /* synthetic */ a cqR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar) {
        this.cqR = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        this.cqR.hideTip();
        i = this.cqR.cqr;
        if (i == 1) {
            bdTypeListView = this.cqR.bou;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.cqR.bou;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.cqR.bou;
                bdTypeListView3.jB();
            }
        }
    }
}
