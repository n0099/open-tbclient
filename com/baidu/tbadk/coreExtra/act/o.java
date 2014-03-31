package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.b.al;
import com.baidu.tbadk.core.frameworkData.IntentAction;
/* loaded from: classes.dex */
final class o implements View.OnClickListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        EditText editText2;
        this.a.h();
        LoginActivity loginActivity = this.a;
        InputMethodManager inputMethodManager = this.a.b;
        editText = this.a.o;
        loginActivity.HidenSoftKeyPad(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.a;
        InputMethodManager inputMethodManager2 = this.a.b;
        editText2 = this.a.p;
        loginActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        al alVar = new al(this.a);
        alVar.a(22002);
        alVar.a(IntentAction.ActivityForResult);
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2001001, alVar));
    }
}
