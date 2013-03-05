package com.baidu.tieba.account;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements View.OnClickListener {
    final /* synthetic */ AccountVcodeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AccountVcodeActivity accountVcodeActivity) {
        this.a = accountVcodeActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        InputMethodManager inputMethodManager;
        EditText editText;
        AccountVcodeActivity accountVcodeActivity = this.a;
        inputMethodManager = this.a.r;
        editText = this.a.p;
        accountVcodeActivity.a(inputMethodManager, editText);
        this.a.j();
    }
}
