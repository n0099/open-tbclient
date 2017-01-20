package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.co;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements View.OnClickListener {
    final /* synthetic */ n this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(n nVar) {
        this.this$0 = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        co coVar;
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        co coVar2;
        coVar = this.this$0.cxm;
        if (coVar != null) {
            coVar2 = this.this$0.cxm;
            coVar2.hideTip();
        }
        i = this.this$0.cxi;
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
