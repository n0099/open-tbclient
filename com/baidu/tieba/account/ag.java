package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.baidu.adp.lib.util.BdUtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        LoginActivity loginActivity = this.a;
        editText = this.a.o;
        BdUtilHelper.a(loginActivity, editText);
        LoginActivity loginActivity2 = this.a;
        editText2 = this.a.p;
        BdUtilHelper.a(loginActivity2, editText2);
        LoginActivity loginActivity3 = this.a;
        editText3 = this.a.q;
        BdUtilHelper.a(loginActivity3, editText3);
        this.a.finish();
    }
}
