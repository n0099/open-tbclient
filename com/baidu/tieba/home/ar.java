package com.baidu.tieba.home;

import android.view.View;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1163a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(SearchActivity searchActivity) {
        this.f1163a = searchActivity;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (!z) {
            UtilHelper.a(this.f1163a, view);
        }
    }
}
