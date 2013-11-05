package com.baidu.tieba.account;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1062a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LoginActivity loginActivity) {
        this.f1062a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.f1062a.w();
        LoginActivity loginActivity = this.f1062a;
        InputMethodManager inputMethodManager = this.f1062a.d;
        editText = this.f1062a.s;
        loginActivity.a(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.f1062a;
        InputMethodManager inputMethodManager2 = this.f1062a.d;
        editText2 = this.f1062a.t;
        loginActivity2.a(inputMethodManager2, editText2);
        Register2Activity.a(this.f1062a, 12007);
    }
}
