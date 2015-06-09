package com.baidu.tieba.account.login;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements View.OnClickListener {
    final /* synthetic */ Login2Activity ayN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Login2Activity login2Activity) {
        this.ayN = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        Login2Activity login2Activity = this.ayN;
        InputMethodManager inputMethodManager = this.ayN.mInputManager;
        editText = this.ayN.ays;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.ayN;
        InputMethodManager inputMethodManager2 = this.ayN.mInputManager;
        editText2 = this.ayN.ayt;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        this.ayN.zn();
    }
}
