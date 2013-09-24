package com.baidu.tieba.account;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(LoginActivity loginActivity) {
        this.f932a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.f932a.w();
        LoginActivity loginActivity = this.f932a;
        InputMethodManager inputMethodManager = this.f932a.d;
        editText = this.f932a.s;
        loginActivity.a(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.f932a;
        InputMethodManager inputMethodManager2 = this.f932a.d;
        editText2 = this.f932a.t;
        loginActivity2.a(inputMethodManager2, editText2);
        Register2Activity.a(this.f932a, 12007);
    }
}
