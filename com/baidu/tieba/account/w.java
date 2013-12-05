package com.baidu.tieba.account;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1106a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(LoginActivity loginActivity) {
        this.f1106a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.f1106a.o();
        LoginActivity loginActivity = this.f1106a;
        InputMethodManager inputMethodManager = this.f1106a.b;
        editText = this.f1106a.o;
        loginActivity.HidenSoftKeyPad(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.f1106a;
        InputMethodManager inputMethodManager2 = this.f1106a.b;
        editText2 = this.f1106a.p;
        loginActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        Register2Activity.a(this.f1106a, 12007);
    }
}
