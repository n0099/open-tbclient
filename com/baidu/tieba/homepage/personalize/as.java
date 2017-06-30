package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.cj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class as implements View.OnClickListener {
    final /* synthetic */ x this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(x xVar) {
        this.this$0 = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cj cjVar;
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        cj cjVar2;
        cjVar = this.this$0.cJa;
        if (cjVar != null) {
            cjVar2 = this.this$0.cJa;
            cjVar2.hideTip();
        }
        i = this.this$0.cIY;
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
