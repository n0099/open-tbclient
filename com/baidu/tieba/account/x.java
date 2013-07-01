package com.baidu.tieba.account;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f683a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LoginActivity loginActivity) {
        this.f683a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.f683a.x();
        LoginActivity loginActivity = this.f683a;
        InputMethodManager inputMethodManager = this.f683a.d;
        editText = this.f683a.s;
        loginActivity.a(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.f683a;
        InputMethodManager inputMethodManager2 = this.f683a.d;
        editText2 = this.f683a.t;
        loginActivity2.a(inputMethodManager2, editText2);
        Register2Activity.a(this.f683a, 1200007);
    }
}
