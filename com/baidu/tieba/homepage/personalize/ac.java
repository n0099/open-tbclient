package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tieba.frs.cs;
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
        cs csVar;
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        cs csVar2;
        csVar = this.this$0.cqm;
        if (csVar != null) {
            csVar2 = this.this$0.cqm;
            csVar2.hideTip();
        }
        i = this.this$0.cqi;
        if (i == 1) {
            bdTypeListView = this.this$0.aMc;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.this$0.aMc;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.this$0.aMc;
                bdTypeListView3.kv();
            }
        }
    }
}
