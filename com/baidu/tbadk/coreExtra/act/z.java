package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ Login2Activity QG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Login2Activity login2Activity) {
        this.QG = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        Login2Activity login2Activity = this.QG;
        InputMethodManager inputMethodManager = this.QG.mInputManager;
        editText = this.QG.Qe;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.QG;
        InputMethodManager inputMethodManager2 = this.QG.mInputManager;
        editText2 = this.QG.Qf;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        this.QG.rB();
    }
}
