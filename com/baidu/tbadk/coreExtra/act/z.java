package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ Login2Activity KT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Login2Activity login2Activity) {
        this.KT = login2Activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        Login2Activity login2Activity = this.KT;
        InputMethodManager inputMethodManager = this.KT.mInputManager;
        editText = this.KT.Ks;
        login2Activity.HidenSoftKeyPad(inputMethodManager, editText);
        Login2Activity login2Activity2 = this.KT;
        InputMethodManager inputMethodManager2 = this.KT.mInputManager;
        editText2 = this.KT.Kt;
        login2Activity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        this.KT.op();
    }
}
