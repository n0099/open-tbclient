package com.baidu.tieba.account;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f916a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(LoginActivity loginActivity) {
        this.f916a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.f916a.v();
        LoginActivity loginActivity = this.f916a;
        InputMethodManager inputMethodManager = this.f916a.d;
        editText = this.f916a.s;
        loginActivity.a(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.f916a;
        InputMethodManager inputMethodManager2 = this.f916a.d;
        editText2 = this.f916a.t;
        loginActivity2.a(inputMethodManager2, editText2);
        Register2Activity.a(this.f916a, 12007);
    }
}
