package com.baidu.tieba.account.login;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ Login2Activity awY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Login2Activity login2Activity) {
        this.awY = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        Login2Activity login2Activity = this.awY;
        InputMethodManager inputMethodManager = this.awY.mInputManager;
        editText = this.awY.awD;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.awY;
        InputMethodManager inputMethodManager2 = this.awY.mInputManager;
        editText2 = this.awY.awE;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        this.awY.yt();
    }
}
