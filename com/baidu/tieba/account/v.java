package com.baidu.tieba.account;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1095a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(LoginActivity loginActivity) {
        this.f1095a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.f1095a.o();
        LoginActivity loginActivity = this.f1095a;
        InputMethodManager inputMethodManager = this.f1095a.b;
        editText = this.f1095a.o;
        loginActivity.HidenSoftKeyPad(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.f1095a;
        InputMethodManager inputMethodManager2 = this.f1095a.b;
        editText2 = this.f1095a.p;
        loginActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        Register2Activity.a(this.f1095a, 12007);
    }
}
