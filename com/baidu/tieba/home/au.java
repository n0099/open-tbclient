package com.baidu.tieba.home;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SearchActivity f1166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(SearchActivity searchActivity) {
        this.f1166a = searchActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        editText = this.f1166a.c;
        editText.setText("");
    }
}
