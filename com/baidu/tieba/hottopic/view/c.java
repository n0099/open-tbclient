package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bFE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bFE = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        linearLayout = this.bFE.bFu;
        linearLayout.performClick();
    }
}
