package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(SearchActivity searchActivity) {
        this.f1452a = searchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.adp.lib.h.g.a(this.f1452a, view);
        }
    }
}
