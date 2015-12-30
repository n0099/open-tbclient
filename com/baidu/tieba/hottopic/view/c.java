package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ a bJl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bJl = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        linearLayout = this.bJl.bJb;
        linearLayout.performClick();
    }
}
