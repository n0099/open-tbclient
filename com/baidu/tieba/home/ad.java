package com.baidu.tieba.home;

import android.view.View;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Button button;
        button = this.a.e;
        if (view == button) {
            this.a.finish();
        }
    }
}
