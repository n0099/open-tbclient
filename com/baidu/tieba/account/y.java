package com.baidu.tieba.account;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f895a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(LoginActivity loginActivity) {
        this.f895a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.f895a.v();
        LoginActivity loginActivity = this.f895a;
        InputMethodManager inputMethodManager = this.f895a.d;
        editText = this.f895a.s;
        loginActivity.a(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.f895a;
        InputMethodManager inputMethodManager2 = this.f895a.d;
        editText2 = this.f895a.t;
        loginActivity2.a(inputMethodManager2, editText2);
        Register2Activity.a(this.f895a, 12007);
    }
}
