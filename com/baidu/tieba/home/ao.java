package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1454a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(SearchActivity searchActivity) {
        this.f1454a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f1454a.c;
        editText.setText("");
    }
}
