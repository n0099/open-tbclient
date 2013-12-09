package com.baidu.tieba.im.searchGroup;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1880a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.f1880a = gVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        SearchGroupActivity searchGroupActivity;
        if (!z) {
            searchGroupActivity = this.f1880a.b;
            com.baidu.adp.lib.h.g.a(searchGroupActivity, view);
        }
    }
}
