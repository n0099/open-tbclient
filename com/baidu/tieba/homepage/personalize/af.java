package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements View.OnClickListener {
    final /* synthetic */ m this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(m mVar) {
        this.this$0 = mVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        this.this$0.hideTip();
        i = this.this$0.cFz;
        if (i == 1) {
            bdTypeListView = this.this$0.bCe;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.this$0.bCe;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.this$0.bCe;
                bdTypeListView3.kv();
            }
        }
    }
}
