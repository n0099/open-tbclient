package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ o this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(o oVar) {
        this.this$0 = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ci ciVar;
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        ci ciVar2;
        ciVar = this.this$0.cBe;
        if (ciVar != null) {
            ciVar2 = this.this$0.cBe;
            ciVar2.hideTip();
        }
        i = this.this$0.cBb;
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
