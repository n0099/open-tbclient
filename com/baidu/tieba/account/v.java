package com.baidu.tieba.account;

import android.view.View;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(LoginActivity loginActivity) {
        this.f1105a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        LoginActivity loginActivity = this.f1105a;
        editText = this.f1105a.o;
        com.baidu.adp.lib.h.g.a(loginActivity, editText);
        LoginActivity loginActivity2 = this.f1105a;
        editText2 = this.f1105a.p;
        com.baidu.adp.lib.h.g.a(loginActivity2, editText2);
        LoginActivity loginActivity3 = this.f1105a;
        editText3 = this.f1105a.q;
        com.baidu.adp.lib.h.g.a(loginActivity3, editText3);
        this.f1105a.finish();
    }
}
