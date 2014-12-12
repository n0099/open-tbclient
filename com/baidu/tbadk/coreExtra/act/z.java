package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ Login2Activity Qf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Login2Activity login2Activity) {
        this.Qf = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        Login2Activity login2Activity = this.Qf;
        InputMethodManager inputMethodManager = this.Qf.mInputManager;
        editText = this.Qf.PC;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.Qf;
        InputMethodManager inputMethodManager2 = this.Qf.mInputManager;
        editText2 = this.Qf.PD;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        this.Qf.register();
    }
}
