package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1135a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(SearchActivity searchActivity) {
        this.f1135a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f1135a.f1110a;
        com.baidu.tieba.util.am.i(this.f1135a, editText.getText().toString().trim());
    }
}
