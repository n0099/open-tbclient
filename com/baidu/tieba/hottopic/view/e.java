package com.baidu.tieba.hottopic.view;

import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ c bMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.bMS = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        LinearLayout linearLayout;
        linearLayout = this.bMS.bMI;
        linearLayout.performClick();
    }
}
