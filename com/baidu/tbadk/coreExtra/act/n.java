package com.baidu.tbadk.coreExtra.act;

import android.view.View;
import android.widget.EditText;
/* loaded from: classes.dex */
final class n implements View.OnClickListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        LoginActivity loginActivity = this.a;
        editText = this.a.o;
        com.baidu.adp.lib.util.i.a(loginActivity, editText);
        LoginActivity loginActivity2 = this.a;
        editText2 = this.a.p;
        com.baidu.adp.lib.util.i.a(loginActivity2, editText2);
        LoginActivity loginActivity3 = this.a;
        editText3 = this.a.q;
        com.baidu.adp.lib.util.i.a(loginActivity3, editText3);
        this.a.finish();
    }
}
