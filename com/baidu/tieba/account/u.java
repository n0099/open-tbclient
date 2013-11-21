package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.f1094a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        LoginActivity loginActivity = this.f1094a;
        editText = this.f1094a.o;
        UtilHelper.a(loginActivity, editText);
        LoginActivity loginActivity2 = this.f1094a;
        editText2 = this.f1094a.p;
        UtilHelper.a(loginActivity2, editText2);
        LoginActivity loginActivity3 = this.f1094a;
        editText3 = this.f1094a.q;
        UtilHelper.a(loginActivity3, editText3);
        this.f1094a.finish();
    }
}
