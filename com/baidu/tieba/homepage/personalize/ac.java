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
        csVar = this.this$0.cKR;
        if (csVar != null) {
            csVar2 = this.this$0.cKR;
            csVar2.hideTip();
        }
        i = this.this$0.cKN;
        if (i == 1) {
            bdTypeListView = this.this$0.aML;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.this$0.aML;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.this$0.aML;
                bdTypeListView3.kv();
            }
        }
    }
}
