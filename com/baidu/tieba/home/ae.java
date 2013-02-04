package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnFocusChangeListener {
    final /* synthetic */ SearchActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(SearchActivity searchActivity) {
        this.a = searchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z) {
            return;
        }
        com.baidu.tieba.c.ag.a(this.a, view);
    }
}
