package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ b this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(b bVar) {
        this.this$0 = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        this.this$0.hideTip();
        i = this.this$0.cEC;
        if (i == 1) {
            bdTypeListView = this.this$0.bBT;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.this$0.bBT;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.this$0.bBT;
                bdTypeListView3.kv();
            }
        }
    }
}
