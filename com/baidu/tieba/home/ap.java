package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(SearchActivity searchActivity) {
        this.f1128a = searchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            com.baidu.tieba.util.am.a(this.f1128a, view);
        }
    }
}
