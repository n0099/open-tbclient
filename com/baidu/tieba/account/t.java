package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
import com.baidu.tieba.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1090a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.f1090a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        LoginActivity loginActivity = this.f1090a;
        editText = this.f1090a.o;
        UtilHelper.a(loginActivity, editText);
        LoginActivity loginActivity2 = this.f1090a;
        editText2 = this.f1090a.p;
        UtilHelper.a(loginActivity2, editText2);
        LoginActivity loginActivity3 = this.f1090a;
        editText3 = this.f1090a.q;
        UtilHelper.a(loginActivity3, editText3);
        this.f1090a.finish();
    }
}
