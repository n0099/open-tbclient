package com.baidu.tieba.account;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements View.OnClickListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.a.x();
        LoginActivity loginActivity = this.a;
        InputMethodManager inputMethodManager = this.a.f;
        editText = this.a.s;
        loginActivity.a(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.a;
        InputMethodManager inputMethodManager2 = this.a.f;
        editText2 = this.a.t;
        loginActivity2.a(inputMethodManager2, editText2);
        Register2Activity.a(this.a, 1200007);
    }
}
