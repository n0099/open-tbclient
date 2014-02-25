package com.baidu.tieba.account;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements View.OnClickListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.a.o();
        LoginActivity loginActivity = this.a;
        InputMethodManager inputMethodManager = this.a.b;
        editText = this.a.o;
        loginActivity.HidenSoftKeyPad(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.a;
        InputMethodManager inputMethodManager2 = this.a.b;
        editText2 = this.a.p;
        loginActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        SapiFastRegActivity.a(this.a, 22002);
    }
}
