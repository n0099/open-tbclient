package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(SearchActivity searchActivity) {
        this.f1133a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f1133a.f1108a;
        com.baidu.tieba.util.am.i(this.f1133a, editText.getText().toString().trim());
    }
}
