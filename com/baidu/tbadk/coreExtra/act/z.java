package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ Login2Activity KU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Login2Activity login2Activity) {
        this.KU = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        Login2Activity login2Activity = this.KU;
        InputMethodManager inputMethodManager = this.KU.mInputManager;
        editText = this.KU.Kt;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.KU;
        InputMethodManager inputMethodManager2 = this.KU.mInputManager;
        editText2 = this.KU.Ku;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        this.KU.op();
    }
}
