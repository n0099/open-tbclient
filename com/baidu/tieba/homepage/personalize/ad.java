package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.cq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(n nVar) {
        this.this$0 = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cq cqVar;
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        cq cqVar2;
        cqVar = this.this$0.cxl;
        if (cqVar != null) {
            cqVar2 = this.this$0.cxl;
            cqVar2.hideTip();
        }
        i = this.this$0.cxh;
        if (i == 1) {
            bdTypeListView = this.this$0.mListView;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.this$0.mListView;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.this$0.mListView;
                bdTypeListView3.startPullRefresh();
            }
        }
    }
}
