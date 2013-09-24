package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f928a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.f928a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.f928a.q;
        if (z) {
            this.f928a.s();
        }
        this.f928a.r = true;
        this.f928a.v();
        this.f928a.w();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.f928a.e();
        str = this.f928a.j;
        if (!com.baidu.tieba.util.at.c(str)) {
            String editable2 = editable.toString();
            str2 = this.f928a.j;
            if (!editable2.equals(str2)) {
                return;
            }
            this.f928a.r();
        }
    }
}
