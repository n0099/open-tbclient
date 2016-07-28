package com.baidu.tieba.homepage.personalize;

import android.view.View;
import com.baidu.adp.widget.ListView.BdTypeListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ b ctz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(b bVar) {
        this.ctz = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        BdTypeListView bdTypeListView;
        BdTypeListView bdTypeListView2;
        BdTypeListView bdTypeListView3;
        this.ctz.hideTip();
        i = this.ctz.csW;
        if (i == 1) {
            bdTypeListView = this.ctz.bqG;
            if (bdTypeListView != null) {
                bdTypeListView2 = this.ctz.bqG;
                bdTypeListView2.setSelection(0);
                bdTypeListView3 = this.ctz.bqG;
                bdTypeListView3.jA();
            }
        }
    }
}
