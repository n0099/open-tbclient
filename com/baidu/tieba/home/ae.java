package com.baidu.tieba.home;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1196a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(SearchActivity searchActivity) {
        this.f1196a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f1196a.finish();
    }
}
